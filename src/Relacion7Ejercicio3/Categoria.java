package Relacion7Ejercicio3;

public class Categoria {

	//ATRIBUTOS
	private static final double IVA_MAXIMO = 100;
	private String nombreCategoria;
	private double iva;
	
	//CONSTRUCTOR
	public Categoria(String nombreCategoria, double iva) throws VentaException {
		this.nombreCategoria = nombreCategoria;
		setIva(iva);
	}

	//METODOS GETTER Y SETTER
	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) throws VentaException {
		if (iva > IVA_MAXIMO) {
			throw new VentaException("Error. El IVA no puede ser superior a " + IVA_MAXIMO + "%.");
		}
		this.iva = iva;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		String info;
		
		info = "Categoria: \nNombre de la categoria: " + nombreCategoria + "\nIVA de la categoria: " + iva + "%.";
		
		return info;
	}
	
	
	
	
	
}
