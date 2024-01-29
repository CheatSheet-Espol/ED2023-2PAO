/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDE;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author CltControl
 */
public class LCD<E> implements List<E> , Iterable<E>{
    private Nodo<E> start;
    private int tamaño=0;
    LCD(){
        start=null;
    }
    public class Nodo<E>{
        E contenido;
        Nodo<E> siguiente;
        Nodo<E> previo;
        
        Nodo(){}
        Nodo(E cont){
            contenido= cont;
            siguiente=null;
            previo=null;
            
        }

        public Nodo<E> getPrevio() {
            return previo;
        }

        public void setPrevio(Nodo<E> previo) {
            this.previo = previo;
        }
        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
        public Nodo<E> getSiguiente() {
            return siguiente;
        }
        public E getContenido() {
            return contenido;
        }
    }

    public Nodo<E> getStart() {
        return start;
    }

    private int getTamaño() {
        return tamaño;
    }
    
    @Override
    public boolean add(E e) {
        if(start==null){
            start= new Nodo(e);
            start.setSiguiente(this.start);
            start.setPrevio(this.start);
            tamaño++;
            return true;
        }
        Nodo<E> nuevoNodo= new Nodo(e);
        Nodo<E> inicio= this.start;
        Nodo<E> prevInicio=inicio.getPrevio();
        nuevoNodo.setPrevio(prevInicio);
        nuevoNodo.setSiguiente(inicio);
        inicio.setPrevio(nuevoNodo);
        prevInicio.setSiguiente(nuevoNodo);
        
        
        
        tamaño++;
        return true;

    }
    @Override
    public String toString(){
        Nodo<E> current;
        int recorridos=0;
        String cadena="";
        for(current=this.start;current.getSiguiente()!=null;
                current=current.getSiguiente()){
            String contenido=current.getContenido().toString()+"\n";
            cadena+=contenido;
            if(recorridos==size()-1){
                break;
            }
            recorridos++;
        }
        return cadena;
        
    }
    public void imprimirInvertido(){
        Nodo<E> current ;
        int recorrer=size()-1;
        for(current=this.start.getPrevio();current.getPrevio()!=null;
                current=current.getPrevio()){
            E contenido=current.getContenido();
            System.out.println(contenido);
            if(recorrer==0){break;}
            recorrer--;
            
        }
    }
    @Override
    public E remove(int index) {
        if(index<0 || index>=tamaño){
            throw new IndexOutOfBoundsException(
            "Indice fuera de los limites del LinkedLIst");
        }
        if (index==0){
            Nodo<E> eliminado= start;
            Nodo<E> sprevio= start.getPrevio();
            Nodo<E> snext=start.getSiguiente();
            snext.setPrevio(sprevio);
            sprevio.setSiguiente(snext);
            start=snext;
            eliminado.setPrevio(null);
            eliminado.setSiguiente(null);
            tamaño--;
            return eliminado.getContenido();
        }
        Nodo<E> encontrado=null;
        if(index<tamaño/2){
            encontrado=findNode(index);
        }
        else if(index>=tamaño/2){
            encontrado=findNodeInverso(index);
        }
        Nodo<E> anterior=encontrado.getPrevio();
        Nodo<E> next= encontrado.getSiguiente();
        anterior.setSiguiente(next);
        next.setPrevio(anterior);
        encontrado.setPrevio(null);
        encontrado.setSiguiente(null);
        tamaño--;
        
        
        return encontrado.getContenido();
    }
    private Nodo<E> findNode(int index){
        int count=0;
        Nodo <E> n;
        for(n=this.start;n!=null; n=n.getSiguiente()){
            if(count==index){
                return n;
            }
            count++;
        }
        return null;
    }
    private Nodo<E> findNodeInverso(int index){
        int count=tamaño-1;
        Nodo <E> n;
        for(n=this.start.getPrevio();n!=null; n=n.getPrevio()){
            if(count==index){
                return n;
            }
            count--;
        }
        return null;
    }
    @Override
    public void add(int index, E element) {
        boolean pass=true;
        if(index<0 || index>tamaño){
            throw new IndexOutOfBoundsException(
            "Indice fuera de los límites del LinkedLIst");
        }
        else if (index==tamaño){
            add(element);
            pass=false;
        }
        Nodo<E> encontrado=null;
        if(index<tamaño/2){
            encontrado=findNode(index);
        }
        else if(index>=tamaño/2){
            encontrado=findNodeInverso(index);
        }
        Nodo <E> nuevoNodo= new Nodo(element);
        Nodo<E> anterior=encontrado.getPrevio();
        anterior.setSiguiente(nuevoNodo);
        nuevoNodo.setPrevio(anterior);
        encontrado.setPrevio(nuevoNodo);
        nuevoNodo.setSiguiente(encontrado);
        if(index==0){this.start=nuevoNodo;}
        tamaño++;
    }
    @Override
    public E get(int index) {
        if(index==0){return this.start.contenido;}
        else if (index<0){
            throw new IndexOutOfBoundsException(
                    "Indice fuera de los límites del LinkedLIst");
        }
        Nodo <E> encontrado=findNode(index);
        return (encontrado!=null)?encontrado.getContenido():null;
    }
    @Override
    public int size() {
        return getTamaño();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            Nodo<E> current=start;
            int visitados=0;
            @Override
            public boolean hasNext() {
                return visitados<size();
            }

            @Override
            public E next() {
                if(!hasNext()){return null;}
                E content=current.getContenido();
                current=current.getSiguiente();
                visitados++;
                return content;

            }
            
        };
    }
    public E find(Comparator cmp, E objeto){
        for(E elemento:this){
            if(cmp.compare(elemento, objeto)==0){
                return elemento;
            }
        }
        return null;
        
    }
    public LCD<E> findAll(Comparator cmp, E objeto){
        LCD<E> filtro= new LCD<E>();
        
        for(E elemento:this){
            if(cmp.compare(elemento,objeto)==0){
                filtro.add(elemento);
            }
        }
        return filtro;
        
    }
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
