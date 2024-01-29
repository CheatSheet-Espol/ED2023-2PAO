# Arboles

Son estructuras de datos no lineales. Los elementos se pueden recorrer de diferentes maneras, no necesariamenete uno detrás de otro.

Son utiles para la busqueda y recuperacion de informacion.

- En los arboles solo se conoce la raiz
- En los nodos están almacenadas el resto de referencias
- Organiza sus elementos formando jerarquias: PADRES E HIJOS
  - Los padres conocen a sus hijos pero los hijos NO conocen a sus padres
- Los elementos se llaman: NODOS
- Todos los NODOS tienen un solo padre
- Los NODOS sin hijos se llaman hojas

## Partes del ARBOL

- root: El primer nodo del arbol, no tiene padre 
- subArbol: Los arboles son recursivos, está compuesto de otros arboles que están compuestos de otros arboles.
- camino: Secuencia de nodos que están conectados
- Longitud del camino: es el numero de nodos menos 1 en un camino.
- Altura del arbol:Es el nivel más alto del arbol, se mide los niveles (que tan abajo llega)
- Nivel: es la longitud del camino de la raíz a ese nodo
- Grado(aridad) de un nodo: Es el numero de hijos del nodo
- Grado del arbol:  Maxima aridad de los nodos. (La aridad del nodo que tiene más hijos)

## Operaciones de los Arboles

-  Insertar
-  Buscar
-  Sacar

## Implementacion en JAVA ARBOLES Multicaminos

~~~java
NODO
public class TreeNode<E>{
    private E contenido;
    private ArrayList<Tree> hijos;// Enlazado con sus hijos

}
public class Tree<E>{
    private TreeNode<E> root;
}
~~~

## Operaciones de arboles

- Recorridos:
  - preOrden  :
  - enOrden   :
  - postOrden :