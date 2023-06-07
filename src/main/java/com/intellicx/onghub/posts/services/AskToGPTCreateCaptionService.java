package com.intellicx.onghub.posts.services;

import com.intellicx.onghub.shared.generics.GenericResponse;
import com.intellicx.onghub.shared.generics.ResponseData;
import com.intellicx.onghub.shared.providers.gpt.GPTProvider;
import org.springframework.stereotype.Service;

@Service
public class AskToGPTCreateCaptionService {

    private final String context = "Aja como um profissional em fazer anúncios e publicações em redes sociais.";

    private final GPTProvider gptProvider;

    public AskToGPTCreateCaptionService(GPTProvider gptProvider) {
        this.gptProvider = gptProvider;
    }

    public GenericResponse<String> execute(String request) {
        String generatedCaption = gptProvider.requestToGPT(context, request);

        return new GenericResponse<>(200, new ResponseData<>(generatedCaption));
    }

}
