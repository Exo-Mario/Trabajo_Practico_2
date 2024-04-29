package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	private LocalDate fechaPago;
    private double montoPagado;
    
	public PagoEfectivo(LocalDate fechaPago, double montoPagado) {
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public void realizarPago(double monto) {
		this.montoPagado = monto - (monto * 0.10);
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("\n=================================");
		System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
        System.out.println("=================================");
	}
}
