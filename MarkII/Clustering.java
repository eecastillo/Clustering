import java.util.ArrayList;
import java.util.Arrays;
//import Cluster;
public class Clustering{

    public static String[] Hamming(String[] arr){
        String [] h=new String[5];
        return h;
    }
    
    public static double[][] sentido(String [][] matriz){
        int[] arrIsInteger = new int[matriz[0].length];//1: entero, 2:string
       // double[] minIntvalue= new double[matriz[0].length]; 
        double[] ASCIIValue;
        double [][] matrix=new double[matriz.length][matriz[0].length];
        for(int j=0;j<matriz[0].length;j++){
           // double min =Double.MAX_VALUE;
            for(int i=0;i<matriz.length;i++){
                switch(arrIsInteger[j]){
                    case 0:
                        try{
                            matrix[i][j]=Double.valueOf(matriz[i][j]);
                            arrIsInteger[j]=1;
                
                        }catch(NumberFormatException e){
                            String word=matriz[i][j].toLowerCase();
                            for(int p=0;p<word.length();p++){
                                matrix[i][j]+= (double)word.charAt(p);;
                            }
                            arrIsInteger[j]=2;
                        }
                    break;
                    case 1:
                        matrix[i][j]=Double.valueOf(matriz[i][j]);
                    break;
                    case 2:
                        String word=matriz[i][j].toLowerCase();
                        for(int p=0;p<word.length();p++){
                            matrix[i][j]+= (double)word.charAt(p);;
                        }
                       
                    break;
                }
               /* if(arrIsInteger[j]==1 && matrix[i][j]<min){
                    min=matrix[i][j];
                    System.out.println(min);
                }*/
               
            }
            /*if(arrIsInteger[j]==1){
                minIntvalue[j]=min;
                for(int n=0;n<matriz.length;n++){
                    matrix[n][j]-=minIntvalue[j];
                }
            }*/
        }
        //for(int k=0;k<matrix.length;k++)
        //    System.out.println(Arrays.toString(matrix[k]));
        
        return matrix;
    }
   
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
       /* ArrayList<Cluster> clust = new ArrayList<Cluster>();
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
*/ 
        String [][] alumnos ={{"15","perros"},
                              {"15","Perra"},
                              {"16","PERRas"},
                              {"14","PerrO"},
                              {"13","PeRrO"}};
                              System.out.println(alumnos.length);
                              System.out.println(alumnos[0].length);
        double [][] tabla = sentido(alumnos);
        for(int k=0;k<tabla.length;k++)
            System.out.println(Arrays.toString(tabla[k]));
        Cluster c0 = new Cluster(tabla[0]);
        Cluster c1 = new Cluster(tabla[1]);
        Cluster c2 = new Cluster(tabla[2]);
        Cluster c3 = new Cluster(tabla[3]);
        Cluster c4 = new Cluster(tabla[4]);

       

    }
}
