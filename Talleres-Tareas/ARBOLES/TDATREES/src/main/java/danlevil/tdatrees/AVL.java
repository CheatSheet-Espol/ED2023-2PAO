/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.tdatrees;

/**
 *
 * @author danlevil
 */


public class AVL {
    private AVLNode root;

    public AVL() {
        this.root = null;
    }

    // Obtener la altura de un nodo
    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Obtener el balance de un nodo
    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Actualizar la altura de un nodo
    private void updateHeight(AVLNode node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    // Rotación simple a la derecha
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Realizar la rotación
        x.right = y;
        y.left = T2;

        // Actualizar alturas
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Rotación simple a la izquierda
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Realizar la rotación
        y.left = x;
        x.right = T2;

        // Actualizar alturas
        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Rotación doble a la izquierda-derecha
    private AVLNode leftRightRotate(AVLNode x) {
        x.left = leftRotate(x.left);
        return rightRotate(x);
    }

    // Rotación doble a la derecha-izquierda
    private AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // Insertar un nodo en el árbol
    public void insert(int key) {
        root = insertNode(root, key);
    }

    private AVLNode insertNode(AVLNode node, int key) {
        // Realizar la inserción como en un BST estándar
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            // No se permiten claves duplicadas
            return node;
        }

        // Actualizar la altura del nodo actual
        updateHeight(node);

        // Obtener el balance y realizar rotaciones si es necesario
        int balance = getBalance(node);

        // Casos de desequilibrio
        // Izquierda - Izquierda
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // Derecha - Derecha
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // Izquierda - Derecha
        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }
        // Derecha - Izquierda
        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node;
    }

    // Eliminar un nodo en el árbol
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private AVLNode deleteNode(AVLNode root, int key) {
        // Realizar la eliminación como en un BST estándar
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (root.left == null || root.right == null) {
                AVLNode temp = (root.left != null) ? root.left : root.right;

                // Caso sin hijos
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // Caso con un hijo
                    root = temp;
                }
            } else {
                // Nodo con dos hijos: obtener el sucesor in-order (menor en el subárbol derecho)
                AVLNode temp = findMinNode(root.right);

                // Copiar el sucesor in-order al nodo actual
                root.key = temp.key;

                // Eliminar el sucesor in-order
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // Si el árbol tenía solo un nodo, no es necesario realizar más acciones
        if (root == null) {
            return root;
        }

        // Actualizar la altura del nodo actual
        updateHeight(root);

        // Obtener el balance y realizar rotaciones si es necesario
        int balance = getBalance(root);

        // Casos de desequilibrio
        // Izquierda - Izquierda
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // Derecha - Derecha
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        // Izquierda - Derecha
        if (balance > 1 && getBalance(root.left) < 0) {
            return leftRightRotate(root);
        }
        // Derecha - Izquierda
        if (balance < -1 && getBalance(root.right) > 0) {
            return rightLeftRotate(root);
        }

        return root;
    }

    // Método auxiliar para encontrar el nodo con el valor mínimo en un subárbol
    private AVLNode findMinNode(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Otros métodos del árbol AVL (código no proporcionado para simplificar)
    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
}
class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = this.right = null;
    }
}