
public class Main {

	public static void main(String[] args) {
		String Uri = "test.csv";
		//ClusteringDivisivo c1 = new ClusteringDivisivo(Uri);
		ClusteringAglomerativo c2 = new ClusteringAglomerativo(Uri, TipoD.EUCLIDIAN);
		//c1.aglomerativo( TipoC.CLUSTER_CENTRIODE,TipoD.EUCLIDIAN);
		//c1.divisivo();
	}

}
