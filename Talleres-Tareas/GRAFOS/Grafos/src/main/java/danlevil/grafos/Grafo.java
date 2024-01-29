/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.grafos;
import java.util.*;

/**
 *
 * @author danlevil
 */
public class Grafo {
    private Map<String, List<Arista>> adyacencia;

    public Grafo() {
        adyacencia = new HashMap<>();
    }

    public void agregarVertice(String vertice) {
        adyacencia.put(vertice, new LinkedList<>());
    }

    public void agregarLado(String origen, String destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
        adyacencia.get(destino).add(new Arista(origen, peso)); 
    }

    public void recorrerEnProfundidad(String inicio) {
        Set<String> visitados = new HashSet<>();
        recorrerEnProfundidadAux(inicio, visitados);
    }

    private void recorrerEnProfundidadAux(String vertice, Set<String> visitados) {
        System.out.print(vertice + " ");
        visitados.add(vertice);
        for (Arista vecino : adyacencia.get(vertice)) {
            if (!visitados.contains(vecino.destino)) {
                recorrerEnProfundidadAux(vecino.destino, visitados);
            }
        }
    }

    public void recorrerEnAnchura(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String vertice = cola.poll();
            System.out.print(vertice + " ");

            for (Arista vecino : adyacencia.get(vertice)) {
                if (!visitados.contains(vecino.destino)) {
                    visitados.add(vecino.destino);
                    cola.add(vecino.destino);
                }
            }
        }
    }

    public int calcularDistanciaTotal() {
        int distanciaTotal = 0;
        for (String vertice : adyacencia.keySet()) {
            for (Arista vecino : adyacencia.get(vertice)) {
                distanciaTotal += vecino.peso;
            }
        }
        return distanciaTotal / 2;
    }

    private static class Arista {
        String destino;
        int peso;

        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    
}
