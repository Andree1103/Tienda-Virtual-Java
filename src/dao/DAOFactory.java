package dao;

import interfaces.*;

public abstract class DAOFactory {
	   // Posibles orígenes de Datos
	   public static final int MYSQL = 1;
	   public static final int ORACLE = 2;
	   public static final int DB2 = 3;
	   public static final int SQLSERVER = 4;
	   public static final int XML = 5;

	   // Se ponen tantas interfaces como tengas
	   public abstract ProductoDAO getProducto();
	   
	   public abstract ClienteDAO getCliente();
	   
		public abstract CategoriaDAO getCategoria();
		
		public abstract MarcaDAO getMarca();
		
		public abstract UsuarioDAO getUsuario();

	   public static DAOFactory getDAOFactory(int whichFactory) {
	      switch(whichFactory) {
	         case MYSQL:
	            return new MySqlDAOFactory();
	         case ORACLE:
	            // return new OracleDAOFactory();
	         case SQLSERVER:
	            // return new SQLServerDAOFactory();
	      }
	      return null;
	   }
}
