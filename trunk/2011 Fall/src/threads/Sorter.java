package threads;

import java.awt.Graphics2D;
import javax.swing.JComponent;

public interface Sorter {
	void sort() throws InterruptedException;
	void setValues(int[] values);
	void setComponent(JComponent component);
	void draw(Graphics2D g2);
}
