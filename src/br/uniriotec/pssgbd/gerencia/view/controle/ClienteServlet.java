package br.uniriotec.pssgbd.gerencia.view.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uniriotec.pssgbd.gerencia.model.bo.ClienteBO;
import br.uniriotec.pssgbd.gerencia.model.entidade.Cidade;
import br.uniriotec.pssgbd.gerencia.model.entidade.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
public class ClienteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServlet() {
		super();
	}

	protected void incluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mensagem = null;
		try {
			RequestDispatcher rd = null;
			String nome = (String) request.getParameter("nome");
			Integer codCidade = Integer.valueOf(request.getParameter("cidade"));
			String sexo = (String) request.getParameter("sexo");
			
			Cliente cliente = new Cliente();
			cliente.setCidade(recuperaCidade(request, codCidade));
			cliente.setNome(nome);
			cliente.setSexo(sexo);
			
			ClienteBO.getInstance().incluir(cliente);
			request.setAttribute("cliente", cliente);
			
			mensagem = "Cliente incluido com Sucesso!";
			request.setAttribute("mensagem", mensagem);
			
			rd = request.getRequestDispatcher("clienteExibir.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Incluir Cliente&mensagem=Erro na inclus�o do cliente! Detalhe: " + e.getMessage());
		}
	}

	/**
	 * M�todo executado antes de apresentar a tela de inclus�o do cliente.
	 * Recupera a lista de cidades utilizada na inclus�o.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void antesIncluir(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Cidade> listaCidades = ClienteBO.getInstance().listarCidades();
			request.getSession().setAttribute("listaCidades", listaCidades);

			RequestDispatcher rd = request
					.getRequestDispatcher("clienteIncluir.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Incluir Cliente&mensagem=Erro na inclus�o do cliente! Detalhe: " + e.getMessage());
		}

	}
	
	protected void listar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Cliente> listaClientes = ClienteBO.getInstance().listar();
			request.setAttribute("listaClientes", listaClientes);

			RequestDispatcher rd = request
					.getRequestDispatcher("clienteListar.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Listar Cliente&mensagem=Erro na listagem de clientes! Detalhe: " + e.getMessage());
		}
	}
	
	

	/**
	 * M�todo que recupera uma cidade da sess�o atrav�s do seu id.
	 * 
	 * @param request
	 *            - cont�m o lista de cidades na sess�o
	 * @param codCidade
	 *            - c�digo da cidade que ser� localizada
	 * @return
	 */
	private Cidade recuperaCidade(HttpServletRequest request, Integer codCidade) {
		List<Cidade> listaCidades = (List<Cidade>) request.getSession()
				.getAttribute("listaCidades");
		for (Cidade cidade : listaCidades) {
			if (cidade.getCodCidade().equals(codCidade))
				return cidade;
		}

		return null;
	}

	/**
	 * Os m�todos com prefixo antes foram utilizados para reutilizar uma �nica p�gina de consulta para as funcionalidades:
	 * Consultar Cliente, Alterar Cliente e Excluir cliente.
	 * 
	 * Prepara as informa��es necess�rias para a altera��o: Consulta o cliente que ser� alterado e carrega a lista de cidades.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void antesAlterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			String comando = request.getParameter("comando");
			
			if (id != null) {
				
				Cliente cliente = ClienteBO.getInstance().consultar(
						Long.valueOf(id));
				request.setAttribute("cliente", cliente);
				
				List<Cidade> listaCidades = ClienteBO.getInstance().listarCidades();
				request.getSession().setAttribute("listaCidades", listaCidades);
				rd = request.getRequestDispatcher("clienteAlterar.jsp");
				
			} else {
				request.setAttribute("comando", comando);
				rd = request.getRequestDispatcher("clienteConsultar.jsp");
			}
			
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Alterar Cliente&mensagem=Erro na altera��o do cliente! Detalhe: " + e.getMessage());
		}
		
	}
	
	/**
	 * Os m�todos com prefixo antes foram utilizados para reutilizar uma �nica p�gina de consulta para as funcionalidades
	 * Consultar Cliente, Alterar Cliente e Excluir cliente.
	 * 
	 * Prepara as informa��es necess�rias para exclus�o do cliente: Consulta o cliente.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected void antesExcluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		try {
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			String comando = request.getParameter("comando");
			
			if (id != null) {
				
				Cliente cliente = ClienteBO.getInstance().consultar(
						Long.valueOf(id));
				request.setAttribute("cliente", cliente);
				
				rd = request.getRequestDispatcher("clienteExcluir.jsp");
				
			} else {
				request.setAttribute("comando", comando);
				rd = request.getRequestDispatcher("clienteConsultar.jsp");
			}
			
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Excluir Cliente&mensagem=Erro na exclus�o do cliente! Detalhe: " + e.getMessage());
		}
	}

	protected void alterar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			
			Cliente cliente = new Cliente();
			//TODO descomentar quando conectar o BD. Em mem�ria trabalhamos com o �ndice da cole��o.
			//cliente.setId(Long.valueOf(id));
			cliente.setNome(request.getParameter("nome"));
			cliente.setSexo(request.getParameter("sexo"));
			
			Cidade cidade = new Cidade();
			cidade.setCodCidade(Integer.valueOf(request.getParameter("cidade")));
			cidade.setNome(request.getParameter("nomeCidade"));
			cliente.setCidade(cidade);
			
			ClienteBO.getInstance().alterar(cliente);
			request.setAttribute("cliente", cliente);
			
			String mensagem = "Cliente alterado com sucesso!";
			request.setAttribute("mensagem", mensagem);
			
			rd = request.getRequestDispatcher("clienteAlterar.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Alterar Cliente&mensagem=Erro na altera��o do cliente! Detalhe: " + e.getMessage());
		}
		
	}

	protected void excluir(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			
			Cliente cliente = new Cliente();
			//TODO descomentar quando conectar o BD.
			//cliente.setId(Long.valueOf(id));
			
			ClienteBO.getInstance().excluir(cliente);
			
			String mensagem = "Cliente exclu�do com sucesso!";
			request.setAttribute("mensagem", mensagem);
			
			rd = request.getRequestDispatcher("cliente.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Excluir Cliente&mensagem=Erro na exclus�o do cliente! Detalhe: " + e.getMessage());
		}
		
		
	}

	protected void consultar(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			RequestDispatcher rd = null;
			String id = request.getParameter("id");
			String comando = request.getParameter("comando");
			
			if (id != null) {
				
				Cliente cliente = ClienteBO.getInstance().consultar(Long.valueOf(id));
				request.getSession().setAttribute("cliente", cliente);
				
				rd = request.getRequestDispatcher("clienteExibir.jsp");
				
			} else {
				request.setAttribute("comando", comando);
				rd = request.getRequestDispatcher("clienteConsultar.jsp");
			}
			
			rd.forward(request, response);
			
		} catch (Exception e) {
			response.sendRedirect("clienteErroGeral.jsp?tituloPagina=Consultar Cliente&mensagem=Erro na consulta de cliente! Detalhe: " + e.getMessage());
		}
		
		
	}
}
