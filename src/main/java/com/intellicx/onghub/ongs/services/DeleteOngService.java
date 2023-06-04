package com.intellicx.onghub.ongs.services;

import com.intellicx.onghub.ongs.dtos.CreateOrUpdateOngDto;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteOngService {
    private final OngsRepository ongsRepository;
    public DeleteOngService(OngsRepository ongsRepository){
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse<String> execute(UUID id){

        Optional<ONGModel> ong = this.ongsRepository.findById(id);

        if (ong.isEmpty()) return new GenericResponse(404, "ONG not found!");

        ONGModel foundOng = ong.get();
        foundOng.setDeletedAt(new Date());

        ONGModel softDeletedOng = this.ongsRepository.softDelete(id);

        return new GenericResponse(200, softDeletedOng);
    }
}
