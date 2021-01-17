package Relacion6Ejercicio1;

public class Rectangulo {

	//CONSTANTES
	private static final int LONGITUD_POR_DEFECTO = 1;
	private static final int ANCHO_POR_DEFECTO = 1;
	private static final int LONGITUD_MAXIMA = 20;
	private static final int ANCHO_MAXIMO = 20;
	
	//ATRIBUTOS
	private double longitud, ancho;
	
	//CONSTRUCTORES
	public Rectangulo() {
		this.longitud = LONGITUD_POR_DEFECTO;
		this.ancho = ANCHO_POR_DEFECTO;
	}
	
	public Rectangulo(double longitud, double ancho) throws RectanguloException{
		setLongitud(longitud);
		setAncho(ancho);
	}
	
	
	//METODOS GETTER Y SETTER
	public double getLongitud() {
		return longitud;
	}

	public double getAncho() {
		return ancho;
	}

	public void setLongitud(double longitud) throws RectanguloException{
		
		if (longitud <= 0 || longitud > LONGITUD_MAXIMA ) {
			throw new RectanguloException("Error. La longitud no puede ser negativa ni mayor a " 
			+ LONGITUD_MAXIMA + ".");
		}
		
		this.longitud = longitud;
	}

	public void setAncho(double ancho) throws RectanguloException{
		
		if (ancho <= 0 || ancho > ANCHO_MAXIMO) {
			throw new RectanguloException("Error. El ancho no puede ser negativo ni mayor a " + ANCHO_MAXIMO + ".");
		}
		
		this.ancho = ancho;
	}
	
	//METODOS DE LA CLASE
	
	/**
	 * Metodo que calcula el perimetro de un rectangulo.
	 * @return
	 */
	public double calcularPerimetroRectangulo() {
		double perimetro;
		
		return perimetro = (longitud * 2) + (ancho * 2);
	}
	
	/**
	 * Metodo que calcula el area de un rectangulo.
	 * @return
	 */
	public double calcularAreaRectangulo() {
		double area;
		
		return area = longitud * ancho;
	}
	
	
	
}
