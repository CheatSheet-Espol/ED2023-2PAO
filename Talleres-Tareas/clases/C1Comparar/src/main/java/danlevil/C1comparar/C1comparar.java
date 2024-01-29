/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.C1comparar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import danlevil.C1comparar.Comparador;

/**
 *
 * @author danlevil
 */
public class C1comparar{

    public static void main(String[] args) {
        System.out.println("Comparando Objeto1\n");
        ArrayList<Objeto1> lista = new ArrayList<Objeto1>();
        
        
        lista.add(new Objeto1(200));
        lista.add(new Objeto1(2));
        lista.add(new Objeto1(25));


        // Ordenar la lista utilizando compareTo
        Collections.sort(lista);

        // Mostrar la lista ordenada
        for (Objeto1 objeto : lista) {
            System.out.println(objeto.getValor());
        }
        
        System.out.println("Comparando clase Persona1\n");
        
        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("eric",19));
        listaPersonas.add(new Persona("fiore",10));
        listaPersonas.add(new Persona("Valentina",29));
        listaPersonas.add(new Persona("fiore",10));
        
        Collections.sort(listaPersonas);
        for (Persona p: listaPersonas){
            System.out.println(p);
        }
        
        System.out.println("\nCOMPARANDO USANDO 'COMPARATOR'");
        Comparador.interfazComparadora();
    }
    
    public static class Objeto1 implements Comparable<Objeto1>{
        private int valor;
        public Objeto1(int valor){
            this.valor=valor;
        }
        public int getValor(){
            return valor;
        }
        @Override
        public int compareTo(Objeto1 o) {
            return Integer.compare(this.valor, o.valor);
        }
    }
    public static class Persona implements Comparable <Persona> {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public int getEdad() {
            return edad;
        }

        @Override
        public int compareTo(Persona otraPersona) {
            // Comparamos las edades
            if (this.edad < otraPersona.edad) {
                return -1; // "este" objeto es menor
            } else if (this.edad > otraPersona.edad) {
                return 1; // "este" objeto es mayor
            } else {
                return 0; // "este" objeto es igual
            }
        }
        @Override
        public String toString(){
            return this.nombre +' '+ this.edad ;
        }
    
        
    }
}
