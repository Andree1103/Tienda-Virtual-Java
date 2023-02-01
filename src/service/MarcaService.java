package service;

import java.util.List;

import dao.DAOFactory;
import beans.Marca;
import interfaces.MarcaDAO;
import utils.Constantes;

public class MarcaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	MarcaDAO objMar = fabrica.getMarca();
	
	public List<Marca> listaMarca(){
		return objMar.listarMarca();
	}
	public Marca buscaMarca(int cod) {
		return objMar.buscarMarca(cod);
	}
	public int registraMarca (Marca obj) {
		return objMar.registrarMarca(obj);
	}
	public int actualizaMarca (Marca obj) {
		return objMar.actualizarMarca(obj);
	}
	public int eliminarMarca(int cod) {
		return objMar.eliminarMarca(cod);
	}
	public List<Marca> listaxNom(String nom){
		return objMar.listarxNom(nom);
	}
}
