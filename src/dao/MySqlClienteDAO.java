package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import interfaces.ClienteDAO;
import utils.MySqlDBConexion;

public class MySqlClienteDAO implements ClienteDAO {
	
	// Listar
	@Override
	public List<Cliente> listarCliente() {
		List<Cliente> data = new ArrayList<Cliente>();
		Cliente obj = null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
	         cn = MySqlDBConexion.getConexion();
	         String sql = "select*from tb_clientes";
	         pstm = cn.prepareStatement(sql);
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            obj = new Cliente();
	            obj.setCodigo(rs.getInt(1));
	            obj.setNombre(rs.getString(2));
	            obj.setApellido(rs.getString(3));
	            obj.setTelefono(rs.getString(4));
	            obj.setCorreo(rs.getString(5));
	            obj.setDireccion(rs.getString(6));
	            data.add(obj);
	         }
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return data;
	   }
	
	//Registrar
	
	public int registrarCliente(Cliente obj) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MySqlDBConexion.getConexion();
	         String sql = "insert into tb_clientes values(null,?,?,?,?,?)";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getNombre());
	         pstm.setString(2, obj.getApellido());
	         pstm.setString(3, obj.getTelefono());
	         pstm.setString(4, obj.getCorreo());
	         pstm.setString(5, obj.getDireccion());
	         estado = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         try {
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      return estado;
	   }
	
	// Buscar 
	
	public Cliente BuscarCliente(int cod) {

		Cliente c = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select*from tb_clientes where IdCliente = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next()) {
				c = new Cliente();
				c.setCodigo(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setTelefono(rs.getString(4));
				c.setCorreo(rs.getString(5));
				c.setDireccion(rs.getString(6));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return c;
	}
	
	// Actualizar
	public int actualizarCliente(Cliente obj) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      try {
	         cn = MySqlDBConexion.getConexion();
	         String sql = "update tb_clientes set NombreCliente=?, ApellidoCliente=?, Telefono=?, Correo=?, Direccion=? where IdCliente=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getNombre());
	         pstm.setString(2, obj.getApellido());
	         pstm.setString(3, obj.getTelefono());
	         pstm.setString(4, obj.getCorreo());
	         pstm.setString(5, obj.getDireccion());
	         pstm.setInt(6, obj.getCodigo());
	         estado = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         try {
	            if (pstm != null)
	               pstm.close();
	            if (cn != null)
	               cn.close();
	         }
	         catch (Exception e2) {
	            e2.printStackTrace();
	         }
	      }
	      return estado;
	   }
	
	//Eliminar
	
	public int EliminarCliente(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_clientes where IdCliente = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	// Buscar por nombre
	
	@Override
	public List<Cliente> BuscarXnomCliente(String nom) {
		List<Cliente> data = new ArrayList<Cliente>();
		Cliente obj = null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
	         cn = MySqlDBConexion.getConexion();
	         String sql = "select*from tb_clientes where NombreCliente like ? ";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1,("%"+nom+"%"));
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            obj = new Cliente();
	            obj.setCodigo(rs.getInt(1));
	            obj.setNombre(rs.getString(2));
	            obj.setApellido(rs.getString(3));
	            obj.setTelefono(rs.getString(4));
	            obj.setCorreo(rs.getString(5));
	            obj.setDireccion(rs.getString(6));
	            data.add(obj);
	         }
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return data;
	   }
	
	
	// Buscar por Apellido
	
	@Override
	public List<Cliente> BuscarXapeCliente(String ape) {
		List<Cliente> data = new ArrayList<Cliente>();
		Cliente obj = null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
	         cn = MySqlDBConexion.getConexion();
	         String sql = "select*from tb_clientes where ApellidoCliente like ?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1,("%"+ape+"%"));
	         rs = pstm.executeQuery();
	         while (rs.next()) {
	            obj = new Cliente();
	            obj.setCodigo(rs.getInt(1));
	            obj.setNombre(rs.getString(2));
	            obj.setApellido(rs.getString(3));
	            obj.setTelefono(rs.getString(4));
	            obj.setCorreo(rs.getString(5));
	            obj.setDireccion(rs.getString(6));
	            data.add(obj);
	         }
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return data;
	   }
	
}
