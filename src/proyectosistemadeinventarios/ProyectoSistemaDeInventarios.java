/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosistemadeinventarios;

import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class ProyectoSistemaDeInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        boolean salir = false;
        String codigo, concepto;
        int cantidad;

        while (!salir) {
            System.out.println("Menú principal");
            System.out.println("1. Agregar productos");
            System.out.println("2. Realizar compra");
            System.out.println("3. Agregar concepto");
            System.out.println("4. Realizar salida");
            System.out.println("5. Listar productos");
            System.out.println("6. Listar un producto");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar productos
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.next();
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el costo del producto: ");
                    double costo = scanner.nextDouble();
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Ingrese la existencia del producto: ");
                    int existencia = scanner.nextInt();
                    inventario.agregarProducto(codigo, nombre, costo, precio, existencia);
                    break;
                case 2:
                    // Realizar compra
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    System.out.print("Ingrese el precio de compra: ");
                    double precioCompra = scanner.nextDouble();
                    System.out.print("Ingrese la cantidad comprada: ");
                    cantidad = scanner.nextInt();
                    inventario.realizarCompra(codigo, precioCompra, cantidad);
                    break;
                case 3:
                    // Agregar concepto
                    System.out.print("Ingrese el concepto a agregar: ");
                    concepto = scanner.next();
                    inventario.agregarConcepto(concepto);
                    break;
                case 4:
                    // Realizar salida
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.next();
                    System.out.print("Ingrese la cantidad a sacar: ");
                    cantidad = scanner.nextInt();
                    System.out.println("Seleccione el concepto de la salida:");
                    for (int i = 0; i < inventario.getConceptos().size(); i++) {
                        System.out.println((i + 1) + ". " + inventario.getConceptos().get(i));
                    }
                    int opcionConcepto = scanner.nextInt();
                    concepto = inventario.getConceptos().get(opcionConcepto - 1);
                    inventario.realizarSalida(codigo, cantidad, concepto);
                    break;
                case 5:
                    // Listar productos
                    inventario.listarProductos();
                    
                    break;
                case 6:
                    // Listar un producto
                    System.out.print("Ingrese el código del producto a listar: ");
                    codigo = scanner.next();
                    inventario.listarProducto(codigo);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }

}
