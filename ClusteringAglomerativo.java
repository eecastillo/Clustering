import java.util.ArrayList;

public class ClusteringAglomerativo extends Clustering {
	/** Esta clase reliza el tipo de clustering aglomerativo.
	 * En este tipo de clustering todos los elementos empiezan sientdo su propio cluster
	 * (entonces habrá un cluster por cada elemento)
	 * se irán uniendo de acuerdo a sus similitudes.
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

	public ClusteringAglomerativo(String Uri, TipoD tipoD, TipoC tipoC, int k)  throws OutOfRangeNumberFoundException {
		super(Uri);
		if(k < 1) throw new OutOfRangeNumberFoundException(k);
		Aglomerativo(tipoD, tipoC, k);
	}
	/** Crea un  clustering aglomerativo
	 *@param matriz- String[][] matriz de datos para Clustering
	 *@param tipoD- TipoD tipo de disctancia que se quiere utilizar
	 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
	 *@param K- int a cuentos clusters se quieren llegar
	 */
	
	public ClusteringAglomerativo(String[][] matriz, TipoD tipoD, TipoC tipoC, int k)  throws OutOfRangeNumberFoundException{
		super(matriz);
		if(k < 1) throw new OutOfRangeNumberFoundException(k);
		Aglomerativo(tipoD, tipoC, k);
	}
	/** Crea un  clustering aglomerativo
	 *@param Uri- la dirección del archivo de donde se sacará la información para relizar clustering
	 *@param tipoD- TipoD tipo de disctancia que se quiere utilizar
	 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
	 **@param K- int a cuentos clusters se quieren llegar
	 */
	
		
	private void Aglomerativo(TipoD tipoD, TipoC tipoC, int k) throws OutOfRangeNumberFoundException{
		ArrayList<Cluster> clust = new ArrayList<Cluster>();
		for(int n=0;n<data.length;n++){
			clust.add(ClusterFactory.getClusterTypeInstance(matrixNumNormalized[n],matrixASCII[n],tipoC));
		}
		System.out.println(clust.size());
		for(int n=0;n<clust.size();n++){
			System.out.println(clust.get(n));
		}
		
		if(k> clust.size()-1 ) throw new OutOfRangeNumberFoundException(k);

		while(clust.size()>k){
			double distanceMin=Double.MAX_VALUE;
			int x=0;
			int y=0;
			double distance=0;
			for(int i=0;i<clust.size()-1;i++){
				for(int j=i+1;j<clust.size();j++){
					distance = ClusterFactory.getClusterTypeDistance(clust.get(i), clust.get(j), tipoD,tipoC);
					System.out.printf("Distancia entre %d y %d: %f\n",i,j,distance);
					if(distance<distanceMin){
						distanceMin=distance;
						x=i;
						y=j;

					}
				}
			}
			System.out.printf("Distancia minima entre %d y %d: %f\n",x,y,distanceMin);
			clust.add(ClusterFactory.getClusterTypeFusion(clust.remove(y),clust.remove(x),tipoC));
			for(int n=0;n<clust.size();n++){
				System.out.println(clust.get(n));
			}
			ScattererPlot.plot("Grafica",clust);
			try {
			Thread.sleep(3000);}
			catch(InterruptedException e) {
				
			}
			System.out.println(clust.size());
		}
	}
	/**En este método se ejecuta el algoritmo de Clustering aglometarivo
	 *@param tipoD- TipoD tipo de disctancia que se quiere utilizar
	 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
	 **@param K- int a cuentos clusters se quieren llegar
	 */
}
