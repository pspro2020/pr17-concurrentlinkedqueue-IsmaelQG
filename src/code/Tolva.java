package code;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable{
	
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
	private Cinta cinta = new Cinta();
	private int id;
	private List<Elemento> listaElementos = new ArrayList<>();

	public Tolva(Cinta cinta, int id) {
		this.cinta = cinta;
		this.id = id;
		for(int i=0; i<5; i++) {
			listaElementos.add(new Elemento(id, i));
		}
	}
	
	@Override
	public void run() {
		System.out.printf("%s -> Tolva n�: %d encendida\n", LocalTime.now().format(format), id);
		for(Elemento i : listaElementos) {
			try {
				cinta.accionarTolva(i);
				TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%s -> Tolva n�: %d vac�a\n", LocalTime.now().format(format), id);
	}
	
	public int getId() {
		return id;
	}

}
