package br.com.sarev.microforum.configs.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.sarev.microforum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/*
 * Classe para Geração do token jwt
 * */
@Service
public class TokenService {
	
	@Value("${micro-forum.jwt.expiration}")
	private String expiration;
	
	@Value("${micro-forum.jwt.secret}")
	private String secret;
	
	public String gerarToke(Authentication authentication) {
		
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date now = new Date();
		
		Date dataExpiracao = new Date(now.getTime() + Long.parseLong(expiration));
		
		return Jwts
				.builder()
				.setIssuer("API Micro-Forum")
				.setSubject(logado.getId().toString())
				.setIssuedAt(now)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
}
