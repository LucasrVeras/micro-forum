package br.com.sarev.microforum;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
 
/* 
 * Suporte para pegar da requisição os paramentros da url os campos de 
 * paginação  e ordenação passando tudo para o SpringData 
 */ 
@EnableSpringDataWebSupport
public class MicroForumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroForumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Micro Forum");
		
	}
}
