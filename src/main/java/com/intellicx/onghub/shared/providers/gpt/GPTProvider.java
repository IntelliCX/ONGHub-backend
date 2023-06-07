package com.intellicx.onghub.shared.providers.gpt;

import com.intellicx.onghub.posts.repositories.PostsRepository;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class GPTProvider {

    @Value("${GPT_API_KEY}")
    private String gptApiKey;
    private final PostsRepository postsRepository;

    @Autowired
    private Environment environment;

    public GPTProvider(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public String requestToGPT(String context, String question) {
        System.out.println(environment.getProperty("GPT_API_KEY"));
        OpenAiService gptService = new OpenAiService(environment.getProperty("GPT_API_KEY"));

        CompletionRequest request = CompletionRequest.builder().prompt(
                String.format("Context: %s. Q: %s", context, question)
        ).model("text-davinci-003").maxTokens(100).build();

        String answer = gptService.createCompletion(request).getChoices().get(0).getText();

        return answer;
    }
}
