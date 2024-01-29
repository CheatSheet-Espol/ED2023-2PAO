/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g10.heapdv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author danlevil
 */
public class HeapDV<E> {

    private Comparator<E> comparador;
    private E[] arreglo;
    private int capacidad = 100;
    private int capacidadEfectiva;
    private boolean esMaxHeap;

    public E[] getArreglo() {
        return arreglo;
    }

    public HeapDV(Comparator<E> cmp) {
        this.comparador = cmp;
        arreglo = (E[]) new Object[capacidad];
        capacidadEfectiva = 0;
        esMaxHeap = true;
    }

    public boolean isEmpty() {
        return capacidadEfectiva == 0;
    }

    private boolean isFull() {
        return capacidadEfectiva == capacidad;
    }


    private void aumentarMemoria(){
        capacidad=capacidad+(capacidad/2);
        E[]nuevo= (E[])new Object[capacidad];
        for(int i=0;i<capacidadEfectiva;i++){
            nuevo[i]=arreglo[i];
        }
        arreglo=nuevo;
    }

    public int size() {
        return capacidadEfectiva;
    }

    public void encolar(E elemento) {

        if (isFull()) {
            aumentarMemoria();
        }

        arreglo[capacidadEfectiva] = elemento;
        capacidadEfectiva++;
        ajustarArriba(capacidadEfectiva - 1);

    }

    public E desencolar() {
        if (isEmpty()) {
            throw new IllegalStateException(" Error NO se puede desencolar ningún elemento.");
        } else if (capacidadEfectiva > 0) {
            E elemento = arreglo[0];
            arreglo[0] = arreglo[capacidadEfectiva - 1];
            capacidadEfectiva--;
            ajustar(0);
            return elemento;
        }
        return null;

    }

    private void ajustar(int pos) {
        int pos_mayor = pos;
        int izq = pos * 2 + 1;
        int der = pos * 2 + 2;

        if (izq >= 0 && izq < capacidadEfectiva && comparador.compare(arreglo[izq], arreglo[pos]) > 0) {
            pos_mayor = izq;
        }

        if (der >= 0 && der < capacidadEfectiva && comparador.compare(arreglo[der], arreglo[pos_mayor]) > 0) {
            pos_mayor = der;
        }

        if (pos_mayor != pos) {
            intercambiar(pos, pos_mayor);
            ajustar(pos_mayor);
        }
    }

    private void ajustarArriba(int pos) {
        int padre = (pos - 1) / 2;

        if (padre >= 0 && comparador.compare(arreglo[pos], arreglo[padre]) > 0) {
            intercambiar(pos, padre);
            ajustarArriba(padre);
        }
    }

    private void intercambiar(int i, int j) {
        E temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
    //TAREA IMPLEMENTACION:
    public List<E> heapSort(List<E> lista) {
        // Crear un HeapDV usando el comparador actual
        HeapDV<E> heap = new HeapDV<>(comparador);

        // Agregar todos los elementos de la lista al heap
        for (E elemento : lista) {
            heap.encolar(elemento);
        }

        // Crear una lista ordenada utilizando el heap
        List<E> listaOrdenada = new ArrayList<>();
        while (!heap.isEmpty()) {
            listaOrdenada.add(heap.desencolar());
        }

        return listaOrdenada;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arreglo, capacidadEfectiva));
    }

}
