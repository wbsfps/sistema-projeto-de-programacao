package br.com.GadoForte.projeto_GadoForte.infra.docs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Gado Forte")
                        .description("O projeto GadoForte permite a sistematização do controle de vacinas aplicadas em bovinos por meio de cadastro dos animais com características como suas idades, raça, " +
                                "peso entre outros e o cadastro das vacinas aplicadas a eles com informações como: data da aplicação, tipo de vacina, dose aplicada e quem fez a aplicação.\n"));
    }
}
