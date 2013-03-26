package lab06.part1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GraphArea extends JComponent {

	private ArrayList<BankAccount> list = new ArrayList<BankAccount>(); 
	
	public void setList(ArrayList<BankAccount> lst) {
		list = lst;
	}

	private double getListMax() {
		double max = 0;
		if(list != null && list.size() > 0) {
			max = list.get(0).getBalance();
			for(BankAccount m : list) {
				if(m.getBalance() > max) {
					max = m.getBalance();
				}
			}
		}
		return max;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2 = (Graphics2D)g;
		
		double max = getListMax();
		if (max > 0) {			
			double htUnit = (getHeight() - 30) / max;
			double wdUnit = (getWidth()/list.size()) - 2;
			double offset = 1;
			
			for (BankAccount m : list) {
				Rectangle2D.Double rect = new Rectangle2D.Double(offset, 
						getHeight() - m.getBalance() * htUnit - 25, wdUnit, m.getBalance() * htUnit);
				g2.setColor(Color.RED);
				g2.fill(rect);
				g2.setColor(Color.BLACK);
				String str = "" + m.getAccountNumber();
				Font font = getFont();
				FontMetrics fm = getFontMetrics(font);
				Rectangle2D strBox = fm.getStringBounds(str, g2);
				g2.drawString(str, (float)(offset + (wdUnit - strBox.getWidth())/2), getHeight()-10F);
				offset += (wdUnit + 2);
			}
		}
	}
}
