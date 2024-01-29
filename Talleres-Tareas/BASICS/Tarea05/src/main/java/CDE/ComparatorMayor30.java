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
public class ComparatorMayor30<E> implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {
        int verificador=0;
        if(!(o1.getClass()==o1.getClass())){
            verificador=1;
        }
        Persona p1=(Persona)o1;
        Persona p2=(Persona)o1;
        if(p1.getEdad()>30 &&p1.getEdad()<40){
            return 0;
        }
        return 1;
        
    }

    

}
