/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package danlevil.p1recursion;

/**
 *
 * @author CltControl
 */
public class Factorial {
    public static int factorial(int n){
        if(n==0){
            return 1;
            
        }else{
            return (n*factorial(n-1));
        }
    }
}
