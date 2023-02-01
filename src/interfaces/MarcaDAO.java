package interfaces;

import java.util.List;
import beans.Marca;

public interface  MarcaDAO {
	public List<Marca> listarMarca();
	public int registrarMarca(Marca obj);
	public int actualizarMarca(Marca obj);
	public int eliminarMarca(int cod);
	public Marca buscarMarca(int cod);
	public List<Marca> listarxNom(String nom);
}
