package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Marca;
import beans.Usuario;
import service.ProductoService;
import service.UsuarioService;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsuarioService serviUsu = new UsuarioService();
    ProductoService serviPro = new ProductoService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("login")) {
			iniciarSesion(request, response);
		}
		else if (xtipo.equals("registrar")) {
			registrar(request, response);
		}
		else if (xtipo.equals("reporte")) {
			reporte(request, response);
		}
	}
	private void reporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviUsu.listar());
		request.getRequestDispatcher("reporteUsuario.jsp").forward(request, response);
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txt_email");
		String pass = request.getParameter("txt_pass");

		Usuario obj = serviUsu.IniciarSesion(email, pass);
		if (obj != null)
		{
			if((obj.getEmail().equals("ADMIN") && obj.getContrasenia().equals("123")) || (obj.getEmail().equals("ADMINISTRADORWEB") && obj.getContrasenia().equals("admin"))) {
				request.getRequestDispatcher("Menu.jsp").forward(request, response);
			}
			else if(obj.getEmail().equals(email) && obj.getContrasenia().equals(pass)) {
				request.setAttribute("productos",serviPro.listaProducto());
				request.getRequestDispatcher("ventaProductos.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msj","Contraseña incorrecta");
				request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
			}
			response.sendRedirect("menu.jsp");
		}
		else {
			request.setAttribute("msj", "Error usuario y/o clave");
			request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
		}
	}
	
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txt_email");
		String pass = request.getParameter("txt_pass");
		
		Usuario obj = new Usuario();
		obj.setEmail(email);
		obj.setContrasenia(pass);
		serviUsu.registrarUsuario(obj);
	}
}
