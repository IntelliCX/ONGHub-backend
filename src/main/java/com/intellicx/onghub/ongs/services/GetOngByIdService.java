package com.intellicx.onghub.ongs.services;

import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOngByIdService {
    private final OngsRepository ongsRepository;

    public GetOngByIdService(OngsRepository ongsRepository) {
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse<Object> execute(UUID id) {
        Optional<ONGModel> ong = ongsRepository.findById(id);

        if (ong.isEmpty()) return new GenericResponse<>(404, new ResponseData<>("ONG not found!"));

        return new GenericResponse<>(200, new ResponseData<>(ong.get()));
    }
}
