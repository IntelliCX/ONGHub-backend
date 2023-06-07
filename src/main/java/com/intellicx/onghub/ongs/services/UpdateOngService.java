package com.intellicx.onghub.ongs.services;

import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.ongs.dtos.CreateOrUpdateOngDto;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateOngService {
    private final OngsRepository ongsRepository;
    public UpdateOngService(OngsRepository ongsRepository){
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse<ONGModel> execute(UUID id, CreateOrUpdateOngDto createOrUpdateOngDto){
        Optional<ONGModel> ong = this.ongsRepository.findById(id);

        if (ong.isEmpty()) return new GenericResponse(404, new ResponseData("ONG not found!"));

        ONGModel foundOng = ong.get();

        BeanUtils.copyProperties(createOrUpdateOngDto, foundOng);

        ONGModel updatedOng = this.ongsRepository.save(foundOng);

        return new GenericResponse(200, new ResponseData(updatedOng));
    }
}
