package Relacion7Ejercicio5;

public class Partido {

	// CONSTANTES
	private static final int MIN_JORNADA = 1;
	private static final int MAX_JORNADA = 38;

	// ATRIBUTOS
	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	private boolean haJugado;

	// CONSTRUCTOR
	private Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws LigaException {
		if (jornada < MIN_JORNADA || jornada > MAX_JORNADA) {
			throw new LigaException(
					"Error. La Jornada tiene que ser mínimo " + MIN_JORNADA + " y maximo " + MAX_JORNADA);
		}
		this.jornada = jornada;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		setResultadoQuiniela(resultadoQuiniela);
		this.haJugado = false;

	}

	// METODOS GETTER Y SETTER
	public int getGolesLocal() {
		return golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public int getJornada() {
		return jornada;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public boolean isHaJugado() {
		return haJugado;
	}

	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

	public void setResultadoQuiniela(char resultadoQuiniela) throws LigaException {
		if (!(resultadoQuiniela == '1' || resultadoQuiniela == 'X' || resultadoQuiniela == '2')) {
			throw new LigaException("Error. Datos de la quiniela incorrectos.");
		}
		this.resultadoQuiniela = resultadoQuiniela;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		String info;

		if (!this.haJugado) {
			info = "Partido entre equipo Local " + equipoLocal + " y equipo Visitante " + equipoVisitante
					+ " todavia no se ha jugado.";
		} else {
			info = "Partido entre equipo local " + equipoLocal + " y el equipo Visitante " + equipoVisitante
					+ "jugado en el estadio " + " de la ciudad" + "ha finalizado con " + golesLocal
					+ " goles de equipo local y " + golesVisitante + " goles de equipo visitante."
					+ "Resultado quiniela ";
		}

		return info;
	}

	// METODOS DE LA CLASE
	public void ponerResultado(String resultado) throws LigaException {
		if (resultado.length() == 0) {
			throw new LigaException("Error. El resultado no puede estar vacio.");
		}

	}

}
