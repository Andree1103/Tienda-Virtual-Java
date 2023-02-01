package interfaces;

import java.util.List;
import beans.Categoria;

public interface CategoriaDAO {
	public List<Categoria> listarCategoria();
	public int registrarCategoria(Categoria obj);
	public int actualizarCategoria(Categoria obj);
	public int eliminarCategoria(int cod);
	public Categoria buscarCategoria(int cod);
	public List<Categoria> listarxNOM(String nom);
}
