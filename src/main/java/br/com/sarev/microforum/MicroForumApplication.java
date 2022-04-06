package br.com.sarev.microforum;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroForumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroForumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Micro Forum");
		
	}
}
