package pe.edu.ulasalle.utest.junit.basico.exception;

public class DivisionPorZeroException extends RuntimeException {

	public DivisionPorZeroException(String mensaje) {
		super(mensaje);
	}
}
