package br.uniriotec.pssgbd.gerencia.model.bo;

import java.util.ArrayList;
import java.util.List;

import br.uniriotec.pssgbd.gerencia.model.entidade.Cidade;
import br.uniriotec.pssgbd.gerencia.model.entidade.Cliente;
import br.uniriotec.pssgbd.gerencia.model.entidade.Local;
import br.uniriotec.pssgbd.gerencia.model.entidade.Usuario;

public class LocalBO extends BaseBO<Local> {
	private static LocalBO instancia;
	private static List<Local> listaLocal = null;

	public static LocalBO getInstance() {
		if (instancia == null) {
			instancia = new LocalBO();
			listaLocal = new ArrayList<Local>();
		}
		return instancia;
	}

	public void incluir(Local local) throws Exception {
		listaLocal.add(local);
	}

	public Local consultar(Long id) throws Exception {
		return listaLocal.get(id.intValue());
	}

	public void alterar(Local local) throws Exception {
		listaLocal.remove(local);
		listaLocal.add(local);
	}

	@Override
	public void excluir(Local local) throws Exception {
		listaLocal.remove(local);
	}

	@Override
	public List<Local> listar() throws Exception {
		return listaLocal;
	}

}
