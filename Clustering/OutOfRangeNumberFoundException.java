package Clustering;

public class OutOfRangeNumberFoundException extends Exception {
	/** Esta Exception revisa si el valor de k esta dentro de los rangos del tamaño 
	 * de la información con la que se hará Clustering
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

	private int outRangeValue;
	

	public OutOfRangeNumberFoundException(int outRangeValue) {
		super("OutOfRangeNumberFoundException");
		this.outRangeValue=outRangeValue;
	}

	public String toString() {
		return String.format("%s\nOut of range number(K) found: %d", 
					          super.getMessage(), this.outRangeValue);
	}

}
