/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package CDE;

import java.util.Comparator;
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
        
        
        System.out.println("\nPrueba del forEach");
        for (String s:lcd1){
            System.out.println(s);
        }
        
        System.out.println("\nPrueba for inverso");
        lcd1.imprimirInvertido();
        
        System.out.println("\nPrueba Comparators");
        LCD <Persona> lcd2 = new LCD<Persona>();
        //lcd2.add(new Persona)
        lcd2.add(new Persona("daniel","villamar",22,"ecu"));
        lcd2.add(new Persona("Javier","Tibau",40,"ecu"));
        lcd2.add(new Persona("Leo","Messi",48,"arg"));
        lcd2.add(new Persona("Julian","Alvarez",22,"arg"));
        lcd2.add(new Persona("Bernardo","Silva",32,"port"));
        lcd2.add(new Persona("Julian","fernandez",32,"ecu"));
        lcd2.add(new Persona("Leo","Messi",38,"arg"));
        lcd2.add(new Persona("Daniel","sanchez",22,"ecu"));
        lcd2.add(new Persona("Kevin","DeBruyne",32,"Bel"));
        lcd2.add(new Persona("kevin","torres",19,"per"));
        
        Comparator<Persona> cmpIdentidad= new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2) {
                int verificador=0;
                if(!(o1.getNombre().equalsIgnoreCase(o2.getNombre()))){
                    verificador=1;
                }
                if(!(o1.getApellido().equalsIgnoreCase(o2.getApellido()))){
                    verificador=1;
                }
                if(!(o1.getEdad()==o2.getEdad())){
                    verificador=1;
                }
                if (!(o1.getNacionalidad().equalsIgnoreCase(o2.getNacionalidad()))){
                    verificador=1;
                }
                return verificador;
            }
        };
        
        System.out.println("primera busqueda: "+lcd2.find(cmpIdentidad, new Persona(
                "julian","Fernandez",32,"ecu")));
        System.out.println("sedunga busqueda:" +lcd2.find(cmpIdentidad, new Persona(
                "julian","Fernandez",31,"ecu")));
        
        System.out.println("tercera busqueda mayor de 30 menor de 40: "
                + lcd2.find(new ComparatorMayor30<Persona>(), new Persona(
                "julian","Fernandez",32,"ecu")));
        
        
        System.out.println("\nPrueba FindALL");
        LCD<Persona> filtro= lcd2.findAll(new ComparatorEdad(),
                new Persona("Julian","Alvarez",22,"arg"));
        System.out.println(filtro);
        
    }
}
