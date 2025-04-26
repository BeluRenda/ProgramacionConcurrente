
public class Sistema {

	public static void main(String[] args) {
		
		MonitorPuente monitor = new MonitorPuente();
		
		//	Coches Direccion Norte-Sur
		new Coches("coche rojo en direccion Norte-Sur", monitor);
		new Coches("coche azul en direccion Norte-Sur", monitor);
		new Coches("coche verde en direccion Norte-Sur", monitor);
		
		
		// Coches Direccion Sur-Norte
		new Coches("coche amarillo en direccion Sur-Norte", monitor);
		new Coches("coche blanco en direccion Sur-Norte", monitor);
		new Coches("coche negro en direccion Sur-Norte", monitor);
	}

}
