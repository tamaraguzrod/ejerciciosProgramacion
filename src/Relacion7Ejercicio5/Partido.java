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
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws LigaException {
		if (jornada < MIN_JORNADA || jornada > MAX_JORNADA) {
			throw new LigaException(
					"Error.La Jornada tiene que ser minimo " + MIN_JORNADA + " y maximo " + MAX_JORNADA);
		}
		this.jornada = jornada;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
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

	public void setGolesLocal(int golesLocal) throws LigaException {
		if (golesLocal < 0) {
			throw new LigaException("Error. Los goles del equipo local son incorrectos.");
		}
		this.golesLocal = golesLocal;
	}

	public void setGolesVisitante(int golesVisitante) throws LigaException {
		if (golesVisitante < 0) {
			throw new LigaException("Error. Los goles del equipo visitante son incorrectos.");
		}
		this.golesVisitante = golesVisitante;
	}

	public boolean isHaJugado() {
		return haJugado;
	}

	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

	/**
	 * Metodo toString
	 */
	public String toString() {
		String info;

		if (!this.haJugado) {
			info = "Partido entre equipo Local " + equipoLocal.getNombreEquipo() + " y equipo Visitante "
					+ equipoVisitante.getNombreEquipo() + " todavia no se ha jugado.";
		} else {
			info = "INFORMACION DEL PARTIDO: " + "\nPartido entre equipo local " + equipoLocal.getNombreEquipo()
					+ " y el equipo visitante " + equipoVisitante.getNombreEquipo() + "\nEn el estadio "
					+ equipoLocal.getNombreEstadio() + " de la ciudad " + equipoLocal.getCiudad()
					+ " ha finalizado con " + golesLocal + " goles de equipo local y " + golesVisitante
					+ " goles de equipo visitante." + "\nResultado quiniela " + resultadoQuiniela;
		}

		return info;
	}

	// METODOS DE LA CLASE
	public void ponerResultado(String resultado) throws LigaException {
		int posicionDelGuion, parteGolesLocal, parteGolesVisitante;

		// Se juega el partido.
		haJugado = true;

		if (resultado.length() == 0) {
			throw new LigaException("Error. El resultado no puede estar vacio.");
		}

		// Se busca el guion con indexOf en la cadena resultado.
		posicionDelGuion = resultado.indexOf('-');

		// Se busca la parte en la cadena resultado de los goles del local.
		parteGolesLocal = Integer.parseInt(resultado.substring(0, posicionDelGuion));
		// Lo mismo con la de los goles del visitante.
		parteGolesVisitante = Integer.parseInt(resultado.substring(posicionDelGuion + 1));

		// Se actualiza los sets de goles de local y visitante.
		setGolesLocal(parteGolesLocal);
		setGolesVisitante(parteGolesVisitante);

		// Si ambos equipos empatan.
		if (golesLocal == golesVisitante) {

			resultadoQuiniela = 'X';
		} else {
			// Si gana el equipo local, se incrementan sus partidos ganados.
			if (golesLocal > golesVisitante) {
				equipoLocal.incrementarPartidosGanados();
				resultadoQuiniela = '1';
			} else {
				equipoVisitante.incrementarPartidosGanados();
				resultadoQuiniela = '2';
			}
		}

	}

}
