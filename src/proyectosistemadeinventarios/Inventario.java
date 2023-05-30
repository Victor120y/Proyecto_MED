/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosistemadeinventarios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Inventario {

    private List<Producto> productos;
    private List<String> conceptos;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.conceptos = new ArrayList<>();
    }

    public void agregarProducto(String codigo, String nombre, double costo, double precio, int existencia) {
        Producto producto = new Producto(codigo, nombre, costo, precio, existencia);
        this.productos.add(producto);
    }

    public void realizarCompra(String codigo, double precioCompra, int cantidad) {
        for (Producto producto : this.productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setCosto(precioCompra);
                producto.setPrecio(precioCompra * 1.3); // Suponiendo un margen de beneficio del 30%
                producto.setExistencia(producto.getExistencia() + cantidad);
                break;
            }
        }
    }

    public void listarProductos() {
        for (Producto producto : this.productos) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Costo: " + producto.getCosto());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Existencia: " + producto.getExistencia());
            System.out.println();
        }
    }

    public void agregarConcepto(String concepto) {
        this.conceptos.add(concepto);
    }

    public void realizarSalida(String codigo, int cantidad, String concepto) {
        for (Producto producto : this.productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setExistencia(producto.getExistencia() - cantidad);
                break;
            }
        }
    }

    public void listarProducto(String codigo) {
    for (Producto producto : this.productos) {
        if (producto.getCodigo().equals(codigo)) {
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Costo: " + producto.getCosto());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Existencia: " + producto.getExistencia());
            break;
        }
    }
}

    public List<String> getConceptos() {
    return this.conceptos;
}


}
