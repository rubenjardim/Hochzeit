package br.uniriotec.pssgbd.gerencia.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pssgbd.gerencia.model.entidade.Endereco;
import br.uniriotec.pssgbd.gerencia.model.entidade.Local;

public class LocalBO extends BaseBO<Local> {
	private static LocalBO instancia;
	private static List<Local> listarLocais = null;

	public static LocalBO getInstance() {
		if (instancia == null) {
			instancia = new LocalBO();
			listarLocais = new ArrayList<Local>();
		}
		return instancia;
	}

	public void incluir(Local local) throws Exception {
		listarLocais.add(local);
	}

	public Local consultar(Long id) throws Exception {
		return listarLocais.get(id.intValue());
	}

	public void alterar(Local local) throws Exception {
		listarLocais.remove(local);
		listarLocais.add(local);
	}

	@Override
	public void excluir(Local local) throws Exception {
		listarLocais.remove(local);
	}

	@Override
	public List<Local> listar() throws Exception {
		
		List<Endereco> listarEnderecos = this.listarEnderecos();
		
		List<Local> listarLocais = new ArrayList<Local>();
		Local local = null;
		
		local = new Local();
		local.setId(0l);
		local.setNome("Casa Matriz");
		local.setAmbiente("Casa de Festa");
		local.setEndereco(listarEnderecos.get(0));
		listarLocais.add(local);
		
		local = new Local();
		local.setId(1l);
		local.setNome("São Matheus");
		local.setAmbiente("Igreja");
		local.setEndereco(listarEnderecos.get(1));
		listarLocais.add(local);
		
		local = new Local();
		local.setId(2l);
		local.setNome("ZeroVinteUm");
		local.setAmbiente("Casa de Festa");
		local.setEndereco(listarEnderecos.get(2));
		listarLocais.add(local);
		
		return listarLocais;
	}
	
	public List<Endereco> listarEnderecos() throws Exception {
		List<Endereco> listarEnderecos = new ArrayList<Endereco>();
		Endereco endereco = null;

		endereco = new Endereco();
		endereco.setId(0l);
		endereco.setRua("Gonçalves Dias");
		endereco.setCep("22067-097");
		endereco.setBairro("Largo Machado");
		endereco.setCidade("Rio de Janeiro");
		endereco.setEstado("Rio de Janeiro");
		listarEnderecos.add(endereco);

		endereco = new Endereco();
		endereco.setId(1l);
		endereco.setRua("Machado de Assis");
		endereco.setCep("21027-017");
		endereco.setBairro("Ipanema");
		endereco.setCidade("Rio de Janeiro");
		endereco.setEstado("Rio de Janeiro");
		listarEnderecos.add(endereco);
		
		endereco = new Endereco();
		endereco.setId(1l);
		endereco.setRua("Imperador Dom Pedro II");
		endereco.setCep("21536-049");
		endereco.setBairro("Ipanema");
		endereco.setCidade("Rio de Janeiro");
		endereco.setEstado("Rio de Janeiro");
		listarEnderecos.add(endereco);

		return listarEnderecos;
	}

}
