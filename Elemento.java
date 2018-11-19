
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
        this.datosASCII=palabras;   
        if(numeros!=null)                                      //cada representacion de la letra en ASCII
            sizeNum=datosNumericos.length;
        else
            sizeNum=0;
        if(palabras!=null)
            sizeASCII=palabras.length;
        else
            sizeASCII=0;
        
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

    public static double isBigger(Elemento x, Elemento Centroide){
        double mayores=0;
        double menores=0;
        int menores2D=0;
        int mayores2D=0;
        for(int i=0;i<x.sizeNum;i++){
            if(x.datosNumericos[i]>=Centroide.datosNumericos[i])
                mayores++;
            else
                menores++;
        }
        for(int i=0; i<x.getSizeASCII() ;i++) {
            menores2D=0;
            mayores2D=0;
			double ASCIIlength= (double)x.datosASCII[i].length;
			for(int j=0; j<ASCIIlength; j++) {
                if(x.datosASCII[i][j]>=Centroide.datosASCII[i][j])
                    mayores2D++;
                else
                    menores2D++;
            }
            if(mayores2D>=menores2D)
                mayores++;
            else
                menores++;
		}
        //if(mayores>menores)
          //  return true;
        return mayores/((double)(x.sizeNum+x.sizeASCII));
    }
}