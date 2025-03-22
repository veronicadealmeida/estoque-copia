package edu.vedev.gestaodeestoque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir qualquer origem
        registry.addMapping("/**")
                .allowedOrigins("*") // Permite qualquer origem
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos desejados
                .allowedHeaders("*")  // Permite qualquer cabeçalho
                .allowCredentials(true); // Permite enviar cookies
    }
}