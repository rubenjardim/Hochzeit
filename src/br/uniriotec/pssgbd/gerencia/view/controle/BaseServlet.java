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
 * Classe respons�vel por processar as requisi��es da aplica��o.
 * 
 * Serve como "template" para os servlets da aplica��o.
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
	 * Executa um m�todo na inst�ncia do servlet. Por exemplo: m�todo incluir em
	 * ClienteServlet. A var��vel comando deve conter o nome do m�todo que ser�
	 * executado na inst�ncia.
	 * 
	 * @param request
	 * @param response
	 */
	private void invocarMetodo(HttpServletRequest request,
			HttpServletResponse response) {
		String comando = request.getParameter("comando");
		System.out.println("BaseServlet " + comando);

		try {

			// array que cont�m os par�metros necess�rios para localizar o m�todo na inst�ncia.
			Class partypes[] = new Class[2];
			partypes[0] = HttpServletRequest.class;
			partypes[1] = HttpServletResponse.class;

			// A inst�ncia do servlet, p. ex. ClienteServlet
			Class cls = this.getClass();
			Method meth = cls.getDeclaredMethod(comando, partypes);

			// par�metros que foram recebidos pelo BaseServlet (requisi��o)
			Object arglist[] = new Object[2];
			arglist[0] = request;
			arglist[1] = response;

			// invoca o m�todo, p. ex. incluir na classe ClienteServlet
			Object retobj = meth.invoke(this, arglist);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
