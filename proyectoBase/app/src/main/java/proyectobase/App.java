/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package proyectobase;

import proyectobase.Casting;
import proyectobase.Conditionals;
import proyectobase.StringLesson;
import proyectobase.MathLesson;
import oop.Demarcacion;
import oop.Equipo;
import oop.ImplementingClass;
import oop.InheritedClass;
import oop.InnerClass;
import oop.MainClass;
import oop.InnerClass.InnerClass2;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Casting casting = new Casting();
        StringLesson string = new StringLesson();
        MathLesson math = new MathLesson();
        Conditionals conditionals = new Conditionals();

        System.out.println(new App().getGreeting());
        MainClass.myStaticMethod(); // Llama al metodo sin la necesidad de instanciar a algun objeto (IMPORTANTE)

        // NOVEDADES DEL OOP
        // CLASES ANIDADAS
        InnerClass claseGrande = new InnerClass();
        InnerClass.InnerClass2 claseChiquita = claseGrande.new InnerClass2(); // Que forma tan curiosita la vdd XD
        System.out.println("Suma de innre y outer: " + claseGrande.outterNumber + claseChiquita.innerNumber);

        // CLASES ABSTRACTAS
        InheritedClass claseNoAbstracta = new InheritedClass();
        claseNoAbstracta.abstractPrint();

        // INTERFACES
        ImplementingClass implementing = new ImplementingClass();
        implementing.interfaceMethod1();
        implementing.interfaceMethod2();

        // ENUMS
        Demarcacion delantero = Demarcacion.DELANTERO;
        System.out.println(delantero.name()); // Devuelve un String con el nombre de la constante (DELANTERO)
        System.out.println(delantero.toString()); // Devuelve un String con el nombre de la constante (DELANTERO)
        System.out.println(delantero.ordinal()); // Devuelve un entero con la posición del enum según está declarada
                                                 // (3).
        System.out.println(Demarcacion.values());

        Equipo equipo = Equipo.BARÇA; // Enum con argumentos por cada valor
        System.out.println(equipo.getNombreClub());
        System.out.println(equipo.getPuestoLiga());

    }
}
