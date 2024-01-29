/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles2;

/**
 *
 * @author danlevil
 */
public class NodoBinario<E> {
    
    E contenido;
    public TreeBinario<E> hijoIzq;
    public TreeBinario<E> hijoDer;
    
    public NodoBinario(E content){
        this.contenido=content;
        hijoIzq=null;
        hijoDer=null;
    }
    public NodoBinario(){
        this.contenido=null;
        this.hijoDer=null;
        this.hijoIzq=null;
    }
    
    ///GETTERS------------------------------
    public E getContenido() {
        return contenido;
    }

    public TreeBinario<E> getHijoIzq() {
        return hijoIzq;
    }

    public TreeBinario<E> getHijoDer() {
        return hijoDer;
    }
    //SETTERS --------------------

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public void setHijoIzq(TreeBinario<E> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(TreeBinario<E> hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
}
