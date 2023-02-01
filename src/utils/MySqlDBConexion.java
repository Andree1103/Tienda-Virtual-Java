package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConexion {
	public static Connection getConexion() {
			Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tienda_gamer2022","root","mysql");
		} catch (Exception e) {
			System.out.println("Error de conexion :" + e.getMessage());
		}
		return cn;
	}
}
