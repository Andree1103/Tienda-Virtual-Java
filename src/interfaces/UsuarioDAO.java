package interfaces;

import java.util.List;

import beans.Usuario;

public interface UsuarioDAO {
	public List<Usuario> listar();
	public Usuario IniciarSesion(String email, String contra);
	public int registrarUsuario(Usuario obj);
}
