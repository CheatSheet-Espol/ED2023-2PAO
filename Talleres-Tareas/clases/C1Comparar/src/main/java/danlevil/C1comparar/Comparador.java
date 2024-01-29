/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.C1comparar;

/**
 *
 * @author danlevil
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
public class Comparador {
    public static void interfazComparadora(){



        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Alice", 30, 1.65));
        personas.add(new Persona("Bob", 25, 1.80));
        personas.add(new Persona("Charlie", 25, 1.70));

        // Ordenar personas por edad
        Collections.sort(personas, Persona.comparadorPorEdad);
        System.out.println("Ordenado por edad:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " - Edad: " + persona.getEdad());
        }

        // Ordenar personas por nombre
        Collections.sort(personas, Persona.comparadorPorNombre);
        System.out.println("\nOrdenado por nombre:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre());
        }

        // Ordenar personas por altura
        Collections.sort(personas, Persona.comparadorPorAltura);
        System.out.println("\nOrdenado por altura:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " - Altura: " + persona.getAltura());
        }
    }


    public static class Persona {
        private String nombre;
        private int edad;
        private double altura;

        public Persona(String nombre, int edad, double altura) {
            this.nombre = nombre;
            this.edad = edad;
            this.altura = altura;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        public double getAltura() {
            return altura;
        }

        // Comparador para ordenar personas por edad
        public static Comparator<Persona> comparadorPorEdad = new Comparator<Persona>() {
            @Override
            public int compare(Persona persona1, Persona persona2) {
                return Integer.compare(persona1.edad, persona2.edad);
            }
        };

        // Comparador para ordenar personas por nombre
        public static  Comparator<Persona> comparadorPorNombre = new Comparator<Persona>() {
            @Override
            public int compare(Persona persona1, Persona persona2) {
                return persona1.nombre.compareTo(persona2.nombre);
            }
        };

        // Comparador para ordenar personas por altura
        public static Comparator<Persona> comparadorPorAltura = new Comparator<Persona>() {
            @Override
            public int compare(Persona persona1, Persona persona2) {
                return Double.compare(persona1.altura, persona2.altura);
            }
        };
    }


}
