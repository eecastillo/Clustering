package Clustering;

public class ClusterAverage extends Cluster{
	/** Esta clase contiene el tipo de cluster por distancia promedio.
	 * En este tipo de cluster la semejanza entre dos clusters
     *  esta dada por el promedio de distancias entre sus individuos.
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */

    public ClusterAverage(double[] numData, double[][] ASCIIData){
        super(numData,ASCIIData);
    }
    /** Crea un ClusterAverage
     * @param  double[] numData - matriz con datos numericos, double[][] ASCIIData - matriz con datos ASCII
    */
    public ClusterAverage(Cluster x, Cluster y){
        super(x,y);
    }
    /** Crea un Cluster Average
     * @param Cluster  x, Cluster  y
    */

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0;
        
        for(int i=0;i<x.size;i++){
            for(int j=0;j<y.size;j++){
                distance+=Cluster.Distancia(x.elements[i].getNumeros(), y.elements[j].getNumeros(), x.elements[i].getASCII(), y.elements[j].getASCII(), tipo);
            }
        }
        return (distance/(x.size*y.size));
    }
    /** Regresa la distancia promedio entre dos clusters, usando el tipo de distancia seleccionado
     * @param  Cluster x- el primer cluster a comparar, Cluster y- el segundo cluster a comparar , TipoD tipo- tipo de ditsnacia que se quiere
     * @return  double averageDistance
    */
}