import java.util.ArrayList;

public class ClusteringAglomerativo<T extends Cluster> extends Clustering {

	//final Class<T> t;
	public Class fingirCentroide(TipoC tipoc) {
		return ClusterCentroide;
	}
	public ClusteringAglomerativo(String Uri, TipoD tipoD, TipoC tipoC) {
		super(Uri);
		ArrayList<T> clust = new ArrayList<T>();
		for(int n=0;n<data.length;n++){
			clust.add(new ClusterCentroide(matrixNumNormalized[n],matrixASCII[n]));
		}
		System.out.println(clust.size());

		for(int n=0;n<clust.size();n++){
			System.out.println(clust.get(n));
		}

		while(clust.size()>1){
			double distanceMin=Double.MAX_VALUE;
			int x=0;
			int y=0;
			double distance=0;
			for(int i=0;i<clust.size()-1;i++){
				// System.out.println(i);
				for(int j=i+1;j<clust.size();j++){
					//  System.out.printf("%d %d \n",i,j);

					distance=ClusterCentroide.Distancia(clust.get(i), clust.get(j), tipoD);
					System.out.printf("Distancia entre %d y %d: %f\n",i,j,distance);
					if(distance<distanceMin){
						distanceMin=distance;
						x=i;
						y=j;

					}
				}
			}
			System.out.printf("Distancia minima entre %d y %d: %f\n",x,y,distanceMin);

			clust.add(new ClusterCentroide(clust.remove(y),clust.remove(x)));
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
}
