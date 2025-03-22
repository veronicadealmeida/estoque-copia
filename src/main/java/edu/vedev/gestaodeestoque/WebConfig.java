package edu.vedev.gestaodeestoque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Altere conforme o seu endpoint
                .allowedOrigins("https://swagger-ui-url.com", "http://localhost:8083", "http://localhost:8080","**/**")  // Adicione as origens necessárias
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Cabeçalhos permitidos
                .allowCredentials(true);  // Permite credenciais
    }
}