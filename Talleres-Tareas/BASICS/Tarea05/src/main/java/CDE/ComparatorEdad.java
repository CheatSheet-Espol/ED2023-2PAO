/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDE;

import java.util.Comparator;

/**
 *
 * @author danlevil
 */
public class ComparatorEdad implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        if(o1.getEdad()==o2.getEdad()){
            return 0;
        }
        return 1;
    }
    
    
}
