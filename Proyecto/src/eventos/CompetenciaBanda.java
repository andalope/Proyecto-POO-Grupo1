//Clase para la competencia de bandas, Hija de la clase Competencia
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;
import participantes.Jurado;

//Indica la relaciòn de herencia respecto a la clase "Competencia"
public class CompetenciaBanda extends Competencia{
    private Jurado[] jurados;
    public CompetenciaBanda() {
    }
//Método constructor de competencias de bandas
    public CompetenciaBanda(int id, LocalDate fecha, LocalTime hora, String[] premios, Jurado[] jurados) {
        super(id, fecha, hora, premios);
        this.jurados = jurados;
    }
//Sobre escritura de los métodos de la clase Competencia
    @Override
    public void registarParticipante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarGanadores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void presentarMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void opcionUno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void opcionDos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void opcionTres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidato buscarParticipante(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ganadorRepetido(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
