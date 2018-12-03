package Clustering;

public enum TipoD{
	/** Esta enumeraci�n describe los tipos de distancia
	 * Que pueden ser utilizados para los algoritmos de clustering
	 * @author: Castillo Pulido Ethandrake, Anah� Santana Hern�ndez, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
    EUCLIDIAN("Distancia Euclidiana"),
    /** La distancia euclidiana o eucl�dea es la distancia "ordinaria" entre dos puntos de un espacio eucl�deo,
     *  la cual se deduce a partir del teorema de Pit�goras.
     */ 
    MANHATTAN("Distancia Manhatan"),
    /** La distancia Manhattan entre dos puntos se calcula como la longitud de cualquier camino que los una mediante
     *  segmentos verticales y horizontales.
     */ 
    PEARSON_CORRELATION("Perason correlation"),
    /**El coeficiente de correlaci�n de Pearson es una medida lineal entre dos variables aleatorias cuantitativas, 
     * es independiente de la escala de medida de las variables.
     */ 
    EISEN_COSINE_CORRELATION("Eisen cosine correlation"),
    /**Es un caso especial de relacion de Pearson donde X_ y Y_ son igules a 0
     */ 
    SPEARMAN_CORRELATION("Spearman correlation");
	/** Es una medida de la correlaci�n.
	 * Oscila entre -1 y +1, indic�ndonos asociaciones negativas o positivas.
     */ 
	
	private final String nombreDistancia;
	private TipoD(String tipo) {	this.nombreDistancia=tipo;	}
	public String toString() { return this.nombreDistancia; }
    /** Imprime el tipo de distancia
     */
}