package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import service.CategoriaService;

/**
 * Servlet implementation class ServletCategoria
 */
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoriaService serviCategoria = new CategoriaService();

    /**
     * Default constructor. 
     */
    public ServletCategoria() {
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
		String xt=request.getParameter("tipo");
		if (xt.equals("listar")) {
			listar(request,response);
		}
		else if (xt.equals("buscar")) {
			buscar(request, response);
		}
		else if (xt.equals("registrar")) {
			registrar(request,response);
		}
		else if (xt.equals("actualizar")) {
			actualizar(request,response);
		}
		else if (xt.equals("eliminar")) {
			eliminar(request,response);
		}
		else if  (xt.equals("ListaxNOM")) {
			ListaxNOM(request,response);
		}
	}

	private void ListaxNOM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("txt_desc");
		request.setAttribute("data", serviCategoria.listaxNOM(nom));
		request.getRequestDispatcher("listarCategoria.jsp").forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviCategoria.eliminaCategoria(cod);
		listar(request,response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod;
		cod = Integer.parseInt(request.getParameter("txt_id"));
		String des = request.getParameter("txt_des");
		Categoria obj = new Categoria();
		obj.setIdcategoria(cod);
		obj.setDescripción(des);
		serviCategoria.actualizaCategoria(obj);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String des = request.getParameter("txt_des");
		Categoria obj = new Categoria();
		obj.setDescripción(des);
		serviCategoria.registraCategoria(obj);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Categoria", serviCategoria.buscaCategoria(cod));
		request.getRequestDispatcher("actualizarCategoria.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviCategoria.listaCategoria());
		request.getRequestDispatcher("listarCategoria.jsp").forward(request, response);
	}

}
