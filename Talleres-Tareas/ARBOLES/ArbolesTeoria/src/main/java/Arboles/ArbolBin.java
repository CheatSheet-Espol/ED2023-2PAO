    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Nodos.NodoBinario;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author danlevil
 */
public class ArbolBin<E> {
    
    private NodoBinario<E> root;
    
    public ArbolBin(){
        this.root=null;
    }
    
    public ArbolBin(E contenido){
        this.root= new NodoBinario(contenido);
        
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public E getRoot() {
        return this.root.getContenido();
    }
    public NodoBinario<E> getRootNode() {
        return this.root;
    }
    public boolean isLeaf() {
        return this.root.getLeft() == null
                && this.root.getRight() == null;
    }
    
    
    public List<E> preOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        results.add(this.root.getContenido());
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().preOrderTraversal();
            results.addAll(leftTraversal);
        }
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().preOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }
    
    public void preOrden(ArbolBin r){
        if(r!=null){
            System.out.println(r.getRoot());
            preOrden(r.getLeft());
            preOrden(r.getRight());
            
        }
        
    }
    public void postOrden(ArbolBin r){
        if(r!=null){
            postOrden(r.getLeft());
            postOrden(r.getRight());
            System.out.println(r.getRoot());
            
        }
        
    }
    public void inOrden(ArbolBin r){
        if(r!=null){
            inOrden(r.getLeft());
            System.out.println(r.getRoot());
            inOrden(r.getRight());
            
        }
        
    }
    public List<E> inOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        if (root.getLeft() != null) {
            List<E> leftTraversal = root.getLeft().inOrderTraversal();
            results.addAll(leftTraversal);
        }
        results.add(this.root.getContenido());
        if (root.getRight() != null) {
            List<E> rightTraversal = root.getRight().inOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }

    void setLeft(ArbolBin<E> t) {
        this.root.setLeft(t);
    }

    void setRight(ArbolBin<E> t) {
        this.root.setRight(t);
    }

    ArbolBin<E> getLeft() {
        return this.root.getLeft();
    }

    ArbolBin<E> getRight() {
        return this.root.getRight();
    }

    public int countNodesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int totalLeft = 0;
        if (this.getLeft() != null) {
            totalLeft = this.getLeft().countNodesRecursive();
        }
        int totalRight = 0;
        if (this.getRight() != null) {
            totalRight = this.getRight().countNodesRecursive();
        }
        return 1 + totalLeft + totalRight;
    }

    public int countNodesIterative() {
        int nNodes = 0;
        Stack<ArbolBin<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            ArbolBin<E> tree = s.pop();
            nNodes++;
            if (tree.getLeft() != null) {
                s.push(tree.getLeft());
            }
            if (tree.getRight() != null) {
                s.push(tree.getRight());
            }
        }
        return nNodes;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        int leavesLeft = 0;
        int leavesRight = 0;
        if (this.getLeft() != null) {
            leavesLeft = this.getLeft().countLeavesRecursive();
        }
        if (this.getRight() != null) {
            leavesRight = this.getRight().countLeavesRecursive();
        }
        return leavesLeft + leavesRight;
    }

    public int countLeavesIterative() {
        int totalLeaves = 0;
        Stack<ArbolBin<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            ArbolBin<E> tree = s.pop();
            if (tree.isLeaf()) {
                totalLeaves++;
            } else {
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }

    public int countInternalNodesIterative() {
        int totalLeaves = 0;
        Stack<ArbolBin<E>> s = new Stack<>();
        if (!this.isEmpty()) {
            s.push(this);
        }
        while (!s.isEmpty()) {
            ArbolBin<E> tree = s.pop();
            if (!tree.isLeaf()) {
                totalLeaves++;
                if (tree.getLeft() != null) {
                    s.push(tree.getLeft());
                }
                if (tree.getRight() != null) {
                    s.push(tree.getRight());
                }
            }
        }
        return totalLeaves;
    }
}
