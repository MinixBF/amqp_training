package fr.lernejo.chat;

import java.util.List;

public class ChatMessageRepository {
    private static List<String> messages ;

    public ChatMessageRepository(List<String> messages) {
        ChatMessageRepository.messages = messages;
    }

    static void addChatMessage(String message){
        messages.add(message);
    }

    List<String> getLastTenMessages(){
        return messages.subList(Math.max(0, messages.size() - 10), messages.size());
    }
}
