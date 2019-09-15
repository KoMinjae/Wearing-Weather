/*
 * ���α׷� �� : ����ũ XML
 * ���α׷� �ۼ��� : ����ö
 * ���α׷� �ۼ��� : 2017/11/24
 * ���α׷� ���� : ���û rss������ ������
 * xml �Ľ��� �����ϴ� ��� Ŭ�����̴�
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.*;
import java.awt.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TakeXml
{
	public int locationNum = 0;
	public String locationName = new String();
	String[] day1 = new String[16];	//���� ���� ��
	String[] temp = new String[16];	//�µ�
	String[] wfEn = new String[16];	//����
	String[] wfKor = new String[16];//���� �ѱ���
	String[] hour1 = new String[16];//�ð�
	String[] pop = new String[16];	//����Ȯ��
	String[] tmx = new String[16];  //���ְ���
	String[] tmn = new String[16];	//���������
	String[] r06 = new String[16];  //6�ð� ������
	
	
	/*			������ ����			*/
	String[] tmEf = new String[14];			//2017-12-10 00:00
	String[] wf = new String[14];			//�������� ��/��
	String[] tmn_w = new String[14];		//�����µ�
	String[] tmx_w = new String[14];		//�ְ�µ�
	
	
	String notConnected = new String("Not Connected"); //���ͳ� ���� �ȵ�������
	public ClockTime clktm = new ClockTime();
	public int hour = clktm.hour;
	public int minute = clktm.minute;
	public int second = clktm.second;
	public int ampm = clktm.dd;

	private boolean FirstBar = false;
	private boolean SecondBar = false;
	
	private int firstK;
	private int lastK;
	
	
	Calendar hourtime = Calendar.getInstance();
	{

	try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilderFactory dbFactory_w = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder parser = dbFactory.newDocumentBuilder();
		DocumentBuilder parser_w = dbFactory_w.newDocumentBuilder();
		
		
		Document xmlDoc = null;
		Document xmlDoc_w = null;
		String[] url = {"http://web.kma.go.kr/wid/queryDFSRSS.jsp?zone=4311259000", //��� û�� ���ŵ�
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174055000", //���� ������ ���1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4276025000",  //���� ��â�� ��â��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2818582000",  //��õ ������ �۵�1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3014053500",  //���� �߱� ���༱ȭ��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4413152000",   //õ�Ƚ� ������ ������
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4711132000",  //�泲 ���׽� ���� ���ر�
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2723067100",   //�뱸 �ϱ� ����1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2623071000",  //�λ� �λ����� ������1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4511358000",   //���� ���ִ����� �ݾ�1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2914074500",  //���ֱ����� ���� ġ��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5011057000",  //���� ���ֽ� ���1��
				"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4794025000"  //��� �︪�� �︪��
		};
		String url_w = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109"; //���� ������ ����
		
		switch(locationNum) {
		case 0:
			locationName = "û��";
			break;
		case 1:
			locationName = "����";
			break;
		case 2:
			locationName = "��â";
			break;
		case 3:
			locationName = "��õ";
			break;
		case 4:
			locationName = "����";
			break;
		case 5:
			locationName = "õ��";
			break;
		case 6:
			locationName = "����";
			break;
		case 7:
			locationName = "�뱸";
			break;
		case 8:
			locationName = "�λ�";
			break;
		case 9:
			locationName = "����";
			break;
		case 10:
			locationName = "����";
			break;
		case 11:
			locationName = "����";
			break;
		case 12:
			locationName = "�︪��";
			break;
		}
		xmlDoc = parser.parse(url[locationNum]);
		xmlDoc_w = parser_w.parse(url_w);
		
		
		Element root = xmlDoc.getDocumentElement();
		Element root_w = xmlDoc_w.getDocumentElement();
		
		for(int i = 0; i < temp.length; i++) {
			Node rootNode = root.getElementsByTagName("data").item(i);
			Node dayNode = ((Element)rootNode).getElementsByTagName("day").item(0);
			Node tempNode = ((Element)rootNode).getElementsByTagName("temp").item(0);
			Node wfEnNode = ((Element)rootNode).getElementsByTagName("wfEn").item(0);
			Node wfKorNode = ((Element)rootNode).getElementsByTagName("wfKor").item(0);
			Node hourNode = ((Element)rootNode).getElementsByTagName("hour").item(0);
			Node popNode = ((Element)rootNode).getElementsByTagName("pop").item(0);
			Node r06Node = ((Element)rootNode).getElementsByTagName("r06").item(0);
			
			day1[i] = dayNode.getTextContent();
			temp[i] = tempNode.getTextContent();
			wfEn[i] = wfEnNode.getTextContent();
			wfKor[i] = wfKorNode.getTextContent();
			pop[i] = popNode.getTextContent();
			hour1[i] = hourNode.getTextContent();
			r06[i] = r06Node.getTextContent();
		}
		try {
		for(int i = 0; i < tmEf.length; i++) {
			Node rootNode = root_w.getElementsByTagName("data").item(i);
			Node tmEfNode = ((Element)rootNode).getElementsByTagName("tmEf").item(0);
			Node wfNode = ((Element)rootNode).getElementsByTagName("wf").item(0);
			Node tmnNode = ((Element)rootNode).getElementsByTagName("tmn").item(0);
			Node tmxNode = ((Element)rootNode).getElementsByTagName("tmx").item(0);
			
			tmEf[i] = tmEfNode.getTextContent();
			wf[i] = wfNode.getTextContent();
			tmn_w[i] = tmnNode.getTextContent();
			tmx_w[i] = tmxNode.getTextContent();
			
			
		}
		}catch(Exception e) {
			System.out.println("Week Not");
		}
		
	}catch(Exception e) {
		System.out.println(notConnected);
		temp[0] = notConnected;
	}
	
    }
	public String getDay(int k) {
		//System.out.println(day1[k]);
		if(day1[k] == "0")
			return "����";
		else if(day1[k] == "1")
			return "����";
		else
			return "��";
	}
	public String[] getR06() {
		return r06;
	}
	public String[] getTemp() {
		return temp;
	}
	public String[] getEn() {
		return wfEn;
	}
	public String[] getHour() {
		return hour1;
	}
	public String[] getPop() {
		return pop;
	}
	public int thisHour() {
		return hourtime.get(Calendar.HOUR_OF_DAY);
	}
	public String[] gethighTemp(){
	    return tmx_w;
	}
	public String[] getlowTemp(){
		return tmn_w;
	}
	
	public void CreateData() {
		try {
			System.out.println("nice");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = dbFactory.newDocumentBuilder();
			
			Document xmlDoc = null;
			String[] url = {"http://web.kma.go.kr/wid/queryDFSRSS.jsp?zone=4311259000", //��� û�� ���ŵ�
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1174055000", //���� ������ ���1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4276025000",  //���� ��â�� ��â��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2818582000",  //��õ ������ �۵�1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3014053500",  //���� �߱� ���༱ȭ��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4413152000",   //õ�Ƚ� ������ ������
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4711132000",  //�泲 ���׽� ���� ���ر�
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2723067100",   //�뱸 �ϱ� ����1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2623071000",  //�λ� �λ����� ������1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4511358000",   //���� ���ִ����� �ݾ�1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2914074500",  //���ֱ����� ���� ġ��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5011057000",  //���� ���ֽ� ���1��
					"http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4794025000"  //��� �︪�� �︪��
			};
			switch(locationNum) {
			case 0:
				locationName = "û��";
				break;
			case 1:
				locationName = "����";
				break;
			case 2:
				locationName = "��â";
				break;
			case 3:
				locationName = "��õ";
				break;
			case 4:
				locationName = "����";
				break;
			case 5:
				locationName = "õ��";
				break;
			case 6:
				locationName = "����";
				break;
			case 7:
				locationName = "�뱸";
				break;
			case 8:
				locationName = "�λ�";
				break;
			case 9:
				locationName = "����";
				break;
			case 10:
				locationName = "����";
				break;
			case 11:
				locationName = "����";
				break;
			case 12:
				locationName = "�︪��";
				break;
			}
			xmlDoc = parser.parse(url[locationNum]);
			
			Element root = xmlDoc.getDocumentElement();
			for(int i = 0; i < temp.length; i++) {
				Node rootNode = root.getElementsByTagName("data").item(i);
				Node dayNode = ((Element)rootNode).getElementsByTagName("day").item(0);
				Node tempNode = ((Element)rootNode).getElementsByTagName("temp").item(0);
				Node wfEnNode = ((Element)rootNode).getElementsByTagName("wfEn").item(0);
				Node wfKorNode = ((Element)rootNode).getElementsByTagName("wfKor").item(0);
				Node hourNode = ((Element)rootNode).getElementsByTagName("hour").item(0);
				Node popNode = ((Element)rootNode).getElementsByTagName("pop").item(0);
				Node r06Node = ((Element)rootNode).getElementsByTagName("r06").item(0);
				
				day1[i] = dayNode.getTextContent();
				temp[i] = tempNode.getTextContent();
				wfEn[i] = wfEnNode.getTextContent();
				wfKor[i] = wfKorNode.getTextContent();
				pop[i] = popNode.getTextContent();
				hour1[i] = hourNode.getTextContent();
				r06[i] = r06Node.getTextContent();
			}
		}catch(Exception e) {System.out.println("Error!");}
	}
	
	public void SetLocation(int num) {
		locationNum = num;
		CreateData();
	}
}
