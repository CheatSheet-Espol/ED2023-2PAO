/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.practicaarraylist;
import java.util.List;

/**
 *
 * @author danlevil
 */
//Este proyecto se compila con Java 11. Actualizar el POM en caso de error.
public class App {

    public static void main(String[] args) {
        System.out.println("02practicaArrayList\n");
        List <String> l1 = new ArrayList();
        System.out.println("ADD Prueba\n");

        l1.add("1");
        l1.add("2");
        l1.add( "3");        
        l1.add( "4");
        l1.add( "5");
        l1.add( "6");
        l1.add( "7");
        l1.add( "8");
        l1.add( "9");
        l1.add( "10");
        l1.add("11");        
        l1.add( "12");
        
        l1.add(0,"desplazamiento");
        l1.add(3,"desplazamiento2");
        l1.add(5,"desplazamiento3");
        
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }

        System.out.println("\nRemove Prueba\n");
        
        l1.remove(0);
        l1.remove(0);
        l1.remove(5);
        l1.remove(1);
        l1.remove(1);
        l1.remove(4);
        l1.remove(l1.size()-1);
        l1.remove(l1.size()-3);
        l1.remove(l1.size()-1);
        l1.remove(l1.size()-1);
        l1.remove(l1.size()-1);






        for(int i=0; i<l1.size();i++){
            System.out.println(l1.get(i));
        }
        
        System.out.println("\nRemove Prueba array vacio");
     
        List <String> l2 = new ArrayList();
        l2.remove(3);

        

        
    }
}
