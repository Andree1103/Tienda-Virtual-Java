package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Marca;
import service.MarcaService;

/**
 * Servlet implementation class ServletMarca
 */
@WebServlet("/ServletMarca")
public class ServletMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MarcaService serviMarca = new MarcaService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMarca() {
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
		String xm=request.getParameter("tipo");
		if (xm.equals("listar")) {
			listar(request,response);
		}
		else if (xm.equals("buscar")) {
			buscar(request, response);
		}
		else if (xm.equals("registrar")) {
			registrar(request,response);
		}
		else if (xm.equals("actualizar")) {
			actualizar(request,response);
		}
		else if (xm.equals("eliminar")) {
			eliminar(request,response);
		}
		else if (xm.equals("ListaxNom")) {
			ListaxNom(request,response);
		}
	}

	private void ListaxNom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("txt_buscar");
		request.setAttribute("data", serviMarca.listaxNom(nom));
		request.getRequestDispatcher("listarMarca.jsp").forward(request, response); 
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviMarca.eliminarMarca(cod);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod;
		cod = Integer.parseInt(request.getParameter("txt_idM"));
		String nom = request.getParameter("txt_nom");
		Marca obj = new Marca();
		obj.setIdmarca(cod);
		obj.setNombremarca(nom);
		serviMarca.actualizaMarca(obj);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("txt_nom");
		Marca obj = new Marca();
		obj.setNombremarca(nom);
		serviMarca.registraMarca(obj);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Marca", serviMarca.buscaMarca(cod));
		request.getRequestDispatcher("actualizarMarca.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviMarca.listaMarca());
		request.getRequestDispatcher("listarMarca.jsp").forward(request, response);
	}

}
