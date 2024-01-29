package Arboles;


import Arboles.ArbolBin;
import Arboles2.NodoBinario;
import Arboles2.TreeBinario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danlevil
 */
public class Main {
    
    public static void main(String[] args) {
 /*       ArbolBin<Integer> tree = new ArbolBin(0);
        tree.setLeft(new ArbolBin(1));
        tree.setRight(new ArbolBin(2));
        tree.getLeft().setLeft(new ArbolBin(3));
        tree.getLeft().setRight(new ArbolBin(45));
        tree.getRight().setLeft(new ArbolBin(5));
        tree.getRight().setRight(new ArbolBin(6));
        tree.getRight().getRight().setRight(new ArbolBin(7));
        tree.getRight().getRight().getRight().setRight(new ArbolBin(8));
        
        System.out.println("Total nodes RECURSIVE: " + tree.countNodesRecursive());
        System.out.println("Total nodes ITERATIVE: " + tree.countNodesIterative());
        System.out.println("Total leaves RECURSIVE: " + tree.countLeavesRecursive());
        System.out.println("Total leaves ITERATIVE: " + tree.countLeavesIterative());
        System.out.println("Total intetrnal nodes ITERATIVE: " + tree.countInternalNodesIterative());
        tree.preOrden(tree);
        System.out.println("inOrden");
        tree.inOrden(tree);
        System.out.println("postOrdenqqqqqq");
        tree.postOrden(tree);
//        ArbolBin<String> expressionTree = buildExpressionTree("3 41 + 12 3 + *");
//        int result = evaluateExpressionTree(expressionTree);
//        System.out.println("Result: " + result);

*/
        TreeBinario<String> arb1= new TreeBinario<>("A");
        //arb1.root.setHijoIzq(new TreeBinario("izq"));
        //arb1.root.setHijoDer(new TreeBinario("der"));
        arb1.añadirElementos("B");
        arb1.añadirElementos("C");
        arb1.añadirElementos("D");
        arb1.añadirElementos("E");
        System.out.println(arb1.preOrderTraversal());
        System.out.println(  arb1.enOrderTraversal());
        System.out.println(arb1.postOrderTraversal());
    }

}
