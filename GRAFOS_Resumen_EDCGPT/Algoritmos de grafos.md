# DIJKSTRA
~~~java
import java.util.*;

class Grafo {
    private Map<Integer, List<Edge>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void añadirArista(int origen, int destino, int peso) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(new Edge(destino, peso));
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Edge(origen, peso)); // Para grafos no dirigidos
    }

    public Map<Integer, Integer> dijkstra(int origen) {
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<NodeDistance> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(node -> node.distancia));

        colaPrioridad.add(new NodeDistance(origen, 0));

        while (!colaPrioridad.isEmpty()) {
            NodeDistance actual = colaPrioridad.poll();
            int nodoActual = actual.nodo;

            if (!distancias.containsKey(nodoActual)) {
                distancias.put(nodoActual, actual.distancia);

                List<Edge> vecinos = grafo.getOrDefault(nodoActual, Collections.emptyList());
                for (Edge vecino : vecinos) {
                    int nodoVecino = vecino.destino;
                    int nuevaDistancia = actual.distancia + vecino.peso;
                    colaPrioridad.add(new NodeDistance(nodoVecino, nuevaDistancia));
                }
            }
        }

        return distancias;
    }

    private static class Edge {
        int destino;
        int peso;

        public Edge(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    private static class NodeDistance {
        int nodo;
        int distancia;

        public NodeDistance(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }
    }
}

public class DijkstraExample {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.añadirArista(1, 2, 2);
        grafo.añadirArista(1, 3, 4);
        grafo.añadirArista(2, 3, 1);
        grafo.añadirArista(2, 4, 7);
        grafo.añadirArista(3, 4, 3);

        int origen = 1;
        Map<Integer, Integer> distancias = grafo.dijkstra(origen);

        System.out.println("Distancias más cortas desde el nodo " + origen + ":");
        for (Map.Entry<Integer, Integer> entry : distancias.entrySet()) {
            System.out.println("Nodo " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

~~~