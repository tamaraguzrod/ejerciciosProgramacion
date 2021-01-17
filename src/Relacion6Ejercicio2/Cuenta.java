package Relacion6Ejercicio2;

public class Cuenta {

	// ATRIBUTOS
	private double saldo;
	private String titular;
	private int contadorReintegros;
	private int contadorIngresos;

	// CONSTRUCTORES
	public Cuenta(String titular) {
		this.titular = titular;
		this.saldo = 0;
		this.contadorReintegros = 0;
		this.contadorIngresos = 0;
	}

	public Cuenta(double saldo, String titular) throws CuentaException {
		if (saldo < 0) {
			throw new CuentaException("Error. El saldo de una cuenta no puede ser negativo.");
		}
		this.titular = titular;
		this.saldo = saldo;
		this.contadorReintegros = 0;
		this.contadorIngresos = 0;

	}

	// METODOS GETTER Y SETTER
	public double getSaldo() {
		return saldo;
	}

	public String getTitularCuenta() {
		return titular;
	}

	public int getContadorReintegros() {
		return contadorReintegros;
	}

	public int getContadorIngresos() {
		return contadorIngresos;
	}

	/**
	 * Metodo toString.
	 */
	public String toString() {
		String info;

		info = "Cuenta: \nTitular: " + titular + "\nSaldo: " + saldo + "\nNumero de Reintegros: " + contadorReintegros
				+ "\nNumero de Ingresos: " + contadorIngresos;

		return info;
	}

	/**
	 * Metodo que realiza el reintegro de una cantidad teniendo en cuenta que la
	 * cantidad no sea negativa ni cero.
	 * 
	 * @param cantidadASacar
	 */
	public void sacarDinero(double cantidadASacar) throws CuentaException {
		if (cantidadASacar <= 0) {
			throw new CuentaException("Error. El reintegro se realiza con cantidades positivas.");

		}
		if (cantidadASacar > saldo) {
			throw new CuentaException("Error. No tiene saldo.");
		}
		// Al saldo se le resta la cantidad de dinero a sacar.
		saldo = saldo - cantidadASacar;
		contadorReintegros++;
	}

	

	/**
	 * Metodo que realiza el ingreso de una cantidad teniendo en cuenta que la
	 * cantidad no sea negativa ni cero.
	 * 
	 * @param cantidadAIngresar
	 */
	public void ingresarDinero(double cantidadAIngresar) throws CuentaException {
		if (cantidadAIngresar <= 0) {
			throw new CuentaException("Error. El ingreso se realiza con cantidades positivas.");
		}
		// Al saldo se le suma la cantidad de dinero que se ingresa.
		saldo = saldo + cantidadAIngresar;
		contadorIngresos++;
	}
}
