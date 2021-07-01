/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import eventos.Carrera5K;
import eventos.Competencia;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import participantes.Estudiante;
/**
 *
 * @author danil
 */
public class Sistema {
private int ultimoIdCandidato;
private int ultimoIdCompetencia;
private Competencia tipo;
private Scanner sc;  
private static Sistema sistema;
private ArrayList<Estudiante> listaEstudiante;
private ArrayList<Competencia> listaCompetencia;

private Sistema() {
    ultimoIdCandidato = 1;
    ultimoIdCompetencia = 1;
    listaEstudiante = new ArrayList<>();
    listaCompetencia = new ArrayList<>();
    sc = new Scanner(System.in);
}

public static Sistema getInstance() {
    if (sistema == null) {
        sistema = new Sistema();
        sistema.inicializar();
    } 
    return sistema;
    }

private void inicializar() {
    Reader rd = new Reader();
    listaEstudiante = rd.cargarEstudiantes();
    String[] premios = new String[3];
    for (int i = 0; i < premios.length; i++) {
        premios[i] = "Se va a otorgar una medalla y $" + 50*(i+1);
    }
    Competencia c = new Carrera5K(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, true);
    listaCompetencia.add(c);
    listaCompetencia.add(new Carrera5K(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, false));
}

public int generarIdCandidato() {
    return ultimoIdCandidato++;
}

public int generarIdCompetencia() {
    return ultimoIdCompetencia++;
}
    
public void cambiarTipo(Competencia c) {
    tipo = c;
}

public void presentarSistema() {
    System.out.println("-------Sistema de control de Competencias-------");
    System.out.println("1. Carrera 5K");
    System.out.println("2. Competencia de Bandas Musicales");
    System.out.println("3. Torneo de videojuegos");
    System.out.println("4. Salir");
    System.out.println("");
    System.out.print("Escoge una opcion: ");
}

public void presentarMenuSeccion() {
    tipo.presentarMenu();
}
    
public void opcionUno() {
    tipo.opcionUno();
}
    
public void opcionDos() {
    tipo.opcionDos();
}
    
public void opcionTres() {
    tipo.opcionTres();
}

public Competencia buscarCompetencia(int id){
    for (Competencia c: listaCompetencia) {
        if (c.getId() == id) {
            return c;
        }
    }
    return null;
}

public Estudiante buscarEstudiante(int id){
    for (Estudiante e: listaEstudiante) {
        if(e.getId() == id) {
            return e;
        }
    }
    return null;
}
    
public void registrarParticipantes(Competencia c) {
    c.registarParticipante();
}
    
public void registrarGanadores(Competencia c){
    c.registrarGanadores();
}
    
public Scanner getScanner(){
    return sc;
}

public ArrayList<Estudiante> getListaEstudiante() {
    return listaEstudiante;
}

public ArrayList<Competencia> getListaCompetencia() {
    return listaCompetencia;
}
    
    
}
