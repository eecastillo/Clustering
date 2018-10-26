import java.util.LinkedList;
import java.util.Queue;
//segunda prueba de concepto
public class Clustering2{
    public static void main(String[] args){
        //crear los clusters
        double distancias [] = {.22,.33,.15,.16,.84,.45,.62,.51};
       
        Queue<Queue> world = new LinkedList<>();
        for(int i=0;i<distancias.length;i++){
            Queue<Double> clus = new LinkedList<>();
            clus.add(distancias[i]);
            world.add(clus);
        }

       Queue<Queue> distances = new LinkedList<>();
        for(int i=0;i<distancias.length-1;i++){
            Queue<Double> clus = new LinkedList<>();
            for(int j=i+1;j<distancias.length;j++){
                    clus.add(Math.abs(distancias[i]-distancias[j]));
            }
            distances.add(clus);
        }

        int x=1;
        int y=1;
        Queue fdim=distances.peek();
        double distMinClust=(Double)fdim.peek();
        double temp;

        System.out.println(distances);
    int filas =distances.size();
       for(int i=0;i<filas;i++){
            for(int j=0;j<filas-i;j++){
                temp=(Double)distances.peek().poll();
                if(temp<distMinClust){
                        distMinClust=temp;
                        x=i+1;
                        y=j+i+2;
                    }
                System.out.println(temp);
            }
            distances.remove();
           
        }
        
        
        System.out.println(world);
        System.out.println(distances);

        System.out.printf("x:%d,y:%d,distance:%f",x,y,distMinClust);
        //insertar datos*/
    }
}
