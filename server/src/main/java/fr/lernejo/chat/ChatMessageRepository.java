package fr.lernejo.chat;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatMessageRepository {
    private static final ArrayList<String> messages = new ArrayList<String>();

    public static void addChatMessage(String message){
        messages.add(message);
    }

    public List<String> getLastTenMessages(){
        return messages.subList(Math.max(0, messages.size() - 10), messages.size());
    }
}
