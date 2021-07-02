
package participantes;

public class Banda extends Candidato{
    private String cancion;
    private IntegranteBanda[] integrantes;

    public Banda(String id, String nombre, String cancion, IntegranteBanda[] integrantes) {
        super(id, nombre);
        this.cancion = cancion;
        this.integrantes = integrantes;
    }
    
}
