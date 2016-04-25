/**
 * Created by Tatiana on 24/04/2016.
 */
public class lista {


    private int idImagen;
    private String nombre;
    private String nombrePila;
    private String fecha;

    public lista(int idImagen, String nombre, String nombrePila, String fecha) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.nombrePila = nombrePila;
        this.fecha = fecha;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public String getFecha() {
        return fecha;
    }

}
