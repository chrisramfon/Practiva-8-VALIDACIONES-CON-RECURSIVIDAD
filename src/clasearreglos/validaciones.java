/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;
import java.util.*;
/**
 *
 * @author Chrisramfon
 */
public class validaciones {
    
    public int leerEntero(){
        try{
           Scanner sc=new Scanner(System.in);
           int i=sc.nextInt();
           return i;
        }catch(Exception e){
            System.out.println("Valor ingresado no es un entero");
            return leerEntero();
        }
    }
    
     public double leerDecimal(){
        try{
           Scanner sc=new Scanner(System.in);
           double i=sc.nextDouble();
           return i;
        }catch(Exception e){
            System.out.println("Valor ingresado no es un número decimal");
            return leerDecimal();
        }
    }
    
     public String leerNombre(String Caracteres){
         try{
           Scanner sc=new Scanner(System.in);
           String s=sc.next();
           s.trim();
           Exception x=new Exception();
           String car=Caracteres.trim();
           for(int i=0;i<s.length();i++){
              char c=s.charAt(i);
              if(car.indexOf(c)==-1){
                  //System.out.println("Valor ingresado no es un nombre válido");
                  throw x;
                  //leerNombre(car);
              }
           }
           return s;
        }catch(Exception e){
            System.out.println("Valor ingresado no es un nombre válido");
            return leerNombre(Caracteres);
        }
         
     }
}
