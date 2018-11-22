public class ClusterAverage extends Cluster{

    public ClusterAverage(double[] numData, double[][] ASCIIData){
        super(numData,ASCIIData);
    }
    public ClusterAverage(ClusterAverage x, ClusterAverage y){
        super(x,y);
    }

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0;
        
        for(int i=0;i<x.size;i++){
            for(int j=0;j<y.size;j++){
                distance+=Cluster.Distancia(x.elements[i].getNumeros(), y.elements[j].getNumeros(), x.elements[i].getASCII(), y.elements[j].getASCII(), tipo);
            }
        }
        return (distance/(x.size*y.size));
    }
}