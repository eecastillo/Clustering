import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ScattererPlot extends JFrame {
	/** Esta clase crea las gráficas de los clusters
	 * @author: Castillo Pulido Ethandrake, Anahí Santana Hernández, Ricardo Cuevas Rosas
	 * @version: 21/11/2018
	 */
	
  private static final long serialVersionUID = 6294689542092367723L;

  public ScattererPlot(String title, ArrayList<? extends Cluster> clust ) {
    super(title);

    // Create dataset
    XYDataset dataset = createDataset(clust);
    // Create chart
    JFreeChart chart = ChartFactory.createScatterPlot(
        "Clustering Data", 
        "X-Axis", "Y-Axis", dataset);

    //Changes background color
    XYPlot plot = (XYPlot)chart.getPlot();
    plot.setBackgroundPaint(Color.DARK_GRAY);
    
    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }
  /** Crea todo lo que se necesita para hacer una gráfica
   * @param: clust un ArrayList de objetos que extienden a Cluster, 
   * title un String que será el nombre de la gráfica
  */

  public XYDataset createDataset(ArrayList<? extends Cluster> clust) {  
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries[] seriesCluster=new XYSeries[clust.size()];
   
    for(int i=0;i<clust.size();i++) {
    	String iterador= "cluster " + i;
    	seriesCluster[i]= new XYSeries(iterador);

    	for(int j=0;j<clust.get(i).size;j++) {
    		seriesCluster[i].add(clust.get(i).elements[j].getNumeros()[0] ,clust.get(i).elements[j].getNumeros()[1] );
    	}
    	dataset.addSeries(seriesCluster[i]);
    }
    return dataset;
  }
  /** Crea una serie de datos en XY
   * para poder gráficarlos
   * @param: clust un ArrayList de objetos que extienden a Cluster
   * @return: XYDataset
  */

  public static void plot(String string,ArrayList<? extends Cluster> clust ) {
    SwingUtilities.invokeLater(() -> {
      ScattererPlot example = new ScattererPlot("Aprupacion de los clusters", clust);
      example.setSize(1000, 600);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
  /** Crea la gráfica
   * en una ventana nueva
   * @param: clust un ArrayList de objetos que extienden a Cluster
  */
  
}