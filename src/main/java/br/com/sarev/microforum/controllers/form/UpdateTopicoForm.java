package br.com.sarev.microforum.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.sarev.microforum.modelo.Topico;
import br.com.sarev.microforum.repositories.TopicoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTopicoForm {
	
	@NotNull @NotEmpty @Length(min = 10)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 15)
	private String mensagem;

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		
		Topico topico = topicoRepository.getById(id);
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		
		return topico;
	}
	
	
	
}
