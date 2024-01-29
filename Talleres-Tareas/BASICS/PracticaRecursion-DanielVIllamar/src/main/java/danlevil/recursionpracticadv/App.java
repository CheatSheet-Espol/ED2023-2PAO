/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package danlevil.recursionpracticadv;

import java.util.ArrayList;

/**
 *
 * @author CltControl
 * 
 */
//En caso de error este proyecto se compila en java 11. Modificar POM;
public class App {

    public static void main(String[] args) {
        
        String pal1="ana";
        String pal2="perro";
        System.out.println((App.esPalindromo(pal1)?"La palabra "+pal1+
                " es palindromo":
                "La palabra "+pal1+" No es palindromo"));
        System.out.println((App.esPalindromo(pal2)?"La palabra "+pal1+
                " es palindromo":
                "La palabra "+pal2+" No es palindromo"));
        System.out.println("2 elevado a 5 es: "+App.potencia(2, 5));
        System.out.println("3 elevado a 3 es: "+App.potencia(3, 3));
        System.out.println("1 elevado a 10 es: "+App.potencia(1, 10));
        System.out.println("'Hello' revertido es: "+App.revertir("Hello"));
        System.out.println("'Palindromo' revertido es: "+App.revertir("Palindromo"));
        System.out.println("'Agua' revertido es: "+App.revertir("Agua"));
    
    }
 
    static boolean esPalindromo(String s){
        if(s.length()<=1){
            return true;
        }else{
            if(s.charAt(0)==s.charAt(s.length()-1)){
                String substring=s.substring(1, s.length()-1);
                return esPalindromo(substring);
            }else{
                return false;
            }
        }
            
    }
    static int potencia(int base, int exponente){
        if(exponente==0){
            return 1;
        }else if(exponente <0){
            return 0;
        }else{
            return base*potencia(base,exponente-1);
        }
    }
    static String revertir(String s){
          if (s.length() <= 1) {
            return s; 
        } else {
            char primerCaracter = s.charAt(0);
            String substring = s.substring(1);
            String palabraInvertidaRestante = revertir(substring);
            return palabraInvertidaRestante + primerCaracter;
        }
        
    }
}
