# Arboles binarios

- Cada nodo puede tener de 0 a 2 hijos (izquierda o derecha)

- Arbol vacio: Ningun nodo
- O contar de tres partes:
  - Un nodo raiz
  - Dos subarboles binarios: Izquierda y derecha
  - definicion recursiva

## Implementacion en JAVA Arbol binario

~~~java
public class ArbolBinario<E>{
    private NodoBinario<E> root;
    //metodos

    public ArbolBinario(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean isLeaf(){
        if(!this.isEmpty()){
            return root.getLeft()==null && root.getRight()==null;
        }
        return false;
    }
}

public class NodoBinario<E>{
    private E contenido;
    private ArbolBinario<E> izquierdo;
    private ArbolBinario<E> derecho;

    public NodoBinario(){
        izquierdo=null;
        derecho=null;
    }
    public NodoBinario(E contenido){
        this.contenido= contenido;
        izquierdo=null;
        derecho=null;
    }
    //getters y setters
}
~~~

## Recorridos de un ARBOL BINARIO
Recorrer es: visitar todos los elementos de una estructura

- preORDEN: 1)raiz           2)sub.izquierdo 3)sub.derecho
- enORDEN:  1) sub.izquierdo 2)raiz          3)sub.derecho
- postORDEN:1)sub.izquierdo  2)sub.derecho   3)raiz

Recorrido por niveles: Imprimir de izquierda a derecha avanzando por nivel (tambien puede ser de derecha a izquierda)

### Implementacion recorrerPreOrden

~~~java
public void recorrerPreOrden(){
    if(this.isEmpty()){
        return;
    sout(this.root.getContenido());
    
    if(this.root.getLeft()!=null){
        this.root.getLeft().recorrerPreOrden();
    }
    if(this.root.getRight()!=null){
        this.root.getRight().recorrerPreOrden();
    }
    

}
public void recorrerEnOrden(){
    if(this.isEmpty()){
        return;
    
    if(this.root.getLeft()!=null){
        this.root.getLeft().recorrerEnOrden();
    }
    
    sout(this.root.getContenido());

    if(this.root.getRight()!=null){
        this.root.getRight().recorrerEnOrden();
    }
    

}
~~~