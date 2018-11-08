import java.util.ArrayList;
import java.util.Arrays;
//import Cluster;
public class Clustering{
   
    public static void main(String[] args){
        //creacion de dos clusters por separado para despues convertirse en uno solo
       /* ArrayList<Cluster> clust = new ArrayList<Cluster>();
        double[] data={4,1,2,5,6,3,2,1,4};
        Cluster Goten = new Cluster(data);
        double[] data2={3,6,5,4,2,1,1,4,5};
        Cluster Trunks = new Cluster(data2);

        

        clust.add(Goten);
        clust.add(Trunks);
        Cluster Gotenks = new Cluster(Goten,Trunks);

        clust.remove(Goten);
        clust.remove(Trunks);

        clust.add(Gotenks);

        System.out.println(Goten);
        System.out.println(Trunks);
        System.out.println("FUUUUUSIIOOOOON");
        System.out.println(Gotenks);
        System.out.println(Arrays.toString(Trunks.getCentroide()));
        System.out.println(Arrays.toString(Goten.getCentroide()));
        System.out.println(Arrays.toString(Gotenks.getCentroide()));*/
        ArrayList<Cluster> clust = new ArrayList<Cluster>();
        double[] data={12,1.98,1,2,4};
        Cluster Goten = new Cluster(data);
        double[] data2={11,1.85,1,5,4};
        Cluster Trunks = new Cluster(data2);

        double[] data3={526,2.10,1,4,2};
        Cluster Goku = new Cluster(data3);

        clust.add(Goten);
        clust.add(Trunks);
        clust.add(Goku);

        double distance1 = Cluster.Distancia(Goten, Trunks, TipoD.EUCLIDIAN);
        double distance2 = Cluster.Distancia(Goten, Goku, TipoD.EUCLIDIAN);
        double distance3 = Cluster.Distancia(Goku, Trunks, TipoD.EUCLIDIAN);

        System.out.printf("Distancia entre goten y trunks es: %f\n",distance1);
        System.out.printf("Distancia entre goten y goku es: %f\n",distance2);
        System.out.printf("Distancia entre goku y trunks es: %f\n",distance3);


    }
}
