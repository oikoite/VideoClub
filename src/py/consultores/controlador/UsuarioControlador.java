package py.consultores.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import py.consultores.conexion.Conexion;
import java.sql.PreparedStatement;

public class UsuarioControlador {
	
	private Conexion con = new Conexion();
	public Usuario autenticar(String usuario, String passowrd) {
		Usuario usr = null;
		String sql = "SELECT nombre, loginname, passwd FROM usuario where loginname like ? and passwd like ?";
		PreparedStatement prstm;
		ResultSet rs;
		
		try {
			prstm = (PreparedStatement) con.conectar().prepareStatement(sql);
			prstm.setString(1, usuario);
			prstm.setString(2, passowrd);
			rs = prstm.executeQuery();
			while (rs.next()) {
				usr = new Usuario();
				usr.setNombre(rs.getString("nombre"));
				usr.setPassword(rs.getString("passwd"));
				usr.setUsername(rs.getString("loginname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usr;
	}

}
