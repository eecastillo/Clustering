import java.util.Arrays;

public class Elemento{
    private double[] categorias;
    private double magnitud=0.0;
    private int size=0;
    private double[] normalizado;

    public Elemento(double[] datos){
        this.categorias=datos;
        size=datos.length;
        Normalizar();
    }

    private void Normalizar(){
        CalcMagnitude();
        normalizado = new double[categorias.length];
        for(int i=0;i<categorias.length;i++){
            normalizado[i]=categorias[i]/this.magnitud;
        }
    }
    private void CalcMagnitude(){
        double cuadrados=0;
        for(int i=0;i<categorias.length;i++){
            cuadrados += categorias[i]*categorias[i];
        }
        this.magnitud=Math.sqrt(cuadrados);
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