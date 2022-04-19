package br.com.sarev.microforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sarev.microforum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findById(String nome);
	Curso findByNome(String nome);
	
}
