package other_classes;

import java.util.HashMap;

public class Map { //En Java es el HashMap
    public Map() {
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        //Cada elemento es operado en base a su llave nada mas
        //Iteraciones en el HM
        for (String key : capitalCities.keySet()) {
            System.out.println(key + ": " + capitalCities.get(key)); //Impresion del valor perteneciente a la llave
        }
    }
}
