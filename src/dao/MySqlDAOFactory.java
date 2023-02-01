package dao;

import interfaces.*;

public class MySqlDAOFactory extends DAOFactory{
	@Override
	public ProductoDAO getProducto() {
		
		return new MySqlProductoDAO();
	}
	
	@Override
	public ClienteDAO getCliente() {
		
		return new MySqlClienteDAO();
	}
	
	@Override
	public CategoriaDAO getCategoria() {
		// TODO Auto-generated method stub
		
		
		return new MySqlCategoriaDAO();
	}

	@Override
	public MarcaDAO getMarca() {
		return new MySqlMarcaDAO();
	}

	@Override
	public UsuarioDAO getUsuario() {
		return new MySqlUsuarioDAO();
	}
}
