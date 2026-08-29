package com.empresa.gollinho.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Libera todas as rotas da API
                .allowedOrigins("http://localhost:4200") // Libera o seu frontend Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Todos os métodos HTTP
                .allowedHeaders("*") // Todos os headers
                .allowCredentials(true); // Permite credenciais/tokens se necessário
    }
}