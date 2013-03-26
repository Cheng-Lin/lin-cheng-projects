import java.awt.Color;
import java.text.DecimalFormat;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TransparencyAttributes;

/**
 * 
 */

/**
 * @author Kaito
 *
 */
public class Starter
	implements Runnable
{
    // solver variables
    int size;
    int multiple = 2;
    float dt = 0.2f;
    FluidSolver3D fs = new FluidSolver3D();
    
    // drawing
    Thread artist = null;
	TransformGroup objTransform;
    TransparencyAttributes[][][] ta;
    
	// Constructor
	public Starter(int size, TransparencyAttributes[][][] ta, TransformGroup obj)
	{
		this.objTransform = obj;
		this.ta = ta;
		
		this.size = size * multiple;
		fs.setup(this.size, dt);
		createSmoke();
	}
	
	public void start()
	{   
		artist = new Thread(this);
		artist.start();
	}
	
	public void stop()
	{	
		artist = null;
		printStuff(fs.temp);
	}
	
	@Override
	public void run()
	{
        while (artist != null)
        {
            try	{
                Thread.sleep(20);
            } catch (InterruptedException e) {}
            
            createSmoke();
        }
        artist = null;
	}
	
	public void createSmoke()
	{
		fs.velocitySolver();
		fs.densitySolver();
		
		for (int x = 1; x <= size; x += multiple)
		{
			for (int y = 1; y <= size; y += multiple)
			{
				for (int z = 1; z <= size; z += multiple)
				{
					float temp = 0.0f;
					
					for (int i = x; i < multiple + x; i++)
					{
						for (int j = y; j <  multiple + y; j++)
						{
							for (int k = z; k < multiple + z; k++)
							{
								//System.out.println(i + " " + j + " " + k);
								temp += fs.d[i][j][k];
							}
						}
					}
					
					temp /= (multiple * multiple * multiple);
	                // draw density
	                if (temp > 0)
	                {
	                    float tVal = (1.0f - temp);
	                    if (tVal < 0) tVal = 0;
	                    ta[(x + multiple - 1) / multiple - 1][(y + multiple - 1) / multiple - 1][(z + multiple - 1) / multiple - 1].setTransparency(tVal);
	                }
	                else
	                	ta[(x + multiple - 1) / multiple - 1][(y + multiple - 1) / multiple - 1][(z + multiple - 1) / multiple - 1].setTransparency(1);
				}
			}
		}
			
//		for (int x = (7 - 1); x <= (7 + 1); x++)
//		{
//			for (int y = (7 - 1); y <= (7 + 1); y++)
//			{
//				for (int z = (7 - 1); z <= (7 + 1); z++)
//				{
//					//System.out.println(x + " " + y + " " + z + " " + fs.d[x][y][z]);
//					System.out.print(fs.d[x][y][z] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("--");
//		}
//		System.out.println("------------");
	}

	public void updateLocation(boolean drag, int x, int y, int z, int xOld, int yOld, int zOld)
	{
        // set boundries
        if (x > size) x = size;
        if (x < 1) x = 1;
        if (y > size) y = size;
        if (y < 1) y = 1;
        if (z > size) z = size;
        if (z < 1) z = 1;
        
        if (drag == true)
        {
            fs.uOld[x * multiple][y * multiple][z * multiple] = (x - xOld) * 50 * multiple;
            fs.vOld[x * multiple][y * multiple][z * multiple] = (y - yOld) * 50 * multiple;
            fs.wOld[x * multiple][y * multiple][z * multiple] = (z - zOld) * 50 * multiple;
        }
        else
        	fs.dOld[x * multiple][y * multiple][z * multiple] = 100;
	}
	
	public void reset()
	{	
		fs.reset();
		
		Transform3D temp = new Transform3D();
		temp.rotX(0);
		objTransform.setTransform(temp);
		
		createSmoke();
	}
	
	public void nextStep()
	{
		stop();
		createSmoke();
		printStuff(fs.temp);
	}
	
	public void setDT(float change)
	{
        dt += change;
        
        if(dt < 0.1f)
        {
        	dt = 0.1f;
        	return;
        }
        else if(dt > 1f)
        {
        	dt = 1f;
        	return;
        }

        // kill fp errors
        dt = (float) Math.round(dt * 100);
        dt /= 100;
        System.out.println(dt);
	}
	
    public void printStuff(float input[][][])
    {
		//DecimalFormat formatter = new DecimalFormat("0.000000000");
    	DecimalFormat formatter = new DecimalFormat("00");
    	float scaled;
    	
    	for (int x = 1; x <= size; x++)
    	{
    		for (int y = 1; y <= size; y++)
    		{
    			scaled = input[x][y][size/2] * 10000;
    			if (scaled > 99) scaled = 99;
    			if (scaled < -99) scaled = -99;
    			
    			if (scaled >-0.9 && scaled < 0.9)
     				System.out.print("... ");
    			else if (scaled < 0)
    				System.out.print(formatter.format(scaled) + " ");
    			else
    				System.out.print("+" + formatter.format(scaled) + " ");
    		}
    		System.out.println();
    	}
    }
}
