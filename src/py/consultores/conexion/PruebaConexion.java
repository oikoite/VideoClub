package py.consultores.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Conexion conn = new Conexion();
		Connection conexion = conn.conectar();
		Statement intruccion = null;
		ResultSet conjuntoResultados = null;
		
		try {
			intruccion = conexion.createStatement();
			String sql="select id_cliente, nombre, fecha_nac::date from cliente";
			conjuntoResultados = intruccion.executeQuery(sql);
			
			ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
			int numeroDeColumnas = metaDatos.getColumnCount();
			
			System.out.println("TABLA CLIENTES");
			for (int i = 1; i <= numeroDeColumnas; i++) 
				System.out.printf("%-8s\t",metaDatos.getColumnName(i));
			System.out.println();
			while (conjuntoResultados.next()) 
			{
				for (int i = 1; i <= numeroDeColumnas; i++)
					System.out.printf("%-8s\t", conjuntoResultados.getObject(i));
				System.out.println();
			}
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
