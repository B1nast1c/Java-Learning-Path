package pe.edu.ulasalle.utest.junit.basico;

import pe.edu.ulasalle.utest.junit.basico.exception.DivisionPorZeroException;

public class ClaseDemo {

	public int ejecutarSuma(int a, int b) {
		return a+b;
	}
	
	public int ejecutarResta(int a, int b) {
		return a-b;
	}
	
	public int ejecutarMultiplicacion(int a, int b) {
		return a*b;
	}
	
	public int ejecutarDivision(int a, int b) {
		if (b == 0) {
			throw new DivisionPorZeroException("El denominador no puede ser cero");
		}
		return a/b;
	}
}
