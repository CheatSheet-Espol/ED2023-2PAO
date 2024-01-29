# Indice
1. [pilas](#pilas)
2. [colas](#colas)


# Pilas o Stack

pila o stack, es como una lista, 
LIFO: Last In First out: el ultimo que llega es el primero en salir.

Conjunto de elementos en el que:
- los elementos se añaden y se remueven por un solo extremo
- el extremo se llama "tope"

- push(elemento): agrega un elemento a la pila
    - el 'tope' debe moverse a ser ese elemento. Y asi a medida se van agregando, aumenta el tamaño

- pop(): remueve el tope de la pila y lo retorna.Disminuye su tamaño, hay que hacer desplazamiento de elementos.
    - preguntar si la pila está vacia y retornar.
- peek(): Devuelve el elemento del tope
    - si la pila está vacia manda error.
- size(): Retorna el tamaño de la pila

tratar de devolver o remover elementos de una pila vacia se llama SUBDESBORDAMIENTO 

Una pila al ser una lista pero limitada , se puede representar de dos maneras: Estatica(arreglos) o dinamica (LinkedList)




### Implementacion estatica (class Stack<E>)
~~~java
//Usando el java.util
Stack<E> pila= new Stack();
~~~
### Implementacion dinamica (interfaz Deque<E>)
~~~java
//Una linkedList implementa el comportamiento de Deque

Deque<E> pila= new LinkedList();
Deque<E> pila= new ArrayDeque();
~~~



### Imprimir en LIFO
~~~java
while(!pila.isEmpty()){
    sysout(pila.pop());
}
~~~
## Aplicaciones de las PIlas

### Hayar pariedad de expresiones
"Enfoque de recordar algo y olvidarlo"
recordar= push, olvidar= pop
Puedo agregar el primer elemento de un par y cuando encuentre a sus segundo elemento elimino el primero que encontré porque deberia ser su "match"

### convertir notacion infija a posfija
POSFIJA :  AB+   ; ABC*+
INFIJA  :   A+B   ; A+B*C

1. acumular en una expresion los operandos (letras)
2 acumular en pilas los operadores
3. ver la prioridad de los operadores (definirla)
4. compararar
    - si el operador es mayor que el tope, se guarda
    - si es menor, se saca el tope , se lo agrega a la expresion y se vuelve a iterar hasta que sea el mayor. Tener cuidado con vaciar la pila
5. Añadir todo a la expresion
6. retornar string

### Evaluar expresiones posfijas
1. acumular en una pila los operandos
2. al encontrar un operador los 2 ultimos operandos son recordados, usados  y olvidados
3. el resultado es recordado
4. iterar hasta que se termine la expresion

### Backtracking

Es una forma de ir hacia atrás , para realizar una busqueda, rastrear cosas hacia atrás.
Las pilas se utilizan para guardar las cosas que tengo que recordar.

Se implementa con:
- Recursividad
- Pilas dinamicas
[indice](#indice)


