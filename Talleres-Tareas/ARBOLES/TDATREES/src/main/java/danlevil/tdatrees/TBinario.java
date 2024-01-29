/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.tdatrees;

/**
 *
 * @author danlevil
 */
public class TBinario {
    private Nodo root;

    // Constructor
    public TBinario() {
        this.root = null;
    }

    // Métodos de recorrido

    // Recorrido inorden
    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inorden(nodo.getDerecho());
        }
    }

    // Recorrido preorden
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }

    // Recorrido postorden
    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }

    // Métodos de manipulación del árbol

    // Agregar un nodo al árbol
    public void agregarNodo(int dato) {
        root = agregarNodoRec(root, dato);
    }

    private Nodo agregarNodoRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato < nodo.getDato()) {
            nodo.setIzquierdo(agregarNodoRec(nodo.getIzquierdo(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDerecho(agregarNodoRec(nodo.getDerecho(), dato));
        }

        return nodo;
    }

    // Eliminar un nodo del árbol
    public void eliminarNodo(int dato) {
        root = eliminarNodoRec(root, dato);
    }

    private Nodo eliminarNodoRec(Nodo nodo, int dato) {
        if (nodo == null) {
            return nodo;
        }

        if (dato < nodo.getDato()) {
            nodo.setIzquierdo(eliminarNodoRec(nodo.getIzquierdo(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDerecho(eliminarNodoRec(nodo.getDerecho(), dato));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            nodo.setDato(encontrarMinimo(nodo.getDerecho()).getDato());
            nodo.setDerecho(eliminarNodoRec(nodo.getDerecho(), nodo.getDato()));
        }

        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    // Buscar un nodo en el árbol
    public Nodo buscarNodo(int dato) {
        return buscarNodoRec(root, dato);
    }

    private Nodo buscarNodoRec(Nodo nodo, int dato) {
        if (nodo == null || nodo.getDato() == dato) {
            return nodo;
        }

        if (dato < nodo.getDato()) {
            return buscarNodoRec(nodo.getIzquierdo(), dato);
        }

        return buscarNodoRec(nodo.getDerecho(), dato);
    }

    // Getter para el nodo raíz
    public Nodo getRoot() {
        return root;
    }

    
}
class Nodo {
    private int dato;
    private Nodo izquierdo;
    private Nodo derecho;

    // Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y setters
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}