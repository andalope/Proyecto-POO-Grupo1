
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import sistema.Sistema;
import participantes.Candidato;
import participantes.Estudiante;


public abstract class Competencia {

    private String id;
    private LocalDate fecha;
    private LocalTime hora;
    private String[] premios;
    protected Candidato[] ganadores;
    protected ArrayList<Candidato> listaParticipantes;
    protected Sistema sistema;
    protected boolean terminado;

    public Competencia() {
        sistema = Sistema.getInstance();
    }

    public Competencia(String id, LocalDate fecha, LocalTime hora, String[] premios) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.premios = premios;
        ganadores = new Candidato[3];
        listaParticipantes = new ArrayList<>();
        sistema = Sistema.getInstance();
        terminado = false;
    }

    public Competencia(String id, LocalDate fecha, LocalTime hora, String[] premios, boolean terminado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.premios = premios;
        ganadores = new Candidato[3];
        listaParticipantes = new ArrayList<>();
        this.terminado = terminado;
        sistema = Sistema.getInstance();
    }

    public Candidato buscarParticipante(String id) {
        for (Candidato c : listaParticipantes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean ganadorRepetido(String id) {
        for (Candidato c: ganadores) {
            if (c != null && c.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return getId().substring(2) + " " + getFecha() + " " + getHora() + " " + listaParticipantes.size();
    }

    public abstract void addParticipante(Candidato c);

    public abstract void registarParticipante();

    public abstract void registrarGanadores();

    public abstract void presentarMenu();

    public abstract void opcionUno();

    public abstract void opcionDos();

    public abstract void opcionTres();

    public String getId() {
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
