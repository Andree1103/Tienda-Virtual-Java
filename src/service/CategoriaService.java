package service;

import dao.DAOFactory;

import java.util.List;

import beans.Categoria;
import interfaces.CategoriaDAO;
import utils.Constantes;

public class CategoriaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	CategoriaDAO objCat = fabrica.getCategoria();
	
	public List<Categoria> listaCategoria(){
		return objCat.listarCategoria();
	}
	
	public Categoria buscaCategoria(int cod) {
		return objCat.buscarCategoria(cod);
	}
	
	public int registraCategoria(Categoria obj) {
		return objCat.registrarCategoria(obj);
	}
	
	public int actualizaCategoria(Categoria obj) {
		return objCat.actualizarCategoria(obj);
	}
	
	public int eliminaCategoria(int cod) {
		return objCat.eliminarCategoria(cod);
	}
	
	public List<Categoria> listaxNOM(String nom){
		return objCat.listarxNOM(nom);
	}
}
