# Arboles binarios de busqueda (ABB)

- Tienen una PROPIEDAD DE ORDEN. Aplica para cada subarbol
  - Dado un nodo:
  - todos los nodos sub Izq. tienen una clave menor que la clave de la raiz
  - todos los nodos sub Der. tienen una clave mayor que la clave de la raiz.
- La clave es o puede ser totalmente distinta del contenido que se está guardando dentro del nodo 
- Se utilizan comparadores: Al momento de hacer inserciones este es el criterio de jerarquia.
- La forma del arbol(morfologia) binario de busqueda depende del orden de como se de el conjunto de las claves al algoritmo que construye el arbol
- Las claves de un ABB son conjuntos (no admite valores repetidos)

## Implementacion ABB 
~~~java

public class BSTree <E,K>{ //E: content  K: clave
    private BSTNodo<E,K> root;
    private Comparator<K> cmp;
    //El constructor debe recibir un comparador.
}

public class BSTNodo<E,K>{
    private E contenido;
    private K clave;
    private BSTree<E,K> izq;
    private BSTree<E,K> der;

}
~~~
## Insercion  en un ABB

Bajo el supuesto de que la propiedad de orden se respeta y está correctamente implementado.

- Crear un nodo
- Buscar en el arbol donde va ubicada
  - Examinar la clave de la raiz, moverse a la izq  o derecha
  - irse moviendo con las claves que tengo conocidas
  - cuando encuentre un null hago la insercion
- Enlazar el nuevo nodo al arbol
  
- Casos base: Si está vacio el arbol se inserta el nodo como root
- Ir comparando siempre si la clave es igual a la que voy encontrando, si es así NO se realiza ninguna insercion.
## Busqueda de un nodo en ABB
- Si el arbol está vacio no se encuentra (raiz==null)
- si la clave buscada es igual a la clave del nodo evaluado. Se ENCONTRÓ EL NODO
- si no, ir preguntando si la clave es menor o mayor para desplazarse a la izquierda o derecha 

## Eliminacion de un nodo

- 

# Arboles de expresion. Son una aplicacion del arbol binario

Evaluar expresiones aritmeticas con distintas notaciones

- infijas: operador en medio
- prefijas:operador antes de dos operandos
- posfijas:operador luego de dos operandos

La raiz contiene el operador (signo) y sus hijos son el operando 1 y operando 2 (numeros)
