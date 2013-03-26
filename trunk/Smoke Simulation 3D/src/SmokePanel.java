/**
 * 
 */

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.*;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.picking.PickCanvas;

import javax.media.j3d.*;
import javax.vecmath.*;
import javax.swing.*;

/**
 * @author Kaito
 *
 */
public class SmokePanel extends JPanel
{
	Starter s;
	
	// Constructor
	public SmokePanel()
	{
		// panel layout
		setLayout(new BorderLayout());
		setFocusable(true);

		GraphicsConfiguration config = 
			SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3D = new Canvas3D(config);
		add("Center", canvas3D);

		BranchGroup scene = createSceneGraph(canvas3D);

		SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
		simpleU.getViewingPlatform().setNominalViewingTransform();
		simpleU.addBranchGraph(scene);
	}
	
	public BranchGroup createSceneGraph(Canvas3D canvas)
	{
		BranchGroup objRoot = new BranchGroup();
		
		TransformGroup objTransform = new TransformGroup();
		objTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		// create the cube
		Grid grid = new Grid(15,15,15);
		objTransform.addChild(grid.getBG());
		objRoot.addChild(objTransform);

		// add mouse listener
		s = new Starter(15, grid.getTA(), objTransform);
		PickCanvas picking = new PickCanvas(canvas, objRoot);
		picking.setMode(PickCanvas.GEOMETRY);
		MyMouseListener mouse = new MyMouseListener(s, picking);
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		
		// right mouse drag rotate
		MiddleMouseRotate myMouseRotate = new MiddleMouseRotate();
		myMouseRotate.setTransformGroup(objTransform);
		myMouseRotate.setSchedulingBounds(new BoundingSphere());
		objRoot.addChild(myMouseRotate);

		// key rotation
		MyKeyListener keys = new MyKeyListener(s, objTransform);
		canvas.addKeyListener(keys);
		
		// set the color of the background to white
		Background backg = new Background(1.0f, 1.0f, 1.0f);
		backg.setApplicationBounds(new BoundingSphere(new Point3d(), 1000.0));
		objRoot.addChild(backg);

		objRoot.compile();
		return objRoot;
	}
	
	public void start()
	{   s.start();	}
	
	public void nextStep()
	{	s.nextStep();	}
	
	public void reset()
	{	s.reset();	}
	
	public void stop()
	{	s.stop();	}
}
