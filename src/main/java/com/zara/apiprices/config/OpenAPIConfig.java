package com.zara.apiprices.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("development@zara.com");
        contact.setName("John Doe");
        contact.setUrl("http://www.zara.com");

        License license = new License().name("License").url("https://license.com/");

        Info info = new Info()
                .title("API Sample")
                .version("1.0")
                .contact(contact)
                .description("This API exposes zara prices.").termsOfService("https://www.zara.com/terms")
                .license(license);

        return new OpenAPI().info(info);
}}
