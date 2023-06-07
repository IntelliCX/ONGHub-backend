package com.intellicx.onghub.contributors.services;

import com.intellicx.onghub.contributors.dtos.CreateOrUpdateContributorDto;
import com.intellicx.onghub.contributors.models.ContributorModel;
import com.intellicx.onghub.contributors.repositories.ContributorsRepository;
import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.ongs.repositories.OngsRepository;
import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreateContributorService {
    private final ContributorsRepository contributorsRepository;
    private final OngsRepository ongsRepository;

    public CreateContributorService(ContributorsRepository contributorsRepository, OngsRepository ongsRepository) {
        this.contributorsRepository = contributorsRepository;
        this.ongsRepository = ongsRepository;
    }

    public GenericResponse<Object> execute(CreateOrUpdateContributorDto createOrUpdateContributorDto) {
        Optional<ContributorModel> foundContributor = contributorsRepository.findByemail(createOrUpdateContributorDto.getEmail());

        if (foundContributor.isPresent()) return new GenericResponse<>(409, new ResponseData<>("This email is already registred!"));

        ContributorModel contributorModel = new ContributorModel();
        BeanUtils.copyProperties(createOrUpdateContributorDto, contributorModel);

        List<UUID> ongsIds = createOrUpdateContributorDto.getOngsIds();

        List<ONGModel> contributorOngs = null;

        if (!ongsIds.isEmpty()) contributorOngs = ongsRepository.findAllById(ongsIds);

        if (contributorOngs.isEmpty()) return new GenericResponse<>(404, new ResponseData<>("ONGs not found!"));

        contributorModel.setOngs(contributorOngs);

        ContributorModel createdContributor = contributorsRepository.save(contributorModel);

        return new GenericResponse<>(200, new ResponseData<>(createdContributor));
    }
}
