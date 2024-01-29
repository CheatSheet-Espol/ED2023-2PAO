# Arboles N-arios

Un árbol N-ario es aquel en el que cada nodo puede tener hasta N hijos. En el caso especial de N=2, se convierte en un árbol binario. O sea puede tener muchos hijos

## Implementación de un Árbol N-ario sin comparadores

~~~java
import java.util.ArrayList;
import java.util.List;

public class NaryTree<E> {
    private Node<E> root;

    public NaryTree(E data) {
        this.root = new Node<>(data);
    }

    private static class Node<E> {
        E data;
        List<Node<E>> children;

        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // Métodos y operaciones para un árbol n-ario...
}

~~~
### Operaciones a realizar con un arbol N-ario

Agregar un Nodo:
Seleccionar el nodo padre y agregar un nuevo nodo como hijo.

Eliminar un Nodo:
Eliminar un nodo y ajustar la estructura para mantener la coherencia.

Recorridos (DFS y BFS):
Realizar un recorrido en profundidad (Depth-First Search) o un recorrido en amplitud (Breadth-First Search) en el árbol.

Buscar un Nodo:
Buscar un nodo específico en el árbol.

Altura del Árbol:
Calcular la altura del árbol.

Número de Nodos:
Contar el número total de nodos en el árbol.

Anchura de un Nivel:
Calcular el número de nodos en un nivel específico del árbol.

~~~java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTree<E> {
    private Node<E> root;

    public NaryTree(E data) {
        this.root = new Node<>(data);
    }

    private static class Node<E> {
        E data;
        List<Node<E>> children;

        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // Método para agregar un nodo al árbol n-ario
    public void addNode(E parentData, E newData) {
        Node<E> parentNode = findNode(root, parentData);
        if (parentNode != null) {
            parentNode.children.add(new Node<>(newData));
        } else {
            System.out.println("El nodo padre no se encuentra.");
        }
    }

    // Método para eliminar un nodo del árbol n-ario
    public void deleteNode(E data) {
        root = deleteNode(root, data);
    }

    private Node<E> deleteNode(Node<E> root, E data) {
        if (root == null) {
            return null;
        }

        if (root.data.equals(data)) {
            return null; // Eliminar este nodo (se puede personalizar según la lógica deseada)
        }

        List<Node<E>> newChildren = new ArrayList<>();
        for (Node<E> child : root.children) {
            Node<E> newChild = deleteNode(child, data);
            if (newChild != null) {
                newChildren.add(newChild);
            }
        }

        root.children = newChildren;
        return root;
    }

    // Método para realizar un recorrido en profundidad (DFS)
    public void depthFirstSearch() {
        depthFirstSearch(root);
    }

    private void depthFirstSearch(Node<E> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " "); // Visitar el nodo
        for (Node<E> child : node.children) {
            depthFirstSearch(child); // Recorrer cada hijo
        }
    }

    // Método para realizar un recorrido en amplitud (BFS)
    public void breadthFirstSearch() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            System.out.print(current.data + " "); // Visitar el nodo

            for (Node<E> child : current.children) {
                queue.offer(child); // Agregar cada hijo a la cola
            }
        }
    }

    // Método para buscar un nodo en el árbol n-ario
    public boolean searchNode(E data) {
        return searchNode(root, data);
    }

    private boolean searchNode(Node<E> node, E data) {
        if (node == null) {
            return false;
        }

        if (node.data.equals(data)) {
            return true;
        }

        for (Node<E> child : node.children) {
            if (searchNode(child, data)) {
                return true;
            }
        }

        return false;
    }

    // Método para calcular la altura del árbol n-ario
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }

        int maxHeight = 0;
        for (Node<E> child : node.children) {
            int height = height(child);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight + 1; // Altura del nodo actual
    }

    // Método para contar el número total de nodos en el árbol n-ario
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }

        int count = 1; // Contar el nodo actual
        for (Node<E> child : node.children) {
            count += countNodes(child); // Contar nodos en cada hijo
        }

        return count;
    }

    // Método para calcular el número de nodos en un nivel específico del árbol n-ario
    public int widthAtLevel(int level) {
        return widthAtLevel(root, level);
    }

    private int widthAtLevel(Node<E> node, int level) {
        if (node == null || level < 0) {
            return 0;
        }

        if (level == 0) {
            return node.children.size();
        }

        int width = 0;
        for (Node<E> child : node.children) {
            width += widthAtLevel(child, level - 1);
        }

        return width;
    }

    public static void main(String[] args) {
        // Crear un árbol n-ario de ejemplo
        NaryTree<Integer> naryTree = new NaryTree<>(1);
        naryTree.addNode(1, 2);
        naryTree.addNode(1, 3);
        naryTree.addNode(1, 4);
        naryTree.addNode(2, 5);
        naryTree.addNode(2, 6);
        naryTree.addNode(3, 7);
        naryTree.addNode(4, 8);

        // Imprimir resultados de operaciones
        System.out.println("Árbol n-ario:");
        naryTree.depthFirstSearch();
        System.out.println("\nNúmero total de nodos: " + naryTree.countNodes());
        System.out.println("Altura del árbol: " + naryTree.height());
        System.out.println("Número de nodos en el nivel 2: " + naryTree.widthAtLevel(2));
        System.out.println("¿El nodo 5 existe en el árbol?: " + naryTree.searchNode(5));

        // Eliminar un nodo y volver a imprimir el árbol
        naryTree.deleteNode(3);
        System.out.println("\nÁrbol n-ario después de eliminar el nodo 3:");
        naryTree.depthFirstSearch();
    }
}

~~~

## Implementación de un Árbol N-ario con comparadores

~~~java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NaryTree<E> {
    private Comparator<E> comparator;
    private Node<E> root;

    public NaryTree(Comparator<E> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    private static class Node<E> {
        E data;
        List<Node<E>> children;

        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public void addNode(E data) {
        root = addNode(root, data);
    }

    private Node<E> addNode(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        for (Node<E> child : node.children) {
            if (comparator.compare(data, child.data) == 0) {
                // Node with the same data already exists, don't add it again
                return node;
            }
        }

        node.children.add(new Node<>(data));
        return node;
    }

    public boolean searchNode(E data) {
        return searchNode(root, data);
    }

    private boolean searchNode(Node<E> node, E data) {
        if (node == null) {
            return false;
        }

        if (comparator.compare(data, node.data) == 0) {
            return true;
        }

        for (Node<E> child : node.children) {
            if (searchNode(child, data)) {
                return true;
            }
        }

        return false;
    }

    public void depthFirstSearch() {
        depthFirstSearch(root);
        System.out.println();
    }

    private void depthFirstSearch(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            for (Node<E> child : node.children) {
                depthFirstSearch(child);
            }
        }
    }

    public static void main(String[] args) {
        // Crear un Árbol N-ario de ejemplo con un comparador para cadenas
        Comparator<String> stringComparator = Comparator.naturalOrder();
        NaryTree<String> naryTree = new NaryTree<>(stringComparator);
        naryTree.addNode("A");
        naryTree.addNode("B");
        naryTree.addNode("C");
        naryTree.addNode("D");

        // Imprimir resultados de operaciones
        System.out.println("Árbol N-ario:");
        naryTree.depthFirstSearch();
        System.out.println("¿El nodo 'C' existe en el árbol?: " + naryTree.searchNode("C"));
    }
}

~~~