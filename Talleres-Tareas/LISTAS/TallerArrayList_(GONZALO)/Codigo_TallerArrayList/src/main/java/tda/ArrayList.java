package tda;
 
public class ArrayList<E> implements List<E> {

    private E[] elements;
    private int MAX_SIZE = 100;
    private int effectiveSize;

    public ArrayList() {
        // elements = new E[100]; // NO vale
        elements = (E[]) new Object[MAX_SIZE];
        effectiveSize = 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            //throw new NullPointerException("Null elements are not accepted");
            return false;
        } else if (isEmpty()) {

            // si se quiere hacer el bacán
            // elements[effectiveSize++] = element;
            // con humildad
            elements[effectiveSize] = element;
            effectiveSize++;

            return true;
        }
        if (isFull()) {
            addCapacity();
        }
        // empujar para hacer espacio. Bit shifting
        for (int i = effectiveSize; i > 0; i--) {
            elements[i + 1] = elements[i];
        }
        elements[0] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        //con humildad
        //elements[effectiveSize] = element;
        //effectiveSize++;
        // con orgullo
        elements[effectiveSize++] = element;
        return true;
    }

    @Override
    public E removeFirst() {
        //mover el arrayhacia la izquierda
        for (int i = 0; i < effectiveSize-1; i++) {
            if(i!= effectiveSize-1){
                elements[i] = elements[i + 1];
            }
            // elements[i+1] = elements[i]; MAL
        }
//elemento final
        effectiveSize--;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > effectiveSize) {
            // throw new IndexOutOfBoundsException("Invalid index: " + index);
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i - 1];
            // elements[i+1] = elements[i]; MAL
        }
        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void addCapacity() {
        MAX_SIZE = MAX_SIZE * 2;
        E[] newElements = (E[]) new Object[MAX_SIZE];
        // copiando los elementos del arreglo viejo al nuevo
        for (int i= 0; i<effectiveSize; i++) {
            newElements[i] = elements[i];
        }
        this.elements = newElements;
    }

    private boolean isFull() {
        return effectiveSize == MAX_SIZE;
    }

    @Override
    public void reverse() {
        int cambiar = this.size()/2;
        E[] elementos = elements.clone();
        int num = this.size()-1;
        for(int i = 0; i < cambiar; i++) {
            this.add(i,elementos[num]);
            num--;
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //@Override
    public ArrayList<E> subList(int from, int to) {
        ArrayList<E> subArreglo  = new ArrayList<>();
        
        if(from<this.size()-1 && to>0) {
            int j = 0;
            for(int i = from; i < to; i++)
            {
                subArreglo.add(j,this.get(i) );
                j++;
            }
    }
        return subArreglo;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    @Override
    public boolean removeFirstNElements(int n) {
        if(n<=this.size()){
            for(int i  = 0; i<n; i++){
                this.removeFirst();
            }
            return true;
        }else 
            return false;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    //metodo rotate
    public void rotate(int k)
    {
        //k es el indice donde debe estar el primer elemento
        //el numero de elementos que deben estar despues del indice son k-1
        
        //copia de arreglo:
        E[] elementos = elements.clone();
        /*
        IMPLEMENTACION NO VALIDA
        int num = k;
        for(int i = 0; i < k; i++) {
            //ejemplo [1,2,3,4] k = 2
            //  [3,4,1,2]
            //
            elementos[i] = elements[num];
            num++;
        }
        for(int i = k-1; i>1; i--)
        {
            //i = 1
            elementos[i] = elements[i];
        }
*/
        int num  = k;
        //los elementos se empujan hasta regresar al inicio
        //resultado final [3,4,1,2]
        
        
        //hace que los elementos del inicio se muevan hacia su parte correspondiente
        for(int i = 0; i < k; i++) {
            //ejemplo [1,2,3,4] k = 2
            //  [,,1,2]
            //
            elements[num] = elementos[i];
            num++;
        } 
        
        //hace que los elementos del final se muevan hacia su parte correspondiente
        //elemento final se mueve a la primera posicio
        int j = k-1;
        for(int i = this.size(); i>k; i--)
        {
            //i = 1
            elements[j]= elementos[i];
            j--;
        }            
    }
    
    
    //Metodo toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.size(); i++){
            if(i != this.size())
            {
                sb.append(elements[i]);
            
                sb.append(",");
            }
            else{
                sb.append(elements[i]);
            }
        }
        return sb.toString();
    }
}


//metodos revisar:
/*
add
removeFirst

*/