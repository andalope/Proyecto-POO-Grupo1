
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Estudiante;


public class TorneoVideojuego extends Competencia{
    private String nombreVideojuego;

    public TorneoVideojuego() {
    }

    public TorneoVideojuego(String id, LocalDate fecha, LocalTime hora, String[] premios, String nombreVideojuego) {
        super(id, fecha, hora, premios);
        this.nombreVideojuego = nombreVideojuego;
    }
    public TorneoVideojuego(String id, LocalDate fecha, LocalTime hora, String[] premios, String nombreVideojuego, boolean terminado) {
        super(id, fecha, hora, premios, terminado);
        this.nombreVideojuego = nombreVideojuego;
    }
// Metodo que registra los participantes en el torneo
    @Override
    public void registarParticipante() {
        if (terminado) {
            System.out.println("Torneo cerrada, no se pueden registrar más estudiantes");
            System.out.println("");
        } else {
            System.out.println("Registro de participantes en torneo " + nombreVideojuego);
            String id;
            do {
                System.out.print("ID del estudiante: ");
                id = sistema.getScanner().nextLine();

                Estudiante e = sistema.buscarEstudiante(id);
                Candidato repetido = buscarParticipante(id);

                if (id.equals("0")) {
                    System.out.println("Volviendo al menu principal");
                } else if (e == null || repetido != null) {
                    System.out.println("Id no existe o estudiante ya registrado");
                } else {
                    addParticipante(e);
                    System.out.println("Estudiante " + e.getNombre() + " registrado");
                }
            } while (!id.equals("0"));
        }
    }
    // metodo que registra los ganadores en eltorneo
    

    @Override
    public void registrarGanadores() {
       if (terminado) {
            System.out.println("Torneo cerrado, no se pueden modificar los ganadores");
            System.out.println("");
        } else if (listaParticipantes.size() >= 3) {
            int i = 0;
            do {
                System.out.println("Ingreso del puesto N°" + (i + 1));
                System.out.print("ID: ");
                String id = sistema.getScanner().nextLine();

                Estudiante e = (Estudiante) buscarParticipante(id);

                if (e == null || ganadorRepetido(id)) {
                    System.out.println("Id no existe o ganador ya incluido");
                    System.out.println("");
                } else {
                    System.out.println("Estudiante " + e + " ganador");
                    System.out.println("");
                    ganadores[i] = e;
                    i++;
                }
            } while (i < 3);
            terminado = true;
        } else {
            System.out.println("No hay suficientes participantes registrados");
            System.out.println("");
        }
     
    }

    @Override
    public void presentarMenu() {
        System.out.println("Estas dentro de la seccion Torneo Videojuegos");
        sistema.competenciasCreadas(this);
        System.out.println("");

        System.out.println("1. Crear nuevo torneo");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar ganadores");
        System.out.println("4. Volver al menu principal");
        System.out.println("");
        System.out.print("Escoge una opcion: ");
    }

    @Override
    public void opcionUno() {
        System.out.println("No debe implementarse. Presion ENTER para volver al menu principal");
        System.out.println("");
    }

    @Override
    public void opcionDos() {
        System.out.print("Ingrese ID del torneo: ");
    }

    @Override
    public void opcionTres() {
        System.out.print("Ingrese ID del torneo: ");
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + nombreVideojuego;
    }    }