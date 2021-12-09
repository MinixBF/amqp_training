package fr.lernejo.chat;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        rabbitTemplate.setRoutingKey("chat_messages");

        while(true) {
            System.out.println("Input a message, we will sent it for you (q for quit)");
            input = scanner.nextLine();
            if(input.equals("q")) {
                exit(0);
            }else {
                rabbitTemplate.convertAndSend(input);
            }
        }
    }
}

