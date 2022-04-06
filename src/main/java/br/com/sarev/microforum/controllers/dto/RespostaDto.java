package br.com.sarev.microforum.controllers.dto;

import java.time.LocalDateTime;

import br.com.sarev.microforum.modelo.Resposta;
import lombok.Getter;

@Getter
public class RespostaDto {
	
	private Long id;
	private String messagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.messagem = resposta.getMensagem();
		this.dataCriacao = resposta.getDataCriacao();
		this.nomeAutor = resposta.getAutor().getNome();
	}
	
	
}
