package pe.edu.ulasalle.demo.excepciones;

public class BOAsistencia {

	public void registrarAsistencia() throws ExceptionChecked {
		
		if (true) {
			throw new ExceptionChecked("Ocurrio un problema");
		}
		
	}
	
	public void registrarDisponibilidad() {
		
		if (true) {
			throw new ExceptionNotChecked("Ocurrio un problema");
		}
		
		
		
	}
}
