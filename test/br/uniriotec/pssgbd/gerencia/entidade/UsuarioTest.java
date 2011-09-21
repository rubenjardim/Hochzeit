package br.uniriotec.pssgbd.gerencia.entidade;

import static org.junit.Assert.*;

import org.junit.Test;

import br.uniriotec.pssgbd.gerencia.model.entidade.Usuario;

public class UsuarioTest {

	@Test
	public void testGetNome() {
		
		Usuario instance = new Usuario();
		instance.setNome("nome");
		
		assertEquals("nome", instance.getNome());
		
		//fail("Not yet implemented");
	}

}
