package Relacion6Ejercicio1;

import java.util.Scanner;

/**
 * Crear una clase Rectangulo con los atributos longitud y ancho,
 * cada uno con un valor predeterminado igual a 1.
 * Proporcionar los m�todos set y get para los atributos longitud y ancho respectivamente.
 * El m�todo set debe verificar que longitud y ancho contengan n�meros reales mayores que cero y menores que 20.
 * Adem�s, proporcionar m�todos que calculen el per�metro y el �rea del rect�ngulo.
 * 
 * Escribir un m�todo main que solicite los datos de un rect�ngulo y muestre cual es su �rea y su per�metro.
 * Probar a introducir un dato incorrecto (mayor o igual que 20).
 * 
 * @author Tamara Guzm�n.
 *
 */

public class PrincipalRectangulo {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		//VARIABLES
		Rectangulo rectangulo;
		double longitud, ancho;
		
		try {
			//Se crea el rectangulo con la longitud y el ancho.
			System.out.print("Introduzca la longitud del rect�ngulo: ");
			longitud = Double.parseDouble(teclado.nextLine());
			
			System.out.print("Introduzca el ancho del rect�ngulo: ");
			ancho = Double.parseDouble(teclado.nextLine());
			
			//Se crea el objeto de la clase.
			rectangulo = new Rectangulo(longitud, ancho);
			
			//Se solicita el perimetro y el area del rectangulo.
			System.out.println("El perimetro del rect�ngulo es: " + rectangulo.calcularPerimetroRectangulo());
			System.out.println("El �rea del rect�ngulo es: " + rectangulo.calcularAreaRectangulo());
			
			//Se vuelven a solicitar los datos para probar los sets.
			System.out.print("Introduzca la nueva longitud del rect�ngulo: ");
			longitud = Double.parseDouble(teclado.nextLine());
			rectangulo.setLongitud(longitud);
			
			System.out.print("Introduzca el nuevo ancho del rect�ngulo: ");
			ancho = Double.parseDouble(teclado.nextLine());
			rectangulo.setAncho(ancho);
			
			//Se actualizan los datos del perimetro y el area del rectangulo.
			System.out.println("El perimetro del rect�ngulo es: " + rectangulo.calcularPerimetroRectangulo());
			System.out.println("El �rea del rect�ngulo es: " + rectangulo.calcularAreaRectangulo());
			
			
		} catch (RectanguloException e) {
			System.out.println(e.getMessage());
		}

	}

}

