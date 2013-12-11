package py.consultores.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexion 
{
	private String host;
	private String puerto;
	private String usuario;
	private String password;
	private String base;
	private String controlador;
	private Connection conexion = null;
	private Properties config;
	
	public Conexion()
	{
		inicializar();
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setControlador(String controlador) {
		this.controlador = controlador;
	}
	
	private void inicializar()
	{
		try {
			config = new Properties();
			config.load(Conexion.class.getClassLoader().getResourceAsStream("configuracion/configuracion.properties")); 
			setHost(config.getProperty("host"));
			setPuerto(config.getProperty("puerto"));
			setUsuario(config.getProperty("usuario"));
			setPassword(config.getProperty("password"));
			setBase(config.getProperty("base"));
			setControlador(config.getProperty("controlador"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection conectar()
	{
		try 
		{
			String urlBaseDatos = "jdbc:postgresql://"+this.host+":"+this.puerto+"/"+this.base;
			Class.forName(this.controlador);
			//String urlBaseDatos = "jdbc:postgresql://fw.lan:5432/vc";
			//Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(urlBaseDatos, this.usuario,this.password);
			return conexion;
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void cerrarConexion()
	{
		try {
			this.conexion.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
