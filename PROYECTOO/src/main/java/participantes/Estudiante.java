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
//La clase Estudiante es una sub clase de la clase candidato
public class Estudiante extends Candidato{
    private String genero;
    private String carrera;

//metodo estudiante
 public Estudiante(String genero, String carrera, int id, String nombre) {
        super(id, nombre);
        this.genero = genero;
        this.carrera = carrera;
    }
 
 //sobre escritura del metodo estudiante
public Estudiante(Estudiante estudiante){
        super(estudiante.getId(), estudiante.getNombre()); //se usa super para poder usar los atributos y metodos de la clase padre Candidato
        genero = estudiante.genero;
        carrera = estudiante.carrera;
    }
}    