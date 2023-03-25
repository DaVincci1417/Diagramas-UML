import java.io.IOException;

public class Bus {
    private String modelo;
    private String marca;
    private String año;
    private String patente;

    //Constructor
    public Bus(String modelo, String marca, String año, String patente) throws Exception {
        setModelo(modelo);
        setMarca(marca);
        setAño(año);
        setPatente(patente);
    }

    //Getters
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public String getAño() {
        return año;
    }
    public String getPatente() {
        return patente;
    }

    //Setters
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    private void setMarca(String marca) {
        this.marca = marca;
    }
    private void setAño(String año) {
        validarAño(año);
        this.año = año;
    }
    private void setPatente(String patente) throws Exception {
        validarPatente(patente);
        this.patente = patente;
    }

    //Validador año
    private void validarAño(String año){
        try{
            Integer.parseInt(año);
        }catch (Exception e){
         System.out.println("Ingrese un año valido.");
        }
    }

    //Validacion de RUT
    private void validarPatente(String patente) throws Exception{
        String patenteSinEspacio = quitarPuntosYGuion(patente);
        String mensajeError = "Ingrese una patente valida.";

        if (patenteSinEspacio.length() > 6 || patenteSinEspacio.length() < 6){
            throw new Exception(mensajeError);
        }
        try {
            Integer.parseInt(patenteSinEspacio.substring(0,5));
        }catch (Exception e){
            throw new Exception(mensajeError);
        }
    }
    private String quitarPuntosYGuion(String patente){
        String patenteSinPunto;
        patenteSinPunto = patente.replace(".", "");
        String patenteLimpia = patenteSinPunto.replace(" ", "");
        return patenteLimpia;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "Modelo: " + modelo + '\n' +
                "Marca: " + marca + '\n' +
                "Año: " + año + "\n" +
                "Patente: " + patente +
                '}';
    }
}
