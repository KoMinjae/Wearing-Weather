/*
 * /*
 * ���α׷� �� : ���� ũ����
 * ���α׷� �ۼ��� : �����, �ڰ��
 * ���α׷� �ۼ��� : 2017/11/24
 * ���α׷� ���� : ���α׷� �����ڸ�
 * ȭ�鿡 �����ش�
 */

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class RealCreator extends JPanel {

   /**
    * Create the panel.
    */
   public RealCreator() {
	   setBackground(Color.white);
      setLayout(null);
      ImageIcon minjae = new ImageIcon("res/�����.png");
      ImageIcon mc = new ImageIcon("res/����ö.png");
      ImageIcon gm = new ImageIcon("res/�ֽ���.png");
      ImageIcon sj = new ImageIcon("res/�ڰ��.png");
      JLabel man1 = new JLabel(minjae);
      
      JButton btnNewButton = new JButton();
      btnNewButton.setIcon(new ImageIcon("res/back.png"));
      btnNewButton.setBounds(1058, 564, 200, 100);
      add(btnNewButton);
      btnNewButton.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            RealFrame.Pane.removeAll();
            RealFrame.Pane.repaint();
            RealFrame.Pane.revalidate();
            RealFrame.Pane.add(RealFrame.p1);
            RealFrame.Pane.repaint();
            RealFrame.Pane.revalidate();
         }
      });
      
      
      JLabel lblNewLabel = new JLabel(minjae);
      lblNewLabel.setBounds(0, 0, 1258, 141);
      add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel(mc);
      lblNewLabel_1.setBounds(0, 141, 1258, 141);
      add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel(gm);
      lblNewLabel_2.setBounds(0, 282, 1258, 141);
      add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel(sj);
      lblNewLabel_3.setBounds(0, 423, 1258, 141);
      add(lblNewLabel_3);

   }
}