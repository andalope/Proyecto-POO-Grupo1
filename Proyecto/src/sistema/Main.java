package sistema;

import eventos.Carrera5K;
import eventos.Competencia;
import eventos.CompetenciaBanda;
import eventos.TorneoVideojuego;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Sistema sistema = Sistema.getInstance();
        Scanner sc = sistema.getScanner();
        sistema.inicializar();
        Competencia[] tipos = new Competencia[3];
        tipos[0] = new Carrera5K();
        tipos[1] = new CompetenciaBanda();
        tipos[2] = new TorneoVideojuego();
        Competencia tipoActual = null;

        int opcion;
        do {
            sistema.presentarSistema();
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            switch (opcion) {
                case 1:
                    tipoActual = tipos[0];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 2:
                    tipoActual = tipos[1];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 3:
                    tipoActual = tipos[2];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Elige una opción correcta");
            }

            if (opcion > 0 && opcion < 4) {
                int opcionSeccion;
                do {
                    sistema.presentarMenuSeccion();
                    opcionSeccion = Integer.parseInt(sc.nextLine());
                    System.out.println("");
                    Competencia actual;
                    String id;

                    switch (opcionSeccion) {
                        case 1:
                            sistema.opcionUno();
                            break;
                        case 2:
                            sistema.opcionDos();
                            id = sc.nextLine();
                            actual = sistema.buscarCompetencia(id);
                            if (actual != null && tipoActual != null && tipoActual.getClass() == actual.getClass()) {
                                sistema.registrarParticipantes(actual);
                            } else {
                                System.out.println("Id de competencia no existe");
                            }
                            break;
                        case 3:
                            sistema.opcionTres();
                            id = sc.nextLine();
                            actual = sistema.buscarCompetencia(id);
                            if (actual != null && tipoActual != null && tipoActual.getClass() == actual.getClass()) {
                                sistema.registrarGanadores(actual);
                            } else {
                                System.out.println("Id de competencia no existe o funcion no aplica implementación");
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
        sc.close();
    }
}