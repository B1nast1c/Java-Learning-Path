package proyectobase;

public class Conditionals {
    public final int firstValue = 550;
    public final int secondValue = 201;
    public String textResult;
    public int weekDay = 4;

    @SuppressWarnings("unused") // Solo para cuestiones del editor
    public Conditionals() { // El constructor jamas lleva tipo, solamente es publico
        if (firstValue > secondValue) {
            System.out.println("Primer valor mayor al segundo");
        }

        // Operador ternario
        textResult = (firstValue > secondValue) ? "Primero mayor" : "Segundo mayor";
        System.out.println("Resultado con operador ternario: " + textResult);

        // Switch
        switch (weekDay) {
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Dia de Semana UwU");
        }
    }
}
