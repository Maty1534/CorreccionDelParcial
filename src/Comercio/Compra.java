package Comercio;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Combo> combos;
    private List<Float> listaImportes;
    private List<Float> listaDescuentos;
    private List<Integer> listaPuntosNecesarios;
    private Cliente cliente;
    private float resultado;
    private Pizzeria pizzeria;

    public Compra(Cliente cliente, Pizzeria pizzeria) {
        this.cliente = cliente;
        combos = new ArrayList<>();
        listaImportes = new ArrayList<>();
        listaDescuentos = new ArrayList<>();
        listaPuntosNecesarios = new ArrayList<>();
        resultado = 0;
        this.pizzeria = pizzeria;
    }

    public void agregarCombo(Combo combo) {
        combos.add(combo);
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void instanciarListas() {
        if (listaImportes.isEmpty()) {
            for (Combo c: combos) {
                if (c.esPosibleCanjearCombo(cliente.getPuntosAcumulados())) {
                    listaDescuentos.add(c.getDescuento());
                    listaPuntosNecesarios.add(c.getPuntosNecesarios());
                } else {
                    listaDescuentos.add(100F);
                    listaPuntosNecesarios.add(0);
                }
                listaImportes.add(c.getPrecio());
            }
        }
    }

    public float importeTotal() {
        instanciarListas();
        float totalImporte = 0;
        for (float importe: listaImportes) {
            totalImporte += importe;
        }
        return totalImporte;
    }

    public float descuentoTotal() {
        instanciarListas();
        float totalDescuento = 0;
        for (int i = 0; i < listaDescuentos.size(); i++) {
            totalDescuento = listaImportes.get(i) * listaDescuentos.get(i) / 100;
        }
        return totalDescuento;
    }

    public void finalizarCompra() {
        instanciarListas();
        int puntosGanados = 0;
        for (int i = 0; i < listaImportes.size(); i++) {
            System.out.println("Puntos actuales del cliente " + cliente.getPuntosAcumulados());
            float importe = listaImportes.get(i);
            float descuento = listaDescuentos.get(i);
            int puntosNecesarios = listaPuntosNecesarios.get(i);
            float operacion;
            if (puntosNecesarios <= cliente.getPuntosAcumulados() && puntosNecesarios != 0) {
                operacion = importe * descuento / 100;
                cliente.descontarPuntos(puntosNecesarios);
                System.out.println("Descuento aplicado para " + combos.get(i).getNombre());
            } else {
                operacion = importe;
                System.out.println("El descuento no se ha aplicado, faltan puntos para " + combos.get(i).getNombre());
            }
            puntosGanados += combos.get(i).calcularPuntos();
            System.out.println("Puntos ganados por el combo " + combos.get(i).getNombre() + " son: " + combos.get(i).calcularPuntos());
            resultado += operacion;
        }
        System.out.println("Total de puntos ganados son: " + puntosGanados);
        cliente.sumarPuntos(puntosGanados);
        cliente.agregarCompra(this);
        pizzeria.agregarCompra(this);
    }

    public float resultadoDeLaOperacion() {
        return resultado;
    }
}
