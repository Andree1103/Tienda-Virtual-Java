package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Producto;
import service.ProductoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoService serviProducto = new ProductoService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
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
		if (xtipo.equals("listar")) {
			listar(request, response);
		}
		else if (xtipo.equals("buscar")) {
			buscar(request, response);
		}
		else if (xtipo.equals("registrar")) {
			registrar(request, response);
		}
		else if (xtipo.equals("actualizar")) {
			actualizar(request, response);
		}
		else if (xtipo.equals("eliminar")) {
			eliminar(request, response);
		}
		else if (xtipo.equals("listarxPrecio"))
			buscador(request, response);
		else if (xtipo.equals("reporte")) {
			reporte(request, response);
		}
	}

	private void buscador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dato = request.getParameter("txt_consulta");
		String cbo = request.getParameter("Elegir");
		
		if (cbo.equals(cbo.valueOf("1"))) {
			int codigo = Integer.parseInt(dato);
			request.setAttribute("data", serviProducto.buscarProductoxcod(codigo));
		} 
		else {
			double precio = Double.parseDouble(dato);
			request.setAttribute("data", serviProducto.listaxPrecio(precio));
		}	
		
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cod"));
		serviProducto.eliminaProducto(id);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoria, marca, stock, id;
		id = Integer.parseInt(request.getParameter("txt_IdProducto"));
		String nom = request.getParameter("txt_NombreProducto");
		double pre = Double.parseDouble(request.getParameter("txt_PrecioUnidad"));
		stock = Integer.parseInt(request.getParameter("txt_StockProducto"));
		marca = Integer.parseInt(request.getParameter("txt_IdMarca"));
		categoria = Integer.parseInt(request.getParameter("txt_IdCategoria"));
		Producto obj = new Producto();
		obj.setCodigo(id);
		obj.setDescripcion(nom);
		obj.setPrecio(pre);
		obj.setStock(stock);
		obj.setIdMarca(marca);
		obj.setIdCategoria(categoria);
		serviProducto.actualizaProducto(obj);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoria, marca, stock;
		String des = request.getParameter("txt_NombreProducto");
		double pre = Double.parseDouble(request.getParameter("txt_PrecioUnidad"));
		stock = Integer.parseInt(request.getParameter("txt_StockProducto"));
		marca = Integer.parseInt(request.getParameter("txt_IdMarca"));
		categoria = Integer.parseInt(request.getParameter("txt_IdCategoria"));
		Producto obj = new Producto();
		obj.setDescripcion(des);
		obj.setPrecio(pre);
		obj.setStock(stock);
		obj.setIdMarca(marca);
		obj.setIdCategoria(categoria);
		serviProducto.registraProducto(obj);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Producto", serviProducto.buscaProducto(id));
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviProducto.listaProducto());
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}

	private void reporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviProducto.listaProducto());
		request.getRequestDispatcher("reporteProducto.jsp").forward(request, response);
	}
}
