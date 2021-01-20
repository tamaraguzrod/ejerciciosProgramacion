package Relacion7Ejercicio2;

import java.util.Scanner;

public class PrincipalPunto {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		Punto punto1 = new Punto(3, 4);
		Punto punto2 = new Punto(4,3);
		
		try {
			Linea linea1 = new Linea(punto1, punto2);
			System.out.println(linea1);
		} catch (LineaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
