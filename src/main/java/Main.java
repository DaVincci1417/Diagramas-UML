import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws Exception {
        principal();
    }
    public static void principal() throws Exception {
        Empresa empresa = new Empresa();
        Scanner leer = new Scanner(System.in);
        int opc = -1;
        do{
            menu();
            opc = leer.nextInt();
            seleccion(opc, empresa);
        }while (opc !=0);
        System.out.println("Ha Salido.");
        System.exit(0);
    }

    public static void menu(){
        System.out.println(
                "0. Salir." + "\n" +
                        "1. Agregar bus." + "\n" +
                        "2. Eliminar bus." + "\n" +
                        "3. Buscar bus." + "\n" +
                        "4. Mostrar buses en propiedad."
        );
    }

    public static void seleccion(int opc, Empresa empresa) throws Exception {
        Scanner leer = new Scanner(System.in);
        switch (opc) {
            case 0:
                break;
            case 1:
                empresa.añadirBus(new Bus("Modelo generico", "tutuki", generarNumerosAleatorios(1), generarNumerosAleatorios(2)));
                break;
            case 2:
                String patente;
                System.out.println("Escriba la patente del bus que desea eliminar.");
                patente = leer.nextLine();
                empresa.eliminarBus(patente);
                break;
            case 3:
                String patenteBuscada;
                System.out.println("Escriba la patente del bus que desea buscar.");
                patenteBuscada = leer.nextLine();
                empresa.buscarBusesSegunSuPatente(patenteBuscada);
                break;
            case 4:
                if(empresa.getBusesEnPropiedad() == null){
                    System.out.println("No hay buses en propiedad");
                } else{
                    empresa.mostrarBusesEnPropiedad();
                }
                break;
            default:
                System.out.println("Agregue una opción valida");
        }

    }

    public static String generarNumerosAleatorios(int opcion){
        //opcion 1 es para generar un año
        if(opcion == 1){
            Random numero = new Random();
            String numeroAleatorio = "";
            for(int i = 0; i < 4; i++){
                numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(10));
            }
            return numeroAleatorio;
        }
        //opcion 2 es para generar una patente
        if(opcion == 2){
            Random numero = new Random();
            String numeroAleatorio = "";
            for(int i = 0; i < 6; i++){
                numeroAleatorio = numeroAleatorio + Integer.toString(numero.nextInt(10));
            }
            return numeroAleatorio;
        }
        return null;
    }

}
