/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CDE;

import java.util.List;

/**
 *
 * @author CltControl
 */
//Programa compilado con maven 11 en caso de error modificar el pom
public class CircularDobleEnlazada {

    public static void main(String[] args) {
        System.out.println("Inicio");
        LCD<String> lcd1= new LCD<String>();
        lcd1.add("e1");
        lcd1.add("e2");
        lcd1.add("e3");
        lcd1.add("e4");
        lcd1.add("e5");
        lcd1.add("e6");
        lcd1.add("e7");
        lcd1.imprimirLinked(1);
//        System.out.println(lcd1.getStart().getContenido());
//        System.out.println(lcd1.getStart().getSiguiente().getContenido());
//        System.out.println(lcd1.getStart().getSiguiente().getSiguiente().getContenido());
//        System.out.println(lcd1.getStart().getPrevio().getContenido());

        System.out.println("elementos de la lista: "+lcd1.size());
        System.out.println("Prueba remove(index)\n");
        System.out.println("eliminado: "+lcd1.remove(5));
 
        lcd1.imprimirLinked(1);
        System.out.println("elementos de la lista: "+lcd1.size());

        System.out.println("Prueba add(index, element)");
        lcd1.add(0, "agregadoINICIO");
        lcd1.add(2, "agregado1");
        lcd1.add(4, "agregado2");
        lcd1.add(lcd1.size(), "agregadoFINAL");
        lcd1.imprimirLinked(3);
        System.out.println("elementos de la lista: "+lcd1.size());
        
        System.out.println("Prueba get(INdex)");
        System.out.println(lcd1.get(0));
        System.out.println(lcd1.get(5));
        System.out.println(lcd1.getStart().getPrevio().contenido);

    }
}
