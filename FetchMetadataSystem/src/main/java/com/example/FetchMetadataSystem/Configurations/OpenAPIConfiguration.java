package com.example.FetchMetadataSystem.Configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * API Configurations for System
 */
@Configuration
public class OpenAPIConfiguration {
    /**
     * Method with definitions of System API
     * @return OpenAPI object
     */
    @Bean
    public OpenAPI defineOpenAPI(@Value("Fetch Metadata System API") String serviceTitle, @Value("3.0") String serviceVersion) {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Metadata System api for development");

        // Configure Contact
        Contact myContact = new Contact();
        myContact.setName("Roni Peled");
        myContact.setEmail("roni.rose@gmail.com");

        // Configure Info
        Info info = new Info()
                .title(serviceTitle)
                .version(serviceVersion)
                .description("This API exposes endpoints to manage Metadata System")
                .contact(myContact);

        return new OpenAPI()
                .info(info).servers(List.of(server));
    }
}
