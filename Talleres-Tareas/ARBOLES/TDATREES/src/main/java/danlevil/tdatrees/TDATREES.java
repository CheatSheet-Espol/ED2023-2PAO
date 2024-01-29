/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.tdatrees;

/**
 *
 * @author danlevil
 */
public class TDATREES {

    public static void main(String[] args) {
        System.out.println("ARBOL BALANCEADO TEST\n");
        AVL avlTree = new AVL();
        avlTree.insert(30);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(10);
        avlTree.insert(25);

        System.out.println("Arbol AVL en inorden:");
        avlTree.inOrderTraversal();
        AVL avlTree2 = new AVL();
        avlTree2.insert(30);
        avlTree2.insert(20);
        avlTree2.insert(40);
        avlTree2.insert(10);
        avlTree2.insert(25);
        System.out.println("\n");
        System.out.println("Arbol AVL en preorden:");
        avlTree.preOrderTraversal();
        
        System.out.println("\n\nARBOL BINARIO TEST\n");
        TBinario arbol= new TBinario();
        arbol.agregarNodo(50);
        arbol.agregarNodo(30);
        arbol.agregarNodo(70);
        arbol.agregarNodo(20);
        arbol.agregarNodo(40);
        arbol.agregarNodo(60);
        arbol.agregarNodo(80);

        // Mostrar recorridos del árbol
        System.out.println("Inorden:");
        arbol.inorden(arbol.getRoot());
        System.out.println();

        System.out.println("Preorden:");
        arbol.preorden(arbol.getRoot());
        System.out.println();

        System.out.println("Postorden:");
        arbol.postorden(arbol.getRoot());
        System.out.println();

        // Buscar un nodo en el árbol
        int datoBuscar = 40;
        Nodo nodoBuscado = arbol.buscarNodo(datoBuscar);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.getDato());
        } else {
            System.out.println("Nodo no encontrado.");
        }

        // Eliminar un nodo del árbol
        int datoEliminar = 30;
        arbol.eliminarNodo(datoEliminar);

        // Mostrar inorden después de eliminar un nodo
        System.out.println("Inorden despues de eliminar el nodo con dato " + datoEliminar + ":");
        arbol.inorden(arbol.getRoot());
    }
}
