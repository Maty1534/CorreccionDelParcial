package comercio;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private List<Combo> listaCombos;
    private List<Compra> listaCompras;
    private String nombre;

    public Pizzeria(String nombre) {
        listaCombos = new ArrayList<>();
        listaCompras = new ArrayList<>();
        this.nombre = nombre;
    }

    public void agregarCompra(Compra compra) {
        listaCompras.add(compra);
    }

    public void agregarCombo(Combo combo) {
        listaCombos.add(combo);
    }

    public List<Combo> getListaCombos() {
        return listaCombos;
    }

    public int obtenerComboVendidos(String nombre) {
        int cantidad = 0;
        for (Compra c: listaCompras) {
            for (int i = 0; i < c.getCombos().size(); i++) {
                if (c.getCombos().get(i).getNombre().equals(nombre)) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    @Override
    public String toString() {
        return nombre + ": " +
                "\nLos combos son: " + listaCombos +
                "\nLas compras en la pizzeria son: " + listaCompras;
    }
}
