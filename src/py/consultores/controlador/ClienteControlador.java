package py.consultores.controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import py.consultores.conexion.Conexion;
import py.consultores.modelo.Cliente;
import py.consultores.utils.LoggerGx;

public class ClienteControlador 
{
	private Conexion con;
	private Connection conexion;
	private PreparedStatement instruccion = null;
	private ResultSet listaClientes = null;
	
	public ClienteControlador()
	{
		con = new Conexion();
		conexion = con.conectar();
	}
	
	/*public static void main(String[] args) {
		ClienteControlador a = new ClienteControlador();
		List<Cliente> lista = a.listaClientes();
		Iterator<Cliente> it = lista.iterator();
		Cliente c = new Cliente();
		while (it.hasNext()) {
			c = it.next();
		}
	}*/
	 public String dateFormat(Date ddate){
         java.text.SimpleDateFormat dia = new java.text.SimpleDateFormat("yyyy-MM-dd");
         String Fecha = dia.format(ddate);
         return Fecha; 
    }
	
	public List<Cliente> listaClientes()
	{
		List<Cliente> lista = new ArrayList<>();
		Cliente cliente = null;
		
		String sql = 
				"select " +
						"id_cliente," +
						"nombre," +
						"fecha_nac," +
						"telefono," +
						"direccion," +
						"mail," +
						"estado " +
				"from " +
						"cliente";
		try {
			
			instruccion   = conexion.prepareStatement(sql);
			listaClientes = instruccion.executeQuery();
            while (listaClientes.next()) 
            {

            	
            	cliente = new Cliente();
				cliente.setId(listaClientes.getInt("id_cliente"));
				cliente.setNombre(listaClientes.getString("nombre"));
				cliente.setFechaNacimiento(formatearFecha(listaClientes.getString("fecha_nac")));
				//cliente.setFechaNacimiento(listaClientes.getString("fecha_nac"));
				cliente.setTelefono(listaClientes.getString("telefono"));
				cliente.setDireccion(listaClientes.getString("direccion"));
				cliente.setMail(listaClientes.getString("mail"));
				cliente.setEstado(listaClientes.getString("estado"));
				lista.add(cliente);
            }
			
			return lista;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void insertarCliente(Cliente cliente)
	{
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
			Date fechaNac = new Date(formatter.parse(cliente.getFechaNacimiento()).getTime());
			
			String sql = 
					"insert into cliente " +
						"( " +
							"nombre," +
							"fecha_nac," +
							"direccion," +
							"telefono," +
							"mail," +
							"estado" +
						")values" +
						"(" +
							"?, " +
							"?, " +
							"?, " +
							"?, " +
							"?, " +
							"?  " +
						")";

			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, cliente.getNombre());
			instruccion.setDate(2,fechaNac);
			instruccion.setString(3, cliente.getDireccion());
			instruccion.setString(4, cliente.getTelefono());
			instruccion.setString(5, cliente.getMail());
			instruccion.setString(6, cliente.getEstado());
			instruccion.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
}		
		
	
	public void actualizarCliente(Cliente cliente)
	{
		try {
			LoggerGx.log("ActualizarCliente >Fecha:" + cliente.getFechaNacimiento());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");		
			Date fechaNac = new Date(formatter.parse(cliente.getFechaNacimiento()).getTime());
			
			String sql = 
					"update " +
							"cliente " +
					"set " +
							"nombre    = ? ," +
							"fecha_nac = ? ," +
							"direccion = ? ," +
							"telefono  = ? ," +
							"mail 	   = ? ," +
							"estado    = ?  " +
					"where " +
							"id_cliente = ?";
		
			instruccion = conexion.prepareStatement(sql);
			instruccion.setString(1, cliente.getNombre());
			instruccion.setDate(2,fechaNac);
			instruccion.setString(3, cliente.getDireccion());
			instruccion.setString(4, cliente.getTelefono());
			instruccion.setString(5, cliente.getMail());
			instruccion.setString(6, cliente.getEstado());
			instruccion.setInt(7, cliente.getId());
			
			instruccion.executeUpdate();
		} catch (SQLException e) 
		{
			LoggerGx.log("actualizarCliente> Error:" + e.toString());
			e.printStackTrace();
		} catch (ParseException e) 
		{
			LoggerGx.log("actualizarCliente> Error:" + e.toString());
			e.printStackTrace();
		}
	}
	
	public void eliminarCliente(Cliente cliente)
	{
		String sql = 
				"delete from " +
						"cliente " +
				"where " +
						"id_cliente = ?";
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setInt(1, cliente.getId());
			instruccion.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Cliente obtenerCliente(Integer idCliente)
	{
		Cliente cliente = new Cliente();

		String sql = 
				"select " +
						"id_cliente, " +
						"nombre, " +
						"fecha_nac, " +
						"telefono, " +
						"direccion, " +
						"mail, " +
						"estado " +
				"from " +
						"cliente " +
				"where " +
						"id_cliente = ?";
		try {
			instruccion = conexion.prepareStatement(sql);
			instruccion.setInt(1, idCliente);
			ResultSet resultado = instruccion.executeQuery();
			resultado.next();
			cliente.setId(resultado.getInt("id_cliente"));
			cliente.setNombre(resultado.getString("nombre"));
			cliente.setFechaNacimiento(formatearFecha(resultado.getString("fecha_nac")));
			cliente.setTelefono(resultado.getString("telefono"));
			cliente.setDireccion(resultado.getString("direccion"));
			cliente.setMail(resultado.getString("mail"));
			cliente.setEstado(resultado.getString("estado"));
			
			return cliente;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String formatearFecha(String fechaNac)
	{
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String fecha[] = null;
	    	fecha = new Date(formatter.parse(fechaNac).getTime()).toString().split("-");
			return fecha[2]+"/"+fecha[1]+"/"+fecha[0];	
		} catch (ParseException e) {
			System.out.println("error al parsear la fecha: " + e.getMessage());
			return null;
		}
		
	}
	
}
