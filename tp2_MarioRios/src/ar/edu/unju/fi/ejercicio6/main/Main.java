package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FelinoSalvaje felinoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);
		
		// Verificar
        if (Converter.isNotNull(felinoSalvaje)) {
            // expresion Lambda
            Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(
                    x.getNombre(),
                    x.getEdad(),
                    x.getPeso()
            ); 
            FelinoDomestico felinoDomestico = converter.convert(felinoSalvaje);
            converter.mostrarObjeto(felinoDomestico);
        }
	}
}
