package pe.edu.ulasalle.utest.test.junit.suites;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import pe.edu.ulasalle.utest.junit.suites.UtilCadena;
import pe.edu.ulasalle.utest.junit.suites.UtilNumerico;

public class GeneracionParam {

	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
	void suiteEsImpar(int number) {
	    assertEquals(true, UtilNumerico.esImpar(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
	void suiteEsImparEnObjet(int number) {
	    assertEquals(true, new UtilNumerico().esImpar(number));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"  ", "\t", "\n"})
	void suiteEsBlanco(String input) {
	    assertEquals(true, UtilCadena.esBlanco(input));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {" abc", " ### "})
	void suiteNoEsBlanco(String input) {
	    assertEquals(false, UtilCadena.esBlanco(input));
	}
	
	@ParameterizedTest
	@CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
	void suiteCadenaEsperado(String input, String expected) {
	    String actualValue = UtilCadena.mayus(input);
	    assertEquals(expected, actualValue);
	}
	
	@ParameterizedTest
	@CsvSource({"5,1,6", "6,2,8", "7,3,10"})
	void suiteMultipleInputEsperado(int input1, int input2, int expected) {
	    assertEquals(expected, UtilNumerico.sumar(input1, input2));
	}
	
	@ParameterizedTest(name = "{index} => concatena {0} y {1} para {2}")
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1, delimiter = ',')
	void suiteCsv(String input, String input2, String expected) {
	    assertEquals(expected, UtilCadena.concatenar(input, input2));
	}
}
