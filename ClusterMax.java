public class ClusterMax extends Cluster{

    public ClusterMax(double[] numData, double[][] ASCIIData){
        super(numData,ASCIIData);
    }
    public ClusterMax(ClusterMax x, ClusterMax y){
        super(x,y);
    }

    public static double Distancia(ClusterMax x, ClusterMax y, TipoD tipo){
       /* double[] minNumX = x.elements[0].getNumeros();
		double[] minNumY = y.elements[0].getNumeros();
		double[][] minASCIIX = x.elements[0].getASCII();
        double[][] minASCIIY = y.elements[0].getASCII();*/
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
}