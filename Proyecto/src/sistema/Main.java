package sistema;
// importa los paquetes con las clases 
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
            sistema.presentarSistema(); //se presenta el menu y se recepta la opcion ingresada por usuario
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            switch (opcion) {//dependiendo de la opcion elegica por el usuario del menu principal, se accede.
                case 1: //opcion 1
                    tipoActual = tipos[0];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 2: //opcion 2
                    tipoActual = tipos[1];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 3: //opcion 3
                    tipoActual = tipos[2];
                    sistema.cambiarTipo(tipoActual);
                    break;
                case 4: //opcion 4 de salir
                    break;
                default: //en caso de que ingrese una opcion que no es correcta
                    System.out.println("Elige una opción correcta");
            }

            if (opcion > 0 && opcion < 4) {
                int opcionSeccion;
                do {
                    sistema.presentarMenuSeccion(); //se presenta el menu que varia dependiendo de la competencia
                    opcionSeccion = Integer.parseInt(sc.nextLine()); //opcion ingresada por usuario
                    System.out.println("");
                    Competencia actual;
                    String id;

                    switch (opcionSeccion) {
                        case 1:
                            sistema.opcionUno();
                            break;
                        case 2: //caso donde se busca una competencia
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