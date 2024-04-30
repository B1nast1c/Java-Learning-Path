import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class DynamicArrayTest {

	@Test
	void testAdd() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        assertEquals("Peubes", names.get(0));
	}

	@Test
	void testPut() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        
        names.put(0, "Pancho");
        assertEquals("Pancho", names.get(0));
	}

	@Test
	void testGet() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        
        String nombre = names.get(0);

        assertEquals("Peubes", nombre);
	}

	@Test
	void testRemove() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        names.put(0, "Pancho");
        names.remove(0);
        assertEquals("Marley", names.get(0));
	}

	@Test
	void testGetSize() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        assertEquals(2, names.getSize());
	}

	@Test
	void testIsEmpty() {
		DynamicArray<String> names = new DynamicArray<>();
        assertEquals(true, names.isEmpty());
	}

	@Test
	void testStream() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        long cont;

        cont = names.stream().count();
        assertEquals(2, cont);
	}

	@Test
	void testToString() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        assertEquals("[Peubes, Marley]", names.toString());
	}

	@Test
	void testIterator() {
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
		Iterator<String> a = names.iterator();
        assertEquals("Marley", a.next());
	}

	@Test
	void testExceptionRemove() {
		
		DynamicArray<String> names = new DynamicArray<>();
        names.add("Peubes");
        names.add("Marley");
        names.put(0, "Pancho");
        assertThrows(Exception.class,()->names.remove(-1));

	}
	
	@Test
	void testExceptionGet() {
		DynamicArray<String> names = new DynamicArray<>();
		System.out.println(names.get(1));
		assertThrows(IndexOutOfBoundsException.class,()->names.get(1));
	}
	
}
