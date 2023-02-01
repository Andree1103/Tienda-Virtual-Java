package service;

import java.util.List;

import beans.Cliente;
import dao.DAOFactory;
import interfaces.ClienteDAO;
import utils.Constantes;


public class ClienteService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ClienteDAO objC = fabrica.getCliente();

	//Colocar funciones proximas
	public List<Cliente> listarCliente() {
		return objC.listarCliente();
	}
	
	// Registrar
	public int registrarCliente(Cliente obj) {
		return objC.registrarCliente(obj);
	}
	
	// Buscar
	public Cliente BuscarCliente(int cod) {
		return objC.BuscarCliente(cod);
	}
	
	//Actualizar
	public int actualizarCliente(Cliente obj) {
		return objC.actualizarCliente(obj);
	}
	
	//Eliminar
	public int EliminarCliente(int cod) {
		return objC.EliminarCliente(cod);
	}
	
	//Buscar por Apellido
	public List<Cliente> BuscarXapeCliente(String ape) {
		return objC.BuscarXapeCliente(ape);
	}
	
	//Buscar por Nombre
	public List<Cliente> BuscarXnomCliente(String nom){
		return objC.BuscarXnomCliente(nom);
	}
}
