/**
 * 
 */

import com.sun.j3d.utils.geometry.Box;

import javax.media.j3d.*;
import javax.vecmath.*;

import java.text.DecimalFormat;

/**
 * @author Kaito
 *
 */
public class Grid
{
	private BranchGroup grid;
	private TransparencyAttributes[][][] ta;
	
	private int xMax, yMax, zMax;

	// Constructor
	public Grid(int xMax, int yMax, int zMax)
	{
		this.xMax = xMax;
		this.yMax = yMax;
		this.zMax = zMax;
		
		createGrid();
	}
	
	// Create Grid
	private void createGrid()
	{
		// cube dimension
		float halfLength = 0.6f / findMax(xMax, yMax, zMax);
		float dimension = 2 * halfLength;
		
		// position adjust factor
		float adjustX = (xMax + 1) / 2.0f * dimension;
		float adjustY = (yMax + 1) / 2.0f * dimension;
		float adjustZ = (zMax + 1) / 2.0f * dimension;
		
		DecimalFormat formatter = new DecimalFormat("000");

		grid = new BranchGroup();
		TransformGroup cube = new TransformGroup();
		ta = new TransparencyAttributes[xMax][yMax][zMax];

		// create cube
		for (int x = 0; x < xMax; x++)
		{
			float xPos = (x + 1) * dimension - adjustX;	// position in x-axis adjust
			for (int y = 0; y < yMax; y++)
			{
				float yPos = (y + 1) * dimension - adjustY;	// position in y-axis adjust
				for (int z = 0; z < zMax; z++)
				{
					// cell
					ColoringAttributes ca = new ColoringAttributes();
					ca.setColor(0.0f, 0.0f, 0.0f);
					
					ta[x][y][z] = new TransparencyAttributes(TransparencyAttributes.NICEST, 1.0f);
					ta[x][y][z].setCapability(TransparencyAttributes.ALLOW_VALUE_WRITE);

					Appearance app = new Appearance();
					app.setColoringAttributes(ca);
					app.setTransparencyAttributes(ta[x][y][z]);

					Box box = new Box(halfLength, halfLength, halfLength, app);
					box.setName(formatter.format(x + 1) + formatter.format(y + 1) + formatter.format(z + 1));
					box.setCapability(Box.ENABLE_PICK_REPORTING);
					box.setCapability(Box.ENABLE_GEOMETRY_PICKING);
          
					// translate the cell to it's right position
					Transform3D translate = new Transform3D();
					translate.setTranslation(
							new Vector3f(xPos, yPos, (z + 1) * dimension - adjustZ));
					TransformGroup tg = new TransformGroup(translate);

					// add cell to cube
					tg.addChild(box);
					cube.addChild(tg);
				}
			}
		}
		
		Transform3D rotationX = new Transform3D();
		rotationX.rotX(Math.PI);
		cube.setTransform(rotationX);
		
		BorderCube border = new BorderCube(0.6f);
		grid.addChild(cube);
		grid.addChild(border);
	}
	
	public BranchGroup getBG()
	{   return grid;    }
	
	public TransparencyAttributes[][][] getTA()
	{	return ta;		}
	
	// Find the Largest Number among xMax, yMax and zMax
	private float findMax(int xMax, int yMax, int zMax)
	{
		int temp = Math.max(xMax, yMax);
		return (float)(Math.max(temp, zMax));
	}
}
