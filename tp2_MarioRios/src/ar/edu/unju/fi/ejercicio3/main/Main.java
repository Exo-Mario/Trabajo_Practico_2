package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Provincia[] provincias = Provincia.values();

        System.out.println("Información de las Provincias:");
        System.out.println("-----------------------------");

        for (Provincia provincia : provincias) {
        	System.out.println("===========================================");
            System.out.println("Provincia: " + provincia);
            System.out.println("Cantidad: " + provincia.getCantidad());
            System.out.println("Población: " + provincia.getPoblacion() + " habitantes");
            System.out.println("Superficie: " + provincia.getSuperficie() + " km²");
            System.out.printf("Densidad poblacional: %.2f habitantes/km²%n", provincia.calcularDensidadPoblacional());
            System.out.println("=========================================== \n");
        }
	}

}
