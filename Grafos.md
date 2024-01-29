# Grafos

Estructuras de datos no lineales
Aplicables en la vida real, para modelar redes
No hay jerarquía
Se puede modelar un grafo para escenarios donde ciertos objetos se relacionan.Se puede aplicar ciertos algoritmos para resolver diversos problemas

## Definicion
Grafo: G=(V,A)
    - V: conjunto de vertices o nodos
    representan los objetos. Los vertice deben ser unicos
    - A: conjunto de aristas(arcos). Representan las relaciones
Hay grafos no dirigidos y dirigidos

## Propiedades y tipos de grafos


- Grafo no dirigido: Pares de nodos no son ordenados (u-v)
- Grafo    dirigido: Pares de nodos  son ordenados (u->v)
- Grafo Valorado   : Donde los arcos tienen un factor de peso.

- Arista: arco de un grafo no dirigido
- Vertices adyacentes: vertices unidos por un arco
- Factor de peso: valor que se puede asociar con un arco, depende del grafo que se represente



| En un grafo no dirigido | En un grafo dirigido |
|-------------|-----------------|
|- Grado(V) : numero de aristas que contiene a V, numero de aristas que están conectadas al vertice (nodo)|- Grado de salida: Numero de aristas que salen al nodo - Grado de entrada:Numero de aristas que entrar al nodo|

### Caminos

Un camino P en un grafo G desde V0 a Vn
Es la secuencia de vertices n+1, tal que (Vi, Vi+1) pertenecen a A para 0<=i <=n

Es una sucesion de vertices entre dos nodos dados. Todos los vertices por donde paso antes de llegar a ese vertice

Longitud de camino: El numero de arcos (aristas) que lo conforman

- Camino simple: Todos los nodos que lo conforman son distintos. Nunca regresar al mismo nodo
- Ciclo: Camino simple cerrado de longitud>=2 donde Vo=Vn. Basicamente partir de un punto y volver al mismo

### Conectividad

|Grafo NO dirigido| Grafo dirigido|
|-----------------|---------------|
|Conexo: existe un camino entre cualquier par de nodos.Todos los nodos conectados Podemos decir que un grafo es no dirigido si es conexo| - Fuertemente conexo: Existe un camino entre cualquier par de nodos|
||- Conexo: existe una cadena entre cualquier par de nodos |

## TDA GRAFO
Datos
- Vertices y aristas (arcos)
  
Operaciones
- añadir vertice(Grafo G, vertice V)
- borrar Vertice(Grafo G, Generico clave)
- conectar (Grafo G, Vertice V1, Vertice V2)
- Borrar arco(Grafo G, Vertice V1, Vertice V2)
- Es Adyacente(Grafo G, Vertice V1, Vertice V2)


# REPRESENTACIONES

## Matriz de adyacencia
- Los vertices se representan por indices (0..n)
- Las relaciones de los vertices se almacenan en una matriz
    - 1 : sí hay arco
    - 0 : si no hay arco
| Grafo no dirigido| Grafo dirigido | Grafo Valorado |
|------------------|----------------|----------------|
|- dos valores por cada conexion |Se coloca solo un valor dependiendo de donde parta y donde llega| Se colaca el factor de peso en vez de 1 donde haya conexion|
- simetrica respecto a su dp||
 - toda su diagonal principal es 0 ||
|||

### Implementacion
- Los vertices pueden ser un objeto complejo, así que se colocan en un arreglo
- Los arcos se colocan dentro de una matriz
  
~~~java
public class Grafo <V>{
    int capacity=20;
    int[][]matrizAdy;
    Object[] vertices; //private ArrayList<V> vertices;
    boolean esDirigido;
}
~~~
## Listas adyacencia

- Los vertices forman una lista enlazada 
- Cada vertice tiene una lista para representar sus relaciones arcos
- Se usa cuando una matriz tendrá demasiados 0 porque no hay conexiones entre sus vertices y ocupará mucho espacio 
- cada vertice tiene una lista con todos los arcos que tiene
  - contiene los vertices que se relacionan con ella, pero almacena un TDA ARCO el cual sería (Vpartida, Vnuevo)...(Vpartida, V n-nuevo)
  - El arco almacena una referencia de quien es el origen y una referencia a quien es el destino

##  Implementacion grafos listas de adyacencia

- Cada vertice tiene: contenido , siguiente, lista de adyacencia
- En cada nodo en la lista de adyacencia tiene: peso del arco, siguiente, una referencia al vertice (arco)

~~~java
public class Nodo<V,E>{
    V contenido;
    List<Edge<E,V>> arcos;
    boolean isVisited;

}

public class Edge<E,V>{
    E data;
    Nodo<V,E> origen;
    Nodo<V,E> target;
    int weight;
}
public class Grafo<V,E>{
    List<Nodo<V,E>> nodo;
    boolean esDirigido;
}
~~~