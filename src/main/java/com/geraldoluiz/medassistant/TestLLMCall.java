package com.geraldoluiz.medassistant;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestLLMCall implements CommandLineRunner {
    private final ChatModel chatModel;

    @Override
    public void run(String @NonNull ... args) throws Exception {
        String response = chatModel.call("Hello, how are you?");
        System.out.println(response);
    }
}
