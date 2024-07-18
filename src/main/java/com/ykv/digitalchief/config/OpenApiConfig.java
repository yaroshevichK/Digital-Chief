package com.ykv.digitalchief.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI myOpenApi() {
        Contact contact = new Contact()
                .name("Katerina");

        Server server = new Server()
                .url("http://localhost:8080");

        Info info = new Info()
                .contact(contact)
                .title("Ticket System")
                .description("REST API бронирования билетов на различные мероприятия (Ticket System) " +
                        "с возможностью выполнения CRUD операций над двумя сущностями:" +
                        " «Мероприятия» и «Билеты»." +
                        " Каждое мероприятие может иметь несколько билетов, и каждый билет относится только к одному мероприятию.");

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}

