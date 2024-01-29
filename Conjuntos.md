# Indice

# Conjuntos
- Coleccion de miembros
- Cada miembro puede ser un conjunto o un elemento primitivo
- Todos los miembros son distintos!!!
- Coleccion homogenea
- Los elementos de un conjunto no tienen un orden
- Por eso los conjuntos no pueden retornar, solo se pueden iterar

## Operaciones elementales
- union : los elementos de A de B o de ambos
- interseccion: los elementos que pertenecen tanto a A como a B
- diferencia: los elementos que solo pertenecen al primero "PRIMERO-SEGUNDO"
- saber si un conjunto tiene un elemento
- saber si un conjunto está vacio
  
## Representaciones
### Vectores de bits
donde allá un elemento se coloca un 1 en ese indice del arreglo
- ventajas:
  - Facil de realizar las operaciones, operacion booleana
- desventajas:
  - No puede haber valores muy grandes
  - solo pueden ser enteros positivos

### Listas ordenadas
- No es solo para enteros
- Representa cualquier conjunto
- Ordenamiento:
  - Ayuda a la eficiencia
  - Solo buscar hasta encontrar un >=x porque mas allá ya no se va a encontrar nada
  - El punto es evitar iterar inecesariamente

## Representaciones
La interfaz set representa conjuntos
dos clases que la implementan: TreeSet , HashSet , LinkedHashSet
- TreeSet: elementos ordenados. Necesita que la clase que le ingresa tenga un orden natural definido
- HashSet: elementos no ordenados, Mas rapido que treeSet
- LinkedHashSet: Se muestran en el orden en que fueron agregados. 
~~~java
//Se pueden añadir cosas con add(element)
Set<TIPO>s1= new TreeSet<>();
Set<TIPO>s2= new HashSet<>();
Set<TIPO>s3= new LinkedHashSet<>();
~~~

[indice](#indice)