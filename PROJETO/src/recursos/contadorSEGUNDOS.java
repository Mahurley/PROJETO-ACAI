package recursos;

public class contadorSEGUNDOS {
	public static void conta(int valor) {
		try {
			Thread.sleep(valor);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
