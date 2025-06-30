package Comercio;

public class Obsequio {
    private int codigo;
    private String nombre;
    private float precio;

    public Obsequio(int codigo, String nombre, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }
}
