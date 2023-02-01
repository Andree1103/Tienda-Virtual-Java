package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import interfaces.UsuarioDAO;
import utils.MySqlDBConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public Usuario IniciarSesion(String email, String contra){
		Usuario obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_usuarios where email=? and contrasenia=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1,email);
			pstm.setString(2,contra);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new Usuario();
				obj.setIdUsuario(rs.getInt(1));
				obj.setEmail(rs.getString(2));
				obj.setContrasenia(rs.getString(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public List<Usuario> listar(){
		List<Usuario> data = new ArrayList<Usuario>();
		Usuario obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_usuarios";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Usuario();
				obj.setIdUsuario(rs.getInt(1));
				obj.setEmail(rs.getString(2));
				obj.setContrasenia(rs.getString(3));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public int registrarUsuario(Usuario obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_usuarios values (null,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getEmail());
			pstm.setString(2, obj.getContrasenia());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
}
