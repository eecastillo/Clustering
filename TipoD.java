public enum TipoD{
	/** Esta enumeraci�n describe los tipod de distancia
	 * Que pueden ser utilizados para los algoritmos de clustering
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
    EUCLIDIAN("Centroide"),
    MANHATTAN("Centroide"),
    PEARSON_CORRELATION("Centroide"),
    EISEN_COSINE_CORRELATION("Centroide"),
    SPEARMAN_CORRELATION("Centroide");
	private final String nombreDistancia;
	private TipoD(String tipo) {	this.nombreDistancia=tipo;	}
	public String toString() { return this.nombreDistancia; }
}