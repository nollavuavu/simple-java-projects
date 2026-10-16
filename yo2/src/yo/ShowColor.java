package yo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowColor
{
	public static int[] hsltorgb(int H, int S, int L) {
	    double h = ((H % 360) + 360) % 360;
	    double s = S / 100.0;
	    double l = L / 100.0;

	    double c = (1 - Math.abs(2 * l - 1)) * s;
	    double x = c * (1 - Math.abs((h / 60) % 2 - 1));
	    double m = l - c / 2;

	    double r, g, b;
	    if (h < 60)       { r = c; g = x; b = 0; }
	    else if (h < 120) { r = x; g = c; b = 0; }
	    else if (h < 180) { r = 0; g = c; b = x; }
	    else if (h < 240) { r = 0; g = x; b = c; }
	    else if (h < 300) { r = x; g = 0; b = c; }
	    else              { r = c; g = 0; b = x; }

	    return new int[] {
	        (int) Math.round((r + m) * 255),
	        (int) Math.round((g + m) * 255),
	        (int) Math.round((b + m) * 255)
	    };
	}
	
	public static void main(String[] args)
	{
		int h,s,l,r,g,b;
		
		String choice = NirajTools.getInput("RGB or HSL").toLowerCase();
		if (choice.equals("hsl")) {
			h = NirajTools.getIntInput("H: ");
			s = NirajTools.getIntInput("S: ");
			l = NirajTools.getIntInput("L: ");
			int[] rgb = hsltorgb(h,s,l);
			System.out.println("Showing color at HSL ("+h+", "+s+", "+l+"):");
			ShowFrameFromColor(rgb[0], rgb[1], rgb[2]);
		}
		else {
			r = NirajTools.getIntInput("R: ");
			g = NirajTools.getIntInput("G: ");
			b = NirajTools.getIntInput("B: ");
			System.out.println("Showing color at RGB ("+r+", "+g+", "+b+"):");
			ShowFrameFromColor(r,g,b);
		}
	}
	
	public static final void ShowFrameFromColor(int r, int g, int b)
	{
		JFrame frame = new JFrame("Showing your true colors...");
		
		JPanel panel = new JPanel();

		Color color = new Color(r, g, b);
		panel.setForeground(color);
		panel.setBackground(color);
		
		frame.add(panel, BorderLayout.CENTER);
		
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
