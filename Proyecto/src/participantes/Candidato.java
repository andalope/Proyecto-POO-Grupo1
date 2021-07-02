
package participantes;


public abstract class Candidato {
    private String id;
    private String nombre;

    public Candidato(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        return id + "/t" + nombre;
    }
    
}

