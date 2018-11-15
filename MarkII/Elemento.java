import java.util.Arrays;

public class Elemento{
    //arreglo con los datos sin normalizar de un elemento
    private double[] datosNumericos;
    private double[][] datosASCII;
    private double magnitud=0.0;
    private int sizeNum=0;
    private int sizeASCII=0;
   // private double[] normalizado;
    
    public Elemento(double[] numeros, double[][] palabras){//--------------->un arreglo para datos numericos y otro arreglo de arreglos 
        this.datosNumericos=numeros;                                        //representando la primera dimension cada palabra y la segunda
        this.datosASCII=palabras;                                         //cada representacion de la letra en ASCII
        sizeNum=datosNumericos.length;
        sizeASCII=datosASCII.length;
        
    }

    //CAMBIAR TODO EL MODELO ACTUAL A UNO DONDE SE TOMEN EN CUENTA NUMEROS Y CARACTERES EN UN MODELO BALANCEADO
    //normaliza los datos entregados en categorias
    
    public double[] getNumeros(){
        return this.datosNumericos;
    }
    public double[][] getASCII(){
        return this.datosASCII;
    }
    public int getSizeNum(){
        return sizeNum;
    }
    public int getSizeASCII(){
        return sizeASCII;
    }
    @Override
    public String toString(){
        String ascii="";
        for(int i=0;i<datosASCII.length;i++){
            ascii+=Arrays.toString(datosASCII[i]);
        }
        return String.format("%s  %s",Arrays.toString(datosNumericos),ascii);
    }
}