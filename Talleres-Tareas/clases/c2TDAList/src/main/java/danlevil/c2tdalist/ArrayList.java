/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.c2tdalist;

/**
 *
 * @author danlevil
 */
public class ArrayList<E> implements List<E> {
    
    private int capacidad=100;
    private int capacidadEfectiva=0;
    private E[] elementos;
    
    public ArrayList(){
        elementos= (E[]) (new Object[capacidad]);
    }

    @Override
    public void set(int index, E e) {
        
    }
    
}
