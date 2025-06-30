import comercio.*;

import java.util.Scanner;

public class TestCombos {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        Pizzeria pizzeria = new Pizzeria("Lo de Marcos");
        Combo combo1 = new Combo(125, "Triple Mac", 15000, 750, 25);
        Combo combo2 = new Combo(100, "Doble queso", 10000, 500, 15);
        ComboEspecial combo3 = new ComboEspecial(110, "Submarino", 20000, 1115, 30, 6000);

        pizzeria.agregarCombo(combo1);
        pizzeria.agregarCombo(combo2);
        pizzeria.agregarCombo(combo3);

        Obsequio obsequio1 = new Obsequio(300, "Oso de peluche", 5000);
        Obsequio obsequio2 = new Obsequio(305, "Espada iluminada", 4500);

        combo3.agregarObsequio(obsequio1);
        combo3.agregarObsequio(obsequio2);

        Cliente cliente1 = new Cliente("Matias", 44466717, 6000);

        Compra compra1 = new Compra(cliente1, pizzeria);
        compra1.agregarCombo(combo1);
        compra1.agregarCombo(combo2);
        compra1.agregarCombo(combo3);

        Compra compra2 = new Compra(cliente1, pizzeria);
        compra2.agregarCombo(combo3);

        Compra compra3 = new Compra(cliente1, pizzeria);
        compra3.agregarCombo(combo1);
        //compra3.agregarCombo(combo1);

        System.out.println("El importe total del los productos es: $" + compra1.importeTotal());
        System.out.println("El descuento total al producto es: $" + compra1.descuentoTotal());
        System.out.println("El importe con descuentos aplicados es: $" + (compra1.importeTotal() - compra1.descuentoTotal()));
        System.out.println("\nDesea efectuar la compra? S/s = Si, N/n = No");
        String respuesta = input.next();
        if (respuesta.equals("s") || respuesta.equals("S")) {
            compra1.finalizarCompra();
        }
        System.out.println("-----------------------------");
        compra2.finalizarCompra();
        System.out.println("-----------------------------");
        compra3.finalizarCompra();

        String nombreCombo = combo1.getNombre();
        System.out.printf("""
                \nLa cantidad de %s vendidos son: %d
                """,nombreCombo,pizzeria.obtenerComboVendidos(nombreCombo));

        input.close();
    }
}
