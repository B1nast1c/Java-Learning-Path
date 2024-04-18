package oop;

interface Interface { // Una interfaz es una clase enteramente abstracta
    public void interfaceMethod1();

    public void interfaceMethod2();
}

// Clase que implementa la interfaz
public class ImplementingClass implements Interface {
    public void interfaceMethod1(){
        System.out.println("Primer metodo de la interfaz");
    }

    public void interfaceMethod2(){
        System.out.println("Segundo metodo dela interfaz");
    }
}
