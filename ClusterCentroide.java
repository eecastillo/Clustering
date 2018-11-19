import java.util.Arrays;
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
	public ClusterCentroide(double[][] numTable, double[][][] ASCIITable){
		super(numTable,ASCIITable);
		CalcularCentroideNumerico();
		CalcularCentroideASCII();
	}
	public ClusterCentroide(){
		super();
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
		//System.out.println(Arrays.toString(centroideNum));
	}
	private void CalcularCentroideASCII(){
		double[][] temp;
		int size = elements[0].getSizeASCII();
		if(size==0)return;
		int[] sizesOfASCII=new int[size];
		for(int i=0;i<size;i++){
			sizesOfASCII[i]=elements[0].getASCII()[i].length;
		}
		centroideASCII=new double[size][];
		double CompCentroide=0;
		for(int i=0;i<size;i++){
			// System.out.println(i);
			centroideASCII[i]=new double[sizesOfASCII[i]];
			for(int j=0;j<sizesOfASCII[i];j++){
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
          /*for(int n=0;n<centroideASCII.length;n++){
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

	public static ClusterCentroide[] Divir(ClusterCentroide clust){
		ClusterCentroide[] arrClust=new ClusterCentroide[2];
		arrClust[0]=new ClusterCentroide();
		arrClust[1]=new ClusterCentroide();
		
		Elemento Centroide = new Elemento(clust.getCentroideNum(),clust.getCentroideASCII());
		for(int i=0;i<clust.elements.length;i++){
			if(Elemento.isBigger(clust.elements[i], Centroide)>0.5){
			//	System.out.printf("Es mayor con: %f\n",Elemento.isBigger(clust.elements[i], Centroide));
				arrClust[1].AddElement(clust.elements[i]);
			}
			else{
			//	System.out.printf("Es menor con: %f\n",Elemento.isBigger(clust.elements[i], Centroide));
				arrClust[0].AddElement(clust.elements[i]);
			}
		}
		if(arrClust[0].size==0){
		
			arrClust[0].AddElement(arrClust[1].RemoveElement(0));
			
		}
		else if(arrClust[1].size==0){
			arrClust[1].AddElement(arrClust[0].RemoveElement(0));
				
		}

		//System.out.println(Arrays.toString(clust.getCentroideNum()));
		/*for(int n=0;n<clust.getCentroideASCII().length;n++){
			System.out.print(Arrays.toString(clust.getCentroideASCII()[n]));
		}*/
		/*System.out.println();
		System.out.println(arrClust[0]);
		System.out.println();
		System.out.println(arrClust[1]);*/
		return arrClust;
	}

	public void AddElement(Elemento nuevo){
		Elemento[] temp=new Elemento[this.size+1];
		for(int i=0;i<this.size;i++){
			temp[i]=this.elements[i];
		}
		temp[this.size]=nuevo;
		this.elements=temp;
		this.size++;
		//System.out.printf("tamaño nuevo al agregar 1: %d\n",this.size);
		CalcularCentroideASCII();
		CalcularCentroideNumerico();
	}
	public Elemento RemoveElement(int index){
		Elemento[] temp=new Elemento[this.size-1];
		Elemento basura = this.elements[index];
		for(int i=0,t=0;i<size;i++){
			if(i!=index){
				temp[t]=this.elements[i];
				t++;
			}
		}
		this.elements=temp;
		this.size=temp.length;
		CalcularCentroideASCII();
		CalcularCentroideNumerico();
		return basura;
	}
}