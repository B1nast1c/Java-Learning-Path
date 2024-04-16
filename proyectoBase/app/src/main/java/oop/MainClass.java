package oop;

/*
 * Notas sobre los modificadores de las variables
 * Public: Visibilidad para todos
 * Private: Visibilidad para la clase misma
 * Protected: Visibilidad para la clase misma y para sus hijos
 * Transient: Usada para campos que no son considerados en la serialiacion de informacion
 *            Usuda usualmente en info sensible o que no se transmite a la red
 * Volatile: Valor posible de modificacion por parte de hilos
 * Static: Elementos accesibles a clase y no a instancias necesariamente
 * Final: Valores constantes
 */

public class MainClass {
    int firstValue = 10;
    int secondValue = 22;
    final int inmutableValue = 5; // La palabra final evita que los valores se modifiquen

    // Documentacion en ingles xd
    public static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }

    // CONSTRUCTORES
    public MainClass() {
        System.out.println("Constructor por defecto UwU");
    }

    public MainClass(String customText) {
        System.out.println("Constructor con referencias: " + customText);
    }
}
