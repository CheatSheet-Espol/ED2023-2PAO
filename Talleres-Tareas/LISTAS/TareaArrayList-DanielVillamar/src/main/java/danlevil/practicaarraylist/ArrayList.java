/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.practicaarraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author danlevil
 */
public class ArrayList<E> implements List<E> {
    
    private int capacidad=10;
    private int capacidadEfectiva=0;
    private E[] elementos;
    
    public ArrayList(){
       elementos= (E[])(new Object[capacidad]);
    }
    
   
    @Override
    public boolean add(E e) {
        if(capacidadEfectiva==capacidad){
            aumentarMemoria();
        
        }
        elementos[capacidadEfectiva]=e;
        capacidadEfectiva++;
        return true;
               
    }
    
    private void aumentarMemoria(){
        capacidad=capacidad+(capacidad/2);
        E[]nuevo= (E[])new Object[capacidad];
        for(int i=0;i<capacidadEfectiva;i++){
            nuevo[i]=elementos[i];
        }
        elementos=nuevo;
    }
    
    @Override
    public void add(int index, E element) {
        if (capacidadEfectiva==0){
            System.out.println("El array esta vacio, agregando al inicio");
            elementos[0]= element;
            capacidadEfectiva++;
        }
        if(index>capacidadEfectiva){throw new IllegalArgumentException(""
                + "Espacios vacios dentro del arreglo");
        }
        if(capacidadEfectiva==capacidad){aumentarMemoria();}
        
        int mover = capacidadEfectiva-index; 
        int nuevoFinal;  
        int puntoPartida=capacidadEfectiva-1;
        
        for(nuevoFinal=capacidadEfectiva;mover>=0;nuevoFinal--){
            if(mover==capacidadEfectiva){mover-=1;}
            elementos[nuevoFinal]=elementos[puntoPartida];
            mover--;   
            puntoPartida--;
        }
        elementos[index]= element;
        capacidadEfectiva++;        
        
    }
    @Override
    public E remove(int index) {
        if(index<0 || index>capacidadEfectiva){
            throw new IndexOutOfBoundsException("Indice fuera del rango valido"); 
        }
        if (capacidadEfectiva==0){
            System.out.println("\nEl arrayList esta vacio\n");
        }
        
        int mover = capacidadEfectiva- (index+1);
        int nuevoInicio=index+1;
        E eliminado=elementos[index];
        for (int i=index;mover>0;i++){
            elementos[i]=elementos[nuevoInicio];
            mover--;
            nuevoInicio++;
        }
        capacidadEfectiva--;
        return eliminado;
        
    }

    @Override
    public int size() {
        return capacidadEfectiva;
    }
    
    @Override
    public E get(int index) {
        return elementos[index];
    }

    @Override
    public E set(int index, E element) {
        E antiguo= elementos[index];
        elementos[index]= element;
        return antiguo;
    }
    

    @Override
    public int indexOf(Object o) {
        return 0;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
