package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable{
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private Cinta cinta = new Cinta();
	private int id;

	public Tolva(Cinta cinta, int id) {
		this.cinta = cinta;
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.printf("%s -> Tolva nº: %d encendida\n", LocalTime.now().format(format), id);
		for(int i=0; i<5; i++) {
			try {
				cinta.accionarTolva(new Elemento(id, i));
				TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%s -> Tolva nº: %d vacía\n", LocalTime.now().format(format), id);
	}
	
	public int getId() {
		return id;
	}

}
