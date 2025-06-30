package comercio;

public class Combo {
    protected int codigo;
    protected String nombre;
    protected float precio;
    protected int puntosNecesarios;
    protected float descuento;

    public Combo(int codigo, String nombre, float precio, int puntosNecesarios, float descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.puntosNecesarios = puntosNecesarios;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public float getDescuento() {
        return descuento;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    public int calcularPuntos() {
        return (int)(precio / 3);
    }

    public boolean esPosibleCanjearCombo(float puntajeAcumulado) {
        return puntajeAcumulado >= puntosNecesarios;
    }
}
