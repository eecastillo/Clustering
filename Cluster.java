
//import Elemento;
import java.util.Arrays;//import Elemento;
public class Cluster{
	/** Esta clase representa un cluster
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	protected Elemento[] elements;
	protected int size=1;


	public Cluster(double[] numData, double[][] ASCIIData){
		this.elements= new Elemento[1];
		this.elements[0]=new Elemento(numData,ASCIIData);
	}
    /** Crea un Cluster
     * @param  double[] numData - matriz con datos numericos, double[][] ASCIIData - matriz con datos ASCII
    */



	public Cluster(Cluster x, Cluster y){
		this.elements= new Elemento[x.getSize()+y.getSize()];
		Elemento[] elementsX=x.getElements();
		Elemento[] elementsY=y.getElements();
		for(int i=0;i<x.getSize();i++){
			this.elements[i]=elementsX[i];
		}
		for(int j=x.getSize();j<x.getSize()+y.getSize();j++){
			this.elements[j]=elementsY[j-x.getSize()];
		}
		this.size=x.getSize()+y.getSize();
	}
    /** Crea un Cluster
     * @param Cluster  x, Cluster  y
    */

	
	public Cluster(double[][] numTable, double[][][] ASCIITable){
		this.elements = new Elemento[numTable.length];
		this.size=numTable.length;
		for(int i=0;i<numTable.length;i++){
			this.elements[i]=new Elemento(numTable[i],ASCIITable[i]);
			//	System.out.println(this.elements[i]);
		}
	}
/** Crea un Cluster
  * @param  double[][] numData - matriz con datos numericos, double[][][] ASCIIData - matriz con datos ASCII
 */
	public Cluster(){
		this.size=0;
		//this.elements=new Elemento[0];
	}
	/** Crea un Cluster con 0 elementos
	 */
    
	
	public void setMatrices (double[] numData, double[][] ASCIIData){
		this.elements= new Elemento[1];
		this.elements[0]=new Elemento(numData,ASCIIData);
	}
	/** Establece las matrices del cluster
	 * @param double[] numData-  martiz númerica, double[][] ASCIIData- matriz ASCII
	 */
	

	public int getSize(){
		return this.size;
	}

	public Elemento[] getElements(){
		return elements;
	}

	 public static double Distancia(Cluster x, Cluster y, TipoD tipo){
		 return 0;
	 }

	protected static double Distancia(double[] xNum, double[] yNum, double[][] xASCII, double[][] yASCII, TipoD tipo){
		double distance=0.0;
		double distanceNum=0;
		double distanceASCII=0;

		double ASCIISize=0;
		if(xASCII!=null)
			ASCIISize = xASCII.length;
		double size=0;
		if(xNum!=null)
			size = xNum.length;
		double totalSize=ASCIISize+size;



		//Hamming
		for(int i=0; i<ASCIISize ;i++) {
			double ASCIIlength= (double)xASCII[i].length;
			for(int j=0; j<ASCIIlength; j++) {
				distanceASCII += ((xASCII[i][j]==yASCII[i][j]) ? 0: 1)/ ASCIIlength ;
			}
		}
		//si ASCIISize era 0, existia una división de 0 entre0
		if(ASCIISize>0){
			distanceASCII = distanceASCII/ASCIISize;
		}
		else{
			distanceASCII=0;
		}



		switch(tipo){
		case EUCLIDIAN:
			for(int i=0;i<size;i++){
				distanceNum += (xNum[i]-yNum[i])*(xNum[i]-yNum[i]);
			}
			distanceNum = Math.sqrt(distanceNum);
			break;
		case MANHATTAN:
			for(int i=0;i<size;i++){
				distanceNum += Math.abs(xNum[i]-yNum[i]);
			}
			break;
		case PEARSON_CORRELATION:
			double xProm = 0;
			double yProm=0;
			for(int i=0;i<size;i++){
				xProm += xNum[i];
				yProm += yNum[i];
			}
			xProm = xProm/size;
			yProm = yProm/size;

			System.out.println("prom y = " + yProm);
			System.out.println("prom x =" + xProm);

			double numerador= 0.0;
			double denominadorX= 0.0;
			double denominadorY= 0.0;

			for(int i=0;i<size;i++) {
				numerador+= (xNum[i]-xProm)*(yNum[i]-yProm);
			}
			for(int i=0;i<size;i++) {
				denominadorX+= (xNum[i]-xProm)*(xNum[i]-xProm);
			}
			for(int i=0;i<size;i++) {
				denominadorY+= (yNum[i]-yProm)*(yNum[i]-yProm);
			}
			//System.out.println("numerador: "+numerador);
			//System.out.println("Denominador x: " + denominadorX);
			//System.out.println("Denominador y: " +denominadorY);
			distanceNum = 1 - (numerador/Math.sqrt(denominadorX*denominadorY));
			break;
		case EISEN_COSINE_CORRELATION:
			double numeradorE= 0.0;
			double denominadorXE= 0.0;
			double denominadorYE= 0.0;
			for(int i=0;i<size;i++) {
				numeradorE+= xNum[i]*yNum[i];
			}
			for(int i=0;i<size;i++) {
				denominadorXE+= xNum[i]*xNum[i];
			}
			for(int i=0;i<size;i++) {
				denominadorYE+= yNum[i]*yNum[i];
			}
			//System.out.println("numerador: "+numeradorE);
			//System.out.println("Denominador x: " + denominadorXE);
			//System.out.println("Denominador y: " +denominadorYE);
			distanceNum = 1 - (numeradorE/Math.sqrt(denominadorXE*denominadorYE));
			break;
		case SPEARMAN_CORRELATION:

			double auxRank=0;
			double[] xRank = new double[(int)size]; 
			double[] yRank = new double[(int)size]; 
			double[] xSorted = Arrays.copyOf(xNum, xNum.length);
			Arrays.parallelSort(xSorted);
			double[] ySorted = Arrays.copyOf(yNum, yNum.length);
			Arrays.parallelSort(ySorted);


			for(int i=0;i<size;i++) {
				double xties=0;
				double yties=0;

				for(int j=0;j<size;j++) {
					if(xNum[i]==xNum[j]) 
						xties++;
					if(yNum[i]==yNum[j])
						yties++;

				}
				if(xties==1) {
					auxRank=Arrays.binarySearch(xSorted, xNum[i]);
					xRank[i]=size-auxRank;
				}
				else if(xties!=1) {
					for(int j=0; j<xties; j++)
						xRank[i]=size-(Arrays.binarySearch(xSorted, xNum[i])+j);
					xRank[i]=xRank[i]/xties;
				}
				if(yties==1) {
					auxRank=Arrays.binarySearch(ySorted, yNum[i]);
					yRank[i]=size-auxRank;
				}
				else if(yties!=1) {
					for(int j=0; j<xties; j++)
						yRank[i]=size-(Arrays.binarySearch(ySorted, yNum[i])+j);
					yRank[i]=yRank[i]/yties;
				}

			}


			//System.out.println("yNum" +Arrays.toString( yNum));
			//System.out.println("xNum" +Arrays.toString( xNum));
			//System.out.println("ySorted" +Arrays.toString( ySorted));
			//System.out.println("xSorted" +Arrays.toString( xSorted));
			//System.out.println("yRank" +Arrays.toString( yRank));
			//System.out.println("xRank" +Arrays.toString( xRank));


			double numeradorS= 0.0;
			for(int i=0;i<size;i++) {
				numeradorS+= (xRank[i]-yRank[i])*(xRank[i]-yRank[i]);
			}


			distanceNum = 1 - 6*numeradorS/(size*((size*size)-1));
		}

		distance=(distanceNum*(size/totalSize)) + (distanceASCII*(ASCIISize/totalSize));
		/*System.out.println("distanceNUM: " + distanceNum);
		System.out.println("distanceASCII: " + distanceASCII);
		System.out.println("distanceTotal: " + distance);*/
		return distance;
	}


	@Override
	public String toString(){
		//System.out.printf("el tamaño de elementos es: %d\n",this.size);
		String print="";
		for(int i=0;i<this.size;i++){
			print+=elements[i].toString();
			print+="/";
		}
		return print;
	}




}