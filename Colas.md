# Colas (Queue)
Es una estructura lineal en donde todos estan unos detrás de otros
- Tiene 2 extremos: frente y final
- Cuando se añade un elemento es al final
- Todo lo que sale, sale por el frente
- FiFO : first in first out
### Operaciones basicas:
- EnColar  {offer(e) ;add (e)}
  Esos metodos devuelven boolean al usar la interfaz Queue
  - Insertar al final
  - el final aumenta
- DesEncolar {remove(); poll()}
poll: si esta vacio, retorna null
remove: si esta vacio lanza una exception de: NoSuchElement
  - remueve el elemento del frente
  - retorna el elemento removido
  - No se puede ejecutar si la cola está vacia
- Conocer quien está al frente y final (devolver sin eliminar)
- Conocer si la cola está vacia (PEEK; element)

### Implementaciones

Una cola es una LISTA, puede ser con arreglos o nodos
~~~java
Queue <TIPO> nombre= new LinkedList();
~~~


# Colas de prioridad
Hasta el momento es lo mejor para ordenamiento.
Cola de prioridad Ascendente
- Se DesEncola al elemento más pequeño de la cola
  
Cola de prioridad Descendente
- Se DesEncola al elemento más grande de la cola

~~~java
PriorityQueue<TIPO> nombre= new PriorityQueue();
~~~

Una cola de prioridad al desencolar si no se especifica el orden, utiliza el orden natural de las cosas. Las clases que usen interfaz Comparable y defina su orden con compareTo

Tambien se le puede enviar una expresion lambda para definir su orden de desencolamiento de esa cola especifica
~~~java
PriorityQueue<TIPO> nombre= new PriorityQueue(
    (t1,t2) -> {
        return t2.getAtributo().compareTo(t1.getAtributo());
    }

);
~~~
[indice](#indice) 
