//Clase para la competencia Carrera 5K, Hija de la clase Competencia
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Estudiante;
import participantes.Participante5K;


//Indica la relación de herencia respecto a la clase "Competencia"
public class Carrera5K extends Competencia {

    public Carrera5K() {
        super();
    }

//sobrecarga del metodo Carrera5k
    public Carrera5K(String id, LocalDate fecha, LocalTime hora, String[] premios) {
        super(id, fecha, hora, premios);
    }

    public Carrera5K(String id, LocalDate fecha, LocalTime hora, String[] premios, boolean terminado) {
        super(id, fecha, hora, premios, terminado);
    }
    
    //Método que presenta el menú de opciones para las competecias de Carreras5K
    @Override
    public void presentarMenu() {
        System.out.println("Estas dentro de la seccion Carreras 5K");

        sistema.competenciasCreadas(this);
        
        System.out.println("");

        System.out.println("1. Crear nueva carrera");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar ganadores");
        System.out.println("4. Volver al menu principal");
        System.out.println("");
        System.out.print("Escoge una opcion: ");
    }

//Método que registra participantes que quieran participar en Carreras5K
    @Override
    public void registarParticipante() {
        if (terminado) {//Si la carrera está cerrada no permite el ingreso de más participantes
            System.out.println("Carrera cerrada, no se pueden registrar más estudiantes");
            System.out.println("");
        } else {//Si la carrera aún no empieza admite el registro de participantes
            System.out.println("Registro de participantes en carrera del " + getFecha());//Registra participantes a una carrea de una fecha determinada
            String id;
            do {
                System.out.print("ID del estudiante: ");
                id = sistema.getScanner().nextLine();//Se obtiene el Id del estudiante

                Estudiante e = sistema.buscarEstudiante(id);//Se verifica si el ID ingresado es válido
                Candidato repetido = buscarParticipante(id);//Verifica si el ID ya ha sido registrado

                if (id.equals("0")) {
                    System.out.println("Volviendo al menu principal");
                } else if (e == null || repetido != null) {//Si el ID ya fue registrado o no es vàlido, no registra a ese participante
                    System.out.println("Id no existe o estudiante ya registrado");
                    System.out.println("");
                } else {//Si el ID es vàlido y no se ha ingresado antes, registra al participante
                    Participante5K p = new Participante5K(e);
                    addParticipante(p);
                    System.out.println(" Estudiante " + e + " registrado");
                    System.out.println("");
                }
            } while (!id.equals("0"));
        }
    }

//Método que registra los ganadores de una Carrera    
    @Override
    public void registrarGanadores() {
        if (terminado) {//Si la carrera ya ha finalizado imprime mensaje y no permite modificaciones
            System.out.println("Carrera cerrada, no se pueden modificar los ganadores");
            System.out.println("");
        } else if (listaParticipantes.size() >= 3) {//Si la lista de participantes inscritos es mayor y igual a 3 entra al ciclo while
            int i = 0;
            do {
                System.out.println("Ingreso del puesto N°" + (i + 1));//Va registrando los ganadores en su posición respectiva
                System.out.print("ID: ");
                String id = sistema.getScanner().nextLine();//Se ingresa el ID del participante


                Participante5K p = (Participante5K) buscarParticipante(id);//Verifica si el ID ingresado realmente pertenece a un participante

                if (p == null || ganadorRepetido(id)) {//Verifica si el ID no existe o si ese participante ya está en el podio de ganadores
                    System.out.println("Id no existe o ganador ya incluido");
                } else {
                    ganadores[i] = p;//Si el ID es válido, se registra el tiempo que realizó cada uno de los miembros del podio
                    System.out.println("Usar coma para el ingreso del tiempo ejemplo: 14,5");
                    System.out.print("Tiempo: ");
                    
                    double tiempo = sistema.getScanner().nextDouble();
                    sistema.getScanner().nextLine();
                    p.setTiempo(tiempo);
                    i++;
                }
            } while (i < 3);//Si hay menos de 3 participantes no se realiza la premiación por falta de participantes
            terminado = true;//Se registra la carrera actual como finalizada para que no se pueda modificar los ganadores posteriormente
        } else {
            System.out.println("No hay suficientes participantes registrados");
            System.out.println("");
        }

    }

    @Override
    public void opcionUno() {
            System.out.println("No debe implementarse");
        System.out.println("");
    }

    @Override
    public void opcionDos() {
        System.out.print("Ingrese ID de la carrera: ");
    }

    @Override
    public void opcionTres() {
        System.out.print("Ingrese ID de la carrera: ");
    }
    
    @Override
    public String toString() {
        return super.toString() + "\t" + listaParticipantes.size();
    }

}
