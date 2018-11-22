import java.util.*;

public class ClusteringDivisivo extends Clustering {

	public ClusteringDivisivo(String Uri) {
		super(Uri);
	
	
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
            // System.out.println(clustD.get(i).size);
             if(clustD.get(i).size>1){
                // System.out.printf("indice:%d, tamaño:%d\n",i,clustD.get(i).size);
                 isSingleton=false;
                 ClusterCentroide[] arrClust=ClusterCentroide.Divir(clustD.remove(i));
                 clustD.add(arrClust[0]);
                 clustD.add(arrClust[1]);
                 break;
             }
           // System.out.printf("tamaño lista:%d\n",clustD.size());
             
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

}