import java.util.*;



public class ClusteringDivisivo extends Clustering {
	/** Esta clase reliza el tipo de clustering divisivo.
	 * En este tipo de clustering todos los elementos empiezan en un mismo cluster 
	 * y se van dividiendo segun sus diferenciqas.
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

	public ClusteringDivisivo(String Uri, int k) throws OutOfRangeNumberFoundException{
		super(Uri);
		if(k < 1||k > matrixNumNormalized.length) throw new OutOfRangeNumberFoundException(k);
	 Divisivo(k);
	}
	/** Reliza el tipo de clustering divisivo
	 *@param Uri- la dirección del archivo de donde se sacará la información para relizar clustering
	 **@param K- int a cuentos clusters se quieren llegar
	 */
	
	public ClusteringDivisivo(String[][] matriz, int k) throws OutOfRangeNumberFoundException {
		super(matriz);
		if(k < 1||k > matrixNumNormalized.length) throw new OutOfRangeNumberFoundException(k);
		 Divisivo(k);
	}
	/** Reliza el tipo de clustering divisivo
	 *@param matriz- String[][] matriz de datos para Clustering
	 **@param K- int a cuentos clusters se quieren llegar
	 */
	
	private void Divisivo(int k) {
	
	ArrayList<ClusterCentroide> clustD = new ArrayList<ClusterCentroide>();
	
     clustD.add(new ClusterCentroide(matrixNumNormalized,matrixASCII));
     Boolean isSingleton=false;
     ScattererPlot.plot("Grafica",clustD);
		try {
		Thread.sleep(3000);}
		catch(InterruptedException e) {
			
		}
		
     for(int j=1; j<k; j++){
    	 if(!isSingleton) {
         isSingleton=true;
         for(int i=0;i<clustD.size();i++){
             if(clustD.get(i).size>1){
                 isSingleton=false;
                 ClusterCentroide[] arrClust=ClusterCentroide.Divir(clustD.remove(i));
                 clustD.add(arrClust[0]);
                 clustD.add(arrClust[1]);
                 break;
             }
             
         }
         ScattererPlot.plot("Grafica",clustD);
			try {
			Thread.sleep(3000);}
			catch(InterruptedException e) {
				
			}
     	}
     }
     
     for(int n=0;n<clustD.size();n++){
         System.out.println(clustD.get(n));

     }
	}
	/**En este método se ejecuta el algoritmo de Clustering divisivo
	 * *@param K- int a cuentos clusters se quieren llegar
	 */
	

}