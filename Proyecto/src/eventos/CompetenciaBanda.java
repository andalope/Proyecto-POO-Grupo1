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
//Constructor de competencias de bandas
    public CompetenciaBanda(String id, LocalDate fecha, LocalTime hora, String[] premios, Jurado[] jurados) {
        super(id, fecha, hora, premios);
        this.jurados = jurados;
    }
//Método para registrar jurados
    private Jurado[] registrarJurados() {
        Jurado[] juradoTmp = new Jurado[3];
        System.out.println("Jurados");
        int i = 0;
        do {
            System.out.println("Informacion del jurado #" + (i + 1));//El número del jurado es i+1 porque las posiciones del arreglo empiezan dede 0 
            System.out.print("ID: ");
            String id = sistema.getScanner().nextLine();//Se ingresa por teclado el ID del jurado

            if (juradoRepetido(id, juradoTmp)) {//Si el ID ingresado ya está dentro del arreglo de jurados, no permite que se vuelva a registrar
                System.out.println("Jurado no existe o ya incluido");
            } else {
                System.out.print("Nombre: ");//Si el ID aún no ha sido registrado solicita nombre y una pequeña descripción 
                String nombre = sistema.getScanner().nextLine();
                System.out.print("Bio: ");
                String bio = sistema.getScanner().nextLine();
                juradoTmp[i] = new Jurado(id, nombre, bio);//Adjunta un nuevo jurado a la lista de jurados con el ID, nombre y descripción
                i++;
            }
        } while (i < juradoTmp.length);//El proceso mencionado ocurre hasta que se registren 3 jurados
        return juradoTmp;
    }
//Método verificador de jurados repetidos
    private boolean juradoRepetido(String id, Jurado[] juradosActuales) {
        for (int i = 0; i < juradosActuales.length; i++) {
            if (juradosActuales[i] != null && juradosActuales[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
//Método verificador de integrantes de banda repetidos
    private boolean integranteRepetido(String id, IntegranteBanda[] lista) {
        for (IntegranteBanda ib : lista) {
            if (ib != null && ib.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
//Método para agregar integrante a una banda
    private IntegranteBanda[] addIntegrantes(int num) {
        IntegranteBanda[] lista = new IntegranteBanda[num];
        int contador = 0;
        do{
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
//Sobreescritura de método para registrar participante a la competencia
    @Override
    public void registarParticipante() {
        System.out.println("Registro de bandas");
        String continuar = "S";//   Condición para que continúe el funcionamiento del ciclo while
        do {
            System.out.print("Nombre de la banda: ");
            String nombre = sistema.getScanner().nextLine();//Se ingresa el nombre de la banda

            System.out.print("Cancion a interpretar: ");
            String cancion = sistema.getScanner().nextLine();// Se ingresa la canción que interpretarán

            System.out.print("¿Cuantos integrantes?: ");
            int num = sistema.getScanner().nextInt();//Se ingresa el número de integrantes
            sistema.getScanner().nextLine();
            IntegranteBanda[] lista = addIntegrantes(num);
            listaParticipantes.add(new Banda(sistema.generarIdBanda(), nombre, cancion, lista));//Se le genera un ID a la banda registrada y se añade la información a la lista de participantes
            continuar = sistema.getScanner().nextLine();//Se pregunta si se desea continuar registrando bandas o no
        } while(!continuar.equals("N"));//El proceso se repetirá mientras la variable continuar sea distinta de N
    }
//Método para registrar ganadores (no se debe implementar)
    @Override
    public void registrarGanadores() {
        //No aplica
    }
//Método que presenta el menú de opciones de la competencia de bandas
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
//sobreescritura que presenta la opción de creación de bandas
    @Override
    public void opcionUno() {
        System.out.println("Creación de bandas musicales");
        LocalDate fecha = Utilitarios.obtenerFecha();
        LocalTime hora = Utilitarios.obtenerHora();
        String[] premios = Utilitarios.registrarPremios();
        Jurado[] juradosEventos = registrarJurados();
//Se crea la competencia de bandas con la fecha y hora en la que se realizará, sus jurados y los premios que habrán
        sistema.addCompetencia(new CompetenciaBanda(sistema.generarIdCompetencia(), fecha, hora, premios, juradosEventos));

        System.out.println("");

    }
//Opción 2 que nos lleva al método que registra bandas
    @Override
    public void opcionDos() {
        System.out.println("");

        System.out.print("Ingrese ID: ");
    }
//Opción 3 que nos permite registrar ganadores (no se debe desarrollar)
    @Override
    public void opcionTres() {
        System.out.println("No aplica");
        System.out.println("");
    }
//Sobreescritura del método añadir participante
    @Override
    public void addParticipante(Candidato c) {
        
    }
//Sobreescritura del método para buscar paticipante
    @Override
    public Candidato buscarParticipante(String nombre) {
        for (Candidato c : listaParticipantes) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

}