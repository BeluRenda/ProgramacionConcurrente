
public class MonitorPuente {
	
	private boolean[] acceso = new boolean [6];
	
	public MonitorPuente() {
		
		for(int i = 0; i< 6; i++) {
			acceso[i] = true;
		}
	}
	
	public synchronized void luzRoja(int i) {
		
		// El coche espera a que cambie la luz a verde
		while(!acceso[i]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		acceso[i] = false;	
	}
		
		public synchronized void luzVerde(int i) {
			
			//	un coche ha terminado de pasar y la luz verde se enciende
			acceso[i] = true;
			
			//	notificamos al coche que esta¡ en espera que el puente esta¡ vacio y puede cruzar
			notify();
	}
}
