# AVL ARBOL BALANCEADO
- Asegurar que siempre una busqueda sea binaria
- Que a partir de un nodo N con clave K
  - Aprox, la mitad tengan claves mayores a K
  - Y aprox, la otra mitad  tengan claves menores
- Para cada NODO p del arbol
  - La altura p izq y altura p der, nunca difieren entre sí en más de una unidad
  - Factor de equilibrio "Alt(Der)-Alt(izq)"
    - positivo: derecha más alto (profundo)
    - negativo: izquierda más alto (profundo)
  - En equilibrio  F.E debe ser : -1 ,  0 , 1

Un nodo tiene un peso de 1 si su subarbol derecho es más alto, -1 si su subarbol izquierdo es más alto y 0 si las alturas son las mismas

Al insertar o extrar nodos se deben realizar operaciones para mantener el equilibrio


## ROTACIONES

### Rotacion Simple izquierda


### Rotacion Simple Derecha
### Rotacion doble izquierda
### Rotacion doble derecha