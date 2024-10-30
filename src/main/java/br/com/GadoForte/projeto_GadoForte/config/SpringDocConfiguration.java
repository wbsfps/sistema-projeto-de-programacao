package br.com.GadoForte.projeto_GadoForte.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Projeto GadoForte", description = "...", version = "3.0"))
public class SpringDocConfiguration {
}
