package Clustering;

public class OutOfRangeNumberFoundException extends Exception {
	/** Esta Exception revisa si el valor de k esta dentro de los rangos del tama�o 
	 * de la informaci�n con la que se har� Clustering
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
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
