package py.consultores.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CerrarSession
 */
public class CerrarSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        if(request.getSession(false) !=null){
        		request.getSession(false).invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
