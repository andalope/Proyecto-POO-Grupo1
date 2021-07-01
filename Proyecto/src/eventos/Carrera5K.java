//Clase para la competencia Carrera 5K, Hija de la clase Competencia
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Estudiante;
import participantes.Participante5K;
import sistema.Sistema;

//Indica la relación de herencia respecto a la clase "Competencia"
public class Carrera5K extends Competencia{
    
public Carrera5K() {
}

//sobrecarga del metodo Carrera5k
public Carrera5K(int id, LocalDate fecha, LocalTime hora, String[] premios) {
        super(id, fecha, hora, premios);
}

public Carrera5K(int id, LocalDate fecha, LocalTime hora, String[] premios, boolean terminado) {
        super(id, fecha, hora, premios, terminado);
}

//sobreescritura de metododos de la clase competencia

//Método que presenta el menú de opciones para las competecias de Carreras5K
@Override
public void presentarMenu() {
    System.out.println("Estas dentro de la seccion Carreras 5K");
    System.out.println("Carreras creadas");
        
    for (Competencia c: Sistema.getInstance().getListaCompetencia()) {
        if (c.getClass() == this.getClass()) {
            System.out.println(c);
        }
    }
    System.out.println("");
        
    System.out.println("1. Crear nueva carrera");
    System.out.println("2. Registrar participantes");
    System.out.println("3. Registrar ganadores");
    System.out.println("4. Volver al menu principal");
    System.out.println("");
    System.out.print("Escoge una opcion: ");
    }

//Método que registrar participantes que quieran participar en Carreras5K
@Override
public void registarParticipante() {
    if (terminado) {//Si la carrera está cerrada no permite el ingreso de más participantes
        System.out.println("Carrera cerrada, no se pueden registrar más estudiantes");
        System.out.println("");
    } else {//Si la carrera aún no empieza admite el registro de participantes
        System.out.println("Registro de participantes en carrera del " + getFecha());//Registra participantes a una carrea de una fecha determinada
        int id;
        do {
            System.out.print("ID del estudiante: ");
            id = Integer.parseInt(sistema.getScanner().nextLine());//Se obtiene el Id del estudiante
            Estudiante e = sistema.buscarEstudiante(id);//Se verifica si el ID ingresado es vàlido
            Candidato repetido = buscarParticipante(id);//Verifica si el ID ya ha sido registrado
            if (e == null || repetido != null) {//Si el ID ya fue registrado o no es vàlido, no registra a ese participante
                System.out.println("Id no existe o estudiante ya registrado");
            } else{
                listaParticipantes.add(new Participante5K(e));//Si el ID es vàlido y no se ha ingresado antes, registra al participante
                System.out.println("Estudiante " + e.getNombre() + " registrado");
            }
        } while (id != 0);
    }
}

//Método que registra los ganadores de una Carrera 
@Override
public void registrarGanadores() {
    if (terminado) {//Si la carrera ya ha finalizado imprime mensaje y no permite modificaciones
        System.out.println("Carrera cerrada, no se pueden modificar los ganadores");
        System.out.println("");
    } else if (listaParticipantes.size() >= 3){//Si la lista de participantes inscritos es mayor y igual a 3 entra al ciclo while
        int i = 0;
        do {
            System.out.println("Ingreso del puesto N°" + (i + 1));//Va registrando los ganadores en su posición respectiva
            System.out.print("ID: ");
            int id = Integer.parseInt(sistema.getScanner().nextLine());//Se ingresa el ID del participante
            Participante5K p = (Participante5K) buscarParticipante(id);//Verifica si el ID ingresado realmente pertenece a un participante
            if (p == null || ganadorRepetido(id)) {//Verifica si el ID no existe o si ese participante ya está en el podio de ganadores
                System.out.println("Id no existe o ganador ya incluido");

            } else {
                ganadores[i] = p;//Se registra el tiempo que realiz+o cada uno de los miembros del podio
                System.out.print("Tiempo: ");
                double tiempo = Double.parseDouble(sistema.getScanner().nextLine());
                p.setTiempo(tiempo);
                i++;
            }
        } while (i < 3);
    } else {//Si hay menos de 3 participantes no se realiza la premiación por falta de participantes
        System.out.println("No hay suficientes participantes registrados");
        System.out.println("");
    }
    terminado = true;//Se registra la carrera actual como finalizada para que no se pueda modificar los ganadores posteriormente
}


//Métodos que indican la opción seleccionada
@Override
public void opcionUno() {//Esta opcion no debe implementarse para carreras 5k
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
public Candidato buscarParticipante(int id) {
    for (Candidato c : listaParticipantes) {
        if (c.getId() == id) {
            return c;
        }
    }
    return null;
}

//Método toString que muestra la informaciòn de una carrera determinada
@Override
public String toString() {
    return getId() + " " + getFecha() + " " + getHora() + " " + listaParticipantes.size();
}
//Método verificador que comprueba si un participante ya está en el podio
@Override
public boolean ganadorRepetido(int id) {
    for (int i = 0; i < ganadores.length; i++) {
        if (ganadores[i] != null && ganadores[i].getId() == id) {
            return true;
        }
    }
    return false;
}
}
