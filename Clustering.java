//import com.opencsv.CSVReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
//import Cluster;
public class Clustering{
   
    private static double[][] NormalizarNum(double [][] matriz){
        double[] magnitudes= CalcMagnitudesNum(matriz);
        double[][] normalizado = new double[matriz.length][matriz[0].length];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                normalizado[i][j]=matriz[i][j]/magnitudes[j];
            }
        }
        return normalizado;
    }
    //calcula la magnitud del conjunto de categorias
    private static double[] CalcMagnitudesNum(double[][] matriz){
        double magnitudNum=0;
        double[] magnitudes= new double[matriz[0].length];
        for(int j=0;j<matriz[0].length;j++){
            magnitudNum=0;
            for(int i=0;i<matriz.length;i++){
                magnitudNum += matriz[i][j]*matriz[i][j];
            }
            magnitudNum=Math.sqrt(magnitudNum);
            magnitudes[j]=magnitudNum;
        }
        return magnitudes;
    }
    ///programar las funciones de normalizar en funcion de las columnas
    //ESTO NO ES UN COMENTARIO, AYUDAAAAA!!!!!!!!
    private static double[][][] NormalizarASCII(double[][][] matriz){
        double[][] magnitudes=CalcMagnitudesASCII(matriz);
        double[][][] normalizado=new double[matriz.length][matriz[0].length][matriz[0][0].length];

        for(int i=0; i<matriz.length; i++){
            for(int j=0;j<matriz[0].length;j++){
                for(int k=0; k<matriz[0][0].length;k++){
                    normalizado[i][j][k]=matriz[i][j][k]/magnitudes[j][k];
                }
            }
        }
       
      /*  for(int i=0;i<normalizado.length;i++){
            for(int j=0;j<normalizado[i].length;j++){
                System.out.println(Arrays.toString( normalizado[i][j]));
            }
        }*/
        

        return normalizado;

    }
    private static double[][] CalcMagnitudesASCII(double[][][] matriz){
        double magnitudASCII=0;
        double[][] magnitudes= new double[matriz[0].length][matriz[0][0].length];
        for(int k=0; k<matriz[0][0].length;k++){
            magnitudASCII=0;
            for(int j=0; j<matriz[0].length;j++) {
                for(int i=0; i<matriz.length;i++ ){
                    magnitudASCII += matriz[i][j][k] * matriz[i][j][k];
                }
                magnitudASCII = Math.sqrt(magnitudASCII);
                magnitudes[j][k]=magnitudASCII;
            }
        }
        return magnitudes;
    }


   
    private static double[][] extractNum(String [][] matriz,boolean[] arrIsInteger){
        int numInt=0;
        for(boolean num: arrIsInteger)
            if(num)
                numInt++;

        double [][] numData=new double[matriz.length][numInt];
        int numCol=0;
        for(int j=0;j<arrIsInteger.length;j++){
            if(arrIsInteger[j]){
                for(int i=0;i<matriz.length;i++){
                   // System.out.println(Double.valueOf(matriz[i][j]));
                    numData[i][numCol]=Double.valueOf(matriz[i][j]);
                }
                numCol++;
            }
        }
        return numData;
    }
    public static double[][][] extractASCII(String [][] matriz,boolean[] arrIsInteger){
        int numStr=0;
        for(boolean str: arrIsInteger)
            if(!str)
                numStr++;
        double [][][] ASCIIValues=new double [matriz.length][numStr][];
        
        int wordCol=0;
        for(int j=0;j<arrIsInteger.length;j++){
            if(!arrIsInteger[j]){
                int max=0;
                for(int i=0;i<matriz.length;i++){
                    if(matriz[i][j].length()>max)
                        max=matriz[i][j].length();
                }
                for(int i=0;i<matriz.length;i++){
                    ASCIIValues[i][wordCol]=new double[max];
                    String word=matriz[i][j].toUpperCase();
                    for(int p=0;p<word.length();p++){
                        ASCIIValues[i][wordCol][p]= (double)word.charAt(p);;
                    }
                }
                wordCol++;
            }
        }
        return ASCIIValues;
    }
    
    
    public static boolean[] Clasificar(String [][] matriz){
        boolean[] arrIsInteger = new boolean[matriz[0].length];
        double test=0.0;
        for(int j=0;j<matriz[0].length;j++){
            try{
                test=Double.valueOf(matriz[0][j]);
                arrIsInteger[j]=true;
            }catch(NumberFormatException e){
                arrIsInteger[j]=false;
            }
        }
        return arrIsInteger;
    }
   
    public static void main(String[] args){
        String[][] data={{""}};
       try{
            List<String> lines = Files.readAllLines(Paths.get("test.csv"));
            int columas=Integer.parseInt(lines.get(0).split(",")[1]);
            int filas=Integer.parseInt(lines.get(1).split(",")[1]);
            data=new String[filas][];
            //System.out.printf("  %d,%d",filas,columas);
            lines=lines.subList(2, lines.size());
            for(int i=0;i<lines.size();i++){
                String ln = lines.get(i).replace("\"", "");
                data[i]=lines.get(i).split(",");
            }
            for(int n=0;n<data.length;n++){
                System.out.println(Arrays.toString(data[n]));
            }
          
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    	
       /* String [][] alumnos ={{"15","100","perros"},
                              {"1","150","Ps"},
                              {"16","90","PERRas"},
                              {"14","120","PerrO"},
                              {"13","110","PeRrO"}};
                              System.out.println(alumnos.length);
                              System.out.println(alumnos[0].length);
        */
        boolean [] classify=Clasificar(data);
        
        double[][]  matrixNum = extractNum(data, classify);
      /*  for(int i=0;i<matrixNum.length;i++){
            System.out.println(Arrays.toString( matrixNum[i]));
        }
        System.out.println();*/
        double[][][] matrixASCII=extractASCII(data, classify);
        for(int i=0;i<matrixASCII.length;i++){
            for(int j=0;j<matrixASCII[i].length;j++){
                System.out.println(Arrays.toString( matrixASCII[i][j]));
            }
        }
        double[][] matrixNumNormalized= NormalizarNum(matrixNum);
        for(int i=0;i<matrixNumNormalized.length;i++){
            System.out.println(Arrays.toString(matrixNumNormalized[i]));
        }
        System.out.println();
       // double[][][] matrixASCIINormalized = NormalizarASCII(matrixASCII);
       
       
     //  Cluster.Distancia(clust.get(0), clust.get(1), TipoD.EISEN_COSINE_CORRELATION);

       //AGLOMERATIVO
       ArrayList<ClusterCentroide> clust = new ArrayList<ClusterCentroide>();
       for(int n=0;n<data.length;n++){
           clust.add(new ClusterCentroide(matrixNumNormalized[n],matrixASCII[n]));
       }
       System.out.println(clust.size());

       for(int n=0;n<clust.size();n++){
                System.out.println(clust.get(n));
            }

       while(clust.size()>1){
           double distanceMin=Double.MAX_VALUE;
           int x=0;
           int y=0;
           double distance=0;
           for(int i=0;i<clust.size()-1;i++){
               // System.out.println(i);
               for(int j=i+1;j<clust.size();j++){
                 //  System.out.printf("%d %d \n",i,j);
                   
                    distance=ClusterCentroide.Distancia(clust.get(i), clust.get(j), TipoD.EUCLIDIAN);
                    System.out.printf("Distancia entre %d y %d: %f\n",i,j,distance);
                    if(distance<distanceMin){
                        distanceMin=distance;
                        x=i;
                        y=j;
                        
                    }
               }
           }
           System.out.printf("Distancia minima entre %d y %d: %f\n",x,y,distanceMin);
            
            clust.add(new ClusterCentroide(clust.remove(y),clust.remove(x)));
            for(int n=0;n<clust.size();n++){
                System.out.println(clust.get(n));
            }
            System.out.println(clust.size());
       }

       //DIVISIVO
       /*
        ArrayList<ClusterCentroide> clustD = new ArrayList<ClusterCentroide>();
        clustD.add(new ClusterCentroide(matrixNumNormalized,matrixASCII));
        Boolean isSingleton=true;
        
        do{
            isSingleton=true;
            for(int i=0;i<clustD.size();i++){
               // System.out.println(clustD.get(i).size);
                if(clustD.get(i).size>1){
                   // System.out.printf("indice:%d, tamaño:%d\n",i,clustD.get(i).size);
                    isSingleton=false;
                    ClusterCentroide[] arrClust=ClusterCentroide.Divir(clustD.remove(i));
                    clustD.add(arrClust[0]);
                    clustD.add(arrClust[1]);
                    break;
                }
              // System.out.printf("tamaño lista:%d\n",clustD.size());
            }

        }while(!isSingleton);
        for(int n=0;n<clustD.size();n++){
            System.out.println(clustD.get(n));
        }*/
    }
}