package functional;

import java.lang.FunctionalInterface;

@FunctionalInterface //Solo contienen un metodo
public interface FuncInterface { //Es una interfaz con un metodo abstracto (Las expresiones lambda ayudan a definir el comportamiento de el metodo sobreescrito)
    public void interfaceMethod();
}

//NOTA: Existen interfaces funcionales ya existentes dentro de java, revisar documentacion