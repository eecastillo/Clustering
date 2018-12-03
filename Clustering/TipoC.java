package Clustering;

public enum TipoC {
	/** Esta enumeraci�n describe los tipos de clusters
	 * que pueden ser utilizados para calcular las distancias entre dos clusters
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	CLUSTER_CENTROIDE("Clustering metodo centroide"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia entre sus centroides
     */
	CLUSTER_MIN("Clustering metodo minimo"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia m�nima entre los individuos m�s pr�ximos
     */
	CLUSTER_MAX("Clustering metodo maximo"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia entre los individuos m�s alejados
     */
	CLUSTER_AVERAGE("Clustering metodo promedio");
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por el promedio de distancias entre sus individuos
     */
	private final String nombreClustering;
	private TipoC(String tipo) {	this.nombreClustering=tipo;	}
	public String toString() { return this.nombreClustering; }
    /** Imprime el tipo de cluster
     */
}
