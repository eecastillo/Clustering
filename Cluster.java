
//import Elemento;
import java.util.Arrays;
public class Cluster{
	protected Elemento[] elements;
	protected int size=1;
	

	public Cluster(double[] numData, double[][] ASCIIData){
		this.elements= new Elemento[1];
		this.elements[0]=new Elemento(numData,ASCIIData);
		// System.out.println(this.elements[0]);
		
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
		
	}

	

	protected static double Distancia(double[] xNum, double[] yNum, double[][] xASCII, double[][] yASCII, TipoD tipo){
		double distance=0.0;
		double distanceNum=0;
		double distanceASCII=0;
		
		double ASCIISize = xASCII.length;
		double size = xNum.length;
		double totalSize=ASCIISize+size;



		//Hamming
		for(int i=0; i<ASCIISize ;i++) {
			double ASCIIlength= (double)xASCII[i].length;
			for(int j=0; j<ASCIIlength; j++) {
				distanceASCII += ((xASCII[i][j]==yASCII[i][j]) ? 0: 1)/ ASCIIlength ;
			}
		}
		distanceASCII = distanceASCII/ASCIISize;



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
		case KENDALL_CORRELATION:
			double xRank = 0;
			double yRank=0;
	

			//System.out.println("prom y = " + yRank);
			//System.out.println("prom x =" + xRank);

			double numeradorS= 0.0;
			double denominadorXS= 0.0;
			double denominadorYS= 0.0;

			for(int i=0;i<size;i++) {
				numeradorS+= (xNum[i]-xRank)*(yNum[i]-yRank);
			}
			for(int i=0;i<size;i++) {
				denominadorXS+= (xNum[i]-xRank)*(xNum[i]-xRank);
			}
			for(int i=0;i<size;i++) {
				denominadorYS+= (yNum[i]-yRank)*(yNum[i]-yRank);
			}
			//System.out.println("numerador: "+numerador);
			//System.out.println("Denominador x: " + denominadorX);
			//System.out.println("Denominador y: " +denominadorY);
			distanceNum = 1 - (numeradorS/Math.sqrt(denominadorXS*denominadorYS));
		}

		distance=(distanceNum*(size/totalSize)) + (distanceASCII*(ASCIISize/totalSize));
		/*System.out.println("distanceNUM: " + distanceNum);
		System.out.println("distanceASCII: " + distanceASCII);
		System.out.println("distanceTotal: " + distance);*/
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
		for(int i=0;i<elements.length;i++){
			print+=elements[i].toString();
			print+="/";
		}
		return print;
	}

	
}