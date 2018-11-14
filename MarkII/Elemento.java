import java.util.Arrays;

public class Elemento{
    //arreglo con los datos sin normalizar de un elemento
    private double[] datosNumericos;
    private double[][] datosASCII;
    private double magnitud=0.0;
    private int size=0;
    private double[] normalizado;
    
    public Elemento(double[] numeros, double[][] palabras){//--------------->un arreglo para datos numericos y otro arreglo de arreglos 
        this.datosNumericos=numeros;                                        //representando la primera dimension cada palabra y la segunda
        this.datosASCII=palabras;                                         //cada representacion de la letra en ASCII
        size=numeros.length+palabras.length;
        Normalizar();
    }

    //CAMBIAR TODO EL MODELO ACTUAL A UNO DONDE SE TOMEN EN CUENTA NUMEROS Y CARACTERES EN UN MODELO BALANCEADO
    //normaliza los datos entregados en categorias
    private void Normalizar(){
        CalcMagnitude();
        normalizado = new double[categorias.length];
        for(int i=0;i<categorias.length;i++){
            normalizado[i]=categorias[i]/this.magnitud;
        }
    }
    //calcula la magnitud del conjunto de categorias
    private void CalcMagnitude(){
        double magnitudNum=0;
        double magnitudString=0;
        double promASCII=0;
        for(int i=0;i<datosNumericos.length;i++){
            magnitudNum += datosNumericos[i]*datosNumericos[i];
        }
        for(int i=0;i<datosASCII.length;i++){
            promASCII=0;
            for(int a=0;a<datosASCII[i].length;a++){
                promASCII+=datosASCII[i][j];
            }
            magnitudString+=(promASCII/datosASCII[i].length)*(promASCII/datosASCII[i].length);
        }
        magnitudNum=Math.sqrt(magnitudNum);
        this.magnitud=(magnitudNum*datosNumericos.length/size)+(magnitudString*datosASCII.length/size);
        System.out.println(this.magnitud);
    }

    public double[] getNormalizado(){
        return this.normalizado;
    }
    public int getSize(){
        return size;
    }
    @Override
    public String toString(){
        return String.format("%s---%s",Arrays.toString(categorias),Arrays.toString(normalizado));
    }
}