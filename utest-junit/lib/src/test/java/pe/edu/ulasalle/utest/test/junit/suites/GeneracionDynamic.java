package pe.edu.ulasalle.utest.test.junit.suites;

import static org.junit.jupiter.api.Assertions.assertEquals;  

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import pe.edu.ulasalle.utest.junit.suites.UtilNumerico;

public class GeneracionDynamic {

	@TestFactory
    Collection<DynamicTest> pruebasEnteros() {
		Collection<DynamicTest> col = new ArrayList<DynamicTest>();
		DynamicTest dina1 = DynamicTest.dynamicTest("Prueba suma", () -> 
		{ 
			assertEquals(2, UtilNumerico.sumar(1, 1));
			
		});
		col.add(dina1);
		DynamicTest dina2 = DynamicTest.dynamicTest("Prueba multiplicacion", () -> {assertEquals(4, UtilNumerico.multiplicar(2, 2));}
				);
		col.add(dina2);
        return col;
    }
	
	@TestFactory
    Collection<DynamicTest> pruebasDecimales() {
		Collection<DynamicTest> col = new ArrayList<DynamicTest>();
		DynamicTest dina1 = DynamicTest.dynamicTest("Prueba division", () -> assertEquals(2, UtilNumerico.dividir(4, 2)));
		col.add(dina1);
		return col;
    }
}
