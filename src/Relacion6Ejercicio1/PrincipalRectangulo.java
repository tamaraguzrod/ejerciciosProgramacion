package Relacion6Ejercicio1;

import java.util.Scanner;

/**
 * Crear una clase Rectangulo con los atributos longitud y ancho,
 * cada uno con un valor predeterminado igual a 1.
 * Proporcionar los métodos set y get para los atributos longitud y ancho respectivamente.
 * El método set debe verificar que longitud y ancho contengan números reales mayores que cero y menores que 20.
 * Además, proporcionar métodos que calculen el perímetro y el área del rectángulo.
 * 
 * Escribir un método main que solicite los datos de un rectángulo y muestre cual es su área y su perímetro.
 * Probar a introducir un dato incorrecto (mayor o igual que 20).
 * 
 * @author Tamara Guzmán.
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
			System.out.print("Introduzca la longitud del rectángulo: ");
			longitud = Double.parseDouble(teclado.nextLine());
			
			System.out.print("Introduzca el ancho del rectángulo: ");
			ancho = Double.parseDouble(teclado.nextLine());
			
			//Se crea el objeto de la clase.
			rectangulo = new Rectangulo(longitud, ancho);
			
			//Se solicita el perimetro y el area del rectangulo.
			System.out.println("El perimetro del rectángulo es: " + rectangulo.calcularPerimetroRectangulo());
			System.out.println("El área del rectángulo es: " + rectangulo.calcularAreaRectangulo());
			
			//Se vuelven a solicitar los datos para probar los sets.
			System.out.print("Introduzca la nueva longitud del rectángulo: ");
			longitud = Double.parseDouble(teclado.nextLine());
			rectangulo.setLongitud(longitud);
			
			System.out.print("Introduzca el nuevo ancho del rectángulo: ");
			ancho = Double.parseDouble(teclado.nextLine());
			rectangulo.setAncho(ancho);
			
			//Se actualizan los datos del perimetro y el area del rectangulo.
			System.out.println("El perimetro del rectángulo es: " + rectangulo.calcularPerimetroRectangulo());
			System.out.println("El área del rectángulo es: " + rectangulo.calcularAreaRectangulo());
			
			
		} catch (RectanguloException e) {
			System.out.println(e.getMessage());
		}

	}

}

