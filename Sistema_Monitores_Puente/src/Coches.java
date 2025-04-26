import java.util.Random;

public class Coches extends Thread {
	
	private enum STATE{ESPERANDO, OBSERVANDO, CRUZANDO};
	private STATE state;
	private String direccion;
	private int times;
	private static int totalCoches;
	private MonitorPuente monitor;
	private int vecesCruzadas = 0;
	
	
	public Coches(String n, MonitorPuente m) {
		times = totalCoches++;
		direccion = n;
		state = STATE.ESPERANDO;
		monitor = m;
		start();
	}
	
	private void esperar() {
		System.out.println("Un " + direccion + " esta¡ ESPERANDO para cruzar. ");
		Random rdm = new Random();
		int waitingTime = rdm.nextInt(250 - 50 + 1) + 50;
		
		try {
			sleep(waitingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El " + direccion + " deja de ESPERAR. ");
		state = STATE.OBSERVANDO;
	}
	
	private void observar() {
		System.out.println("El " + direccion + " esta¡ OBSERVANDO si se puede cruzar. ");
		monitor.luzRoja(times);
		
		// El coche que observa tiene luz verde para pasar
		state = STATE.CRUZANDO;
	}
	
	private void cruzar() {
		System.out.println("Un " + direccion + " esta¡ CRUZANDO el puente. "
							+ "[" + vecesCruzadas + " veces " + state + "]");
		
		Random rdm = new Random();
		int passingTime = rdm.nextInt(250 - 50 + 1) + 50;
		
		try {
			sleep(passingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vecesCruzadas++;
		monitor.luzVerde(times);
		state = STATE.ESPERANDO;
	}
	
	@Override
	public void run() {
		while(true) {
			switch(state) {
			case CRUZANDO:
					cruzar();
					break;
			case OBSERVANDO:
				observar();
				break;
			case ESPERANDO:
				esperar();
				break;
			}
		}	
	}
}
