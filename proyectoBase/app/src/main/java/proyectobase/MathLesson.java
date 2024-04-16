package proyectobase;
import java.math.*;

public class MathLesson {
    public final int firstValue = 10;
    public final int secondValue = 3;
    public int randomValue = (int)(Math.random() * 101);

    public MathLesson() { //El constructor jamas lleva tipo, solamente es publico
        System.out.println("Max: " + Math.max(firstValue, secondValue));
        System.out.println("Min: " + Math.min(firstValue, secondValue)); //Suma / Concantenacion de Strings
        System.out.println("SQRT: " + Math.sqrt(firstValue));
        System.out.println("ABS: " + Math.abs(-firstValue));
        System.out.println("Random: " + randomValue);
    }
}
