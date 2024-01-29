# Iteradores

Iterable es una interfaz de JAVA. Es parametrizada por tipo
 
~~~java
//ESTO ES CUANDO SE USA UNA INTERFAZ LIST PROPIA
"List extends Iterable"
~~~

Utilidad: 
Permite el uso de una version mejorada del lazo for. "for-each"
Un iterador tiene que hacer seguimiento al elemento en el que se está actualmente.


~~~java

for (TipoElemento variable: Estructura){}
~~~
### metodo forEach

Metodo forEach:  Permite usar ese lazo for.

~~~java
Iterator  iter1= coleccion.iterator();
while(iter1.hasNext()){|
    sysout(iter1.next());
}
~~~


### metodo iterator

Metodo Iterator: Devuelve un iterable de la estructura que puede ser recorrido desde fuera. Abstrae el proceso de iteracion.
- retorna una instancia de la interfaz iterator

Dicha instancia debe definirse sus metodos hasnext y next, porque cada iterador es una nueva instancia

- la instancia guarda el estado donde está la iteracion
- debe producir un nuevo iterador cada vez que es invocado.
- No debe retornar el mismo iterador 2 veces


- Iterator en arraylist se usa enteros para controlar la iteracion
- Iterator en linkedlist usa un nodo pointer para controlar la iteracion.

~~~java
//SE CREA UNA CLASE ANONIMA AL SOBREESCRIBIR EL METODO ITERATOR DENTRO DE LAS ED
public iterator<E> iterator(){
    Iterator<E> it= new Iterator<E>(){
        //hasNext()
        //next()
    };
    return  it;
}
~~~
o
~~~java
//SE CREA UNA CLASE ANONIMA AL SOBREESCRIBIR EL METODO ITERATOR DENTRO DE LAS ED
public iterator<E> iterator(){
  //logica
  return new Iterator<E>(){
    //hasNext
    //next
  }
}
~~~

## Interfaz iterator:

tiene 2 metodos
Hay que implementar 2 metodos:
    -hasNext(): boolean. true sí hay un siguiente
        - implementar la logica de hasta cuando habrá un siguiente
    -next(): retorna E el siguiente elemento.
        - avanza el cursos al siguiente elemento.