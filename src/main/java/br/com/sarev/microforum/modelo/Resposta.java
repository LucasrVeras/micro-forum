package br.com.sarev.microforum.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_resposta")
public class Resposta {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mensagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Topico topico;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario autor;
	private Boolean solucao = false;

}
