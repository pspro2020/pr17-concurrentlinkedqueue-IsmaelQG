package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Elemento {
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private int idTolva;
	private int idElemento;
	
	public Elemento(int idTolva, int idElemento) {
		this.idTolva = idTolva;
		this.idElemento = idElemento;
		System.out.printf("%s -> El elemento nº:%d de la tolva: %d ha caido a la cinta\n",LocalTime.now().format(format), idElemento, idTolva);
	}
	
	@Override
	public String toString() {
		return String.format("%s -> El elemento nº:%d de la tolva: %d ha sido clasificado\n",LocalTime.now().format(format), idElemento, idTolva);
	}

}
