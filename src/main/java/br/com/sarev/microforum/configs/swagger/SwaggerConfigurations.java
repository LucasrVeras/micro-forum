package br.com.sarev.microforum.configs.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sarev.microforum.modelo.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket forumApi() {
		
		return new Docket(DocumentationType.SWAGGER_2) //Docket e tipo de documentação
				.select() 
				.apis(RequestHandlerSelectors.basePackage("br.com.sarev.microforum")) // Indica os pacotes serão lidos pelo swagger
				.paths(PathSelectors.ant("/**")) // Indica quais paths/endpoints que o springfox swagger faz analise 
				.build()
				.ignoredParameterTypes(Usuario.class); // Ignora todas as url que usam a classe contida no método
	}	
}
