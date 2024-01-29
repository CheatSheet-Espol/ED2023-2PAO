# Indice

1. [Listas](#listas)
    - [comportamiento](#comportamiento-listas)

2. [ArrayList](#arraylists)
3. [LinkedList](#linkedlist-implementacion-dinamica)
    - [implementacion](#implementacion-linkedlist)


# Estructuras Lineales
- Elementos estan colocados uno detrás de otro
- Cada elemento de una lista se conoce como 'nodo'
- Los elementos se guardan en los nodos y los nodos conforman la lista.

Conjuntos lineales: Listas,Pilas, Colas, Conjuntos y Mapas
# Listas
- Coleccion de 0 o más elementos
- Todos los elementos son de un mismo tipo
- Si la lista no tiene elementos se dice que está vacia.

Caracteristica principal:Dinamica, puede achicarse o crecer de ser necesario

### Comportamiento listas

- Crear y eliminar
- conocer si esta vacia
- añadir y remover elementos
- consultar el primer y ultimo elemento
- Imprimir sus elementos en pantalla
- Buscar un elemento con cierta información en la lista

En java el TDA list es una interfaz, la cual es implementada por 2 clases concretas: ArrayList y LinkedList
~~~java
List a= new ArrayList();
List b= new LinkedList();
~~~
[indice](#indice)


### Simplemente Enlazadas
Escencialmente es un enlace entre el elemento y el elemento que viene después.Un elemento conoce quien viene después.


[indice](#indice)

### Doblemente Enlazadas
Enlace entre de un elemento con su anterior y su proximo. El elemento conoce quien va antes y quien va después



[indice](#indice)

### Circulares
Enlace donde el elemento conoce su siguiente, y el ultimo elemento conoce al primer elemento (enlace). Se puede iterar infinitamente sino se pone un mecanismo que detenga el ciclo



[indice](#indice)

### Circular Doblemente Enlazada
Enlaces dobles y el primero conoce al ultimo así como el ultimo conoce al primero por medio de enlaces. Se puede iterar infinitamente en ambos sentidos.



[indice](#indice)

## Listas simples
- Conjunto de nodos uno detrás de otro
    - siempre se puede conocer al nodo inicial y final
- Cada nodo tiene un contenido y un sucesor unico, el ultimo nodo referencia a null

[indice](#indice)

# Implementacion TDA LISTA


## ArrayList (implementacion estatica o continua)

La clase ArrayList al ser estatica por debajo tiene un arreglo . El cual se va modificando la capacidad y simula que el arraylist tiene capacidad infinita.
Los arraylist son excelentes para acceder a informacion que ya estaba en ellos pero malo para insertar y remover porque esos algoritmos tienen complejidad O(n)

Caracterisitcas:
- Secuencia de elementos
- Cada elemento tiene un indice
    - tiempo de acceso a un elemento es constante  O(1)
- Al insertar o remover un elemento
    - Todos los elementos restantes avanzaran o retrocederán 
- CapacidadEfectiva: El numero real de elementos que se está usando en todo el arraylist
    - inicia en 0, se modifica al insertar y eliminar

Hay que parametrizar arrayList y List para que la implementacion de los metodos de la interfaz sea correcta
~~~java
public class ArrayList<E> implements List<E>{
    private E[] elements;
    private int capacidad=100;
    private int capacidadEfectiva=0;
    public ArrayList(){
        elements = (E[]) (new Object[capacidad]); //Se hace un cast porque se debe instanciar el arreglo con clase Object. Prohibido en adelante para ED por eso se usan Generics
    }
    //metodos override de List
    //add, addFirst, addLast, remove, clear, set, toString, size, isEmpty...etc
    @Override
    public E get(int index) {
        //hacer validaciones
        if (index>0 && index< capacidad){

            return element[index];
        }else{
            return null;
        }
    }
}
~~~

[indice](#indice)



## LinkedList (implementacion Dinamica)
Implementacion flexible 

- La implementacion hace referencia al header y last, solo apunta a 2 nodos.!!

- Los nodos ya no son adyacentes en memoria (los bits de memoria ya no estan contiguos)
    - un nodo A logra un enlace con B
    - Almacena dentro la direccion de memoria de B
    - El nodo final no tiene siguiente y apunta a null




Caracteristicas:

- Al insertar o eliminar un nodo ya no hay que 'mover' al resto del elemento, solo enlazarlo con la lista, Es eficiente para agregar y remover.

- Agregar en una posicion (complejidad Constante):
    - Poner al elemento en un nodo
    - Enlazarlo con el siguiente de mi nuevo nodo
    - modificar el anterior del nodo al que estoy haciendo referencia con el nuevo. Ahora ese será el anterior del nuevo nodo.

- Para iterar una lista necesito un nodo viajero que va a ser referencia a cada nodo y su siguiente hasta llegar al final

### Nodos
tienen:
- Contenido
- Referencia del siguiente (puntero)

### implementacion LinkedList
- LLevar un control de quien es el primero y ultimo de la lista
    - Header: primero
    - Last  : ultimo
- La posicion de un nodo está dada por una referencia a dicho nodo
- La lista no tiene elementos predefinidos.
- Crear una clase Nodo
    - contenido
    - nodoSiguiente

- Atributos
    - header y last

~~~java
public class NodeSimpleList<E>{
    private  E content;
    private NodeSimpleList next;

    getNext();
    getContent();

}

public class SimpleLinkedList<E> implements List<E>{
    private NodeSimpleList<E> header;
    private NodeSimpleList<E> last;

    // IMPLEMENTAR METODOS ABSTRACTOS...

    public String toString(){
        String s="";
    //Recorrer la lista desde la clase LInked
    //El nodo comienza con el primero y luego se actualiza al siguien hasta que llegue al final que es el que tiene una referencia null. Recomendado.
    NodeSimpleList<E> n; //nodo viajero
        for(n= this.header; n!=null; n=n.getNext()){
        E e= n.getContent();
        s+=e.toString()+" ";
        }
    }
    //2da forma de iterar
    NodeSimpleList<E> n= this.header; //nodo viajero
    while(true){
        E e= n.getContent();
        if(n==last){break;}
        else{n=n.getNext();}
    }
}

~~~


[indice](#indice)

## Listas doblemente enlazadas
- Se puede avanzar hacia la derecha o hacia la izquierda.
- Cada nodo tiene dos enlaces, hacia el siguiente y hacia el anterior.
    - prev: predecesor
    - next: un sucesor
    - data: generics
- el primer nodo no tiene un previo y el ultimo no tiene un next

- Eliminar un nodo hay que desconectarlo absolutamente de la lista.

~~~java
public class DobleEnlazada<E> implements List<E>{
    private NodoDoble<E> header,last;
    public DobleEnlazada(){
        this.header=null;
        this.last=null;
    }
    //getters, setters y metodos abstractos

    private class NodoDoble<E>{
        public E contenido;
        public NodoDoble<E> next;
        public NodoDoble<E> previo;
        public NodoDoble(E contenido){
            this.contenido=null;
            this.next=null;
            this.previo=null;
        }
        //getters y setters

    }
}
~~~

[indice](#indice)

## Listas circulares (simplemente enlazada)

El avance es solo hacia la derecha (next)

El ultimo tiene una referencia al primero.

- No hay referencia al head, a traves del last se puede obtener el primero
- last.next=head;

~~~java
public NodoCE<E>{
    public E contenido;
    NodoCE<E> next;
    public NodoCE(){
        this.contenido=null;
        this.next=this;
    }
}
~~~

[indice](#indice)

## Listas circulares doblemente enlazadas

- La lista solo tiene como referencia al ultimo nodo del cual se conoce el next y el previo
- Los nodos tienen dos punteros

[indice](#indice)
