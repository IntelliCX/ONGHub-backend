package com.intellicx.onghub.contributors.services;

import com.intellicx.onghub.contributors.models.ContributorModel;
import com.intellicx.onghub.contributors.repositories.ContributorsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllContributorsService {

    private final ContributorsRepository contributorsRepository;
    public GetAllContributorsService(ContributorsRepository contributorsRepository){
        this.contributorsRepository = contributorsRepository;
    }

    public GenericResponse<List<ContributorModel>> execute() {
        return new GenericResponse(200, new ResponseData(contributorsRepository.findAll()));
    }
}
