
package participantes;


public class Jurado extends Candidato{
    private String bio;

    public Jurado(String id, String nombre, String bio) {
        super(id, nombre);
        this.bio = bio;
    }
}
