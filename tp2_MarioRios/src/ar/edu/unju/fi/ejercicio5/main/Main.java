package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productos = preCargarProductos();
        
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);
            
            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    ArrayList<Producto> productosSeleccionados = seleccionarProductos(scanner, productos);
                    if (!productosSeleccionados.isEmpty()) {
                        realizarPago(scanner, productosSeleccionados);
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
        
        scanner.close();
	}
	
	private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1 - Mostrar productos");
        System.out.println("2 - Realizar compra");
        System.out.println("3 - Salir");
        System.out.print("Seleccione una opción: ");
    }
	
	private static int obtenerOpcion(Scanner scanner) {
        int opcion = 0;
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar el buffer
        }
        return opcion;
    }
	
	private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("\n--- Productos Disponibles ---");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
	
	private static ArrayList<Producto> seleccionarProductos(Scanner scanner, ArrayList<Producto> productos) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        boolean seguirSeleccionando = true;
        
        while (seguirSeleccionando) {
            System.out.print("\nIngrese el número del producto que desea comprar (0 para finalizar): ");
            int opcion = obtenerOpcion(scanner);
            
            if (opcion == 0) {
                seguirSeleccionando = false;
            } else if (opcion > 0 && opcion <= productos.size()) {
                Producto producto = productos.get(opcion - 1);
                if (producto.isEstado()) {
                    productosSeleccionados.add(producto);
                    producto.setEstado(false); // Marcar el producto como no disponible
                    System.out.println("Producto añadido al carrito.");
                } else {
                    System.out.println("El producto seleccionado no está disponible.");
                }
            } else {
                System.out.println("Número de producto inválido.");
            }
        }
        
        return productosSeleccionados;
    }
	
	private static void realizarPago(Scanner scanner, ArrayList<Producto> productosSeleccionados) {
        double total = 0;
        for (Producto producto : productosSeleccionados) {
            total += producto.getPrecioUnitario();
        }
        
        System.out.println("\nTotal a pagar: $" + total);
        System.out.println("Seleccione el método de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");
        System.out.print("Opción: ");
        
        int opcionPago = obtenerOpcion(scanner);
        switch (opcionPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now(), total);
                pagoEfectivo.realizarPago(total);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                System.out.print("\nIngrese el número de tarjeta: ");
                String numeroTarjeta = scanner.next();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), total);
                pagoTarjeta.realizarPago(total);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

	private static ArrayList<Producto> preCargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        // Pre-cargar 15 productos con datos (puede que no tengan sentido, pero son para rellenar)
        
        Producto producto1 = new Producto("001", "Gaseosa Torasso", 1200.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, false);
        Producto producto2 = new Producto("002", "Galletas Oreo", 800.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true);
        Producto producto3 = new Producto("003", "Pelota de futbol", 1800.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.TELEFONIA, false);
        Producto producto4 = new Producto("004", "Bateria AAA", 500.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true);
        Producto producto5 = new Producto("005", "Cafetera", 6000.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.INFORMATICA, false);
        
        Producto producto6 = new Producto("006", "Mochila Azul", 3500.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true);
        Producto producto7 = new Producto("007", "Algodon", 700.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, false);
        Producto producto8 = new Producto("008", "Stickers", 1200.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false);
        Producto producto9 = new Producto("009", "Lavadora", 8500.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR, true);
        Producto producto10 = new Producto("010", "Camioneta Toyota", 40000.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, true);
        
        Producto producto11 = new Producto("011", "Muñeco Buzz", 2500.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, false);
        Producto producto12 = new Producto("012", "Resortera", 2700.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true);
        Producto producto13 = new Producto("013", "Camisa Brasil", 2300.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.ELECTROHOGAR, true);
        Producto producto14 = new Producto("014", "Guantes", 4200.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA, false);
        Producto producto15 = new Producto("015", "Chaqueta", 5600.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, true);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        productos.add(producto11);
        productos.add(producto12);
        productos.add(producto13);
        productos.add(producto14);
        productos.add(producto15);
        
        return productos;
    }

}
