package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static ArrayList<Efemeride> efemerides = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion;
		
		do {
			System.out.println("-----------------------");
            System.out.println("1 – Crear efeméride");
            System.out.println("2 – Mostrar efemérides");
            System.out.println("3 – Eliminar efeméride");
            System.out.println("4 – Modificar efeméride");
            System.out.println("5 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            switch (opcion) {
            
                case 1: // CREAR
                    System.out.print("Ingrese el código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Ingrese el número de mes (1-12): ");
                    int numMes = sc.nextInt();
                    sc.nextLine();
                    Mes mes = validarMes(numMes);
                    
                    System.out.print("Ingrese el día: ");
                    int dia = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Ingrese el detalle: ");
                    String detalle = sc.nextLine();

                    Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
                    efemerides.add(efemeride);
                    System.out.println("\nEfeméride creada con éxito.");
                    break;
                    
                    
                case 2: // MOSTRAR
                	
                    if (efemerides.isEmpty()) {
                        System.out.println("\nNo hay efemérides para mostrar.");
                        break;
                    }
                    
                    for (Efemeride efem : efemerides) {
                        System.out.println("\n"+efem.getCodigo() + " - " + efem.getMes() + " - " + efem.getDia() + " - " + efem.getDetalle());
                    }
                    break;
                    
                    
                case 3: // ELIMINAR
                	
                    if (efemerides.isEmpty()) {
                        System.out.println("\nNo hay efemérides para eliminar.");
                        break;
                    }
                    
                    System.out.print("\nIngrese el código de la efeméride a eliminar: ");
                    int codigoEliminar = sc.nextInt();
                    boolean eliminado = efemerides.removeIf(efem -> efem.getCodigo() == codigoEliminar);
                    
                    if (eliminado) {
                        System.out.println("\nEfeméride eliminada con éxito.");
                    } else {
                        System.out.println("\nNo se encontró una efeméride con ese código.");
                    }
                    break;
                    
                    
                case 4: // MODIFICAR
                	
                    if (efemerides.isEmpty()) {
                        System.out.println("\nNo hay efemérides para modificar.");
                        break;
                    }
                    
                    System.out.print("\nIngrese el código de la efeméride a modificar: ");
                    int codigoModificar = sc.nextInt();

                    Efemeride efemerideModificar = null;
                    for (Efemeride efem : efemerides) {
                        if (efem.getCodigo() == codigoModificar) {
                            efemerideModificar = efem;
                            break;
                        }
                    }

                    if (efemerideModificar == null) {
                        System.out.println("\nNo se encontró una efeméride con ese código.");
                        break;
                    }

                    System.out.print("Ingrese el nuevo número de mes (1-12): ");
                    int numMesModificar = sc.nextInt();
                    sc.nextLine();
                    Mes mesModificar = validarMes(numMesModificar);

                    System.out.print("Ingrese el nuevo día: ");
                    int diaModificar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ingrese el nuevo detalle: ");
                    String detalleModificar = sc.nextLine();

                    efemerideModificar.setMes(mesModificar);
                    efemerideModificar.setDia(diaModificar);
                    efemerideModificar.setDetalle(detalleModificar);

                    System.out.println("\nEfeméride modificada con éxito.");
                    break;
                    
                    
                case 5: // SALIR
                	
                    System.out.println("\nSaliendo...");
                    sc.close();
                    break;
                    
                    
                default:
                	
                    System.out.println("\nOpción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5); 
	}
	
	private static Mes validarMes(int numMes) {
        Mes mes;
        switch (numMes) {
            case 1: mes = Mes.ENERO; break;
            case 2: mes = Mes.FEBRERO; break;
            case 3: mes = Mes.MARZO; break;
            case 4: mes = Mes.ABRIL; break;
            case 5: mes = Mes.MAYO; break;
            case 6: mes = Mes.JUNIO; break;
            case 7: mes = Mes.JULIO; break;
            case 8: mes = Mes.AGOSTO; break;
            case 9: mes = Mes.SEPTIEMBRE; break;
            case 10: mes = Mes.OCTUBRE; break;
            case 11: mes = Mes.NOVIEMBRE; break;
            case 12: mes = Mes.DICIEMBRE; break;
            default:
                System.out.println("\nMes no válido, se asignará ENERO por defecto.");
                mes = Mes.ENERO;
                break;
        }
        return mes;
    }

}
