
package participantes;

import infoGeneral.RolBanda;


public class IntegranteBanda extends Estudiante{
    private RolBanda rol;
    
    public IntegranteBanda(Estudiante e, RolBanda rol){
        super(e);
        this.rol = rol;
    }

    public IntegranteBanda(RolBanda rol, String genero, String carrera, String id, String nombre) {
        super(genero, carrera, id, nombre);
        this.rol = rol;
    }
    
}
