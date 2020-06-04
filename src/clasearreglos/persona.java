/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;

/**
 *
 * @author ali
 */
public class persona {

    private int edad;
    private String nombre;
    private int cod;
    private String Apellido;
    private String telefono;
    private String correo;
    private String direccion;

    public persona() {
        edad = 0;

        nombre = null;
        cod = -1;
        Apellido = "";
        telefono = "";
        correo = "";
        direccion = "";
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getCod() {
        return cod;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void mostrar() {
        System.out.println("Nombre -> " + getNombre());
        System.out.println("Edad -> " + getEdad());

    }

}
