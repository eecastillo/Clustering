<<<<<<< HEAD
//import Elemento;
import java.util.Arrays;
public class Cluster{
    private Elemento[] elements;
    private int size=1;
    private double[] centroide;

    public Cluster(double[] data){
        this.elements= new Elemento[1];
        this.elements[0]=new Elemento(data);
        System.out.println(this.elements[0]);
        CalcularCentroide();
    }

    public Cluster(Cluster x, Cluster y){
        this.elements= new Elemento[x.getSize()+y.getSize()];
        Elemento[] elementsX=x.getElements();
        Elemento[] elementsY=y.getElements();
        for(int i=0;i<x.getSize();i++){
            this.elements[i]=elementsX[i];
        }
        for(int j=x.getSize();j<x.getSize()+y.getSize();j++){
            this.elements[j]=elementsY[0];
        }
        CalcularCentroide();
    }

    private void CalcularCentroide(){
        double[] temp;
        int size = elements[0].getSize();
        centroide = new double[size];
        double CompCentroide=0;
        for(int i=0;i<size;i++){
            CompCentroide=0;
            for(int j=0;j<elements.length;j++){
                temp=elements[j].getNormalizado();
                CompCentroide += temp[i];
            }
            centroide[i]=CompCentroide/elements.length;
        }
    }

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0.0;
        double[] centroideX = x.getCentroide();
        double[] centroideY = y.getCentroide();
        int size = centroideX.length;
        
        switch(tipo){
            case EUCLIDIAN:
                for(int i=0;i<size;i++){
                    distance += (centroideX[i]-centroideY[i])*(centroideX[i]-centroideY[i]);
                }
                distance = Math.sqrt(distance);
            break;
            case MANHATTAN:
                for(int i=0;i<size;i++){
                    distance += Math.abs(centroideX[i]-centroideY[i]);
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

    public double[] getCentroide(){
        return this.centroide;
    }
=======
//import Elemento;
import java.util.Arrays;
public class Cluster{
    private Elemento[] elements;
    private int size=1;
    private double[] centroide;

    public Cluster(double[] data){
        this.elements= new Elemento[1];
        this.elements[0]=new Elemento(data);
        CalcularCentroide();
    }

    public Cluster(Cluster x, Cluster y){
        this.elements= new Elemento[x.getSize()+y.getSize()];
        Elemento[] elementsX=x.getElements();
        Elemento[] elementsY=y.getElements();
        for(int i=0;i<x.getSize();i++){
            this.elements[i]=elementsX[i];
        }
        for(int j=x.getSize();j<x.getSize()+y.getSize();j++){
            this.elements[j]=elementsY[0];
        }
        CalcularCentroide();
    }

    private void CalcularCentroide(){
        double[] temp;
        int size = elements[0].getSize();
        centroide = new double[size];
        double CompCentroide=0;
        for(int i=0;i<size;i++){
            CompCentroide=0;
            for(int j=0;j<elements.length;j++){
                temp=elements[j].getNormalizado();
                CompCentroide += temp[i];
            }
            centroide[i]=CompCentroide/elements.length;
        }
    }

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double distance=0.0;
        switch(tipo){
            case EUCLIDIAN:
            break;
            case MANHATTAN:
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

    public double[] getCentroide(){
        return this.centroide;
    }
>>>>>>> 2bc72a71e6b5fc94b60645287124f665108e4746
}