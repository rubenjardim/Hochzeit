package br.uniriotec.pssgbd.gerencia.view.controle;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniriotec.pssgbd.gerencia.model.entidade.BaseEntity;


/**
 * Classe responsável por processar as requisições da aplicação.
 * 
 * Serve como "template" para os servlets da aplicação.
 * 
 * @author Flavio
 *
 */

public abstract class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected abstract void incluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	protected abstract void alterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	protected abstract void excluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	protected abstract void listar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	protected abstract void consultar(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		invocarMetodo(req, resp);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		invocarMetodo(request, response);
	}

	/**
	 * Executa um método na instância do servlet. Por exemplo: método incluir em
	 * ClienteServlet. A varíável comando deve conter o nome do método que será
	 * executado na instância.
	 * 
	 * @param request
	 * @param response
	 */
	private void invocarMetodo(HttpServletRequest request,
			HttpServletResponse response) {
		String comando = request.getParameter("comando");
		System.out.println("BaseServlet " + comando);

		try {

			// array que contém os parâmetros necessários para localizar o método na instância.
			Class partypes[] = new Class[2];
			partypes[0] = HttpServletRequest.class;
			partypes[1] = HttpServletResponse.class;

			// A instância do servlet, p. ex. ClienteServlet
			Class cls = this.getClass();
			Method meth = cls.getDeclaredMethod(comando, partypes);

			// parâmetros que foram recebidos pelo BaseServlet (requisição)
			Object arglist[] = new Object[2];
			arglist[0] = request;
			arglist[1] = response;

			// invoca o método, p. ex. incluir na classe ClienteServlet
			Object retobj = meth.invoke(this, arglist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
