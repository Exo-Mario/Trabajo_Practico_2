package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(12000, 673307, 53219),  // (Cantidad, Población, Superficie) en habitantes y km²
    SALTA(18000, 1214441, 155488),
    TUCUMAN(14000, 1691091, 22224),
    CATAMARCA(9000, 367828, 102602),
    LA_RIOJA(5000, 331847, 89680),
    SANTIAGO_DEL_ESTERO(24000, 874006, 136351);

    private int cantidad;
    private int poblacion;
    private int superficie;
    
	private Provincia(int cantidad, int poblacion, int superficie) {
		this.cantidad = cantidad;
		this.poblacion = poblacion;
		this.superficie = superficie;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
    
	public double calcularDensidadPoblacional() {
        return (double) poblacion / superficie;
    }
    
}
