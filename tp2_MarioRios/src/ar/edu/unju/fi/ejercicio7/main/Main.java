package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Producto> productos = preCargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarProductosDisponibles(productos);
                    break;
                case 2:
                    mostrarProductosFaltantes(productos);
                    break;
                case 3:
                    incrementarPrecios(productos);
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente(productos);
                    break;
                case 6:
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
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
	
	private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1 - Mostrar productos disponibles");
        System.out.println("2 - Mostrar productos faltantes");
        System.out.println("3 - Incrementar precios de productos en un 20%");
        System.out.println("4 - Mostrar productos de categoría Electrohogar disponibles");
        System.out.println("5 - Ordenar productos por precio de forma descendente");
        System.out.println("6 - Mostrar nombres de productos en mayúsculas");
        System.out.println("7 - Salir");
        System.out.print("\nIngrese una opción: ");
    }
	
	private static void mostrarProductosDisponibles(List<Producto> productos) {
        System.out.println("\nProductos disponibles:");
        Consumer<Producto> consumer = p -> {
            if (p.isEstado()) {
                System.out.println(p);
            }
        };
        productos.forEach(consumer);
    }
	
	private static void mostrarProductosFaltantes(List<Producto> productos) {
        System.out.println("\nProductos faltantes:");
        Predicate<Producto> predicate = p -> !p.isEstado();
        productos.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
	
	private static void incrementarPrecios(List<Producto> productos) {
        System.out.println("\nIncrementando precios en un 20%...");
        Function<Producto, Producto> mapper = p -> new Producto(
                p.getCodigo(),
                p.getDescripcion(),
                p.getPrecioUnitario() * 1.2,
                p.getOrigenFabricacion(),
                p.getCategoria(),
                p.isEstado()
        );
        List<Producto> productosIncrementados = productos.stream()
                .map(mapper)
                .collect(Collectors.toList());
        productosIncrementados.forEach(System.out::println);
    }
	
	private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
        System.out.println("\nProductos de categoría Electrohogar disponibles:");
        Predicate<Producto> predicate = p -> p.getCategoria() == Producto.Categoria.ELECTROHOGAR && p.isEstado();
        productos.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
	
	private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
        System.out.println("\nProductos ordenados por precio de forma descendente:");
        Comparator<Producto> comparator = Comparator.comparing(Producto::getPrecioUnitario).reversed();
        productos.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }
	
	private static void mostrarNombresEnMayusculas(List<Producto> productos) {
        System.out.println("\nNombres de productos en mayúsculas:");
        Function<Producto, String> mapper = p -> p.getDescripcion().toUpperCase();
        productos.stream()
                .map(mapper)
                .forEach(System.out::println);
    }

}
