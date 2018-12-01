public class ClusterMax extends Cluster{
	/** Esta clase contiene el tipo de cluster por distancia m�xima.
	 * En este tipo de cluster la semejanza entre dos clusters
     * esta dada por la distancia entre los individuos m�s alejados.
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

    public ClusterMax(double[] numData, double[][] ASCIIData){
        super(numData,ASCIIData);
    }
    /** Crea un Cluster max
     * @param  double[] numData - matriz con datos numericos, double[][] ASCIIData - matriz con datos ASCII
    */
    public ClusterMax(Cluster x, Cluster y){
        super(x,y);
    }
    /** Crea un Cluster max
     * @param Cluster x, Cluster y
    */

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0;
        double maxDistance=Cluster.Distancia( x.elements[0].getNumeros(), y.elements[0].getNumeros(), x.elements[0].getASCII(), y.elements[0].getASCII(), tipo);
        
        for(int i=0;i<x.size;i++){
            for(int j=0;j<y.size;j++){
                distance=Cluster.Distancia(x.elements[i].getNumeros(), y.elements[j].getNumeros(), x.elements[i].getASCII(), y.elements[j].getASCII(), tipo);
                if(distance>maxDistance){
                    maxDistance=distance;
                }
            }
        }
        return maxDistance;
    }
    /** Regresa la distancia m�xima entre dos clusters, usando el tipo de distancia seleccionado
     * @param  Cluster x- el primer cluster a comparar, Cluster y- el segundo cluster a comparar , TipoD tipo- tipo de ditsnacia que se quiere
     * @return  double maxDistance
    */
}