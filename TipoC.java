
public enum TipoC {
	CLUSTER_CENTROIDE("Clustering metodo centroide"),
	CLUSTER_MIN("Clustering metodo minimo"),
	CLUSTER_MAX("Clustering metodo maximo"),
	CLUSTER_AVERAGE("Clustering metodo promedio");
	private final String nombreClustering;
	private TipoC(String tipo) {	this.nombreClustering=tipo;	}
	public String toString() { return this.nombreClustering; }
}
