import java.util.ArrayList;
import java.util.Arrays;
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
       
        for(int i=0;i<normalizado.length;i++){
            for(int j=0;j<normalizado[i].length;j++){
                System.out.println(Arrays.toString( normalizado[i][j]));
            }
        }
        

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
        
        boolean [] classify=Clasificar(alumnos);
        
        double[][]  matrixNum = extractNum(alumnos, classify);
        for(int i=0;i<matrixNum.length;i++){
            System.out.println(Arrays.toString( matrixNum[i]));
        }
        System.out.println();
        double[][][] matrixASCII=extractASCII(alumnos, classify);
        for(int i=0;i<matrixASCII.length;i++){
            for(int j=0;j<matrixASCII[i].length;j++){
                System.out.println(Arrays.toString( matrixASCII[i][j]));
            }
        }
        double[][] matrixNumNormalized= NormalizarNum(matrixNum);
        double[][][] matrixASCIINormalized = NormalizarASCII(matrixASCII);
        ArrayList<Cluster> clust = new ArrayList<Cluster>();
        for(int n=0;n<alumnos.length;n++){
            clust.add(new Cluster(matrixNumNormalized[n],matrixASCII[n]));
        }
        /*Cluster c0 = new Cluster(tabla[0]);
        Cluster c1 = new Cluster(tabla[1]);
        Cluster c2 = new Cluster(tabla[2]);
        Cluster c3 = new Cluster(tabla[3]);
        Cluster c4 = new Cluster(tabla[4]);
*/
       

    }
}
