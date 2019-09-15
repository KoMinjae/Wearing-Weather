/*
 * ���α׷� �� : ���� ��ũ��
 * ���α׷� �ۼ��� : ����ö, �ֽ���
 * ���α׷� �ۼ��� : 2017/11/24
 * ���α׷� ���� : �� ���α׷��� ����ȭ������
 * ���� ����, �ְ� ����, �ڷΰ���, ��õ ������, ����������
 * �� �� �ִ� ��ư�� �ִ�
 * ���� ���� ��ư���� ������ ������ �ٷ� ��µȴ�.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainScreen extends JPanel {
	
	public JLabel todayDate;
	public JLabel locationLabel;
	public JLabel Temperate;
	public JLabel gangsu;
	public JLabel DAYOFYEAR;
	
	public JLabel NALSI;
	public JButton todayButton;
	public ImageIcon today;
	public Listener bread;
	public static WeekOndo p4 = new WeekOndo();
	public static String[] todayTemp = new String[16];
	
	public MainScreen(TakeXml xml) {
		setBackground(Color.white);
		
		ImageIcon back = new ImageIcon("res/backButton.png");
		
		ImageIcon loc = new ImageIcon("res/locationButton.png");
		
		ImageIcon week = new ImageIcon("res/weekButton.png");
		
		ImageIcon recommend = new ImageIcon("res/recommendButton.png");
		
		setBounds(0, 0, 1264, 682);
		setLayout(null);
		
		
		/********************		�ϰ����� �̹���		***********************/
		
		if(xml.wfEn[0].equals("Cloudy"))
			today = new ImageIcon("res/cloudy.gif");
		else if(xml.wfEn[0].equals("Clearly"))
			today = new ImageIcon("res/clearly.gif");
		else if(xml.wfEn[0].equals("Rainy"))
			today = new ImageIcon("res/Rain.gif");
		else if(xml.wfEn[0].equals("Snow"))
			today = new ImageIcon("res/snow.gif");
		else if(xml.wfEn[0].equals("Mostly Cloudy"))
			today = new ImageIcon("res/mostlycloudy.gif");
		else if(xml.wfEn[0].equals("Partly Cloudy"))
			today = new ImageIcon("res/PartlyCloudy.gif");
		else if(xml.wfEn[0].equals("Snow/Rain"))
        	RealFrame.p0.today = new ImageIcon("res/snow.gif");
		else
			today = new ImageIcon("res/clearly.gif");
		System.out.println(xml.wfEn[0]);
		System.out.println(today);
		todayButton = new JButton(today);
		add(todayButton);
		todayButton.setBounds(0, 32, 1000, 468);
		todayButton.setIcon(today);
		
		
		/********************		�ϰ�����		***********************/
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		todayButton.add(panel);
		todayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               String CuWeather=RealFrame.xml.wfKor[0]; //���糯��
                ImageIcon snow = new ImageIcon("res/snow.gif");
                ImageIcon clearly = new ImageIcon("res/clearly.gif");
                ImageIcon snowrain = new ImageIcon("res/snowrain.gif");
                ImageIcon cloudy = new ImageIcon("res/cloudy.gif");
                ImageIcon mostlycloudy = new ImageIcon("res/mostlycloudy.gif");
                ImageIcon rain = new ImageIcon("res/rain.gif");
                ImageIcon PartlyCloudy = new ImageIcon("res/PartlyCloudy.gif");
                
                   
                JPanel Panel1 = new JPanel();
               JFreeChart chart = p4.getChart(xml,0);
                ChartPanel fr = new ChartPanel(chart);
                System.out.println(CuWeather);
                if(CuWeather.equals("����"))
                chart.getPlot().setBackgroundImage(clearly.getImage());
              
                else if(CuWeather.equals("��"))
                   chart.getPlot().setBackgroundImage(snow.getImage());
            
                else if(CuWeather.equals("��/��"))
                   chart.getPlot().setBackgroundImage(snowrain.getImage());

                else if(CuWeather.equals("�帲"))
                   chart.getPlot().setBackgroundImage(cloudy.getImage());
            
                else if(CuWeather.equals("��"))
                   chart.getPlot().setBackgroundImage(rain.getImage());
                 
                else if(CuWeather.equals("���� ����"))
                   chart.getPlot().setBackgroundImage(PartlyCloudy.getImage());
                
                else  if(CuWeather.equals("���� ����"))
                   chart.getPlot().setBackgroundImage(mostlycloudy.getImage());
                  
               fr.setSize(1280,720);
               fr.setLayout(null);
               JButton on = new JButton(new ImageIcon("res/backbu.png"));
            
               on.setBounds(1162, 590, 75, 75);
               fr.add(on);
               
                on.addMouseListener(new MouseAdapter() {
                     public void mousePressed(MouseEvent e) {
                        RealFrame.Pane.removeAll();
                        RealFrame.Pane.repaint();
                        RealFrame.Pane.revalidate();
                        RealFrame.Pane.add(RealFrame.p0);
                        RealFrame.Pane.repaint();
                        RealFrame.Pane.revalidate();
                     }
                  });
               
               
               RealFrame.Pane.removeAll();
               RealFrame.Pane.repaint();
               RealFrame.Pane.revalidate();
               RealFrame.Pane.add(fr);
               RealFrame.Pane.repaint();
               RealFrame.Pane.revalidate();
               
         
            }
         });
		
		panel.setLayout(null);
		panel.setBackground(new Color(255, 0, 0, 0));
		
		//������
		
		JLabel How = new JLabel("���� ���");
		How.setForeground(Color.BLACK);
		How.setBounds(40, 168, 87, 27);
		panel.add(How);
		How.setFont(new Font("���� ���", Font.PLAIN, 20));
		
		
		/********************		�ڷΰ���		***********************/
		JButton backButton = new JButton(back);
		backButton.setBounds(1000, 32, 266, 218);
		add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				  JFreeChart chart = p4.getChart(xml,0);

				RealFrame.Pane.removeAll();
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
				RealFrame.Pane.add(RealFrame.p1);
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
				
			}
		});
		
		
		
		/********************		��������		***********************/
		JPanel locationpanel = new JPanel();
		locationpanel.setBounds(0, 0, 0, 0);
		
		JButton locationButton = new JButton(loc);
		locationButton.setBounds(1000, 250, 280, 250);
		add(locationButton);
		//Font font=new Font("HY����M",Font.PLAIN,22);
		locationButton.add(locationpanel);
		locationpanel.setLayout(null);
		locationpanel.setBackground(new Color(255, 0, 0, 0));
		
		locationLabel = new JLabel(xml.locationName);
		locationLabel.setFont(new Font("HY����M", Font.PLAIN, 28));
		locationLabel.setBounds(12, 20, 224, 29);
		locationLabel.setHorizontalAlignment(JLabel.CENTER);
		locationpanel.add(locationLabel);
		
		locationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RealFrame.Pane.removeAll();
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
				RealFrame.Pane.add(RealFrame.p5);
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
				
			}
		});
		
		//�ְ� ���� ��ư
		JButton weekButton = new JButton(week);
        weekButton.setBounds(0, 500, 640, 182);
        add(weekButton);
        weekButton.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
                  String CuWeather=RealFrame.xml.wfKor[0]; //���糯��
                  ImageIcon snow = new ImageIcon("res/snow.gif");
                  ImageIcon clearly = new ImageIcon("res/clearly.gif");
                  ImageIcon snowrain = new ImageIcon("res/snowrain.gif");
                  ImageIcon cloudy = new ImageIcon("res/cloudy.gif");
                  ImageIcon mostlycloudy = new ImageIcon("res/mostlycloudy.gif");
                  ImageIcon rain = new ImageIcon("res/rain.gif");
                  ImageIcon PartlyCloudy = new ImageIcon("res/PartlyCloudy.gif");
               
                  
                  JPanel Panel1 = new JPanel();
                 
                  
              JFreeChart chart = p4.getChart(xml,1);
               ChartPanel fr = new ChartPanel(chart);
               System.out.println(CuWeather);
               
               if(CuWeather.equals("����"))
               chart.getPlot().setBackgroundImage(clearly.getImage());
             
               else if(CuWeather.equals("��"))
                  chart.getPlot().setBackgroundImage(snow.getImage());
           
               else if(CuWeather.equals("��/��"))
                  chart.getPlot().setBackgroundImage(snowrain.getImage());

               else if(CuWeather.equals("�帲"))
                  chart.getPlot().setBackgroundImage(cloudy.getImage());
           
               else if(CuWeather.equals("��"))
                  chart.getPlot().setBackgroundImage(rain.getImage());
                
               else if(CuWeather.equals("���� ����"))
                  chart.getPlot().setBackgroundImage(PartlyCloudy.getImage());
               
               else  if(CuWeather.equals("���� ����"))
                  chart.getPlot().setBackgroundImage(mostlycloudy.getImage());
                 
              fr.setSize(1280,720);
              fr.setLayout(null);
              JButton on = new JButton(new ImageIcon("res/backbu.png"));
           
              on.setBounds(1162, 590, 75, 75);
              fr.add(on);
              
               on.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                       RealFrame.Pane.removeAll();
                       RealFrame.Pane.repaint();
                       RealFrame.Pane.revalidate();
                       RealFrame.Pane.add(RealFrame.p0);
                       RealFrame.Pane.repaint();
                       RealFrame.Pane.revalidate();
                    }
                 });
              
              
              RealFrame.Pane.removeAll();
              RealFrame.Pane.repaint();
              RealFrame.Pane.revalidate();
              RealFrame.Pane.add(fr);
              RealFrame.Pane.repaint();
              RealFrame.Pane.revalidate();
              
        
           }
        });
		
        
        
        /********************		��õ������		***********************/
		JButton recommendButton = new JButton(recommend);
		recommendButton.setBounds(640, 500, 624, 182);
		add(recommendButton);
		recommendButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				RealFrame.Pane.removeAll();
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
				RealFrame.Pane.add(RealFrame.clot);
				RealFrame.Pane.repaint();
				RealFrame.Pane.revalidate();
			}
		});
		
		try {
			System.out.println(todayTemp);
			todayTemp=xml.getTemp();
			Temperate = new JLabel(todayTemp[0]);
			Temperate.setBounds(40, 197, 650, 76);
			panel.add(Temperate);
			Temperate.setText(todayTemp[0]);
			Temperate.setFont(new Font("HY����M", Font.PLAIN, 67));
			
			JLabel lblNewLabel = new JLabel("\uB0A0\uC528");
			lblNewLabel.setFont(new Font("HY����M", Font.PLAIN, 20));
			lblNewLabel.setBounds(40, 89, 105, 27);
			panel.add(lblNewLabel);
			
			NALSI = new JLabel();
			panel.add(NALSI);
			NALSI.setFont(new Font("HY����M", Font.PLAIN, 30));
			NALSI.setBounds(40, 104, 249, 69);
			NALSI.setText(xml.wfKor[0]);
			
			
			gangsu = new JLabel("\uAC15\uC218\uD655\uB960");
			gangsu.setBounds(40, 290, 87, 15);
			gangsu.setText("����Ȯ�� : " + RealFrame.xml.pop[0] + "%");
			gangsu.setFont(new Font("HY����M", Font.PLAIN, 12));
			panel.add(gangsu);
			
			Timer t = new Timer(1000, bread = new Listener());
			t.start();
			DAYOFYEAR = new JLabel("");
			DAYOFYEAR.setFont(new Font("HY����M", Font.PLAIN, 16));
			DAYOFYEAR.setBounds(0, 0, 379, 33);
			add(DAYOFYEAR);
			todayDate = new JLabel();
			todayDate.setBounds(138, 0, 300, 33);
			add(todayDate);
			todayDate.setFont(new Font("HY����M", Font.PLAIN, 16));
			
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
}
