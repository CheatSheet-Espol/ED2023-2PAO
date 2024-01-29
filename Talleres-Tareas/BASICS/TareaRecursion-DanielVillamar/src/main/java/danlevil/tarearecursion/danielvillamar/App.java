/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.tarearecursion.danielvillamar;

/**
 *
 * @author danlevil
 */
//Proyecto compilado en Java 11, modificar POM en caso de error.
public class App {

    public static void main(String[] args) {
        System.out.println("La suma de digitos de 135 es: " + App.sumarDigitos(135));
        System.out.println("La suma de digitos de  67 es: "+ App.sumarDigitos(67));
        System.out.println("La suma de digitos de 1111 es : "+ App.sumarDigitos(1111));
    }
    
    static int sumarDigitos(int n){
        if (n < 10) {
            return n; 
        } else {
            int  num1= n / 10; 
            int ultimoDigito = n % 10; 
            return  sumarDigitos(num1) +ultimoDigito ;
        }
    
    }
    
}
