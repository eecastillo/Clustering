
//import Elemento;
import java.util.Arrays;
public class Cluster{
    private Elemento[] elements;
    private int size=1;
    private double[] centroideNum;
    private double[][]  centroideASCII;

    public Cluster(double[] numData, double[][] ASCIIData){
        this.elements= new Elemento[1];
        this.elements[0]=new Elemento(numData,ASCIIData);
        System.out.println(this.elements[0]);
        CalcularCentroideNumerico();
        CalcularCentroideASCII();
    }

    public Cluster(Cluster x, Cluster y){
        this.elements= new Elemento[x.getSize()+y.getSize()];
        Elemento[] elementsX=x.getElements();
        Elemento[] elementsY=y.getElements();
        for(int i=0;i<x.getSize();i++){
            this.elements[i]=elementsX[i];
        }
        for(int j=x.getSize();j<x.getSize()+y.getSize();j++){
            this.elements[j]=elementsY[j-x.getSize()];
        }
        CalcularCentroideNumerico();
        CalcularCentroideASCII();
    }

    private void CalcularCentroideNumerico(){
        double[] temp;
        int size = elements[0].getSizeNum();
        centroideNum = new double[size];
        double CompCentroide=0;
        for(int i=0;i<size;i++){
            CompCentroide=0;
            for(int j=0;j<elements.length;j++){
                temp=elements[j].getNumeros();
                CompCentroide += temp[i];
            }
            centroideNum[i]=CompCentroide/elements.length;
        }
       
    }
    private void CalcularCentroideASCII(){
        double[][] temp;
        int size = elements[0].getSizeASCII();
        int sizeOfASCII=elements[0].getASCII()[0].length;
        centroideASCII=new double[size][sizeOfASCII];
        double CompCentroide=0;
        for(int i=0;i<size;i++){
           // System.out.println(i);
                
            for(int j=0;j<sizeOfASCII;j++){
                CompCentroide=0;
                for(int k=0;k<elements.length;k++){
                    temp=elements[k].getASCII();
                    CompCentroide += temp[i][j];
                }
                for(int k=0;k<size;k++){         
                    centroideASCII[i][j]=CompCentroide/elements.length;
                }
            }
        }
      /*  for(int n=0;n<centroideASCII.length;n++){
            System.out.print(Arrays.toString(centroideASCII[n]));
        }
        System.out.println();*/
    }

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0.0;
        double distanceNum=0;
        double distanceASCII=0;
        double[] centroideNumX = x.getCentroideNum();
        double[] centroideNumY = y.getCentroideNum();
        double[][] centroideASCIIX = x.getCentroideASCII();
        double[][] centroideASCIIY = y.getCentroideASCII();

        int size = centroideNumX.length;
        
        switch(tipo){
            case EUCLIDIAN:
                for(int i=0;i<size;i++){
                    distance += (centroideNumX[i]-centroideNumY[i])*(centroideNumX[i]-centroideNumY[i]);
                }
                distance = Math.sqrt(distance);
            break;
            case MANHATTAN:
                for(int i=0;i<size;i++){
                    distance += Math.abs(centroideNumX[i]-centroideNumY[i]);
                }
            break;
            case KERNELIZED:
            
            break;
        }
        return distance;
    }

    public int getSize(){
        return this.size;
    }

    public Elemento[] getElements(){
        return elements;
    }

    @Override
    public String toString(){
        String print="";
        for(int i=0;i<elements.length;i++)
            print+=elements[i].toString();
        return print;
    }

    public double[] getCentroideNum(){
        return this.centroideNum;
    }

    public double[][] getCentroideASCII(){
        return this.centroideASCII;
    }
}