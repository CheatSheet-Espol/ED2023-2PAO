# Recursividad
Una función se llama a sí misma para resolver un problema más pequeño del mismo tipo. En la recursividad, cada llamada a la función resuelve una parte del problema, y las llamadas se acumulan hasta que se alcanza un caso base que no requiere más subdivisión.

### Analizando el caso base

- Garantiza que la funcion recursiva termine

1. Identifica la condicion de parada: La parte mas simple donde no necesito más recursividad, la respuesta es sencilla de sacar.
2. Convergencia : Cada llamada recursiva debe llevar al caso base, acercarme a la minima respuesta
3. No bucles: La condicion base debe cumplirse en algun punto.
4. Cumplir requisitos: verificar que el resultado en el caso base tenga sentido y no cause problemas en el calculo general.
   
ejemplo con algoritmo factorial:

1. Identificación de la condición de parada:
El caso base podría ser cuando el número es 0.

1.2 Menor problema resoluble:
El menor problema resoluble es calcular el factorial de 0, que es 1.
2. Convergencia:
Con cada llamada recursiva, el número disminuye, acercándose al caso base (0).

3. Evitar bucles infinitos:
Asegúrate de que la condición del caso base (n == 0) se cumpla en algún momento.

4. Verificación de requisitos mínimos:
Asegúrate de que el factorial de 0 sea 1, que es el resultado correcto según la definición del factorial.

### Analizando el caso recursivo

1. Pensar en el problema y el subproblema como se relacionan y como la resulcion del subproblema ayuda a resolver el problema
2. Llamadas recursivas: Cada llamada debe reducir el tamaño del problema, cada llamada debe acercar el problema global al caso base.
3. Pensar en combinar resultados: A menudo, hay una operación o combinación de resultados que ocurre después de las llamadas recursivas.
4. Verificar que sea solido: Al combinar los resultados se obtiene la solucion correcta.

EJEMPLO CON ALGORITMO FACTORIAL:

1. Relación entre el problema original y el subproblema:
La relación es que el factorial de un número n es n multiplicado por el factorial de n-1.

2.Reducción del tamaño del problema:
Cada llamada recursiva reduce el problema al calcular el factorial de un número menor (n-1).

3.Evitar ciclos infinitos y convergencia:
La llamada recursiva eventualmente llega al caso base cuando n == 0.

4.Combinación de resultados de subproblemas:
Después de la llamada recursiva, multiplicas el resultado de n por el resultado del factorial de n-1.

5-Solidez del caso recursivo:
El caso recursivo maneja de manera efectiva problemas más pequeños al calcular el factorial de n-1.

~~~java
EJEMPLOS 
FACTORIAL
public class RecursividadEjemplo {
    public static void main(String[] args) {
        int numero = 5;
        int resultado = calcularFactorial(numero);
        System.out.println("El factorial de " + numero + " es: " + resultado);
    }

    // Función recursiva para calcular el factorial
    public static int calcularFactorial(int n) {
        // Caso Base: factorial de 0 es 1
        if (n == 0) {
            return 1;
        } else {
            // Caso Recursivo: n! = n * (n-1)!
            return n * calcularFactorial(n - 1);
        }
    }
}

FIBONACCI
public class RecursividadEjemplo {
    public static void main(String[] args) {
        int n = 7;
        int resultado = fibonacci(n);
        System.out.println("El término " + n + " en la secuencia de Fibonacci es: " + resultado);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

TORRE DE HANOI
El problema de las Torres de Hanoi consiste en mover una torre de discos de un poste a otro, siguiendo ciertas reglas. La solución se puede expresar de forma recursiva:
public class RecursividadEjemplo {
    public static void main(String[] args) {
        int numDiscos = 3;
        hanoi(numDiscos, 'A', 'C', 'B');
    }

    public static void hanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 desde " + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, auxiliar, destino);
            System.out.println("Mover disco " + n + " desde " + origen + " a " + destino);
            hanoi(n - 1, auxiliar, destino, origen);
        }
    }
}

Suma de elementos en un arreglo:
Puedes calcular la suma de elementos en un arreglo de manera recursiva sumando el primer elemento con la suma de los elementos restantes.
public class RecursividadEjemplo {
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        int resultado = sumaArreglo(arreglo, 0);
        System.out.println("La suma de los elementos en el arreglo es: " + resultado);
    }

    public static int sumaArreglo(int[] arr, int indice) {
        if (indice == arr.length) {
            return 0;  // Caso base: suma de elementos en un arreglo vacío es 0
        } else {
            return arr[indice] + sumaArreglo(arr, indice + 1);
        }
    }
}


~~~