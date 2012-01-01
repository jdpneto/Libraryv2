
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfObserver implements Observer {
    
    ArrayList<Stat> ObserverState;
    Subject s;
    
    PdfObserver(Subject s)
    {
        this.s=s;
    }
    
    private static String FILE = "genre.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet.");
        ObserverState = s.getState();
        try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
                        generateImage();
                        document.add(new Paragraph("Genre Distribution", catFont));
                        //document.addTitle("Genre Distribution");
                        Paragraph stats = new Paragraph();
                        stats.add(new Paragraph(" "));
                        for(Stat stat : ObserverState)
                        {
                            stats.add(new Paragraph("Genre: "+stat.getType()+", Share: "+stat.getValue()+"%;"));
                        }
                        document.add(stats);
                        stats.add(new Paragraph(" "));
                        com.itextpdf.text.Image image;
                        
                        image = com.itextpdf.text.Image.getInstance("image_pfd.png");
                        document.add(image);
                        
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    private void generateImage()
    {
        OutputStream out = null;
        try{
                    PieDataset dataset = createDataset();
            JFreeChart chart = createChart(dataset,"");
            out = new FileOutputStream("image_pfd.png");
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
