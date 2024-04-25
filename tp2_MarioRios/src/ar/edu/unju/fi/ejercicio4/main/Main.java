package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            try {
                System.out.println("1 – Alta de jugador");
                System.out.println("2 – Mostrar todos los jugadores");
                System.out.println("3 – Modificar la posición de un jugador");
                System.out.println("4 – Eliminar un jugador");
                System.out.println("5 – Salir");
                System.out.print("Ingrese una opción: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
                        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

                        System.out.print("Ingrese la nacionalidad: ");
                        String nacionalidad = scanner.nextLine();

                        System.out.print("Ingrese la estatura (en metros): ");
                        double estatura = Double.parseDouble(scanner.nextLine());

                        System.out.print("Ingrese el peso (en kg): ");
                        double peso = Double.parseDouble(scanner.nextLine());

                        System.out.println("Posiciones:");
                        for (Posicion posicion : Posicion.values()) {
                            System.out.println((posicion.ordinal() + 1) + " - " + posicion);
                        }
                        System.out.print("Seleccione la posición (1-4): ");
                        int opcionPosicion = Integer.parseInt(scanner.nextLine());
                        if (opcionPosicion < 1 || opcionPosicion > 4) {
                            System.out.println("Opción no válida. Debe ser un número entre 1 y 4.");
                            break;
                        }

                        Posicion posicion = Posicion.values()[opcionPosicion - 1];
                        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
                        jugadores.add(jugador);
                        System.out.println("Jugador agregado con éxito.");
                        break;

                    case 2:
                        for (Jugador jugadorMostrar : jugadores) {
                            System.out.println(jugadorMostrar.toString());
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombreModificar = scanner.nextLine();

                        System.out.print("Ingrese el apellido del jugador: ");
                        String apellidoModificar = scanner.nextLine();

                        Jugador jugadorModificar = null;

                        Iterator<Jugador> iterModificar = jugadores.iterator();
                        while (iterModificar.hasNext()) {
                            Jugador jugador1 = iterModificar.next();
                            if (jugador1.getNombre().equalsIgnoreCase(nombreModificar) && jugador1.getApellido().equalsIgnoreCase(apellidoModificar)) {
                                jugadorModificar = jugador1;
                                break;
                            }
                        }

                        if (jugadorModificar != null) {
                            System.out.println("Posiciones:");
                            for (Posicion posicionModificar : Posicion.values()) {
                                System.out.println((posicionModificar.ordinal() + 1) + " - " + posicionModificar);
                            }
                            System.out.print("Seleccione la nueva posición (1-4): ");
                            int opcionPosicionModificar = Integer.parseInt(scanner.nextLine());
                            if (opcionPosicionModificar < 1 || opcionPosicionModificar > 4) {
                                System.out.println("Opción no válida. Debe ser un número entre 1 y 4.");
                                break;
                            }

                            Posicion nuevaPosicion = Posicion.values()[opcionPosicionModificar - 1];
                            jugadorModificar.setPosicion(nuevaPosicion);
                            System.out.println("Posición modificada con éxito.");
                        } else {
                            System.out.println("No se encontró un jugador con ese nombre y apellido.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombreEliminar = scanner.nextLine();

                        System.out.print("Ingrese el apellido del jugador: ");
                        String apellidoEliminar = scanner.nextLine();

                        Iterator<Jugador> iterEliminar = jugadores.iterator();
                        while (iterEliminar.hasNext()) {
                            Jugador jugadorEliminar = iterEliminar.next();
                            if (jugadorEliminar.getNombre().equalsIgnoreCase(nombreEliminar) && jugadorEliminar.getApellido().equalsIgnoreCase(apellidoEliminar)) {
                                iterEliminar.remove();
                                System.out.println("Jugador eliminado con éxito.");
                                break;
                            }
                        }

                        if (!iterEliminar.hasNext()) {
                            System.out.println("No se encontró un jugador con ese nombre y apellido.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Debe ser YYYY-MM-DD.");
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            } finally {
                scanner.nextLine(); // Limpiar el buffer del scanner
            }

        } while (opcion != 5);

        scanner.close();
    }
}