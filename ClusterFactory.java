
public class ClusterFactory {
	/** Esta clase crea instancias de el tipo de cluster que le pidas
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
	private TipoC tipoC;
	private double matrixNumNormalized[];
	private double matrixASCII[][];
	

	public ClusterFactory(TipoC tipoC,double[] matrixNumNormalized,double[][] matrixASCII) {
		setTipoC(tipoC);
		this.matrixNumNormalized=matrixNumNormalized;
		this.matrixASCII = matrixASCII;
	}
	
	public ClusterFactory(double[] matrixNumNormalized,double[][] matrixASCII) {
		this.matrixNumNormalized=matrixNumNormalized;
		this.matrixASCII = matrixASCII;
	}
	
	public void setTipoC(TipoC tipo){
		this.tipoC = tipo;
	}
	
	public Cluster getCluster() {
		switch(this.tipoC) {
		case CLUSTER_CENTROIDE:
			return new ClusterCentroide(this.matrixNumNormalized,this.matrixASCII);

		case CLUSTER_MIN:
			return new ClusterMin(this.matrixNumNormalized,this.matrixASCII);
			
		case CLUSTER_MAX:
			return new ClusterMax(this.matrixNumNormalized,this.matrixASCII);
			
		case CLUSTER_AVERAGE:
			return new ClusterAverage(this.matrixNumNormalized,this.matrixASCII);
		
		}
		
		return new Cluster();
		
	}

}
