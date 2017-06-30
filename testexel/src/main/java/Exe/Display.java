package Exe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Sano on 21.06.2017.
 */
public class Display extends JFrame implements ActionListener {

	private int Hieght = 600;
	private int Width = 600;
	private JButton buttonSend;
	private JButton buttonPrint;
	private JTextField textFieldName;
	private JTextField textFieldAge;
	private JTextField textFieldPhone;
	private static JLabel panel;
	private static JTextArea textArea;
	private JScrollPane scrollPane;

	private ExelWorker exelWorker;

	String file = "C:\\Users\\Sano\\Desktop\\myExel.xlsx";

	public Display() throws IOException {
		setTitle("Exel Test");
		setSize(new Dimension(Width, Hieght));
		setLayout(null);

		buttonSend = new JButton("Send");
		buttonSend.setBounds(240, 200, 80, 60);
		buttonSend.addActionListener(this);

		buttonPrint = new JButton("Print");
		buttonPrint.setBounds(100, 200, 80, 60);
		buttonPrint.addActionListener(this);

		textFieldName = new JTextField();
		textFieldAge = new JTextField();
		textFieldPhone = new JTextField();

		textArea = new JTextArea(30,4);
		textArea.setBounds(40,300,500,150);
		textArea.setText("ID"+"    "+"Name"+"   "+"Age"+"   "+"Code"+"\n");

		scrollPane=new JScrollPane(textArea);
		//scrollPane.setBounds(540,300,20,150);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		textFieldName.setBounds(50, 50, 150, 40);
		textFieldAge.setBounds(210, 50, 150, 40);
		textFieldPhone.setBounds(370, 50, 150, 40);

		panel = new JLabel();
		panel.setBounds(330, 200, 200, 20);
		panel.setText("Enter and press");

		exelWorker = new ExelWorker(file);
		//exelWorker.redAndPrintExel();




		add(textFieldName);
		add(textFieldAge);
		add(textFieldPhone);
		add(buttonSend);
		add(buttonPrint);
		add(panel);
		add(textArea);
		add(scrollPane);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Name", 80, 80);
		g.drawString("Age", 240, 80);
		g.drawString("Code", 400, 80);
	}

	public void actionPerformed(ActionEvent e) {
		String name = "";
		int age = 0;
		int phone = 0;
		if (e.getSource() == buttonSend) {
			name = textFieldName.getText();
			age = Integer.parseInt(textFieldAge.getText());
			phone = Integer.parseInt(textFieldPhone.getText());
			try {
				exelWorker.writeExel(name, age, phone);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			if (!exelWorker.nameFound) {
				textFieldName.setText("");
			} else {
				textFieldName.setText("");
				textFieldAge.setText("");
				textFieldPhone.setText("");
			}
		}

		if(e.getSource()==buttonPrint){
			try {
				exelWorker.redAndPrintExel();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void setPanelText(String text) {
		panel.setText(text);
	}

	public static   void setAreaText(int ID,String name,int age,int code) {
		String p="   ";
		textArea.append((ID+" ")+p+name+p+(age+" ")+p+(code+" ")+"\t"+"\n");


	}
}
