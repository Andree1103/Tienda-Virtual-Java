package dao;

import interfaces.MarcaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Marca;
import utils.MySqlDBConexion;

public class MySqlMarcaDAO implements MarcaDAO {

	@Override
	public List<Marca> listarMarca() {
		List<Marca> data = new ArrayList<Marca>();
		Marca obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_marcas";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Marca();
				obj.setIdmarca(rs.getInt(1));
				obj.setNombremarca(rs.getString(2));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarMarca(Marca obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_marcas values(null,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombremarca());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarMarca(Marca obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_marcas set NombreMarca=? where IdMarca=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombremarca());
			pstm.setInt(2, obj.getIdmarca());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarMarca(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_marcas where IdMarca=?";
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
	public Marca buscarMarca(int cod) {
		Marca obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_marcas where IdMarca=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1,cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new Marca();
				obj.setIdmarca(rs.getInt(1));
				obj.setNombremarca(rs.getString(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Marca> listarxNom(String nom) {
		List<Marca> data = new ArrayList<Marca>();
		Marca obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_marcas where NombreMarca like ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, ("%"+nom+"%"));
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Marca();
				obj.setIdmarca(rs.getInt(1));
				obj.setNombremarca(rs.getString(2));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
