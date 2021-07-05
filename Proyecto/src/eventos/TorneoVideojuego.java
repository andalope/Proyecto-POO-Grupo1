
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Estudiante;

// Indica la relacion de Herencia con la clase competencia 
public class TorneoVideojuego extends Competencia{
    private String nombreVideojuego;

    public TorneoVideojuego() {
    }
// Sobrecarga del metodo TorneoVideojuego
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
        if (terminado) {// No se permiten mas participantes con la carrera creada
            System.out.println("Torneo cerrada, no se pueden registrar más estudiantes");
            System.out.println("");
        } else {// admite participantes si la carrera aun no empieza
            System.out.println("Registro de participantes en torneo " + nombreVideojuego);
            String id;
            do {
                System.out.print("ID del estudiante: ");
                id = sistema.getScanner().nextLine();// Obtiene el id del estudiante

                Estudiante e = sistema.buscarEstudiante(id);// verifica si el id ingresado es valido 
                Candidato repetido = buscarParticipante(id);// verifica si el id ha sido registrado 

                if (id.equals("0")) {
                    System.out.println("Volviendo al menu principal");
                } else if (e == null || repetido != null) {//Si el ID ya fue registrado o no es vàlido, no registra a ese participante
                    System.out.println("Id no existe o estudiante ya registrado");
                } else {//Si el ID es vàlido y no se ha ingresado antes, registra al participante
                    addParticipante(e);
                    System.out.println("Estudiante " + e.getNombre() + " registrado");
                }
            } while (!id.equals("0"));
        }
    }
    // metodo que registra los ganadores en eltorneo
    

    @Override
    public void registrarGanadores() {
       if (terminado) {//Si la carrera ya ha finalizado imprime mensaje y no permite modificaciones
            System.out.println("Torneo cerrado, no se pueden modificar los ganadores");
            System.out.println("");
        } else if (listaParticipantes.size() >= 3) {//Si la lista de participantes inscritos es mayor y igual a 3 entra al ciclo while
            int i = 0;
            do {
                System.out.println("Ingreso del puesto N°" + (i + 1));//Va registrando los ganadores en su posición respectiva
                System.out.print("ID: ");
                String id = sistema.getScanner().nextLine();//Se ingresa el ID del participante

                Estudiante e = (Estudiante) buscarParticipante(id);//Verifica si el ID ingresado realmente pertenece a un participante

                if (e == null || ganadorRepetido(id)) {//Verifica si el ID no existe o si ese participante ya está en el podio de ganadores
                    System.out.println("Id no existe o ganador ya incluido");
                    System.out.println("");
                } else {
                    System.out.println("Estudiante " + e + " ganador");
                    System.out.println("");
                    ganadores[i] = e;//Si el ID es válido, se registra el tiempo que realizó cada uno de los miembros del podio
                    i++;
                }
            } while (i < 3);//Si hay menos de 3 participantes no se realiza la premiación por falta de participantes
            terminado = true;
        } else {
            System.out.println("No hay suficientes participantes registrados");
            System.out.println("");
        }
     
    }
// Menú con las opciones 
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