package code;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Cinta cinta = new Cinta();
		Thread tolvaThread;
		for(int i=0; i<5; i++) {
			tolvaThread = new Thread(new Tolva(cinta ,i));
			tolvaThread.start();
		}
		
		TimeUnit.SECONDS.sleep(3);
		
		cinta.clasificar();
	}

}
