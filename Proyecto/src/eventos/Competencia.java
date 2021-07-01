//Clase padre de la que derivan todas las competiciones
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import sistema.Sistema;
import participantes.Candidato;
/**
 *
 * @author danil
 */
//competencia es una clase abstracta
public abstract class Competencia {
//declaracion de datos y arraylists
private int id;
private LocalDate fecha;
private LocalTime hora;
private String[] premios;
protected Candidato[] ganadores;
protected ArrayList<Candidato> listaParticipantes;
protected Sistema sistema;
protected boolean terminado;

public Competencia() {
        
}

//sobrecarga del metodo Competencia (CONSTRUCTOR)
public Competencia(int id, LocalDate fecha, LocalTime hora, String[] premios) {
    this.id = id;
    this.fecha = fecha;
    this.hora = hora;
    this.premios = premios;
    ganadores = new Candidato[3];
    listaParticipantes = new ArrayList<>();
    sistema = Sistema.getInstance();
    }
//sobrecarga del método Competencia que inclute la variable que indica si la competencia ha finalizado
public Competencia(int id, LocalDate fecha, LocalTime hora, String[] premios, boolean terminado) {
    this.id = id;
    this.fecha = fecha;
    this.hora = hora;
    this.premios = premios;
    ganadores = new Candidato[3];
    listaParticipantes = new ArrayList<>();
    this.terminado = terminado;
    sistema = Sistema.getInstance();
    }

//metodos abstractos que variaran en cada sub clase de Competencia
public abstract void registarParticipante();
    
public abstract Candidato buscarParticipante(int id);
    
public abstract boolean ganadorRepetido(int id);

public abstract void registrarGanadores();

public abstract void presentarMenu();
    
public abstract void opcionUno();
    
public abstract void opcionDos();
    
public abstract void opcionTres();

//getters
public int getId() {
        return id;
}

public LocalDate getFecha() {
    return fecha;
}

public LocalTime getHora() {
    return hora;
}

public String[] getPremios() {
    return premios;
}

public Candidato[] getGanadores() {
    return ganadores;
}

public ArrayList<Candidato> getListaParticipantes() {
    return listaParticipantes;
}

public boolean isTerminado() {
    return terminado;
}

public void setTerminado(boolean terminado) {
    this.terminado = terminado;
}    

}
