package pe.edu.ulasalle.demo.excepciones;

public class MainExcepciones {

	public static void main(String[] args) {
		BOAsistencia bo = new BOAsistencia();
		bo = null;
		try {
			bo.registrarAsistencia();
		} catch (ExceptionChecked e) {
			//trato de solucionar
			System.out.println("Ha ocurrido un problema inesperado. Intente mas tarde");
		}
		bo.registrarDisponibilidad();
	}
}
