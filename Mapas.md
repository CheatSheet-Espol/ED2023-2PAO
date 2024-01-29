# Indice

# Mapas o Diccionario
Es un conjunto limitado
- No necesita realizar operaciones como interseccion y union
- Tabla de N filas (llamadas cubetas)
- Funcion de dispersion para calcular a que fila deberá ir dicho elemento.
- clave-valor
Tabla de Hash
Cada objeto tiene una clave , la cual se pasa a la funcion de dispersion

## Operaciones
- Añade un elemento  a un conjunto: Insertar
- Consultar si un elemento es miembro
- Eliminar elementos de un conjunto: Suprimir

### Representacion
Dispercion o Hashing

# Funciones de dispersion (Hash)
conversion o hash h(x)
- Transforma una clave en un indice
- Distribuir claves uniformemente 
- generar un indice entre 0 y N-1
- algoritmo sencillo
- Mecanismos de colision (cuando hay 2 claves diferentes y generan el mismo indice)

## Tipos de funciones HASH

### Aritmetica modular (claves son numeros int)
- indice = clave%N
- las nCubetas sea un numero primero


### Mitad del cuadrado (claves son numeros)
- Elevar la clave al cuadrado
- Tomar los indices de una determinada posicion
- el numero de digitos depende del rango del indice
   N: 100 y clave =256
   tomar 1 y 2 desde derecha a izquierda
   indice= 256**2 = 65536 
   tomar = 63 , ese será el indice, está en el rango de las cubetas

### Truncamiento  (clave con numeros)
- tomar directamente d digitos de la clave
- en posiciones fijas
  N: 1000 , tomar siempre 1 , 2, 5 de derecha a izquierda
  clave= 72588495 
  indice: 598

### Plegamiento (funciona para claves strings)
- divide la clave en trozos
- aplicar operacion
  clave: "DAVID"
  sumar codigos ASCII
  tomar el residuo para B y ese es el indice

## Tratamiento de colisiones
### Hashing abierto

Cada cubeta almacena un conjunto de elementos
### Hashing cerrado 

Cada elemento va en una cubeta
Redispersar
- Aplicar otra funcion de hash de reserva

Intentar de nuevo

[indice](#indice)