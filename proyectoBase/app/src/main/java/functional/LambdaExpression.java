package functional;

@FunctionalInterface
interface MathInterface {
    int math(int a, int b);
}

class Math { //Para usar el operador :: NO SE IMPLEMENTA LA INTERFAZ
    public static int math(int a, int b) {
        return a + b;
    }
}

public class LambdaExpression {
    public LambdaExpression() {
        // Lambda es similar a la funcion flecha implementada en JavaScript
        // Camo a implementar con la interfaz funcional
        FuncInterface interfaz = () -> System.out.println("Metodo por defecto");
        interfaz.interfaceMethod(); // Imprime Metodo por defecto

        // Ahora una interfaz de CALCULOS MATEMATICOS
        MathInterface addition = (a, b) -> a + b;
        MathInterface subtraction = (a, b) -> a - b;
        MathInterface multiplication = (a, b) -> a * b;
        MathInterface division = (a, b) -> a / b;
        System.out.println("SUMA " + addition.math(2, 3));
        System.out.println("RESTA " + subtraction.math(2, 3));
        System.out.println("PRODUCTO " + multiplication.math(2, 3));
        System.out.println("DIVISION " + division.math(2, 3));

        // Ahora con el operador de ::
        MathInterface doubleColon = Math::math;
        System.out.println("SUMA con :: " + doubleColon.math(1, 2));

    }
}
