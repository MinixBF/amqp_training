package fr.lernejo.chat;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean start = true;
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        while(start) {
            System.out.println("Input a message, we will sent it for you (q for quit)");
            input = scanner.nextLine();
            if(input.equals("q")) {
                start = false;
                exit(0);
            }else {
                rabbitTemplate.convertAndSend("chat_messages", input);
            }
        }
    }
}

