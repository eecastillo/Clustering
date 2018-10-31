import java.util.ArrayList;
import java.util.Arrays;
//import Cluster;
public class Clustering{
   
    public static void main(String[] args){
        ArrayList<Cluster> clust = new ArrayList<Cluster>();
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
        System.out.println(Arrays.toString(Gotenks.getCentroide()));


    }
}