package yo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NirajTools 
{
	
	public static final void drawCircle()
	{
		drawCircle(250);
	}
	
	public static final void drawCircle(int radius)
	{
		Shape s = new Ellipse2D.Double(radius + 10, radius + 10, radius, radius);
		draw(s);
	}
	
	public static final void drawRectangle(int x, int y, int width, int height)
	{
		Shape s = new Double(x, y, width, height);
		draw(s);
	}
	
	public static final void drawRectangle()
	{
		drawRectangle(0, 0, 200, 150);
	}
	
	private static final void draw(Shape s)
	{
		JFrame frame = new JFrame();
		JPanel panel = new GraphicsPanel(s);
		frame.getContentPane().add(Box.createVerticalStrut(50), BorderLayout.NORTH);
		frame.getContentPane().add(Box.createHorizontalStrut(50), BorderLayout.WEST);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private static class GraphicsPanel extends JPanel
	{
		Shape s;
		public GraphicsPanel(Shape s)
		{
			this.s = s;
		}
		public void paint(Graphics g)
		{
			g.setColor(Color.red);
			((Graphics2D)g).draw(s);
		}
	}
	
	public static final String readConsole()
	{
		return readConsole("");
	}
	
	public static final String getInput()
	{
		return getInput("");
	}
	
	public static final String readConsole(String message)
	{
		System.out.println(message);
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		scanner.close();
		return data;
	}
	
	public static final String getInput(String message)
	{
		String data = JOptionPane.showInputDialog(message);
		return data;
	}
	
	public static final int getIntInput(String message)
	{
		String data = getInput(message);
		int i = 0;
		try 
		{
			i = Integer.parseInt(data);
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Incorrect input provided");
		}
		return i;
	}
	
	public static final double getDoubleInput(String message)
	{
		String data = getInput(message);
		double i = 0;
		try 
		{
			i = java.lang.Double.parseDouble(data);
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Incorrect input provided");
		}
		return i;
	}
}
