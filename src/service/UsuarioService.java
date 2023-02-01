package service;

import java.util.List;

import beans.Usuario;
import dao.DAOFactory;
import interfaces.UsuarioDAO;
import utils.Constantes;

public class UsuarioService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	UsuarioDAO objU = fabrica.getUsuario();
	
	public List<Usuario> listar(){
		return objU.listar();
	}
	
	public Usuario IniciarSesion(String email, String contra) {
		return objU.IniciarSesion(email, contra);
	}
	public int registrarUsuario(Usuario obj) {
		return objU.registrarUsuario(obj);
	}
}
