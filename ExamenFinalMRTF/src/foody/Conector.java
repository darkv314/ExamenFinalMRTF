package foody;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Conector {
	// Atributos de la clase

	private static Connection con;
	private static Conector INSTANCE = null;

	// conector
	private Conector() {
	}

	private synchronized static void crearInstancia() {
		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "ricardoT";
		String password = "trapizonda1";
		String dataBase = "foody";
		try {
			// Importando la libreria de conexion mysql
			Class.forName("com.mysql.jdbc.Driver");
			String urlConection = "jdbc:mysql://" + host + "/" + dataBase + "?user=" + user + "&password=" + password;
			con = DriverManager.getConnection(urlConection);
			System.out.println("Nice");
		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
			System.out.println(e);
		}
	}

	public static Conector getInstancia() {
		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	public ArrayList<String> ejercicio1() throws SQLException {
		ArrayList<String> listaNombres = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement(
				"select menu_name from  menu where menu_id in (select menu_id from orders where order_status = \"PAYMENT_CONFIRMED\")");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaNombres.add(rs.getString("menu_name"));
		}
		rs.close();
		return listaNombres;
	}

	public ArrayList<String> ejercicio2() throws SQLException {
		ArrayList<String> listaNombres = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement(
				"select first_name from customer where customer_id in (SELECT distinct customer_id from payment_details where SUBSTRING(card_holder_name, char_length(card_holder_name)-2 , 3) = \"ton\")");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			listaNombres.add(rs.getString("first_name"));
		}
		rs.close();
		return listaNombres;
	}

	public int ejercicio3() throws SQLException {
		int numeroPagos = 0;
		PreparedStatement ps = con.prepareStatement(
				"select count(id) from payment where payment_type = \"CASH_ON_DELIVERY\" and order_id in (select order_id from orders where customer_id in (select customer_id from customer where first_name = \"max\"))");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			numeroPagos = rs.getInt("count(id)");
		}
		rs.close();
		return numeroPagos;
	}
}
