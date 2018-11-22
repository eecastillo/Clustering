public class ClusterMin extends Cluster{

    public ClusterMin(double[] numData, double[][] ASCIIData){
        super(numData,ASCIIData);
    }
    public ClusterMin(ClusterMin x, ClusterMin y){
        super(x,y);
    }

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0;
        double minDistance=Cluster.Distancia( x.elements[0].getNumeros(), y.elements[0].getNumeros(), x.elements[0].getASCII(), y.elements[0].getASCII(), tipo);
        
        for(int i=0;i<x.size;i++){
            for(int j=0;j<y.size;j++){
                distance=Cluster.Distancia(x.elements[i].getNumeros(), y.elements[j].getNumeros(), x.elements[i].getASCII(), y.elements[j].getASCII(), tipo);
                if(distance<minDistance){
                    minDistance=distance;
                }
            }
        }
        return minDistance;
    }
}