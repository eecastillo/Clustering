
public class ClusterFactory {
	/** Esta clase crea instancias de el tipo de cluster que le pidas
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
	public static Cluster getClusterTypeInstance(double[] numData, double[][] ASCIIData,TipoC type){
        switch(type){
        case CLUSTER_MAX:
            System.out.println("ClusterMax");
            return new ClusterMax(numData,ASCIIData);
        case CLUSTER_CENTROIDE:
            System.out.println("ClusterCentroide");
            return new ClusterCentroide(numData,ASCIIData);
        case CLUSTER_MIN:
            System.out.println("ClusterMin");
            return new ClusterMin(numData,ASCIIData);
        case CLUSTER_AVERAGE:
            System.out.println("ClusterAverage");
            return new ClusterAverage(numData,ASCIIData);
        default:
        	return new ClusterCentroide(numData,ASCIIData);
        }
    }
	/**En este método se devuelve una instancia del tipo de Clustering correspondiente su argumento de entrada
	 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
	 *@param numData- double[],  ASCIIData - double[][]: matrices con la información que tendrán los clusters
	 */
	
    public static double getClusterTypeDistance(Cluster x, Cluster y, TipoD tipo,  TipoC type){
        switch(type){
            case CLUSTER_MAX:
                System.out.println("ClusterMax");
                return ClusterMax.Distancia(x, y, tipo);
            case CLUSTER_CENTROIDE:
                System.out.println("ClusterCentroide");
                return ClusterCentroide.Distancia(x, y, tipo);
            case CLUSTER_MIN:
                System.out.println("ClusterMin");
                return ClusterMin.Distancia(x, y, tipo);
            case CLUSTER_AVERAGE:
                System.out.println("ClusterAverage");
                return ClusterAverage.Distancia(x, y, tipo);
            default:
            	 return ClusterCentroide.Distancia(x, y, tipo);
            }
    }
	/**En este método se devuelve la distancia entre Clusters
	 *  del tipo de Clustering correspondiente su argumento de entrada
	 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
	 *@param tipoD - TipoD tipo de distancia que se desea utilizar
	 *@param Cluster x, Cluster y - Clusters entre los cuales se calculará la distancia
	 */
    
    public static Cluster getClusterTypeFusion(Cluster x, Cluster y, TipoC type){
    	 switch(type){
         case CLUSTER_MAX:
             System.out.println("ClusterMax");
             return new ClusterMax(x,y);
         case CLUSTER_CENTROIDE:
             System.out.println("ClusterCentroide");
             return new ClusterCentroide(x,y);
         case CLUSTER_MIN:
             System.out.println("ClusterMin");
             return new ClusterMin(x,y);
         case CLUSTER_AVERAGE:
             System.out.println("ClusterAverage");
             return new ClusterAverage(x,y);
         default:
        	 return new ClusterCentroide(x,y);
         }
    		/**En este método fusiona dos Clusters
    		 *  del tipo de Clustering correspondiente su argumento de entrada
    		 *@param tipoC- TipoC tipo de Cluster que se quiere utilizar
    		 *@param Cluster x, Cluster y - Clusters que se fusionarán
    		 */
        
    }

}
