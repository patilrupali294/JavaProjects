package com.assignment2.Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 *
 * @author K.S.Boppaiah Rupali Deoram Patil
 * @version 1.0
 * @since 2017-09-25
 */
public class GraphClass extends JPanel {
	/**
	 * Instance variables of the class
	 * 
	 */
	private double[] values;
	private String[] labels;
	private Color[] colors;
	private String title;

	/**
	 * Constructor
	 * 
	 * @param values
	 *            array of type double[] labels array of type String[] colors
	 *            array of type Color[] title of type String
	 * 
	 */
	public GraphClass(double[] values, String[] labels, Color[] colors, String title) {
		this.labels = labels;
		this.values = values;
		this.colors = colors;
		this.title = title;
	}

	/**
	 * This method is used to display a bar chart If the values to the bar chart
	 * are null it return null Else the values are plotted
	 * Reffered:http://www.javacodex.com/Graphics/Bar-Chart
	 * 
	 */
	public void paintComponent(Graphics g) {

		if (values == null || values.length == 0) {
			return;
		}

		double minValue = 0;
		double maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			if (minValue > values[i]) {
				minValue = values[i];
			}
			if (maxValue < values[i]) {
				maxValue = values[i];
			}
		}

		Dimension dim = getSize();
		int panelWidth = dim.width;
		int panelHeight = dim.height;
		int barWidth = (panelWidth - 550) / values.length;

		Font titleFont = new Font("Book Antiqua", Font.BOLD, 15);
		FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);

		Font labelFont = new Font("Book Antiqua", Font.PLAIN, 14);
		FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

		int titleWidth = titleFontMetrics.stringWidth(title);
		int stringHeight = titleFontMetrics.getAscent();
		int stringWidth = (panelWidth - titleWidth) / 2;
		g.setFont(titleFont);
		g.drawString(title, stringWidth, stringHeight);

		int top = titleFontMetrics.getHeight();
		System.out.println("top" + top);
		int bottom = labelFontMetrics.getHeight();
		System.out.println("height:" + bottom);
		System.out.println("max:" + "\t" + maxValue);
		if (maxValue == minValue) {
			return;
		}
		double scale = (panelHeight - top - bottom) / (maxValue - minValue);
		stringHeight = panelHeight - labelFontMetrics.getDescent();
		g.setFont(labelFont);
		for (int j = 0; j < values.length; j++) {
			int valueP = j * barWidth + 1;
			int valueQ = top;
			int height = (int) (values[j] * scale);
			if (values[j] >= 0) {
				valueQ += (int) ((maxValue - values[j]) * scale);
			} else {
				valueQ += (int) (maxValue * scale);
				height = -height;
			}
			String car = "Count:" + "\t" + values[j];

			g.setColor(colors[j]);
			g.fillRect(valueP + 5, valueQ, barWidth - 20, height - 20);
			g.setColor(Color.black);
			g.drawRect(valueP + 5, valueQ, barWidth - 20, height - 20);
			g.setFont(labelFont);
			g.setColor(Color.BLACK);
			g.drawString(car, valueP, valueQ);

			int labelWidth = labelFontMetrics.stringWidth(labels[j]);
			stringWidth = j * barWidth + (barWidth - labelWidth) / 2;
			g.setColor(Color.GRAY);
			g.drawString(labels[j], stringWidth, stringHeight);

		}
	}

}
