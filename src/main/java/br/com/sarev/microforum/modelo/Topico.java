package br.com.sarev.microforum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_topico")
public class Topico {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	
	@ManyToOne
	private Usuario autor;
	
	@NonNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;
	
	@OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
	private List<Resposta> respostas = new ArrayList<>();

	
	public Topico() {
	}
	
	public Topico( String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}

	public Topico( String titulo, String mensagem) {
		super();
		this.titulo = titulo;
		this.mensagem = mensagem;
	}
}
