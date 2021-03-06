import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.*;
import java.io.IOException;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.picking.PickCanvas;

import javax.media.j3d.*;
import javax.vecmath.*;
import javax.swing.*;

public class GamePanel extends JPanel
	implements ActionListener
{
	private BranchGroup scene, cube;
	private LifeCube lifeCube;	
	private MyMouseListener mouse;
	private LifeRule rule;
	
	private FileLoader fl;
	private FileSaver fs;
	
	private Timer auto;
	
	// Constructor
	public GamePanel()	
	{		
		fl = new FileLoader(this);
		fs = new FileSaver();
		
		// panel layout
		setLayout(new BorderLayout());

		GraphicsConfiguration config = 
			SimpleUniverse.getPreferredConfiguration();
		Canvas3D canvas3D = new Canvas3D(config);
		add("Center", canvas3D);

		createSceneGraph(canvas3D);

		SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
		simpleU.getViewingPlatform().setNominalViewingTransform();
		simpleU.addBranchGraph(scene);
		
		auto = new Timer(100, this);
	}

	// Reset the Cube
	public void createLifeCube(int rows, int columns, int steps, int lives)
	{
		auto.stop();
		
		cube.detach();
    	mouseControl(rows, columns, steps, lives);	// create a new cube
    	scene.addChild(cube);
	}

	// Create the Environment
	public void createSceneGraph(Canvas3D canvas)
	{
		scene = new BranchGroup();
		scene.setCapability(Group.ALLOW_CHILDREN_WRITE);
		scene.setCapability(Group.ALLOW_CHILDREN_EXTEND);

		cube = new BranchGroup();
		cube.setCapability(BranchGroup.ALLOW_DETACH);
		scene.addChild(cube);
		
		PickCanvas picking = new PickCanvas(canvas, scene);
		picking.setMode(PickCanvas.GEOMETRY);
		mouse = new MyMouseListener(picking);
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);

		// set the color of the background to white
		Background backg = new Background(1.0f, 1.0f, 1.0f);
		backg.setApplicationBounds(new BoundingSphere(new Point3d(), 1000.0));
		scene.addChild(backg);

		scene.compile();
	}

	// Create a New Cube with New MouseControl
	public void mouseControl(int rows, int columns, int steps, int lives)
	{
		cube = new BranchGroup();
		cube.setCapability(BranchGroup.ALLOW_DETACH);

		TransformGroup objTransform = new TransformGroup();
		objTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objTransform.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		// create the cube
		lifeCube = new LifeCube(rows, columns, steps, lives);
		rule = new LifeRule(getRA());
		mouse.newLifeCube(lifeCube);
		objTransform.addChild(lifeCube.getBG());
		cube.addChild(objTransform);

		// right mouse drag rotate
		RightMouseRotate myMouseRotate = new RightMouseRotate();
		myMouseRotate.setTransformGroup(objTransform);
		myMouseRotate.setSchedulingBounds(new BoundingSphere());
		cube.addChild(myMouseRotate);

		// middle mouse drag zoom
		MouseZoom myMouseZoom = new MouseZoom();
		myMouseZoom.setTransformGroup(objTransform);
		myMouseZoom.setSchedulingBounds(new BoundingSphere());
		cube.addChild(myMouseZoom);

		cube.compile();
	}
	
	// Start the Game of Life
	public void startGame(boolean automatic)
	{
		if (automatic == true)
			auto.start();	//using timer
		else
			rule.nextGen();	//go to next step
	}
	
	// Stop the Game of Life
	public void stopAnimate()
	{	auto.stop();	}
	
	// Set the Speed of the Game
	public void setSpeed(int speed)
	{	auto.setDelay(speed);	}

	@Override
	// Timer Action
	public void actionPerformed(ActionEvent e)
	{	rule.nextGen();		}
	
	public void SaveFile()
	{
		if (lifeCube != null)
			fs.SaveFile(getRA());
		else
			JOptionPane.showMessageDialog(this, "Nothing Has Been Created Yet", 
					"Saving Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void OpenFile() throws IOException
	{	fl.OpenFile();	}
	
	public RenderingAttributes[][][] getRA()
	{	return lifeCube.getRA();	}
}