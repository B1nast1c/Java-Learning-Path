package other_classes;

import java.util.ArrayList;

//Nota: a diferencia de la LinkedList, el Array lis permite interactuar con el indice que se quiera en su lugar la LL solo actua con el primero y el ultimo elemento
//En lugar de ArrayList, se usa el HasSet tambien, pero este es un set, no permite elementos repetidos

public class ArrayListClass {
    public ArrayList<String> cars;

    public ArrayListClass() {
        cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda"); //Agregar elementos al array

        //Operaciones por defecto
        cars.get(1); //Obtener el elemento de cierto indice
        cars.set(1, cars.get(2)); //Cambio de elemento en el indice especificado
        cars.remove(3); //Elimina un elemento en cierto indice
        cars.clear(); //Limpieza del array
    }
}
