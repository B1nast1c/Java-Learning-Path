package main.java.proyectobase;

public class StringLesson {
    public final String text = "Baguette Chocolate";

    public StringLesson() { //El constructor jamas lleva tipo, solamente es publico
        System.out.println("Largo: " + text.length());
        System.out.println("UPPERCASE: " + text.toUpperCase()); //Suma / Concantenacion de Strings
        System.out.println("lowercase: " + text.toLowerCase());
        System.out.println("Index de Chocolate: " + text.indexOf("Chocolate"));
    }
}
