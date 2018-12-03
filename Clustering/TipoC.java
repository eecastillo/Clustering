package Clustering;

public enum TipoC {
	/** Esta enumeración describe los tipos de clusters
	 * que pueden ser utilizados para calcular las distancias entre dos clusters
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	CLUSTER_CENTROIDE("Clustering metodo centroide"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia entre sus centroides
     */
	CLUSTER_MIN("Clustering metodo minimo"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia mínima entre los individuos más próximos
     */
	CLUSTER_MAX("Clustering metodo maximo"),
    /**  En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia entre los individuos más alejados
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
