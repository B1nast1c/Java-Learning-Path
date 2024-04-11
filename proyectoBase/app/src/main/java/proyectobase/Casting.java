package main.java.proyectobase;

public class Casting {
    //Widening (De tipo mas pequeño a mas grande)
    public final int firstValue = 5;
    public double secondValue = firstValue;

    //Narrowing (Inversa del primero)
    public final double thirdValue = 50.25;
    public int fourthValue = (int) thirdValue;

    public Casting() { //El constructor jamas lleva tipo, solamente es publico
        //WIDENING
        System.out.println("W Sin castear " + firstValue);
        System.out.println("W Casteado " + secondValue);

        //NARROWING
        System.out.println("N Sin castear " + thirdValue);
        System.out.println("N Casteado " + fourthValue);
    }
}
