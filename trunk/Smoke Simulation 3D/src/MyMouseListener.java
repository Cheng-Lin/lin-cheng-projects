/**
 * 
 */

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.picking.*;

/**
 * @author Kaito
 *
 */
public class MyMouseListener
	implements MouseListener, MouseMotionListener
{
	private Starter starter;
	private PickCanvas picking;
	private int x, y, z;
	
	/**
	 * 
	 */
	public MyMouseListener(PickCanvas picking)
	{	this.picking = picking;		}
	
	public MyMouseListener(Starter starter, PickCanvas picking)
	{
		this.starter = starter;
		this.picking = picking;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// active when left mouse is used
		if (e.getModifiers() != InputEvent.BUTTON2_MASK)
		{
			picking.setShapeLocation(e);
			PickResult result = picking.pickAny();
		
			if (result != null)
			{
				Primitive p = (Primitive)result.getNode(PickResult.PRIMITIVE);

				if (p != null)
				{
					String s = p.getName();

					int x2 = x;
					int y2 = y;
					int z2 = z;	
					x = Integer.parseInt(s.substring(0, 3));
					y = Integer.parseInt(s.substring(3, 6));
					z = Integer.parseInt(s.substring(6));
					
					if (e.getModifiers() == InputEvent.BUTTON3_MASK)
						starter.updateLocation(true, x, y, z, x2, y2, z2);
					else
						starter.updateLocation(false, x, y, z, 0, 0, 0);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		// active when left mouse is used
		if (e.getModifiers() == InputEvent.BUTTON1_MASK)
		{
			picking.setShapeLocation(e);
			PickResult result = picking.pickAny();
		
			if (result != null)
			{
				Primitive p = (Primitive)result.getNode(PickResult.PRIMITIVE);

				if (p != null)
				{
					String s = p.getName();
				
					x = Integer.parseInt(s.substring(0, 3));
					y = Integer.parseInt(s.substring(3, 6));
					z = Integer.parseInt(s.substring(6));
					
					starter.updateLocation(false, x, y, z, 0, 0, 0);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e)	{}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e)	{}

}
