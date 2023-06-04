package com.intellicx.onghub.ongs.services;

import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllOngsService {
    private final OngsRepository ongsRepository;

    public GetAllOngsService(OngsRepository ongsRepository) {
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse execute() {
        List<ONGModel> ongs = this.ongsRepository.findAll();

        return new GenericResponse(200, ongs);
    }
}
