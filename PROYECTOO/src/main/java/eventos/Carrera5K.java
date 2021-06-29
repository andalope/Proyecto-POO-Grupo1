/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Estudiante;
import participantes.Participante5K;
import sistema.Sistema;
/**
 *
 * @author danil
 */
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

@Override
public void registarParticipante() {
    if (terminado) {
        System.out.println("Carrera cerrada, no se pueden registrar más estudiantes");
        System.out.println("");
    } else {
        System.out.println("Registro de participantes en carrera del " + getFecha());
        int id;
        do {
            System.out.print("ID del estudiante: ");
            id = Integer.parseInt(sistema.getScanner().nextLine());
            Estudiante e = sistema.buscarEstudiante(id);
            Candidato repetido = buscarParticipante(id);
            if (e == null || repetido != null) {
                System.out.println("Id no existe o estudiante ya registrado");
            } else{
                listaParticipantes.add(new Participante5K(e));
                System.out.println("Estudiante " + e.getNombre() + " registrado");
            }
        } while (id != 0);
    }
}

@Override
public void registrarGanadores() {
    if (terminado) {
        System.out.println("Carrera cerrada, no se pueden modificar los ganadores");
        System.out.println("");
    } else if (listaParticipantes.size() >= 3){
        int i = 0;
        do {
            System.out.println("Ingreso del puesto N°" + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(sistema.getScanner().nextLine());
            Participante5K p = (Participante5K) buscarParticipante(id);
            if (p == null || ganadorRepetido(id)) {
                System.out.println("Id no existe o ganador ya incluido");

            } else {
                ganadores[i] = p;
                System.out.print("Tiempo: ");
                double tiempo = Double.parseDouble(sistema.getScanner().nextLine());
                p.setTiempo(tiempo);
                i++;
            }
        } while (i < 3);
    } else {
        System.out.println("No hay suficientes participantes registrados");
        System.out.println("");
    }
    terminado = true;
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
public Candidato buscarParticipante(int id) {
    for (Candidato c : listaParticipantes) {
        if (c.getId() == id) {
            return c;
        }
    }
    return null;
}

@Override
public String toString() {
    return getId() + " " + getFecha() + " " + getHora() + " " + listaParticipantes.size();
}

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
