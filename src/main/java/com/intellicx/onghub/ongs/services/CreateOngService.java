package com.intellicx.onghub.ongs.services;

import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.ongs.dtos.CreateOrUpdateOngDto;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateOngService {
    private final OngsRepository ongsRepository;
    public CreateOngService(OngsRepository ongsRepository){
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse<ONGModel> execute(CreateOrUpdateOngDto createOrUpdateOngDto){
        Optional<ONGModel> foundOng = ongsRepository.findByemail(createOrUpdateOngDto.getEmail());

        if (foundOng.isPresent()) return new GenericResponse(409, "This email is already registred!");

        ONGModel ongModel = new ONGModel();

        BeanUtils.copyProperties(createOrUpdateOngDto, ongModel);

        ONGModel createdOng = ongsRepository.save(ongModel);

        return new GenericResponse(200, createdOng);
    }
}
