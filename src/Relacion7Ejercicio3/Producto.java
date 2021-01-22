package Relacion7Ejercicio3;

public class Producto {
	
	//ATRIBUTOS
	private int codigo;
	private String descripcion;
	private double precioSinIva;
	private Categoria categoria;
	private static int siguienteCodigoADar = 1;
	
	//CONSTRUCTOR
	public Producto(String descripcion, double precioSinIva, Categoria categoria) throws VentaException {
		
		//Esto genera los codigos automaticamente.
		this.codigo = siguienteCodigoADar;
		siguienteCodigoADar++;
		
		this.descripcion = descripcion;
		setPrecioSinIva(precioSinIva);
		this.categoria = categoria;
	}
	
	//METODOS GETTER Y SETTER

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioSinIva() {
		return precioSinIva;
	}

	public void setPrecioSinIva(double precioSinIva) throws VentaException{
		if (precioSinIva <= 0) {
			throw new VentaException("Error. El precio del producto no puede ser cero ni negativo.");
		}
		this.precioSinIva = precioSinIva;
	}

	public int getCodigo() {
		return codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	
	/**
	 * Metodo toString.
	 */
	public String toString() {
		String info;
		
		info=  "Producto \nCodigo: " + codigo + "\nDescripcion: " + descripcion + "\nPrecio Sin IVA: " + precioSinIva + "�."
				+ "\nCategoria del Producto: " + categoria;
		
		return info;
	}

	//METODOS DE LA CLASE
	
	/**
	 * Metodo que calcula el precio de venta de un producto con su IVA, dependiendo de la categoria.
	 * @return
	 */
	public double calcularPrecioConIva() {
		double precioConIva;
		
		 precioConIva = precioSinIva + (precioSinIva * categoria.getIva())/ 100; 
		
		return precioConIva;
		
		
	}
	
	

}
