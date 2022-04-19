package br.com.sarev.microforum.repositories;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sarev.microforum.modelo.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
    public void carregarCursoPeloSeuNome() {
		
		String nomeCurso = "JavaScript";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso ,curso.getNome());
	}
}
