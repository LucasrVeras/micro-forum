package br.com.sarev.microforum.configs.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.sarev.microforum.modelo.Usuario;
import br.com.sarev.microforum.repositories.UsuarioRepository;

/*
 * Classe para recuperar token, autenticar e validar usuário.
 * */
public class AutenticacaoViaTokenFiltro extends OncePerRequestFilter {
	
	private TokenService tokenService;
	
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoViaTokenFiltro(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToke(request);
		boolean valid = tokenService.isTokenValid(token);
		
		// Válidação de autorização do cliente
		if (valid) {
			autenticarCliente(token);
		}else {
			
		}
		
		filterChain.doFilter(request, response);
	}
	
	// Autenticação cliente
	private void autenticarCliente(String token) {
		
		Long idUsuario = tokenService.getIdUsuario(token);
	 	Usuario usuario = usuarioRepository.findById(idUsuario).get();
		
		UsernamePasswordAuthenticationToken authentication =  
				new UsernamePasswordAuthenticationToken(usuario,
						null, usuario.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);;
		
	}

	/*
	 * Recuperar token JWT
	 * 
	 * */
	private String recuperarToke(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}	
}
