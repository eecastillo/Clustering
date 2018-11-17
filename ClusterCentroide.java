public class ClusterCentroide extends Cluster{
    private double[] centroideNum;
    private double[][]  centroideASCII;
    
    public ClusterCentroide(double[] numData, double[][] ASCIIData){
        super(numData, ASCIIData);
        CalcularCentroideNumerico();
		CalcularCentroideASCII();
    }

    public ClusterCentroide(ClusterCentroide x, ClusterCentroide y){
        super(x, y);
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

    public static double Distancia(ClusterCentroide x, ClusterCentroide y, TipoD tipo){
        double[] centroideNumX = x.getCentroideNum();
		double[] centroideNumY = y.getCentroideNum();
		double[][] centroideASCIIX = x.getCentroideASCII();
		double[][] centroideASCIIY = y.getCentroideASCII();
		return Cluster.Distancia(centroideNumX, centroideNumY, centroideASCIIX,centroideASCIIY, tipo);
		
		//System.out.println(Arrays.toString(centroideNumX));
		//System.out.println(Arrays.toString(centroideNumY));
		/*for(int i=0;i<centroideASCIIX.length;i++) {
			System.out.println(Arrays.toString(centroideASCIIX[i]));
		}
		for(int i=0;i<centroideASCIIY.length;i++) {
			System.out.println(Arrays.toString(centroideASCIIY[i]));
		}*/
	}
	public double[] getCentroideNum(){
		return this.centroideNum;
	}

	public double[][] getCentroideASCII(){
		return this.centroideASCII;
	}
}