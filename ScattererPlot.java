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
	  
    
  /*  XYSeries series01234 = new XYSeries("Cluster 3-4");
    series01234.add(1, 45);
    series01234.add(2, 21);
    series01234.add(2, 36);
    series01234.add(4, 48);
    series01234.add(5, 55);
    dataset.addSeries(series01234);*/

    return dataset;
  }

  public static void plot(String string,ArrayList<? extends Cluster> clust ) {
    SwingUtilities.invokeLater(() -> {
      ScattererPlot example = new ScattererPlot("Scatter Chart Example", clust);
      example.setSize(1000, 600);
      example.setLocationRelativeTo(null);
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      example.setVisible(true);
    });
  }
  
}