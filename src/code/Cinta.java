package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cinta {
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private ConcurrentLinkedQueue<Elemento> separador = new ConcurrentLinkedQueue<>();
	
	public void accionarTolva(int idTolva, int idElemento) {
		separador.add(new Elemento(idTolva, idElemento));
	}
	
	public void clasificar() throws InterruptedException {
		while(!separador.isEmpty()) {
			System.out.print(separador.element().toString());
			separador.remove();
			TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
		}
		System.out.printf("%s -> Todos los elementos clasificados\n", LocalTime.now().format(format));
	}

}
