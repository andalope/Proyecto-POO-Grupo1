/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import eventos.Carrera5K;
import eventos.Competencia;
import eventos.CompetenciaBanda;
import eventos.TorneoVideojuego;
import java.util.Scanner;

/**
 *
 * @author danil
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema sistema = Sistema.getInstance();
        Scanner sc = sistema.getScanner();
        Competencia[] tipos = new Competencia[3];
        tipos[0] = new Carrera5K();
        tipos[1] = new CompetenciaBanda();
        tipos[2] = new TorneoVideojuego();
        
        int opcion;
        do{
            sistema.presentarSistema();
            opcion = Integer.parseInt(sc.nextLine());
            System.out.println("");
            if (opcion != 4) {
                
            }
            switch(opcion) {
                case 1:
                    sistema.cambiarTipo(tipos[0]);
                    break;
                case 2:
                    sistema.cambiarTipo(tipos[1]);
                    break;
                case 3:
                    sistema.cambiarTipo(tipos[2]);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Elige una opción correcta");
            }
            
            if (opcion > 0 && opcion < 4) {
                int opcionSeccion;
                do{
                    sistema.presentarMenuSeccion();
                    opcionSeccion = Integer.parseInt(sc.nextLine());
                    System.out.println("");
                    Competencia actual;
                    int id;
                    
                    switch(opcionSeccion) {
                        case 1:
                            sistema.opcionUno();
                            break;
                        case 2:
                            sistema.opcionDos();
                            id = Integer.parseInt(sc.nextLine());
                            actual = sistema.buscarCompetencia(id);
                            if (actual != null) {
                                sistema.registrarParticipantes(actual);
                            } else {
                                System.out.println("Id de carrera no existe");
                            }
                            break;
                        case 3:
                            sistema.opcionTres();
                            id = Integer.parseInt(sc.nextLine());
                            actual = sistema.buscarCompetencia(id);
                            if (actual != null) {
                                sistema.registrarGanadores(actual);
                            } else {
                                System.out.println("Id de carrera no existe");
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Elige una opción correcta");
                    }
                } while (opcionSeccion != 4);
            }
            
        } while (opcion != 4);
        
 }        
}
