import java.util.ArrayList;

public class Empresa {
    private ArrayList<Bus> busesEnPropiedad = new ArrayList<>();

    public Empresa(){

    }

    //Getters
    public ArrayList<Bus> getBusesEnPropiedad() {
        return busesEnPropiedad;
    }

    //Metodos principales
    public void añadirBus(Bus bus){
        busesEnPropiedad.add(bus);
        System.out.println("Se ha agregado el bus.");
    }
    public void eliminarBus(String patente){
        int posicion = -1;
        for (int i = 0; i < busesEnPropiedad.size(); i++) {
            if (busesEnPropiedad.get(i).getPatente().equals(patente)) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            System.out.println("El bus ha sido eliminado.");
            busesEnPropiedad.remove(posicion);
        } else {
            System.out.println("No se ha encontrado el bus.");
        }
    }
    public void buscarBusesSegunSuPatente(String patente){
        int posicion = -1;
        for (int i = 0; i < busesEnPropiedad.size(); i++) {
            if (busesEnPropiedad.get(i).getPatente().equals(patente)) {
                posicion = i;
            }
        }
        if (posicion != -1) {
            System.out.println("El bus ha sido encontrado: " + "\n" +busesEnPropiedad.get(posicion));
        } else {
            System.out.println("No se ha encontrado el bus.");
        }
    }
    public void mostrarBusesEnPropiedad(){
        for(int i = 0; i < busesEnPropiedad.size(); i++){
            System.out.println(busesEnPropiedad.get(i));
        }
    }
}
