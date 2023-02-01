package dao;

import interfaces.CategoriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Categoria;
import utils.MySqlDBConexion;

public class MySqlCategoriaDAO implements CategoriaDAO {

	@Override
	public List<Categoria> listarCategoria() {
		List<Categoria> data = new ArrayList<Categoria>();
		Categoria obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_categorias";
			pstm = cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {
				obj = new Categoria();
				obj.setIdcategoria(rs.getInt(1));
				obj.setDescripción(rs.getString(2));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarCategoria(Categoria obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm= null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql ="insert into tb_categorias values(null,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripción());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarCategoria(Categoria obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_categorias set Descripcion=? where IdCategoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripción());
			pstm.setInt(2, obj.getIdcategoria());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarCategoria(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_categorias where IdCategoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public Categoria buscarCategoria(int cod) {
		Categoria obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_categorias where IdCategoria=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new Categoria();
				obj.setIdcategoria(rs.getInt(1));
				obj.setDescripción(rs.getString(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public List<Categoria> listarxNOM(String nom) {
		List<Categoria> data = new ArrayList<Categoria>();
		Categoria obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_categorias where Descripcion like ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, (nom+"%"));
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Categoria();
				obj.setIdcategoria(rs.getInt(1));
				obj.setDescripción(rs.getString(2));
				data.add(obj);
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
}
