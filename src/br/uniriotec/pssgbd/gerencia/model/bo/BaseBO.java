package br.uniriotec.pssgbd.gerencia.model.bo;

import java.util.List;

import br.uniriotec.pssgbd.gerencia.model.entidade.BaseEntity;
import br.uniriotec.pssgbd.gerencia.model.entidade.Cliente;
import br.uniriotec.pssgbd.gerencia.model.entidade.Usuario;

/**
 * Essa classe BO genérica da aplicação.
 * Todos os BOS deve estendê-la informando o seu tipo <T>
 * 
 * P.ex.: public class ClienteBO extends BaseBO<Cliente>
 *
 * 
 * @author Flavio
 *
 * @param <T>
 */
public abstract class BaseBO<T> {

	public abstract void incluir (T t) throws Exception;
	public abstract void alterar (T t) throws Exception;
	public abstract void excluir (T t) throws Exception;
	public abstract List<T> listar() throws Exception;
	
}
