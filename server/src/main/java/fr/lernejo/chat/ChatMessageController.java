package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChatMessageController {
    private final ChatMessageRepository repository;

    public ChatMessageController(ChatMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/message")
    public List<String> getChatMessages() {
        return repository.getLastTenMessages();
    }
}
