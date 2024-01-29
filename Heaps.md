# Indice
# HEAPS (Arboles binarios Completos y Parcialmente Ordenados)

- Todos sus niveles estan completos

- El ultimo nivel puede estar vacio, allí las hojas van apareciendo seguidas de izquierda a derecha
:Ver definicion de arbol binario completo.

- Propiedad de Orden:
  - Entre raiz e hijos la raiz contiene el mayor (o menor , dependiendo si es Ascendente) de todos
  - Nos dice quién es el mayor o menor del trio
  - No se menciona y No guarda consideracion entre la relacion que guardan los hijos
  - HEAP DESCENDIENTE: Mayor valor en la raíz
  - HEAP ASCENDENTE: MENOR valor en la raíz
  
### UTILIDAD DE UN HEAP
- Al remover consecutivamente la raíz se van consiguiendo los valores ordenados.
- Se utiliza para el ordenamientod HeapSort
- Para implementar colas de prioridad
- El heap está debajo de la cola de prioridad

## Implementacion
- No admite huecos
  - Cada nivel se va llenando de izq a derecha
- Se puede numerar cada nodo
  - En el orden de llenado
  - dado un indice se pueden conocer los indices de los hijos y padre de un nodo.
### RELACION MATEMATICA PARA LOS INDICES DE RAICES Y NODOS
  - Indice i EMPEZANDO DESDE 1
    - Hijo izquierdo: i*2
    - Hijo derecho: i*2+1
    - Padre:          i/2
  - Indice i EMPEZANDO DESDE 0
    - Hijo izquierdo: i*2+1
    - Hijo derecho: i*2+2
    - Padre:          (i-1)/2

- Debe haber un vector con un:
  - size
  - tamañoEfectivo: elementos agregados

## Implementacion HEAP
- Se necesita un arreglo
- Un tamaño efectivo
- El maximo del arreglo
~~~java 
public class HEAP<E>{
    private Comparator<E>f;
    private E[]arreglo;
    private int MAX=numero;
    private int efectivo;
    private boolean isMax;

}
~~~
## OPeraciones basicas del heap
- Desencolar:Extraer al elemento mas grande/pequeño del heap(la raiz)
  - HEAP MAXIMO: DESCENDENTE (maximo valor al inicio)
  - HEAP MINIMO: ASCENDENTE  (minimo valor al inicio)
- Encolar: Insertar un valor al heap y ubicarlo en la posicion correcta
  - Sigue las propiedades de orden
- HEAPSORT: permite generar un arreglo/lista ordenado
- Ajustar: Restablece la propiedad de orden de un subheap hacia abajo, No se aplica a todo el arbol
- Construir heap: Dado un arreglo que no es un heap, lo ordena y lo convierte en un heap.

- posIzq, posDer, posPadre: retorna indice de los nodos, sino cumple las reglas retorna -1

## Algoritmos de Heap
### Ajustar
Dado un indice pos
Se comparan los tres valores para ver quien tiene le mayor
Si el mayor lo tiene algun hijo. Intercambia

### Construir un heap
- Se inicia desde la ultima raiz y se va ordenando hacia arriba
- Los nodos raiz comienzan desde 0 hasta (n/2)-1
  - n : effective size 

### Desencolar
- retornar la raiz
- Intercambiar valores : raiz con el ultimo
- aminorar el tamaño efectivo
- ajustar el arbol desde la raiz
  
### Encolar
- Añadir un nuevo elemento: Al final
- El elemento empieza a subir a su posicion ideal
- comparando siempre con el padre
  - Hasta que el valor insertado sea menor que el del padre.
