package py.consultores.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import py.consultores.controlador.Usuario;
import py.consultores.controlador.UsuarioControlador;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuario = null;
	private HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Usuario usr = (Usuario)request.getSession().getAttribute("usuario"); 
    	if(null == usr){
    			UsuarioControlador controlador = new UsuarioControlador();
    			try {
    				usuario = controlador.autenticar(request.getParameter("user").toString(), request.getParameter("password").toString());
    			} catch (Exception e) {
    				request.getRequestDispatcher("login.jsp");
				}
    			if(usuario != null){
    				session = request.getSession(true);
    				session.setAttribute("usuario", usuario);
    				
    				try {
						request.getRequestDispatcher("Cliente").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
    				
    			}else{
    				try {
						request.getRequestDispatcher("login.jsp").forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    	}else{
    		try {
				request.getRequestDispatcher("Cliente").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
  
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

}
