import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;


public class Clustering{
	/** Esta clase............
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
	protected String[][] data={{""}};
	protected double[][] matrixNumNormalized;
	protected double[][][] matrixASCII;
	
//	private static Clustering instance= null;
//	public static Clustering getInstance(String Uri){
//		if(instance==null) instance= new Clustering(Uri);
//		return instance;
//	}
	
	
	public Clustering(String Uri){
		start(Uri);
	}

	private double[][] NormalizarNum(double [][] matriz){
		double[] magnitudes= CalcMagnitudesNum(matriz);
		double[][] normalizado = new double[matriz.length][matriz[0].length];
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){
				normalizado[i][j]=matriz[i][j]/magnitudes[j];
			}
		}
		return normalizado;
	}

	//calcula la magnitud del conjunto de categorias
	private double[] CalcMagnitudesNum(double[][] matriz){
		double magnitudNum=0;
		double[] magnitudes= new double[matriz[0].length];
		for(int j=0;j<matriz[0].length;j++){
			magnitudNum=0;
			for(int i=0;i<matriz.length;i++){
				magnitudNum += matriz[i][j]*matriz[i][j];
			}
			magnitudNum=Math.sqrt(magnitudNum);
			magnitudes[j]=magnitudNum;
		}
		return magnitudes;
	}
	///programar las funciones de normalizar en funcion de las columnas
	//ESTO NO ES UN COMENTARIO, AYUDAAAAA!!!!!!!!
	private double[][][] NormalizarASCII(double[][][] matriz){
		double[][] magnitudes=CalcMagnitudesASCII(matriz);
		double[][][] normalizado=new double[matriz.length][matriz[0].length][matriz[0][0].length];

		for(int i=0; i<matriz.length; i++){
			for(int j=0;j<matriz[0].length;j++){
				for(int k=0; k<matriz[0][0].length;k++){
					normalizado[i][j][k]=matriz[i][j][k]/magnitudes[j][k];
				}
			}
		}


		return normalizado;

	}
	private double[][] CalcMagnitudesASCII(double[][][] matriz){
		double magnitudASCII=0;
		double[][] magnitudes= new double[matriz[0].length][matriz[0][0].length];
		for(int k=0; k<matriz[0][0].length;k++){
			magnitudASCII=0;
			for(int j=0; j<matriz[0].length;j++) {
				for(int i=0; i<matriz.length;i++ ){
					magnitudASCII += matriz[i][j][k] * matriz[i][j][k];
				}
				magnitudASCII = Math.sqrt(magnitudASCII);
				magnitudes[j][k]=magnitudASCII;
			}
		}
		return magnitudes;
	}



	private double[][] extractNum(String [][] matriz,boolean[] arrIsInteger){
		int numInt=0;
		for(boolean num: arrIsInteger)
			if(num)
				numInt++;

		double [][] numData=new double[matriz.length][numInt];
		int numCol=0;
		for(int j=0;j<arrIsInteger.length;j++){
			if(arrIsInteger[j]){
				for(int i=0;i<matriz.length;i++){
					numData[i][numCol]=Double.valueOf(matriz[i][j]);
				}
				numCol++;
			}
		}
		return numData;
	}
	public double[][][] extractASCII(String [][] matriz,boolean[] arrIsInteger){
		int numStr=0;
		for(boolean str: arrIsInteger)
			if(!str)
				numStr++;
		double [][][] ASCIIValues=new double [matriz.length][numStr][];

		int wordCol=0;
		for(int j=0;j<arrIsInteger.length;j++){
			if(!arrIsInteger[j]){
				int max=0;
				for(int i=0;i<matriz.length;i++){
					if(matriz[i][j].length()>max)
						max=matriz[i][j].length();
				}
				for(int i=0;i<matriz.length;i++){
					ASCIIValues[i][wordCol]=new double[max];
					String word=matriz[i][j].toUpperCase();
					for(int p=0;p<word.length();p++){
						ASCIIValues[i][wordCol][p]= (double)word.charAt(p);;
					}
				}
				wordCol++;
			}
		}
		return ASCIIValues;
	}


	public boolean[] Clasificar(String [][] matriz){
		boolean[] arrIsInteger = new boolean[matriz[0].length];
		double test=0.0;
		for(int j=0;j<matriz[0].length;j++){
			try{
				test=Double.valueOf(matriz[0][j]);
				arrIsInteger[j]=true;
			}catch(NumberFormatException e){
				arrIsInteger[j]=false;
			}
		}
		return arrIsInteger;
	}

	
	

	private void start(String Uri){

		//this.data={{""}};
		try{
			List<String> lines = Files.readAllLines(Paths.get(Uri));
			int columas=Integer.parseInt(lines.get(0).split(",")[1]);
			int filas=Integer.parseInt(lines.get(1).split(",")[1]);
			data=new String[filas][];

			lines=lines.subList(2, lines.size());
			for(int i=0;i<lines.size();i++){
				String ln = lines.get(i).replace("\"", "");
				data[i]=lines.get(i).split(",");
			}
			for(int n=0;n<data.length;n++){
				System.out.println(Arrays.toString(data[n]));
			}

		}catch(Exception e){
			System.out.println(e.getMessage());
		}


		boolean [] classify=Clasificar(data);

		double[][]  matrixNum = extractNum(data, classify);
		/*  for(int i=0;i<matrixNum.length;i++){
            System.out.println(Arrays.toString( matrixNum[i]));
        }
        System.out.println();*/
		matrixASCII=extractASCII(data, classify);
		for(int i=0;i<matrixASCII.length;i++){
			for(int j=0;j<matrixASCII[i].length;j++){
				System.out.println(Arrays.toString( matrixASCII[i][j]));
			}
		}
		matrixNumNormalized= NormalizarNum(matrixNum);
		for(int i=0;i<matrixNumNormalized.length;i++){
			System.out.println(Arrays.toString(matrixNumNormalized[i]));
		}
		System.out.println();	
	}
	
	
}