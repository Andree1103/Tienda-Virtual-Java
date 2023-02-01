package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Producto;
import interfaces.ProductoDAO;
import utils.MySqlDBConexion;

public class MySqlProductoDAO implements ProductoDAO {
	
	@Override
	public List<Producto> listarProducto() {
		List<Producto> data = new ArrayList<Producto>();
		Producto obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select tp.IdProducto, tp.NombreProducto, tp.PrecioUnidad, tp.StockProducto, tm.IdMarca, tm.NombreMarca, tc.IdCategoria, tc.Descripcion from tb_productos tp inner join tb_marcas tm on tp.IdMarca = tm.IdMarca inner join tb_categorias tc on tp.IdCategoria = tc.IdCategoria";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Producto();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));
				obj.setIdMarca(rs.getInt(5));
				obj.setNombreMarca(rs.getString(6));
				obj.setIdCategoria(rs.getInt(7));
				obj.setNombreCategoria(rs.getString(8));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	
	@Override
	public int registrarProducto(Producto obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;	
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into tb_productos values(null,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setInt(3, obj.getStock());
			pstm.setInt(4, obj.getIdMarca()); 
			pstm.setInt(5, obj.getIdCategoria()); 
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarProducto(Producto obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update tb_productos set NombreProducto=?, PrecioUnidad=?,  StockProducto=?, IdMarca=?, IdCategoria=? where IdProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setInt(3, obj.getStock());
			pstm.setInt(4, obj.getIdMarca());
			pstm.setInt(5, obj.getIdCategoria());
			pstm.setInt(6, obj.getCodigo());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarProducto(int id) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_productos where IdProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public Producto buscarProducto(int id) {
		Producto obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
				
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from tb_productos where IdProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new Producto();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));    
		        obj.setNombreMarca(rs.getString(5)); 
		        obj.setNombreCategoria(rs.getString(6));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public List<Producto> listarxPrecio(double precio) {
		List<Producto> data = new ArrayList<Producto>();
		Producto obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select tp.IdProducto, tp.NombreProducto, tp.PrecioUnidad, tp.StockProducto, tm.IdMarca, tm.NombreMarca, tc.IdCategoria, tc.Descripcion from tb_productos tp inner join tb_marcas tm on tp.IdMarca = tm.IdMarca inner join tb_categorias tc on tp.IdCategoria = tc.IdCategoria where tp.PrecioUnidad>=?";
			pstm = cn.prepareStatement(sql);
			pstm.setDouble(1, precio);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new Producto();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));
				obj.setIdMarca(rs.getInt(5));
				obj.setNombreMarca(rs.getString(6));
				obj.setIdCategoria(rs.getInt(7));
				obj.setNombreCategoria(rs.getString(8));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	
	@Override
	public List<Producto> buscarProductoxcod(int cod) {
		Producto obj = null;
		List<Producto> data = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select tp.IdProducto, tp.NombreProducto, tp.PrecioUnidad, tp.StockProducto, tm.IdMarca, tm.NombreMarca, tc.IdCategoria, tc.Descripcion from tb_productos tp inner join tb_marcas tm on tp.IdMarca = tm.IdMarca inner join tb_categorias tc on tp.IdCategoria = tc.IdCategoria where tp.IdProducto=?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new Producto();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));
				obj.setIdMarca(rs.getInt(5));
				obj.setNombreMarca(rs.getString(6));
				obj.setIdCategoria(rs.getInt(7));
				obj.setNombreCategoria(rs.getString(8));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}	
}
