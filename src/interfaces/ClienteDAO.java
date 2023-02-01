package interfaces;

import java.util.List;

import beans.Cliente;

public interface ClienteDAO {
	
	//(Listar,Buscar,Registrar,Actualizar,Eliminar)
	
	public List<Cliente> listarCliente();
	
	public int registrarCliente(Cliente obj);
	
	public Cliente BuscarCliente(int cod);
	
	public int actualizarCliente(Cliente obj);
	
	public int EliminarCliente(int cod);
	
	//Buscar por Nombre
	public List<Cliente> BuscarXnomCliente(String nom);
	
	// Buscar por Apellido
	public List<Cliente> BuscarXapeCliente(String ape);
}
