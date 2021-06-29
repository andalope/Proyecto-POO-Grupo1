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
    
}
