package foody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) 
	{
		System.out.println("Conectando");
		Conector instancia = Conector.getInstancia();
		
		// Ejercicio 1
		
		try
		{
			System.out.println("Nombre de los menus: ");
			ArrayList<String> listNombres = instancia.ejercicio1();
			for(String nombre:listNombres)
			{
				System.out.println(nombre);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// Ejercicio 2
		
		try
		{
			System.out.println("Nombre de los clientes con nombre de tarjeta de credito terminada en ton: ");
			ArrayList<String> listNombres = instancia.ejercicio2();
			for(String nombre:listNombres)
			{
				System.out.println(nombre);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// Ejercicio 3
		
		try
		{
			System.out.println("Numero de pagos en efectivo del cliente max: ");
			int nP = instancia.ejercicio3();
			System.out.println(nP);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
