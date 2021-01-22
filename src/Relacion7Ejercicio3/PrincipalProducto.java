package Relacion7Ejercicio3;

import java.util.Scanner;

public class PrincipalProducto {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			// Crear categoria
			Categoria categoria = new Categoria("ALIMENTACION", 18);

			// Crear productos
			Producto producto1 = new Producto("PATATAS FRITAS", 1.5, categoria);

			Producto producto2 = new Producto("PAN", 1, categoria);
			
			//Precio con IVA.
			System.out.println("Precio del producto1 es: " + producto1.calcularPrecioConIva() + "%.");
			System.out.println("Precio del producto2 es: " + producto1.calcularPrecioConIva() + "%.");
			
		} catch (VentaException e) {
			System.out.println(e.getMessage());
		}

	}

}
