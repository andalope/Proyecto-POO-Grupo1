/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menuprincipal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author danil
 */
public class MenuPrincipal {

    /**
     * @param args the command line arguments
     */
    
    String[] opciones = new String[4];
    opciones[1]  = "1";
    
    Scanner sc = new Scanner(System.in);
    
    public boolean verificador(){
        String opcion_escogida = "";
        opcion_escogida = sc.nextLine();
        //for(int validador=0; validador< opcionesMenuPrincipal.size(); validador++){
          //  d;
            
        //}
       // if(opcion_escogida){
       //}
        
       // return opcion_escogida;
           
    }
            
    public String menuPrincipal(){
       
        boolean check= false;
        
        do{
        System.out.println("Menu principal");
        System.out.println("1. Carrera 5K");
        System.out.println("2. Competencia de Bandas musicales");
        System.out.println("3. Torneo de videojuegos");
        System.out.println("4. Salir");
        

        }
        

        
        while(check!=true){
            System.out.println("Ingrese una opcion correcta");
        }

        
       
        
        
        
        
    } 
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
