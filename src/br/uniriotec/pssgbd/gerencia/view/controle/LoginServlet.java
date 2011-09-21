package br.uniriotec.pssgbd.gerencia.view.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.uniriotec.pssgbd.gerencia.model.bo.ClienteBO;
import br.uniriotec.pssgbd.gerencia.model.bo.UsuarioBO;
import br.uniriotec.pssgbd.gerencia.model.entidade.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			
			UsuarioBO usuarioBO = new UsuarioBO();
			List<Usuario> listaUsuario = usuarioBO.listar();
			
			for (int i = 0; i < listaUsuario.size(); i++) {
				
				if (username.equals(listaUsuario.get(i).getNome()) && password.equals(listaUsuario.get(i).getSenha())) {
					
					HttpSession session = request.getSession();
					session.setAttribute("username", username);

					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					
				}
				
			}
			
			response.sendRedirect("login.jsp");
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
