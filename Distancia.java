<<<<<<< HEAD
public class Distancia{
    private double[] elementos;
    private DistanciaTipo tipo= DistanciaTipo.EUCLIDEAN;
    private double distancia;
  
    public Distancia(double [] elementos ){
      setElementos(elementos);
      calcularDistancia();
    }

    public Distancia(double [] elementos, DistanciaTipo tipo){
      Distancia(elementos);
      setTipo(tipo);
    }

    public void setElementos(double [] elementos){
      this.elementos=elementos;
    }
    public void setTipo(DistanciaTipo tipo){
      this.tipo=tipo;
    }
    public void setDistancia(){

    }

    public double[] getElementos(){
      return this.elementos;
    }
    public DistanciaTipo getTipo(){
      return this.tipo;
    }
    public double getDistancia(){
      return this.distancia;
    }

    private void calcularDistancia(){
      for(int i=0;i<elementos.length;i++){
        
      }
    }

=======
public class Distancia{
    private double[] normalizados;
    private DistanciaTipo tipo= DistanciaTipo.EUCLIDEAN;

  /*  public Distancia(){
    }

    public Distancia(int ){

    }
*/
>>>>>>> 2bc72a71e6b5fc94b60645287124f665108e4746
}