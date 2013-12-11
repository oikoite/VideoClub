package py.consultores.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HTTPClient.Request;

import py.consultores.controlador.ClienteControlador;
import py.consultores.modelo.Cliente;
import py.consultores.utils.LoggerGx;

public class ClienteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ClienteControlador clienteControlador = new ClienteControlador();
	private LoggerGx logger = new LoggerGx();
	
    public ClienteServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{				
			logger.log("Log");
			String operacion = request.getParameter("operacion");
			if(operacion!=null)
			{
		        switch (operacion) 
				{
					case "Editar":
						Cliente cliente = editar(new Integer(request.getParameter("id")));
						listar(request, response, cliente, "Editar");
						break;
					case "Eliminar":
						eliminar(new Integer(request.getParameter("id")));
						listar(request, response, "Eliminar");
						break;
					case "Agregar":
						agregar(request, response);
						listar(request, response, "Agregar");
						break;
					case "Modificar":
						modificar(request, response);
						listar(request, response, "Modificar");
						break;
					case "Cancelar":
						listar(request, response, "Cancelar");
						break;
					default:
						listar(request, response, "Listar");
						break;
				}
			}
			else
			{
				listar(request, response, "Listar");
			}
				
		}
		catch(Exception ex)
		{
			logger.log("Error:" + ex.toString());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		logger.log("DoPOST");
		doGet(request,response);
	}

	public void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Cliente cliente = new Cliente();
		
		cliente.setNombre(request.getParameter("nombreCliente"));
		cliente.setFechaNacimiento(request.getParameter("fechaNaCliente"));
		cliente.setTelefono(request.getParameter("telefonoCliente"));
		cliente.setDireccion(request.getParameter("direccionCliente"));
		cliente.setMail(request.getParameter("emailCliente"));
		cliente.setEstado(request.getParameter("estadoCliente"));
		clienteControlador.insertarCliente(cliente);
	}
	
	public Cliente editar(Integer idCliente)
	{
		return clienteControlador.obtenerCliente(idCliente);
	}
	
	public void modificar(HttpServletRequest request, HttpServletResponse response)
	{
		Cliente cliente = new Cliente();
		cliente.setId(new Integer(request.getParameter("idCliente")));
		cliente.setNombre(request.getParameter("nombreCliente"));
		cliente.setFechaNacimiento(request.getParameter("fechaNaCliente"));
		cliente.setTelefono(request.getParameter("telefonoCliente"));
		cliente.setDireccion(request.getParameter("direccionCliente"));
		cliente.setMail(request.getParameter("emailCliente"));
		cliente.setEstado(request.getParameter("estadoCliente"));
		clienteControlador.actualizarCliente(cliente);
	}
	
	public void eliminar(Integer idCliente)
	{
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		clienteControlador.eliminarCliente(cliente);
	}
	
	public void listar(HttpServletRequest request, HttpServletResponse response, 
			String operacion)throws ServletException, IOException
	{
		List<Cliente> lista = clienteControlador.listaClientes();
        if(lista != null)
        {  
        	request.setAttribute("clientes", lista);
        }
    	request.setAttribute("operacion", operacion);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);	
	}
	
	public void listar(HttpServletRequest request, HttpServletResponse response, 
			Cliente cliente, String operacion) throws ServletException, IOException
	{
		List<Cliente> lista = clienteControlador.listaClientes();
        if(lista != null)
        {  
        	request.setAttribute("clientes", lista);
        }
        request.setAttribute("cliente", cliente);
    	request.setAttribute("operacion", operacion);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);	
	}
}
