import java.awt.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;

import org.jfree.chart.renderer.category.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.*;
 

public class WeekOndo {
 
    public JFreeChart getChart(TakeXml xml,int weatherflag) {
       
    
        // ������ ���� 
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();   // �ְ�
        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();   // ����
        // ������ �Է� ( ��, ����, ī�װ� )
        if(weatherflag==0){ // �ϰ������� 
           double[] todaytemp = new double[8];
           String[] todayhour = new String[8];
           for(int i=0;i<8;i++){
           todaytemp[i] =Double.parseDouble(xml.getTemp()[i]);
           todayhour[i] = xml.getHour()[i];
        
           }
        // �׷��� 3       
           for(int  j=0;j<8;j++)
              dataset2.addValue(todaytemp[j], "T1",todayhour[j]+"��");
        }
        
        else if(weatherflag==1){ // �ְ������� 
           int k=0;
           double[] weekhightemp = new double[7];
           double[] weeklowtemp = new double[7];
           int day=RealFrame.p0.bread.day;
           for(int i=0;i<7;i++){
           weekhightemp[i] =Double.parseDouble(xml.gethighTemp()[k]);
           weeklowtemp[i] =Double.parseDouble(xml.getlowTemp()[k]);
           k=k+2;
             }
           
           for(int  j=0;j<7;j++)
              dataset2.addValue(weekhightemp[j], "T1",(day+j)+"��");
           for(int  j=0;j<7;j++)
              dataset3.addValue(weeklowtemp[j], "T2",(day+j)+"��");
      
        }
        
        // ������ ���� �� ����
        // ������ ����
     
        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();//�ְ�
        final LineAndShapeRenderer renderer3 = new LineAndShapeRenderer();//����
       
        // ���� �ɼ� ����
        final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();
        final ItemLabelPosition p_center = new ItemLabelPosition(
                ItemLabelAnchor.CENTER, TextAnchor.CENTER
            );
        final ItemLabelPosition p_below = new ItemLabelPosition(
                     ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_LEFT
                     );
        Font f = new Font("Gulim", Font.BOLD, 14);
        Font axisF = new Font("Gulim", Font.PLAIN, 14);
       
        // ������ ����
        // �׷��� 3       
        renderer2.setBaseItemLabelGenerator(generator);
        renderer2.setBaseItemLabelsVisible(true);
        renderer2.setBaseShapesVisible(true);
        renderer2.setDrawOutlines(true);
        renderer2.setUseFillPaint(true);
        renderer2.setBaseFillPaint(Color.red);
        renderer2.setBaseItemLabelFont(f);
        renderer2.setBasePositiveItemLabelPosition(p_below);
        renderer2.setSeriesPaint(0,new Color(100,10,10));
        renderer2.setSeriesStroke(0,new BasicStroke(
                                               2.0f,
                                               BasicStroke.CAP_ROUND,
                                               BasicStroke.JOIN_ROUND,
                                               3.0f)
        );
        
        renderer3.setBaseItemLabelGenerator(generator);
        renderer3.setBaseItemLabelsVisible(true);
        renderer3.setBaseShapesVisible(true);
        renderer3.setDrawOutlines(true);
        renderer3.setUseFillPaint(true);
        renderer3.setBaseFillPaint(Color.blue);
        renderer3.setBaseItemLabelFont(f);
        renderer3.setBasePositiveItemLabelPosition(p_below);
        renderer3.setSeriesPaint(0,new Color(144,229,119));
        
        renderer3.setSeriesStroke(0,new BasicStroke(
                                               2.0f,
                                               BasicStroke.CAP_ROUND,
                                               BasicStroke.JOIN_ROUND,
                                               3.0f)
        );
       
        // plot ����
        final CategoryPlot plot = new CategoryPlot();
       
        // plot �� ������ ����
        plot.setDataset(2, dataset2);
        plot.setRenderer(2, renderer2);
        plot.setDataset(3, dataset3);
        plot.setRenderer(3, renderer3);

        // plot �⺻ ����
        plot.setOrientation(PlotOrientation.VERTICAL);       // �׷��� ǥ�� ����
        plot.setRangeGridlinesVisible(true);                         // X�� ���̵� ���� ǥ�ÿ���
        plot.setDomainGridlinesVisible(true);                      // Y�� ���̵� ���� ǥ�ÿ���
 
        // ������ ���� ���� : dataset ��� ������� ������ ( ��, ���� ����Ѱ� �Ʒ��� �� )
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
       
        // X�� ����
        plot.setDomainAxis(new CategoryAxis());           // X�� ���� ����
        plot.getDomainAxis().setTickLabelFont(axisF); // X�� ���ݶ� ��Ʈ ����
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD);       // ī�װ� �� ��ġ ����
 
        // Y�� ����
        plot.setRangeAxis(new NumberAxis());              // Y�� ���� ����
        plot.getRangeAxis().setTickLabelFont(axisF);  // Y�� ���ݶ� ��Ʈ ����
        
        final JFreeChart chart = new JFreeChart(plot);
        // ���õ� plot�� �������� chart ����'
        if(weatherflag==0){ //�ϰ�������
           String CuWeather=xml.wfKor[0];
           chart.setTitle("�ϰ� ����( "+CuWeather+" )" );
        }
   
        if(weatherflag==1){ //�ְ�������
           String CuWeather=xml.wfKor[0];
           chart.setTitle("�ְ� ���� (T1=�ְ��� , T2=�������)" );
        }
        
        return chart;
    }
}