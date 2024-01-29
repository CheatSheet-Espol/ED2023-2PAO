# Notacion O grande
La notacion en computacion ayuda a describir el comportamiento de un algoritmo
"El algoritmo se va a demorar X unidades de tiempo o va a utilizar X recursos de la memoria"
Esta notacion es en funcion de la ENTRADA

- unidades de tiempo o memoria = Complejidad
- Analizar la complejidad es las unidades de tiempo que le va a tomar ejecutarse el algoritmo en funcion de la entrada
- O grande escencialmente se pregunta las operaciones necesarias en el peor de los casos
- O grande siempre se pone en el peor de los casos.
- Se utiliza para analizar que algoritmo conviene utilizar.

Es util para analizar entradas que son grandes.

## Tipos de complejidades
- Complejidad Constante O(1): Independientemente de los valores de la entrada el algoritmo se ejecuta en el mismo tiempo
n: EL numero de operaciones necesarias en el peor de los casos
- Complejidad Logaritmica O(n log(n)): Recomendada. La entrada es grande y a medida que avanza la entrada se reduce
- Complejidad lineal O(n)
- Complejidad Cuadratica O(n²)
- Complejidad Factorial O(n!) : (!Evitar). Algoritmos de fuerza bruta
[indice](#indice)

## Analizar la notacion
- Un algoritmo que tenga algoritmos dentro que sean O(1), su complejidad también será constante
- Analizar la entrada, los arrays con dimension n , dependiendo cuantas operaciones se hagan sobre él puede ser: n o n²

[indice](#indice)
