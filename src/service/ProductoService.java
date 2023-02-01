package service;

import java.util.List;

import beans.Producto;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;


public class ProductoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProductoDAO objPro = fabrica.getProducto();

	public List<Producto> listaProducto() {
		return objPro.listarProducto();
	}
	
	public List<Producto> listaxPrecio(double precio) {
		return objPro.listarxPrecio(precio);
	}
	
	public List<Producto> buscarProductoxcod(int cod) {
		return objPro.buscarProductoxcod(cod);
	}
	
	public Producto buscaProducto(int id) {
		return objPro.buscarProducto(id);
	}
	
	public int registraProducto(Producto obj) {
		return objPro.registrarProducto(obj);
	}
	
	public int actualizaProducto(Producto obj) {
		return objPro.actualizarProducto(obj);
	}
	
	public int eliminaProducto(int id) {
		return objPro.eliminarProducto(id);
	}
	
}