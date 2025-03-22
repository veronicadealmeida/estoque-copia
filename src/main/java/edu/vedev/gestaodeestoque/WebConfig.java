package edu.vedev.gestaodeestoque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Defina os endpoints desejados, ou use "/**" para todos
                .allowedOrigins("http://localhost:8083", "http://estoque-copia-prd.up.railway.app")  // Adicione todas as origens necessárias
                .allowedMethods("GET", "POST", "PUT", "DELETE");

    }
}