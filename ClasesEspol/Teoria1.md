# Indice
1. [comparar](#comparar)
2. [ordenar](#ordenar)


## TDA
Basicamente todo es un TDA, una representacion de un objeto que tiene metodos y atributos
## Generics
Una clase que puede ser utilizada para almacenar distintos tipos de datos, se suele usar generics para reutilizar colecciones de datos y que almacenen distintas cosas.Hay que tener cuidado con el tipo de dato y con no poder usar algun metodo que no cuente en la clase especificada.

sintaxis: class<T> 

y sus metodos deben incluir el valor T, se puede usar distintos tipos de elementos genericos
ej: class2<T, U> 

# Comparar y Ordenar
### comparar
El método compare se utiliza para comparar dos elementos, y el método sort se utiliza para ordenar una colección de elementos utilizando esas comparaciones. Para personalizar el ordenamiento de objetos en Java, puedes sobreescribir el método compare en una clase que implemente la interfaz Comparator o el método compareTo en una clase que implemente la interfaz Comparable.

- Interfaz Comparable: Es generica, implementar para que se compara asi misma
sintaxis: A implements Comparable<A>

- metodo compareTo: Compara el objeto actual y otro objeto. Devuelve un valor (int) que indica su orden relativo
sintaxis: public int compareTo(T otroObjeto)
    Valores relativos:
    - 0: actual = otro
    - 1: actual > otro
    - -1: actual< otro
- Comparator:Interfaz, no hay necesidad de modificar las clases existentes
### clases anonimas
Esto permite definir una clase concreta que implementa la interfaz Comparator (o cualquier otra interfaz funcional) al mismo tiempo que se crea una instancia de esa clase. En el contexto de los comparadores, se utiliza esta sintaxis para crear objetos Comparator personalizados de manera concisa sin la necesidad de definir una clase separada para cada comparador.
~~~java
Interfaz interfaz = new Interfaz() {
    // Implementación de métodos de la interfaz
};
public static Comparator<Persona> comparadorPorNombre = new Comparator<Persona>() {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        return persona1.nombre.compareTo(persona2.nombre);
    }
};
~~~
- metodo compare: toma 2 argumentos del tipo T
    - sintaxis: int compare(T objeto1, T objeto2)
    - 0 : o1 = o2
    - +1 : o1 > o2
    - -1 : o1 < o2
La interfaz Comparable se implementa dentro de la propia clase que se desea comparar
La interfaz Comparator es independiente, se puede implementar aparte para crear distintos tipos de criterios de ordenamiento
[indice](#indice)


### ordenar
- metodo sort: Es un método de las clases Collections (para listas) y Arrays (para matrices) que se utiliza para ordenar una colección de elementos utilizando un Comparator.
    Formas de usar Collection.sort
    - un solo parametro Collections.sort(lista) : Se usa su orden natural, el ordenamiento se basa en lo definido en compareTo
    - dos parametros Collections.sort(lista, comparador); :
    el comparador en este caso define el criterio de ordenamiento

Usa el algoritmo 'Merge Sort'
[indice](#indice)
