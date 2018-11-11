import java.util.Arrays;

public class Elemento{
    //arreglo con los datos sin normalizar de un elemento
    private double[] datosNumericos;
    private double[][] datosASCII;
    private double magnitud=0.0;
    private int size=0;
    private double[] normalizado;
    
    public Elemento(double[] numeros, double[][] palabras){//--------------->un arreglo para datos numericos y otro arreglo de arreglos 
        this.datosNumericos=datos;                                        //representando la primera dimension cada palabra y la segunda
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
        double cuadrados=0;
        for(int i=0;i<categorias.length;i++){
            cuadrados += categorias[i]*categorias[i];
        }
        this.magnitud=Math.sqrt(cuadrados);
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