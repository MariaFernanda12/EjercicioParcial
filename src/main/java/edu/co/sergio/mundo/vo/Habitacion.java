
package edu.co.sergio.mundo.vo;

public class Habitacion {

    private int id;
    private int precio;
    private int personas;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id=" + id + ", precio=" + precio + ", personas=" + personas + ", estado=" + estado + '}';
    }
}
