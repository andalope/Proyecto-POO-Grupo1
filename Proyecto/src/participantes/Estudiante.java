
package participantes;


public class Estudiante extends Candidato{
    private String genero;
    private String carrera;

    public Estudiante(String genero, String carrera, String id, String nombre) {
        super(id, nombre);
        this.genero = genero;
        this.carrera = carrera;
    }
    
    public Estudiante(Estudiante estudiante){
        super(estudiante.getId(), estudiante.getNombre());
        genero = estudiante.genero;
        carrera = estudiante.carrera;
    }
    
}
