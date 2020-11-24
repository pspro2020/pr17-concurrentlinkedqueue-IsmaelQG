package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cinta implements Runnable{
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private ConcurrentLinkedQueue<Elemento> separador = new ConcurrentLinkedQueue<>();
	
	public void accionarTolva(Elemento e) {
		separador.add(e);
	}

	@Override
	public void run() {
		while(!separador.isEmpty()) {
			try {
				System.out.print(separador.element().toString());
				separador.remove();
				TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
			}
			catch(InterruptedException e) {
				
			}
		}
		System.out.printf("%s -> Todos los elementos clasificados\n", LocalTime.now().format(format));
	}

}
