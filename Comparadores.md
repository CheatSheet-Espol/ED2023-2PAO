# Comparadores

metodo "equals": me ayuda a comparar 2 objetos a nivel logico, no a nivel fisico (referencia en memoria). El metodo equals se lo puede sobreescribir, lo implementa la clase que quiere compararse con otro objeto. Ambos objetos deben ser de la misma clase (de preferencia)

Comparator en java es una interfaz, parametrizada por tipo, tiene varios metodos en ED se usa:
Comparator es un objeto que recibe objetos y los compara.
Se pueden usar varios comparadores distintos para comparar diferentes parametros
Escencialmente usa expresiones lambda.

### COMPARE ()
Como es una interfaz hay que implementar la logica cuando se crea un nuevo objeto.
retorna un entero.

(-1)Negativo: objeto1 < objeto2
(0) cero    : objeto1== objeto2
(1) positivo: objeto1>objeto2

Con esos valores de retorno se puede implementar metodos que hagan acciones al comparar
Devuelve un valor negativo si el primer objeto es menor, cero si son iguales y un valor positivo si el primer objeto es mayor que el segundo.
~~~java
//CON CLASE ANONIMA 
comparator<E> compName = new Comparator<E>{
    public int compare(E objeto1, E objeto 2){
        //logica return
        //return objeto1-objeto2  tanto para string o integer(int)
    }
}
//CLASE QUE EXTIENDE COMPARATOR
public class ComparadorPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.getNombre().compareTo(p2.getNombre());
    }
}

public class ComparadorPorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.getEdad(), p2.getEdad());
    }
}
~~~
- Se pueden crear clases que implementen la interfaz comparaator<E> para encapsular el comportamiento del algoritmo.

~~~java
//expresion lambda para comparators
metodo((E atributos1, E a2)-->{
    //logica
}, objetoComparar)

~~~

- compareTo : sirve para comparar objetos que hayan implementado la interfaz comparator : strings , integers...etc

## INTERFAZ COMPARABLE

Es una interfaz que implementan las clases de objetos, lo cual les permite definir un "orden natural", util cuando no se está trabajando con comparadores.
Devuelve un valor negativo si el objeto actual es menor, cero si son iguales y un valor positivo si el objeto actual es mayor que el objeto dado.


~~~java
public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    // Constructor, getters y setters

    @Override
    public int compareTo(Persona otraPersona) {
        return this.edad - otraPersona.edad;
    }
}
```

~~~