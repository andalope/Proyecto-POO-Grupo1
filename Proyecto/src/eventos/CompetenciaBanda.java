//Clase para la competencia de bandas, Hija de la clase Competencia
package eventos;

import infoGeneral.RolBanda;
import java.time.LocalDate;
import java.time.LocalTime;
import participantes.Banda;
import participantes.Candidato;
import participantes.Estudiante;
import participantes.IntegranteBanda;
import participantes.Jurado;
import sistema.Utilitarios;

//Indica la relaciòn de herencia respecto a la clase "Competencia"
public class CompetenciaBanda extends Competencia {

    private Jurado[] jurados;

    public CompetenciaBanda() {
        super();
    }

    public CompetenciaBanda(String id, LocalDate fecha, LocalTime hora, String[] premios, Jurado[] jurados) {
        super(id, fecha, hora, premios);
        this.jurados = jurados;
    }
    
    public CompetenciaBanda(String id, LocalDate fecha, LocalTime hora, String[] premios, Jurado[] jurados, boolean terminado) {
        super(id, fecha, hora, premios, terminado);
        this.jurados = jurados;
    }

    private Jurado[] registrarJurados() {
        Jurado[] juradoTmp = new Jurado[3];
        System.out.println("Jurados");
        int i = 0;
        do {
            System.out.println("Informacion del jurado #" + (i + 1));
            System.out.print("ID: ");
            String id = sistema.getScanner().nextLine();

            if (juradoRepetido(id, juradoTmp)) {
                System.out.println("Jurado no existe o ya incluido");
            } else {
                System.out.print("Nombre: ");
                String nombre = sistema.getScanner().nextLine();
                System.out.print("Bio: ");
                String bio = sistema.getScanner().nextLine();
                juradoTmp[i] = new Jurado(id, nombre, bio);
                i++;
            }
        } while (i < juradoTmp.length);
        return juradoTmp;
    }

    private boolean juradoRepetido(String id, Jurado[] juradosActuales) {
        for (int i = 0; i < juradosActuales.length; i++) {
            if (juradosActuales[i] != null && juradosActuales[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean integranteRepetido(String id, IntegranteBanda[] lista) {
        for (IntegranteBanda ib : lista) {
            if (ib != null && ib.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private IntegranteBanda[] crearIntegrantes(int num) {
        IntegranteBanda[] lista = new IntegranteBanda[num];
        int contador = 0;
        do {
            System.out.print("ID Integrante " + (contador + 1) + ": ");
            String id = sistema.getScanner().nextLine();
            Estudiante e = sistema.buscarEstudiante(id);

            if (e == null || integranteRepetido(id, lista)) {
                System.out.println("Integrante no existe o ya repetido");
            } else {
                System.out.print("Rol(CANTANTE, GUITARRISTA, BAJISTA, BATERISTA, OTRO): ");
                RolBanda rb = RolBanda.valueOf(sistema.getScanner().nextLine());
                lista[contador] = new IntegranteBanda(e, rb);
                contador++;
            }
        } while (contador < num);
        return lista;
    }

    @Override
    public void registarParticipante() {
        System.out.println("Registro de bandas");
        String continuar = "S";
        do {
            System.out.print("Nombre de la banda: ");
            String nombre = sistema.getScanner().nextLine();

            Candidato c = buscarParticipante(nombre);

            if (c == null) {
                System.out.print("Cancion a interpretar: ");
                String cancion = sistema.getScanner().nextLine();

                System.out.print("¿Cuantos integrantes?: ");
                int num = sistema.getScanner().nextInt();
                sistema.getScanner().nextLine();

                IntegranteBanda[] lista = crearIntegrantes(num);
                Banda b = new Banda(sistema.generarIdBanda(), nombre, cancion, lista);
                addParticipante(b);
                System.out.println("");
                
                System.out.println("¿Desea agregar otra banda? (S/N)");
                continuar = sistema.getScanner().nextLine();
            } else {
                System.out.println("Banda ya registrada");
                System.out.println("");
            }
        } while (!continuar.equals("N"));
    }

    @Override
    public void registrarGanadores() {
        //No aplica
    }

    @Override
    public void presentarMenu() {
        System.out.println("Estas dentro de la seccion Bandas Musicales");
        sistema.competenciasCreadas(this);
        System.out.println("");

        System.out.println("1. Crear nueva competencia");
        System.out.println("2. Registrar bandas");
        System.out.println("3. Registrar ganadores");
        System.out.println("4. Volver al menu principal");
        System.out.println("");
        System.out.print("Escoge una opcion: ");
    }

    @Override
    public void opcionUno() {
        System.out.println("Creación de bandas musicales");
        LocalDate fecha = Utilitarios.obtenerFecha();
        LocalTime hora = Utilitarios.obtenerHora();
        String[] premios = Utilitarios.registrarPremios();
        Jurado[] juradosEventos = registrarJurados();

        sistema.addCompetencia(new CompetenciaBanda(sistema.generarIdCompetencia(), fecha, hora, premios, juradosEventos));

        System.out.println("");

    }

    @Override
    public void opcionDos() {
        System.out.print("Ingrese ID del torneo: ");
    }

    @Override
    public void opcionTres() {
        System.out.println("No debe implementarse. Presion ENTER para volver al menu principal");
        System.out.println("");
    }

    @Override
    public Candidato buscarParticipante(String nombre) {
        for (Candidato c : listaParticipantes) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + listaParticipantes.size();
    }
}
