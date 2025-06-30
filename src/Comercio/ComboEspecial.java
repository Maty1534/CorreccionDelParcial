package Comercio;

import java.util.ArrayList;
import java.util.List;

public class ComboEspecial extends Combo{
    private List<Obsequio> obsequios;
    private float valorEspecial;

    public ComboEspecial(int codigo, String nombre, float precio, int puntosNecesarios, float descuento, float valorEspecial) {
        super(codigo, nombre, precio, puntosNecesarios, descuento);
        this.valorEspecial = valorEspecial;
        obsequios = new ArrayList<>();
    }

    public void agregarObsequio(Obsequio obsequio) {
        obsequios.add(obsequio);
    }

    @Override
    public boolean esPosibleCanjearCombo(float puntajeAcumulado) {
        if (puntajeAcumulado >= puntosNecesarios) {
            float cantidad = 0;
            for (Obsequio o: obsequios) {
                cantidad += o.getPrecio();
            }
            return cantidad >= valorEspecial;
        } else {
            return false;
        }
    }

    @Override
    public int calcularPuntos() {
        return (int)(precio / 5);
    }
}
