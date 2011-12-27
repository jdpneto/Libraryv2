
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class ImageObserver implements Observer {
    ArrayList<Stat> ObserverState;
    @Override
    public void update(Subject s) {
        OutputStream out = null;
        try {
            this.ObserverState = s.getState();
            PieDataset dataset = createDataset();
            JFreeChart chart = createChart(dataset,"Genre Distribution");
            out = new FileOutputStream("genre.png");
            ChartUtilities.writeChartAsJPEG(out, chart, 500, 270);
        } catch (IOException ex) {
            //Logger.getLogger(ImageObserver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                //Logger.getLogger(ImageObserver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for(Stat s : ObserverState)
            result.setValue(s.getType(), s.getValue());
        return result;
        
    }
    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(
            title,  				// chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
}
