/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participantes;

import infoGeneral.RolBanda;
/**
 *
 * @author danil
 */
public class IntegranteBanda extends Estudiante{
    private RolBanda rol;
    
public IntegranteBanda(RolBanda rol, String genero, String carrera, int id, String nombre) {
    super(genero, carrera, id, nombre);
    this.rol = rol;
}
    
}