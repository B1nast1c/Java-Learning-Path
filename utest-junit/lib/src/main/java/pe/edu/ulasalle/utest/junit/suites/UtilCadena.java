package pe.edu.ulasalle.utest.junit.suites;

public class UtilCadena {

	public static boolean esBlanco(String input) {
        return input == null || input.trim().isEmpty();
    }
	
	public static String concatenar(String input, String input2) {
        return input+input2;
    }
	
	public static String mayus(String input) {
        return input.toUpperCase();
    }
}
