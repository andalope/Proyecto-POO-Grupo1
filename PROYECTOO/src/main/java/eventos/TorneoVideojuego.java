/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos;

import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Candidato;

/**
 *
 * @author danil
 */
public class TorneoVideojuego extends Competencia{
private String nombreVideojuego;

public TorneoVideojuego() {
}

public TorneoVideojuego(int id, LocalDate fecha, LocalTime hora, String[] premios, String nombreVideojuego) {
    super(id, fecha, hora, premios);
    this.nombreVideojuego = nombreVideojuego;
}

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
