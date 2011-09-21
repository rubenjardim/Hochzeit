package br.uniriotec.pssgbd.gerencia.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pssgbd.gerencia.model.entidade.Cidade;
import br.uniriotec.pssgbd.gerencia.model.entidade.Cliente;
import br.uniriotec.pssgbd.gerencia.model.entidade.Usuario;

public class UsuarioBO extends BaseBO<Usuario> {
	
	private static UsuarioBO instancia;
	private static List<Usuario> listaUsuario = null;

	public static UsuarioBO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioBO();
			listaUsuario = new ArrayList<Usuario>();
		}
		return instancia;
	}

	@Override
	public void incluir(Usuario usuario) throws Exception {
		listaUsuario.add(usuario);
	}

	@Override
	public void alterar(Usuario usuario) throws Exception {
		listaUsuario.remove(usuario);
		listaUsuario.add(usuario);
	}

	@Override
	public void excluir(Usuario usuario) throws Exception {
		listaUsuario.remove(usuario);
	}

	@Override
	public List<Usuario> listar() throws Exception {

		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		Usuario usuario = null;
		
		usuario = new Usuario();
		usuario.setId(0l);
		usuario.setNome("admin");
		usuario.setSenha("admin");
		listaUsuario.add(usuario);

		usuario = new Usuario();
		usuario.setId(1l);
		usuario.setNome("gerente");
		usuario.setSenha("gerente");
		listaUsuario.add(usuario);
		
		usuario = new Usuario();
		usuario.setId(2l);
		usuario.setNome("cliente");
		usuario.setSenha("cliente");
		listaUsuario.add(usuario);
		
		return listaUsuario;
		
	}
	
}
