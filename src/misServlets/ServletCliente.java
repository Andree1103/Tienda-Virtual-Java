package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//
	ClienteService serviCliente = new ClienteService();
	//
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
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
	
	//
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equals("listar"))
			listar(request, response);
		else if (xtipo.equals("registrar"))
			Registrar(request, response);
		else if (xtipo.equals("buscar"))
			Buscar(request, response);
		else if (xtipo.equals("actualizar"))
			Actualizar(request, response);
		else if (xtipo.equals("eliminar"))
			Eliminar(request, response);
		else if (xtipo.equals("BuscarxNombrexApellido"))
			BuscarxNomxApe(request, response);
		else if (xtipo.equals("reporte"))
			Reporte(request, response);
	   }

	//Listar
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setAttribute("data", serviCliente.listarCliente());
	      request.getRequestDispatcher("listarCliente.jsp").forward(request, response);
	   }
	
	//Registrar
	
	   private void Registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      Cliente obj = new Cliente();
		      String nom = request.getParameter("txt_nom");
		      String ape = request.getParameter("txt_ape");
		      String telf = request.getParameter("txt_telf");
		      String co = request.getParameter("txt_co");
		      String dir = request.getParameter("txt_dir");
		      obj.setNombre(nom);
		      obj.setApellido(ape);
		      obj.setTelefono(telf);
		      obj.setCorreo(co);
		      obj.setDireccion(dir);
		      int estado = serviCliente.registrarCliente(obj);
		      if (estado != -1)
		         listar(request, response);
		      else
		         response.sendRedirect("error.html");
		   }
	   
	   //Buscar
	   
		private void Buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String dato = request.getParameter("cod");
		      int codigo = Integer.parseInt(dato);
		      Cliente x = serviCliente.BuscarCliente(codigo);
		      request.setAttribute("registro", x);
		      request.getRequestDispatcher("ActualizarCliente.jsp").forward(request, response);      
		}
		
		
		//Actualizar
	   
		private void Actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      Cliente obj = new Cliente();
		      String cod = request.getParameter("txt_cod");
		      String nom = request.getParameter("txt_nom");
		      String ape = request.getParameter("txt_ape");
		      String telf = request.getParameter("txt_telf");
		      String co = request.getParameter("txt_co");
		      String dir = request.getParameter("txt_dir");
		      obj.setCodigo(Integer.parseInt(cod));
		      obj.setNombre(nom);
		      obj.setApellido(ape);
		      obj.setTelefono(telf);
		      obj.setCorreo(co);
		      obj.setDireccion(dir);
		      int estado = serviCliente.actualizarCliente(obj);
		      if (estado != -1)
		         listar(request, response);
		      else
		         response.sendRedirect("error.html");
		   }
		

		//Eliminar
		private void Eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String dato = request.getParameter("cod");
		      int codigo = Integer.parseInt(dato);
		      serviCliente.EliminarCliente(codigo);
		      request.getRequestDispatcher("ServletCliente?tipo=listar").forward(request, response);
		}
	
		// Buscar x Nombre y Apellido
		private void BuscarxNomxApe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String nom = request.getParameter("Buscar");
			String cbo = request.getParameter("Elegir");
			if (cbo.equals(cbo.valueOf("1"))) {
				request.setAttribute("data", serviCliente.BuscarXnomCliente(nom));
			} 
			else {
				request.setAttribute("data", serviCliente.BuscarXapeCliente(nom));
			}	
			request.getRequestDispatcher("listarCliente.jsp").forward(request, response);
				
		}
		
		// Reporte
		private void Reporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("data", serviCliente.listarCliente());
			request.getRequestDispatcher("reporteCliente.jsp").forward(request, response);
		   }
		
}
