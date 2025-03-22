package edu.vedev.gestaodeestoque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Defina os endpoints desejados, ou use "/**" para todos
                .allowedOrigins("https://swagger-ui-url.com", "https://estoque-copia-prd.up.railway.app", "http://localhost:3000")  // Adicione todas as origens necessárias
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Permitir todos os cabeçalhos
                .allowCredentials(true);  // Permite cookies e credenciais
    }
}