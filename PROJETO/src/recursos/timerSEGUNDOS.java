package recursos;

public class timerSEGUNDOS {
	public timerSEGUNDOS(int valor) {
		try {
			Thread.sleep(valor);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
