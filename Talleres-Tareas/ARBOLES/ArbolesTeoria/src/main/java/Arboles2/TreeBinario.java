/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles2;

import Arboles.ArbolBin;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author danlevil
 */
public class TreeBinario<E> {
    public NodoBinario<E> root;
    
    
    public TreeBinario(){
        root=null;
    }
    public TreeBinario(E content){
        this.root= new NodoBinario(content);
    }
    public boolean isLeaf(){
        boolean hijoDerExists=root.getHijoDer()==null;
        boolean hijoIzqExists=root.getHijoIzq()==null;
        
        return hijoDerExists&&hijoIzqExists;
    }
    public boolean isEmpty(){
        return root==null;
    }
    
    public E getRoot(){
        return this.root.getContenido();
    }
    //RECORRIDO PRE ORDEN
    private void preOrden(){
        if(this.isEmpty()){
            return;
        }
        if(this.isLeaf()){
            System.out.println(root.getContenido());
            return;
        }
        System.out.println(this.getRoot().toString());
        this.root.getHijoIzq().preOrden();
        this.root.getHijoDer().preOrden();
        return;
        
    }
    private void preOrden(TreeBinario tree){
        if(tree!=null){
            System.out.println(tree.root.getContenido());
            preOrden(tree.root.getHijoIzq());
            preOrden(tree.root.getHijoDer());
            
        }
        
    }
    public List<E> preOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        results.add(this.root.getContenido());
        if (root.getHijoIzq() != null) {
            List<E> leftTraversal = root.getHijoIzq().preOrderTraversal();
            results.addAll(leftTraversal);
        }
        if (root.getHijoDer() != null) {
            List<E> rightTraversal = root.getHijoDer().preOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }
    
    
    
    //RECORRIDO EN ORDEN
    private void enOrden(){
        if(this.isEmpty()){
            return;
        }
        if(this.isLeaf()){
            System.out.println(root.getContenido());
            return;
        }
        this.root.getHijoIzq().preOrden();
        System.out.println(this.getRoot().toString());
        this.root.getHijoDer().preOrden();
        return;
    }
    private void enOrden(TreeBinario tree){
        if(tree!=null){
            preOrden(tree.root.getHijoIzq());
            System.out.println(tree.root.getContenido());
            preOrden(tree.root.getHijoDer());
            
        }
    } 
    public List<E> enOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        if (root.getHijoIzq() != null) {
            List<E> leftTraversal = root.getHijoIzq().enOrderTraversal();
            results.addAll(leftTraversal);
        }
        results.add(this.root.getContenido());
        if (root.getHijoDer() != null) {
            List<E> rightTraversal = root.getHijoDer().enOrderTraversal();
            results.addAll(rightTraversal);
        }
        return results;
    }
   
    
    //RECORRIDO POSTORDEN
    private void postOrden(){
        if(this.isEmpty()){
            return;
        }
        if(this.isLeaf()){
            System.out.println(root.getContenido());
            return;
        }
        this.root.getHijoIzq().preOrden();
        this.root.getHijoDer().preOrden();
        System.out.println(this.getRoot().toString());
        return;
    }
    private void postOrden(TreeBinario tree){
        if(tree!=null){
            preOrden(tree.root.getHijoIzq());
            preOrden(tree.root.getHijoDer());
            System.out.println(tree.root.getContenido());
            
        }
        
    }    
    public List<E> postOrderTraversal() {
        List<E> results = new LinkedList<>();
        if (this.isEmpty()) {
            return results;
        }
        if (root.getHijoIzq() != null) {
            List<E> leftTraversal = root.getHijoIzq().postOrderTraversal();
            results.addAll(leftTraversal);
        }
        if (root.getHijoDer() != null) {
            List<E> rightTraversal = root.getHijoDer().postOrderTraversal();
            results.addAll(rightTraversal);
        }
        results.add(this.root.getContenido());
        return results;
        
        
        
    }
    //AÑADIR ELEMENTOS
    public void añadirElementos(E contenido){
        TreeBinario<E> izquierdo= root.getHijoIzq();
        TreeBinario<E> derecho= root.getHijoDer();
        if(this.root==null){
            root= new NodoBinario<E>(contenido);
            return;
        }
        if(izquierdo==null){
            root.setHijoIzq(new TreeBinario(contenido));
            return;
         
        }
        else if(derecho==null){
            root.setHijoDer(new TreeBinario(contenido));
            return;
        }
        root.getHijoIzq().añadirElementos(contenido);
        root.getHijoDer().añadirElementos(contenido);
        
    }
    

}
