package br.com.sarev.microforum.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sarev.microforum.configs.security.TokenService;
import br.com.sarev.microforum.controllers.dto.TokenDto;
import br.com.sarev.microforum.controllers.form.LoginForm;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm loginForm){
		
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.conveter();
		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToke(authentication);
			System.out.println(token);
			return ResponseEntity
					.ok(new TokenDto(token, "Bearer"));	
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}	
	}	
}
