package ggm.tallerarraylist_p01;

import tda.ArrayList;
import tda.List;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
    

        // crear un ArrayList de enteros aquí
        // anañadir elementos al ArrayList creado
        // llamar al método toString aquí
        // probar los otros métodos solicitados e imprmir resultados
        ArrayList<Integer> enteros = new ArrayList<>();
        enteros.addLast(1);
        enteros.addLast(2);
        enteros.addLast(3);
        enteros.addLast(4);
        enteros.addLast(5);
        enteros.addLast(6);
        
        System.out.println(enteros.toString());
        System.out.println(enteros.subList(1,4).toString());
        
        


        System.out.println(enteros.removeFirstNElements (2));
        System.out.println(enteros.toString());
        
        
        /*
        enteros.rotate(2);
        
        System.out.println(enteros.toString());
        */
        
        
        // crear un ArrayList de Strings aquí
        // anañadir elementos al ArrayList creado
        // llamar al método toString aquí
        // probar los otros métodos solicitados e imprmir resultados
        
     /*
        ArrayList<String> strings = new ArrayList<>();
        strings.addLast("Alice");
        strings.addLast("Bob");
        strings.addLast("Charlie");
        strings.addLast("David");
        strings.addLast("Eve");
        strings.addLast("Frank");

        strings.toString();
        
        strings.subList(1,2);
        strings.toString();

        strings.rotate(2);
        strings.toString();

        strings.removeFirstNElements (2);
        strings.toString();    
*/

    }
}
