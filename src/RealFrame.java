/*
 * ���α׷� �� : ���� ������
 * ���α׷� �ۼ��� : ����ö, �ڰ��
 * ���α׷� �ۼ��� : 2017/11/24
 * ���α׷� ���� : ��� ȭ���� �����Ǵ�
 * �ǳ��� ������ �ְ�
 * �ǳ��� ������ �������ִ�
 * ���� �������̴�.
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.bcel.generic.GETFIELD;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class RealFrame extends JFrame {

	public static int locationNum = 0;
	public static TakeXml xml = new TakeXml();
	public static JPanel Pane = new JPanel();
	public static Intro into = new Intro();
	public static MainScreen p0 = new MainScreen(xml);
	public static MenuScreen01 p1 = new MenuScreen01(); 
	public static RealCreator cred = new RealCreator();
	public static RealClothes clot = new RealClothes();
	public static JLayeredPane jlp = new JLayeredPane();
    public static WeekOndo p4 =new WeekOndo();
    public static Select_Area p5 = new Select_Area();
    public static Help_Instruction tutoria = new Help_Instruction();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealFrame frame = new RealFrame();
					frame.setVisible(true);
					frame.setSize(1280, 720);
					frame.setTitle("Wearing Weather");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RealFrame() {
		
		Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Pane.setLayout(new BorderLayout(0, 0));
		setContentPane(Pane);
		JFreeChart chart = p4.getChart(xml, 0);
		ChartPanel fr = new ChartPanel(chart);
		add(fr);

		
		Pane.add(into);

		
		
		
		//p1.setLayout(null);
	}

}
