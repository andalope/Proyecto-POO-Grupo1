
package sistema;

import eventos.Carrera5K;
import eventos.Competencia;
import eventos.CompetenciaBanda;
import eventos.TorneoVideojuego;
import static infoGeneral.RolBanda.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import participantes.Banda;
import participantes.Estudiante;
import participantes.IntegranteBanda;
import participantes.Jurado;


public class Sistema {

    private int ultimoIdCompetencia;
    private int ultimoIdBanda;
    private Competencia tipo;
    private Scanner sc;
    
    private static Sistema sistema;

    private ArrayList<Estudiante> listaEstudiante;
    private ArrayList<Competencia> listaCompetencia;

    private Sistema() {
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
        Competencia c1 = new Carrera5K(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, true);
        c1.addParticipante(buscarEstudiante("202002028"));
        c1.addParticipante(buscarEstudiante("201811411"));
        c1.addParticipante(buscarEstudiante("201902996"));
        c1.addParticipante(buscarEstudiante("200900850"));
        c1.addParticipante(buscarEstudiante("202007290"));
        c1.addParticipante(buscarEstudiante("201812302"));
        
        Competencia c2 = new Carrera5K(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios);
        c2.addParticipante(buscarEstudiante("202002028"));
        c2.addParticipante(buscarEstudiante("201811411"));
        c2.addParticipante(buscarEstudiante("201902996"));
        c2.addParticipante(buscarEstudiante("200900850"));
        c2.addParticipante(buscarEstudiante("202007290"));
        
        Jurado[] lista = new Jurado[3];
        lista[0] = new Jurado("1", "Jose", "Sin Bio");
        lista[1] = new Jurado("2", "Juan", "Sin Bio");
        lista[2] = new Jurado("3", "Jaime", "Sin Bio");
        
        IntegranteBanda[] intBanda1 = new IntegranteBanda[2];
        intBanda1[0] = new IntegranteBanda(buscarEstudiante("202007290"), GUITARRISTA);
        intBanda1[1] = new IntegranteBanda(buscarEstudiante("201811411"), OTRO);
        Banda b1 = new Banda(generarIdBanda(), "Los chicos que lloran", "Olvidala mejor", intBanda1);
        
        IntegranteBanda[] intBanda2 = new IntegranteBanda[2];
        intBanda2[0] = new IntegranteBanda(buscarEstudiante("201902996"), BATERISTA);
        intBanda2[1] = new IntegranteBanda(buscarEstudiante("201811411"), GUITARRISTA);
        Banda b2 = new Banda(generarIdBanda(), "Don Medardo y su orquesta", "Cumbia chonera", intBanda2);
        
        Competencia c3 = new CompetenciaBanda(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, lista, true);
        c3.addParticipante(b1);
        c3.addParticipante(b2);
        
        
        Competencia c4 = new CompetenciaBanda(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, lista);
        c4.addParticipante(b1);
        c4.addParticipante(b2);
        
        Competencia c5 = new TorneoVideojuego(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, "ABC", true);
        c5.addParticipante(buscarEstudiante("202002028"));
        c5.addParticipante(buscarEstudiante("201811411"));
        c5.addParticipante(buscarEstudiante("201902996"));
        c5.addParticipante(buscarEstudiante("200900850"));
        c5.addParticipante(buscarEstudiante("202007290"));
        c5.addParticipante(buscarEstudiante("201812302"));
        
        Competencia c6 = new TorneoVideojuego(generarIdCompetencia(), LocalDate.now(), LocalTime.now(), premios, "To leave");
        c6.addParticipante(buscarEstudiante("202002028"));
        c6.addParticipante(buscarEstudiante("201811411"));
        c6.addParticipante(buscarEstudiante("201902996"));
        c6.addParticipante(buscarEstudiante("200900850"));
        
        listaCompetencia.add(c1);
        listaCompetencia.add(c2);
        listaCompetencia.add(c3);
        listaCompetencia.add(c4);
        listaCompetencia.add(c5);
        listaCompetencia.add(c6);
    }

    public String generarIdCompetencia() {
        return "C-" + ultimoIdCompetencia++;
    }
    
    public String generarIdBanda() {
        return "B-" + ultimoIdBanda++;
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
    
    public Competencia buscarCompetencia(String id){
        for (Competencia c: listaCompetencia) {
            if (c.getId().substring(2).equals(id)) {
                return c;
            }
        }
        return null;
    }
    
    public Estudiante buscarEstudiante(String id){
        for (Estudiante e: listaEstudiante) {
            if(e.getId().equals(id)) {
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
    
    public void competenciasCreadas(Object o){
        for (Competencia c : listaCompetencia) {
            if (c.getClass() == o.getClass()) {
                System.out.println(c);
            }
        }
    }
    
    public void addCompetencia(Competencia c){
        listaCompetencia.add(c);
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
