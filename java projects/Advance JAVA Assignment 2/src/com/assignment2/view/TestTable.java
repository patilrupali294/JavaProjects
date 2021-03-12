package com.assignment2.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.assignment2.Model.GraphClass;

/**
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class TestTable extends JFrame implements ActionListener {

	/**
	 * Instance of graph class
	 */
	private GraphClass g;
	/**
	 * Instance variables of the class
	 * 
	 */
	public double[] values = new double[] { 0, 0, 0, 0, 0 };
	public String[] labels = new String[] { "CAR 1", "CAR 2", "CAR 3", "CAR 4", "CAR 5" };
	public Color[] colors = new Color[] { Color.red, Color.orange, Color.yellow, Color.green, Color.blue };
	private String title = "GRAPH!";
	/**
	 * Date format in hour minutes and seconds
	 */
	DateFormat dateformat = new SimpleDateFormat("hh:mm:ss");
	/**
	 * Date format in days months and year
	 */
	DateFormat dateformat1 = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * This is an instance of JPanel
	 */
	private JPanel mousePanel;
	private JPanel graphPanel;
	/**
	 * Instance of JTable
	 */
	private JTable table;
	/**
	 * Instance of JButton
	 */
	private JButton buttonToSave;
	/**
	 * Instance of JScrollPane
	 */
	private JScrollPane scroll;
	private JScrollPane scroll1;
	private JPanel controlTable;
	/**
	 * This is an instance od JLabel
	 */
	private JLabel FinalScore;
	ImageIcon i;

	// Coloumns for the table
	String[] columns = new String[] { "Car Number", "Count", "Date", "Car Clciked At Time", "Program Track Reccord",
			"Track Date", "Crash Occured At Time", "Rating" };

	// Data for the table
	Object[][] data = new Object[][] { { 1, 0, "0", "0", 0, 0, 0, i }, { 2, 0, "0", "0", 0, 0, 0, i },
			{ 3, 0, "0", "0", 0, 0, 0, i }, { 4, 0, "0", "0", 0, 0, 0, i }, { 5, 0, "0", "0", 0, 0, 0, i } };
	private BufferedWriter writer;
	private FileWriter fileWriter;

	public void createGUI() {
		System.out.println("t");
		super.setSize(700, 1500);
		mousePanel = new JPanel();
		controlTable = new JPanel();
		graphPanel = new JPanel();
		buttonToSave = new JButton("save");
		FinalScore = new JLabel();
		// FinalScore.setText(getScore());
		/**
		 * @author peeskillet Reference: stackoverflow.com
		 */
		DefaultTableModel model = new DefaultTableModel(data, columns) {
			@Override
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
				case 1:
					return Integer.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return ImageIcon.class;
				default:
					return Object.class;
				}
			}
		};

		table = new JTable(model);
		table.setRowHeight(0, 20);
		table.setRowHeight(1, 20);
		table.setRowHeight(2, 20);
		table.setRowHeight(3, 20);
		table.setRowHeight(4, 20);
		table.setRowHeight(5, 20);
		g = new GraphClass(values, labels, colors, title);
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(900, 300));
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		controlTable.add(scroll);

		scroll1 = new JScrollPane(g);
		scroll1.setPreferredSize(new Dimension(900, 600));
		scroll1.setAlignmentX(Component.CENTER_ALIGNMENT);
		graphPanel.add(scroll1);

		add(controlTable, BorderLayout.NORTH);
		add(mousePanel, BorderLayout.PAGE_END);
		add(graphPanel, BorderLayout.CENTER);
		mousePanel.add(buttonToSave);
		mousePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		mousePanel.add(FinalScore);
		mousePanel.add(Box.createRigidArea(new Dimension(10, 5)));
		setTitle("Final Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		buttonToSave.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object buttonValue = e.getActionCommand();
		System.out.println(e);
		if (buttonValue.equals("save")) {

			try {
				/**
				 * This method uses DOM to create the contents from the table to
				 * an XML file Referred:
				 * Referred:http://www.mkyong.com/java/how-to-create-xml-file-in-java-dom/
				 */
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("GAME");
				doc.appendChild(rootElement);

				// set attribute to staff element 1
				Element staff = doc.createElement("NUMBER");
				rootElement.appendChild(staff);
				String number = Integer.toString((int) data[0][0]);
				String countnumber = Integer.toString((int) data[0][1]);
				String dateofcar = (String) data[0][2];
				String timeofcar = (String) data[0][3];
				Attr attr = doc.createAttribute("id");
				attr.setValue(number);
				staff.setAttributeNode(attr);
				// first elements
				Element firstname = doc.createElement("Count");
				firstname.appendChild(doc.createTextNode(countnumber));
				staff.appendChild(firstname);

				// CHECK FOR DATE AND TIME
				if ((dateofcar.equals(0)) && (timeofcar.equals(0))) {
					dateofcar = "0";
					timeofcar = "0";
				} else {
					dateofcar = (String) data[0][2];
					timeofcar = (String) data[0][3];
				}

				// second element for staff
				Element date = doc.createElement("Date");
				date.appendChild(doc.createTextNode(dateofcar));
				staff.appendChild(date);
				// Third element for staff
				Element time = doc.createElement("Time");
				time.appendChild(doc.createTextNode(timeofcar));
				staff.appendChild(time);

				// set attribute to staff element 2
				Element staff1 = doc.createElement("NUMBER");
				rootElement.appendChild(staff1);
				String number1 = Integer.toString((int) data[1][0]);
				String countnumber1 = Integer.toString((int) data[1][1]);
				Attr attr1 = doc.createAttribute("id");
				attr1.setValue(number1);
				staff1.setAttributeNode(attr1);
				// first elements
				Element firstname1 = doc.createElement("Count");
				firstname1.appendChild(doc.createTextNode(countnumber1));
				staff1.appendChild(firstname1);
				String dateofcar1 = (String) data[1][2];
				String timeofcar1 = (String) data[1][3];
				// CHECK FOR DATE AND TIME
				if ((dateofcar1.equals(0)) && (timeofcar1.equals(0))) {
					dateofcar1 = "0";
					timeofcar1 = "0";
				} else {
					dateofcar1 = (String) data[1][2];
					timeofcar1 = (String) data[1][3];
				}
				// second element
				Element date1 = doc.createElement("Date");
				date1.appendChild(doc.createTextNode(dateofcar1));
				staff1.appendChild(date1);
				// Third element
				Element time1 = doc.createElement("Time");
				time1.appendChild(doc.createTextNode(timeofcar1));
				staff1.appendChild(time1);

				// set attribute to staff element 3
				Element staff2 = doc.createElement("NUMBER");
				rootElement.appendChild(staff2);
				String number2 = Integer.toString((int) data[2][0]);
				String countnumber2 = Integer.toString((int) data[2][1]);
				String dateofcar2 = (String) data[2][2];
				String timeofcar2 = (String) data[2][3];
				Attr attr2 = doc.createAttribute("id");
				attr2.setValue(number2);
				staff2.setAttributeNode(attr2);
				// first elements
				Element firstname2 = doc.createElement("Count");
				firstname2.appendChild(doc.createTextNode(countnumber2));
				staff2.appendChild(firstname2);

				// CHECK FOR DATE AND TIME
				if ((dateofcar2.equals(0)) && (timeofcar2.equals(0))) {
					dateofcar2 = "0";
					timeofcar2 = "0";
				} else {
					dateofcar2 = (String) data[2][2];
					timeofcar2 = (String) data[2][3];
				}
				// second element
				Element date2 = doc.createElement("Date");
				date2.appendChild(doc.createTextNode(dateofcar2));
				staff2.appendChild(date2);
				// Third element
				Element time2 = doc.createElement("Time");
				time2.appendChild(doc.createTextNode(timeofcar2));
				staff2.appendChild(time2);

				// set attribute to staff element 4
				Element staff3 = doc.createElement("NUMBER");
				rootElement.appendChild(staff3);
				String number3 = Integer.toString((int) data[3][0]);
				String countnumber3 = Integer.toString((int) data[3][1]);
				String dateofcar3 = (String) data[3][2];
				String timeofcar3 = (String) data[3][3];
				Attr attr3 = doc.createAttribute("id");
				attr3.setValue(number3);
				staff3.setAttributeNode(attr3);
				// first elements
				Element firstname3 = doc.createElement("Count");
				firstname3.appendChild(doc.createTextNode(countnumber3));
				staff3.appendChild(firstname3);

				// CHECK FOR DATE AND TIME
				if ((dateofcar3.equals(0)) && (timeofcar3.equals(0))) {
					dateofcar3 = "0";
					timeofcar3 = "0";
				} else {
					dateofcar3 = (String) data[3][2];
					timeofcar3 = (String) data[3][3];
				}

				// second element
				Element date3 = doc.createElement("Date");
				date3.appendChild(doc.createTextNode(dateofcar3));
				staff3.appendChild(date3);
				// Third element
				Element time3 = doc.createElement("Time");
				time3.appendChild(doc.createTextNode(timeofcar3));
				staff3.appendChild(time3);

				// set attribute to staff element 5
				Element staff4 = doc.createElement("NUMBER");
				rootElement.appendChild(staff4);
				String number4 = Integer.toString((int) data[4][0]);
				String countnumber4 = Integer.toString((int) data[4][1]);
				String dateofcar4 = (String) data[4][2];
				String timeofcar4 = (String) data[4][3];
				Attr attr4 = doc.createAttribute("id");
				attr4.setValue(number4);
				staff4.setAttributeNode(attr4);
				// first elements
				Element firstname4 = doc.createElement("Count");
				firstname4.appendChild(doc.createTextNode(countnumber4));
				staff4.appendChild(firstname4);

				// CHECK FOR DATE AND TIME
				if ((dateofcar4.equals(0)) && (timeofcar4.equals(0))) {
					dateofcar4 = "0";
					timeofcar4 = "0";
				} else {
					dateofcar4 = (String) data[4][2];
					timeofcar4 = (String) data[4][3];
				}
				// second element
				Element date4 = doc.createElement("Date");
				date4.appendChild(doc.createTextNode(dateofcar4));
				staff4.appendChild(date4);
				// Third element
				Element time4 = doc.createElement("Time");
				time4.appendChild(doc.createTextNode(timeofcar4));
				staff4.appendChild(time4);

				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("F:\\workspace\\Assignment2\\xmlFileTest.xml"));

				transformer.transform(source, result);

				System.out.println("File saved!");

			} catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			} catch (TransformerException tfe) {
				tfe.printStackTrace();
			}
		}

	}

}
