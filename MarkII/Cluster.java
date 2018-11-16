package Clustering.MarkII;

//import Elemento;
import java.util.Arrays;
public class Cluster{
	private Elemento[] elements;
	private int size=1;
	private double[] centroideNum;
	private double[][]  centroideASCII;

	public Cluster(double[] numData, double[][] ASCIIData){
		this.elements= new Elemento[1];
		this.elements[0]=new Elemento(numData,ASCIIData);
		// System.out.println(this.elements[0]);
		CalcularCentroideNumerico();
		CalcularCentroideASCII();
	}

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

	public static double Distancia(Cluster x, Cluster y, TipoD tipo){
		double distance=0.0;
		double distanceNum=0;
		double distanceASCII=0;
		double[] centroideNumX = x.getCentroideNum();
		double[] centroideNumY = y.getCentroideNum();
		double[][] centroideASCIIX = x.getCentroideASCII();
		double[][] centroideASCIIY = y.getCentroideASCII();
		double ASCIISize = centroideASCIIX.length;
		double size = centroideNumX.length;
		double totalSize=ASCIISize+size;


		System.out.println(Arrays.toString(centroideNumX));
		System.out.println(Arrays.toString(centroideNumY));
		for(int i=0;i<centroideASCIIX.length;i++) {
			System.out.println(Arrays.toString(centroideASCIIX[i]));
		}
		for(int i=0;i<centroideASCIIY.length;i++) {
			System.out.println(Arrays.toString(centroideASCIIY[i]));
		}

		//Hamming
		for(int i=0; i<ASCIISize ;i++) {
			double centroideASCIIlength= (double)centroideASCIIX[i].length;
			for(int j=0; j<centroideASCIIlength; j++) {
				distanceASCII += ((centroideASCIIX[i][j]==centroideASCIIY[i][j]) ? 0: 1)/ centroideASCIIlength ;
			}
		}
		distanceASCII = distanceASCII/ASCIISize;



		switch(tipo){
		case EUCLIDIAN:
			for(int i=0;i<size;i++){
				distanceNum += (centroideNumX[i]-centroideNumY[i])*(centroideNumX[i]-centroideNumY[i]);
			}
			distanceNum = Math.sqrt(distanceNum);
			break;
		case MANHATTAN:
			for(int i=0;i<size;i++){
				distanceNum += Math.abs(centroideNumX[i]-centroideNumY[i]);
			}
			break;
		case PEARSON_CORRELATION:
			double xProm = 0;
			double yProm=0;
			for(int i=0;i<size;i++){
				xProm += centroideNumX[i];
				yProm += centroideNumY[i];
			}
			xProm = xProm/size;
			yProm = yProm/size;

			System.out.println("prom y = " + yProm);
			System.out.println("prom x =" + xProm);

			double numerador= 0.0;
			double denominadorX= 0.0;
			double denominadorY= 0.0;

			for(int i=0;i<size;i++) {
				numerador+= (centroideNumX[i]-xProm)*(centroideNumY[i]-yProm);
			}
			for(int i=0;i<size;i++) {
				denominadorX+= (centroideNumX[i]-xProm)*(centroideNumX[i]-xProm);
			}
			for(int i=0;i<size;i++) {
				denominadorY+= (centroideNumY[i]-yProm)*(centroideNumY[i]-yProm);
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
				numeradorE+= centroideNumX[i]*centroideNumY[i];
			}
			for(int i=0;i<size;i++) {
				denominadorXE+= centroideNumX[i]*centroideNumX[i];
			}
			for(int i=0;i<size;i++) {
				denominadorYE+= centroideNumY[i]*centroideNumY[i];
			}
			System.out.println("numerador: "+numeradorE);
			System.out.println("Denominador x: " + denominadorXE);
			System.out.println("Denominador y: " +denominadorYE);
			distanceNum = 1 - (numeradorE/Math.sqrt(denominadorXE*denominadorYE));
			break;
		case KENDALL_CORRELATION:
			double xRank = 0;
			double yRank=0;
	

			System.out.println("prom y = " + yRank);
			System.out.println("prom x =" + xRank);

			double numeradorS= 0.0;
			double denominadorXS= 0.0;
			double denominadorYS= 0.0;

			for(int i=0;i<size;i++) {
				numeradorS+= (centroideNumX[i]-xRank)*(centroideNumY[i]-yRank);
			}
			for(int i=0;i<size;i++) {
				denominadorXS+= (centroideNumX[i]-xRank)*(centroideNumX[i]-xRank);
			}
			for(int i=0;i<size;i++) {
				denominadorYS+= (centroideNumY[i]-yRank)*(centroideNumY[i]-yRank);
			}
			//System.out.println("numerador: "+numerador);
			//System.out.println("Denominador x: " + denominadorX);
			//System.out.println("Denominador y: " +denominadorY);
			distanceNum = 1 - (numeradorS/Math.sqrt(denominadorXS*denominadorYS));
		}

		distance=(distanceNum*(size/totalSize)) + (distanceASCII*(ASCIISize/totalSize));
		System.out.println("distanceNUM: " + distanceNum);
		System.out.println("distanceASCII: " + distanceASCII);
		System.out.println("distanceTotal: " + distance);
		return distance;
	}

	public int getSize(){
		return this.size;
	}

	public Elemento[] getElements(){
		return elements;
	}

	@Override
	public String toString(){
		String print="";
		for(int i=0;i<elements.length;i++)
			print+=elements[i].toString();
		return print;
	}

	public double[] getCentroideNum(){
		return this.centroideNum;
	}

	public double[][] getCentroideASCII(){
		return this.centroideASCII;
	}
}