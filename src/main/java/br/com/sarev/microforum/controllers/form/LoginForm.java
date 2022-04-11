package br.com.sarev.microforum.controllers.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginForm {
	
	private String email;
	private String senha;
	
	
	public UsernamePasswordAuthenticationToken conveter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
