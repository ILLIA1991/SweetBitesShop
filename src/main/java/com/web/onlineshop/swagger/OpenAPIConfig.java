package com.web.onlineshop.swagger;


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
        contact.setEmail("ilasemcenkov1@gmail.com");
        contact.setName("Illia Belikau");
        contact.setUrl("https://github.com/ILLIA1991");

        License mitLicense = new License().name("Mit License").url("https://chonscalicense.com/Licenses/mit/;");

        Info info = new Info()
                .title("SweetBitesShop")
                .version("1.0")
                .contact(contact)
                .description("API for SweetBitesShop System")
                .license(mitLicense);
        return new OpenAPI().info(info);
    }
}
