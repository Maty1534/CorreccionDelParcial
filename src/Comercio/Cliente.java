package Comercio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private int numeroIdentificador;
    private int puntosAcumulados;
    private List<Compra> listaCompras;

    public Cliente (String nombre, int numeroIdentificador, int puntosAcumulados) {
        this.nombre = nombre;
        this.numeroIdentificador = numeroIdentificador;
        this.puntosAcumulados = puntosAcumulados;
        listaCompras = new ArrayList<>();
    }

    public float getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void descontarPuntos(int puntos) {
        puntosAcumulados -= puntos;
    }

    public void sumarPuntos(int puntos) {
        puntosAcumulados += puntos;
    }

    public void agregarCompra(Compra compra) {
        listaCompras.add(compra);
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }
}
