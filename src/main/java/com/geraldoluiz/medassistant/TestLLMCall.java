package com.geraldoluiz.medassistant;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TestLLMCall implements CommandLineRunner {
    private final ChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        ChatResponse chatResponse = chatModel.call(new Prompt("Hello, how are you?"));


        String content = Objects.requireNonNull(chatResponse.getResult().getOutput().getText());
        System.out.println("Chat response");
        System.out.println(content);

        System.out.println("\nMetadata");
        System.out.println("Model " + chatResponse.getMetadata().getModel());
        System.out.println("Tokens " + chatResponse.getMetadata().getUsage().getCompletionTokens());
        System.out.println("Total de tokens " + chatResponse.getMetadata().getUsage().getTotalTokens());

        System.out.println("Finished reason: " + chatResponse.getResult().getMetadata().getFinishReason());
    }
}
