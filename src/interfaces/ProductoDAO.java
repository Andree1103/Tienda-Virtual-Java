package interfaces;

import java.util.List;

import beans.Producto;

public interface ProductoDAO {

	public List<Producto> listarProducto();
	// La pr�xima los dem�s m�todos del CRUD
	public int registrarProducto(Producto obj);
	public int actualizarProducto(Producto obj);
	public int eliminarProducto(int id);
	public Producto buscarProducto(int id);	
	public List<Producto> listarxPrecio(double precio);
	public List<Producto> buscarProductoxcod(int cod);
}
