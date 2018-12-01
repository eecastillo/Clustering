import java.util.*;

public class ClusteringDivisivo extends Clustering {
	/** Esta clase reliza el tipo de clustering divisivo.
	 * En este tipo de clustering todos los elementos empiezan en un mismo cluster 
	 * y se van dividiendo segun sus diferenciqas.
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

	public ClusteringDivisivo(String Uri) {
		super(Uri);
		 Divisivo();
	}
	/** Reliza el tipo de clustering divisivo
	 *@param Uri- la dirección del archivo de donde se sacará la información para relizar clustering
	 */
	
	public ClusteringDivisivo(String[][] matriz) {
		super(matriz);
		 Divisivo();
	}
	/** Reliza el tipo de clustering divisivo
	 *@param matriz- String[][] matriz de datos para Clustering
	 */
	
	private void Divisivo() {
	
	ArrayList<ClusterCentroide> clustD = new ArrayList<ClusterCentroide>();
	
     clustD.add(new ClusterCentroide(matrixNumNormalized,matrixASCII));
     Boolean isSingleton=true;
     ScattererPlot.plot("Grafica",clustD);
		try {
		Thread.sleep(3000);}
		catch(InterruptedException e) {
			
		}
     do{
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
     }while(!isSingleton);
     for(int n=0;n<clustD.size();n++){
         System.out.println(clustD.get(n));

     }
	}
	/**En este método se ejecuta el algoritmo de Clustering divisivo
	 */
	

}