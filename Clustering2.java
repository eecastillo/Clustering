import java.util.LinkedList;
import java.util.Queue;

public class Clustering2{
    public static void main(String[] args){
        //crear los clusters
        double distancias []={.71,.65,.14,.12,.16,.14,.78,.16,.45,.80};
      //  Queue<Integer> arrcluster[]=new cluster[elementos.length];
       
        Queue<Double> c1 = new LinkedList<>();
        Queue<Double> c2 = new LinkedList<>();
        Queue<Double> c3 = new LinkedList<>();
        Queue<Double> c4 = new LinkedList<>();
        Queue<Double> c5 = new LinkedList<>();
        Queue<Double> c6 = new LinkedList<>();
        Queue<Double> c7 = new LinkedList<>();
        Queue<Double> c8 = new LinkedList<>();
        Queue<Double> c9 = new LinkedList<>();
        Queue<Double> c10 = new LinkedList<>();
      //  Queue<Double>[] c = {c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};
        Queue<Double>[] res = (Queue<Double>[]) new Queue<Double>[distancias.length];
        c1.add(distancias[0]);
        c2.add(distancias[1]);
        c3.add(distancias[2]);
        c4.add(distancias[3]);
        c5.add(distancias[4]);
        c6.add(distancias[5]);
        c7.add(distancias[6]);
        c8.add(distancias[7]);
        c9.add(distancias[8]);
        c10.add(distancias[9]);

        System.out.println(c1);
        //insertar datos
    }
}
