public class Main {

	public static void main(String[] args) {
		String Uri = "test.csv";
		/*String[][] matriz= {{"3", "10"},
				    		{"15", "8"},
				    		{"4", "11"},
				    		{"1", "10"},
				    		{"24", "15"},
				    		{"4", "14"},
				    		{"21", "16"},
				    		{"4", "14"},
				    		{"4", "19"},
				    		{"84", "17"},
				    		{"1", "20"},
				    		{"5", "18"},
				    		{"8", "10"},
				    		{"4", "9"},
				    		{"12", "10"},
				    		{"84", "9"} };*/
		/*try {
			ClusteringDivisivo c1 = new ClusteringDivisivo(Uri,17);
		} catch (OutOfRangeNumberFoundException e) { 
			System.out.println(e);
		}*/
		
		try {
			ClusteringAglomerativo c2 = new ClusteringAglomerativo(Uri, TipoD.EUCLIDIAN, TipoC.CLUSTER_CENTROIDE, 15);
		} catch (OutOfRangeNumberFoundException e) { 
			System.out.println(e);
		}
		
		
		
	}

}
