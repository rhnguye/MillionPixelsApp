package model; 

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    int pixelsPurchased = 323482;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
         
        return model;
    }
     
    private void createBarModels() {
//        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries bought = new ChartSeries();
        bought.setLabel("Meals Bought");
        bought.set("\n", pixelsPurchased);
        
        ChartSeries remaining = new ChartSeries();
        remaining.setLabel("Meals Remaining");
        remaining.set("\n", 1000000-pixelsPurchased);
        
        horizontalBarModel.addSeries(bought);
        horizontalBarModel.addSeries(remaining);
        DecimalFormat df2 = new DecimalFormat(".##");
        double temp = ((double)pixelsPurchased/1000000)*100;
        horizontalBarModel.setTitle("One Million Meal Plan (" + df2.format(temp) +"% Complete )");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Meals Purchased (22 cents per meal.)");
        xAxis.setMin(0);
        xAxis.setMax(1000000);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
       // yAxis.setLabel("Year");        
    }
 
}