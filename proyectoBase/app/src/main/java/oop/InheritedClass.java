package oop;

abstract class AbstractClass {
    public abstract void abstractPrint();

    public void normalMethod() {
        System.out.println("Metodo normal de clase abstracta");
    }
}

public class InheritedClass extends AbstractClass { //Esta es la clase que se instancia
    public void abstractPrint() {
        System.out.println("Metodo normal heredado y establecido de la clase abstracta");
    }
}