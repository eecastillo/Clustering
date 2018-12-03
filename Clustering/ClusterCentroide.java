package Clustering;

public class ClusterCentroide extends Cluster{
	/** Esta clase contiene el tipo de cluster por distancia centroide.
	 * En este tipo de cluster la semejanza entre dos clusters
     *  esta dada por la distancia entre sus centroides.
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
    private double[] centroideNum;
    private double[][]  centroideASCII;
    
    public ClusterCentroide(double[] numData, double[][] ASCIIData){
        super(numData, ASCIIData);
        CalcularCentroideNumerico();
		CalcularCentroideASCII();
    }
    /** Crea un ClusterCentroide
     * @param  double[] numData - matriz con datos numericos, double[][] ASCIIData - matriz con datos ASCII
    */

    public ClusterCentroide(Cluster x, Cluster y){
        super(x, y);
        CalcularCentroideNumerico();
		CalcularCentroideASCII();
	}
    /** Crea un Cluster Centroide
     * @param Cluster  x, Cluster  y
    */

    
	public ClusterCentroide(double[][] numTable, double[][][] ASCIITable){
		super(numTable,ASCIITable);
		CalcularCentroideNumerico();
		CalcularCentroideASCII();
	}
	   /** Crea un ClusterCentroide
     * @param  double[][] numData - matriz con datos numericos, double[][][] ASCIIData - matriz con datos ASCII
    */
	public ClusterCentroide(){
		super();
	}
	   /** Crea un ClusterCentroide
 */
    
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
    /** Calcula el centroide de los datos númericos
    */

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
    /** Calcula el centroide de los datos ASCII
    */

    public static double Distancia(Cluster x, Cluster y, TipoD tipo){
        double[] centroideNumX = ((ClusterCentroide)x).getCentroideNum();
		double[] centroideNumY = ((ClusterCentroide)y).getCentroideNum();
		double[][] centroideASCIIX = ((ClusterCentroide)x).getCentroideASCII();
		double[][] centroideASCIIY = ((ClusterCentroide)y).getCentroideASCII();
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
    /** Regresa la distancia entre los centroidesd de dos clusters, usando el tipo de distancia seleccionado
     * @param  ClusterCentroide x- el primer cluster a comparar, ClusterCenroide y- el segundo cluster a comparar , TipoD tipo- tipo de ditsnacia que se quiere
     * @return  double averageDistance
    */
    
    
	public double[] getCentroideNum(){
		return this.centroideNum;
	}
	   /** Regresa la el centroide númerico
     * @return  double[] centroideNum[]
    */

	public double[][] getCentroideASCII(){
		return this.centroideASCII;
	}
	   /** Regresa la el centroide ASCII
  * @return  double[][] centroideASCII
 */

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
			for(int i=0;i<arrClust[1].size/2;i++)
				arrClust[0].AddElement(arrClust[1].RemoveElement(0));
			
		}
		else if(arrClust[1].size==0){
			for(int i=0;i<arrClust[0].size/2;i++)
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
    /** Divide el cluster en dos  , los mayores y los menores
     * @param  ClusterCentroide- el cluster que se quiere dividir en dos
     *  @return   ClusterCentroide[2]- un arreglo con dos cluster uno con los mayores y uno con los menores
    */
	

	public void AddElement(Elemento nuevo){
		Elemento[] temp=new Elemento[this.size+1];
		for(int i=0;i<this.size;i++){
			temp[i]=this.elements[i];
		}
		temp[this.size]=nuevo;
		this.elements=temp;
		this.size++;
		//System.out.printf("tamaÃ±o nuevo al agregar 1: %d\n",this.size);
		CalcularCentroideASCII();
		CalcularCentroideNumerico();
	}
    /** Agrega un nuevo elemento al centroide
     * @param  Elemento- el elemento que se quiere agregar 
     */
	 
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
    /** Elimina un elemento del centroide
     * @param  Elemento- el elemento que se quiere eliminar
     */
}