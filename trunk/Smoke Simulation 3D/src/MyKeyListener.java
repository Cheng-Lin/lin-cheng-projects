import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

public class MyKeyListener
	implements KeyListener
{
	Starter starter;
	
	TransformGroup objTransform;
	Transform3D rotationX = new Transform3D();
	Transform3D rotationY = new Transform3D();
	
	double xRotate = 0.0;
	double yRotate = 0.0;
	
	public MyKeyListener(Starter s, TransformGroup obj)
	{
		starter = s;
		this.objTransform = obj;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		if (arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			xRotate -= 0.1;
			rotationX.rotX(xRotate);
			rotationY.rotY(yRotate);
			rotationX.mul(rotationY);
			objTransform.setTransform(rotationX);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			xRotate += 0.1;
			rotationX.rotX(xRotate);
			rotationY.rotY(yRotate);
			rotationX.mul(rotationY);
			objTransform.setTransform(rotationX);
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			yRotate -= 0.1;
			rotationX.rotX(xRotate);
			rotationY.rotY(yRotate);
			rotationY.mul(rotationX);
			objTransform.setTransform(rotationY);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			yRotate += 0.1;
			rotationX.rotX(xRotate);
			rotationY.rotY(yRotate);
			rotationY.mul(rotationX);
			objTransform.setTransform(rotationY);
		}
		
		if (arg0.getKeyCode() == KeyEvent.VK_N)		
		{
			starter.createSmoke();
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_EQUALS)
		{
			starter.setDT(0.05f);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_MINUS)
		{
			starter.setDT(-0.05f);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0)	{
		// TODO Auto-generated method stub
	}
	
	private double setBounds(double angle)
	{
		if (angle > Math.PI)
			return angle - Math.PI;
		else if (angle < 0)
			return Math.PI + angle;
		else
			return 0;
	}
	
	
}
