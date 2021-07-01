/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participantes;

/**
 *
 * @author danil
 */
public class Banda extends Candidato {
    private String cancion;
    private IntegranteBanda[] integrantes;
    
public Banda(int id, String nombre) {
    super(id, nombre);
}   
}
