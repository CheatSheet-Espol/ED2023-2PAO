/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

import Arboles.ArbolBin;

/**
 *
 * @author danlevil
 */
public class NodoBinario<E> {
    private E contenido;
    private ArbolBin<E> left;
    private ArbolBin<E> right;
    
    public NodoBinario(E contenido){
        this.contenido=contenido;
        this.left=null;
        this.right=null;
    }

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public ArbolBin<E> getLeft() {
        return left;
    }

    public void setLeft(ArbolBin<E> left) {
        this.left = left;
    }

    public ArbolBin<E> getRight() {
        return right;
    }

    public void setRight(ArbolBin<E> right) {
        this.right = right;
    }
    
    
}
