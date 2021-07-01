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
//se define la clase candidato como abstracta
public abstract class Candidato {
    private int id;
    private String nombre;
    
public Candidato(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

//getters
public int getId() {
        return id;
    }
    
public String getNombre() {
        return nombre;
    }
    
}
