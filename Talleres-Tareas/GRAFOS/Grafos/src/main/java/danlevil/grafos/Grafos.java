/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.grafos;

/**
 *
 * @author danlevil
 */
public class Grafos {

    public static void main(String[] args) {
        Grafo ciudad = new Grafo();

        ciudad.agregarVertice("CASA");
        ciudad.agregarVertice("ESCUELA");
        ciudad.agregarVertice("A");
        ciudad.agregarVertice("B");
        ciudad.agregarVertice("C");
        ciudad.agregarVertice("D");
        ciudad.agregarVertice("E");
        ciudad.agregarVertice("F");

        ciudad.agregarLado("CASA", "A", 3);
        ciudad.agregarLado("CASA", "B", 2);
        ciudad.agregarLado("CASA", "C", 5);
        ciudad.agregarLado("A", "D", 3);
        ciudad.agregarLado("B", "D", 1);
        ciudad.agregarLado("B", "E", 6);
        ciudad.agregarLado("D", "F", 4);
        ciudad.agregarLado("C", "E", 2);
        ciudad.agregarLado("E", "F", 1);
        ciudad.agregarLado("E", "ESCUELA", 4);
        ciudad.agregarLado("F", "ESCUELA", 2);

        System.out.println("Recorrido en Profundidad:");
        ciudad.recorrerEnProfundidad("CASA");
        System.out.println();

        System.out.println("Recorrido en Anchura:");
        ciudad.recorrerEnAnchura("CASA");
        System.out.println();

        int distanciaTotal = ciudad.calcularDistanciaTotal();
        System.out.println("Distancia total de la ciudad: " + distanciaTotal + " km");
    }
}
