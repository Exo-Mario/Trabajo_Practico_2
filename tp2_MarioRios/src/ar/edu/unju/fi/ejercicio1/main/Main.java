package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcion;
        
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 – Crear Producto");
            System.out.println("2 – Mostrar productos");
            System.out.println("3 – Modificar producto");
            System.out.println("4 – Salir");
            System.out.println("Elija una opción:");

            try {
                opcion = sc.nextInt();
                sc.nextLine();  // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        crearProducto();
                        break;
                    case 2:
                        mostrarProductos();
                        break;
                    case 3:
                        modificarProducto();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese una opción válida.");
                sc.nextLine();  // Limpiar el buffer del scanner
                opcion = 0;
            }
            
        } while (opcion != 4);

        sc.close();
		
	}
	
	// CREAR PRODUCTO
	
	private static void crearProducto() {
		
        System.out.println("Ingrese el código del producto:");
        String codigo = sc.nextLine();

        System.out.println("Ingrese la descripción del producto:");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese el precio unitario del producto:");
        double precioUnitario = sc.nextDouble();

        System.out.println("------ Origen de fabricación ------");
        int index = 1;
        for (OrigenFabricacion origen : OrigenFabricacion.values()) {
            System.out.println(index + " - " + origen);
            index++;
        }
        System.out.println("Elija una opción:");
        int origenIndex = sc.nextInt() - 1;
        sc.nextLine();  // Limpiar el buffer del scanner

        System.out.println("------ Categoría ------");
        index = 1;
        for (Categoria categoria : Categoria.values()) {
            System.out.println(index + " - " + categoria);
            index++;
        }
        System.out.println("Elija una opción:");
        int categoriaIndex = sc.nextInt() - 1;
        sc.nextLine();  // Limpiar el buffer del scanner

        Producto producto = new Producto(codigo, descripcion, precioUnitario, 
                                         OrigenFabricacion.values()[origenIndex], 
                                         Categoria.values()[categoriaIndex]);
        productos.add(producto);
        System.out.println("Producto creado con éxito.");
        
    }
	
	// MOSTRAR PRODUCTO
	
	private static void mostrarProductos() {
		
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        
        System.out.println("Listado de productos:");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        
    }
	
	// MODIFICAR PRODUCTO
	
	private static void modificarProducto() {
		
        if (productos.isEmpty()) {
            System.out.println("No hay productos para modificar.");
            return;
        }

        System.out.println("Ingrese el código del producto a modificar:");
        String codigo = sc.nextLine();

        Producto productoAModificar = null;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                productoAModificar = producto;
                break;
            }
        }

        if (productoAModificar == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Seleccione el atributo a modificar:");
        System.out.println("1 - Descripción");
        System.out.println("2 - Precio unitario");
        System.out.println("3 - Origen de fabricación");
        System.out.println("4 - Categoría");
        int atributo = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer del scanner

        switch (atributo) {
            case 1:
                System.out.println("Ingrese la nueva descripción:");
                String nuevaDescripcion = sc.nextLine();
                productoAModificar.setDescripcion(nuevaDescripcion);
                break;
                
            case 2:
                System.out.println("Ingrese el nuevo precio unitario:");
                double nuevoPrecio = sc.nextDouble();
                productoAModificar.setPrecioUnitario(nuevoPrecio);
                break;
                
            case 3:
                System.out.println("------ Origen de fabricación ------");
                int index = 1;
                for (OrigenFabricacion origen : OrigenFabricacion.values()) {
                    System.out.println(index + " - " + origen);
                    index++;
                }
                System.out.println("Elija una opción:");
                int origenIndex = sc.nextInt() - 1;
                sc.nextLine();  // Limpiar el buffer del scanner
                productoAModificar.setOrigenFabricacion(OrigenFabricacion.values()[origenIndex]);
                break;
                
            case 4:
                System.out.println("------ Categoría ------");
                index = 1;
                for (Categoria categoria : Categoria.values()) {
                    System.out.println(index + " - " + categoria);
                    index++;
                }
                System.out.println("Elija una opción:");
                int categoriaIndex = sc.nextInt() - 1;
                sc.nextLine();  // Limpiar el buffer del scanner
                productoAModificar.setCategoria(Categoria.values()[categoriaIndex]);
                break;
                
            default:
                System.out.println("Opción no válida.");
                break;
        }
        
    }

}