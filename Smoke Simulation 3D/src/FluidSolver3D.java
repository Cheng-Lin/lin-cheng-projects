/**
 * 
 */

/**
 * @author Kaito
 *
 */
public class FluidSolver3D
{
    int size, bSize;
    float dt;

    float visc = 0.0f;
    float diff = 0.0f;

    float[][][] tmp;

    float[][][] d, dOld;
    float[][][] u, uOld;
    float[][][] v, vOld;
    float[][][] w, wOld;
    float[][][] curl;
    float[][][] temp;
    
    float i, j, k;
    
	// Constructor
	public void setup(int size, float dt)
	{
		this.size = size;
		this.dt = dt;
		bSize = this.size + 2;
		
		reset();
	}

    /**
     * Reset the datastructures.
     * We use 1d arrays for speed.
     **/
    public void reset()
    {
        d    = new float[bSize][bSize][bSize];
        dOld = new float[bSize][bSize][bSize];
        u    = new float[bSize][bSize][bSize];
        uOld = new float[bSize][bSize][bSize];
        v    = new float[bSize][bSize][bSize];
        vOld = new float[bSize][bSize][bSize];
        w	 = new float[bSize][bSize][bSize];
        wOld = new float[bSize][bSize][bSize];
        curl = new float[bSize][bSize][bSize];
        temp = new float[bSize][bSize][bSize];

        for (int i = 0; i < bSize; i++)
        {
        	for (int j = 0; j < bSize; j++)
        	{
        		for (int k = 0; k < bSize; k++)
        		{
            		u[i][j][k] = uOld[i][j][k] = 0.0f;
            		v[i][j][k] = vOld[i][j][k] = 0.0f;
            		w[i][j][k] = wOld[i][j][k] = 0.0f;
            		d[i][j][k] = dOld[i][j][k] = curl[i][j][k] = 0.0f;
            		temp[i][j][k] = 0.0f;
        		}
        	}
        }
        
        d[bSize / 2][bSize-2][bSize / 2] = 100;
        d[bSize / 2][1][bSize / 2] = 100;
    }
    
    /**
     * Calculate the buoyancy force as part of the velocity solver.
     * Fbuoy = -a*d*Y + b*(T-Tamb)*Y where Y = (0,1,0). The constants
     * a and b are positive with appropriate (physically meaningful)
     * units. T is the temperature at the current cell, Tamb is the
     * average temperature of the fluid grid. The density d provides
     * a mass that counteracts the buoyancy force.
     *
     * In this simplified implementation, we say that the tempterature
     * is synonymous with density (since smoke is *hot*) and because
     * there are no other heat sources we can just use the density
     * field instead of a new, seperate temperature field.
     *
     * @param Fbuoy Array to store buoyancy force for each cell.
     **/
    public void buoyancy(float[][][] Fbuoy)
    {
        float Tamb = 0;
        float a = 0.000625f;
        float b = 0.025f;

        // sum all temperatures
        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= size; j++)
            	for (int k = 1; k <= size; k++)
            		Tamb += d[i][j][k];

        // get average temperature
        Tamb /= (size * size * size);

        // for each cell compute buoyancy force
        for (int i = 1; i <= size; i++)
            for (int j = 1; j <= size; j++)
            	for (int k = 1; k <= size; k++)
            		Fbuoy[i][j][k] =  a * d[i][j][k] + -b * (d[i][j][k] - Tamb);
    }
    
    /**
     * Calculate the curl at position (x, y, z) in the fluid grid.
     * Physically this represents the vortex strength at the
     * cell. Computed as follows: w = (del x U) where U is the
     * velocity vector at (x, y, z).
     **/
    public float curl(int x, int y, int z)
    {
    	float dw_dy = (w[x][y + 1][z] - w[x][y - 1][z]) * 0.5f;
    	float dv_dz = (v[x][y][z + 1] - v[x][y][z - 1]) * 0.5f;
    	float dw_dx = (w[x + 1][y][z] - w[x - 1][y][z]) * 0.5f;
    	float du_dz = (u[x][y][z + 1] - u[x][y][z - 1]) * 0.5f;
        float du_dy = (u[x][y + 1][z] - u[x][y - 1][z]) * 0.5f;
        float dv_dx = (v[x + 1][y][z] - v[x - 1][y][z]) * 0.5f;
        
        i = dw_dy - dv_dz;
        j = -(dw_dx - du_dz);
        k = dv_dx - du_dy;

        return (float)Math.sqrt(i * i + j * j + k * k);
    }
    
    /**
     * Calculate the vorticity confinement force for each cell
     * in the fluid grid. At a point (x,y,z), Fvc = N x w where
     * w is the curl at (x,y,z) and N = del |w| / |del |w||.
     * N is the vector pointing to the vortex center, hence we
     * add force perpendicular to N.
     *
     * @param Fvc_x The array to store the x component of the
     *        vorticity confinement force for each cell.
     * @param Fvc_y The array to store the y component of the
     *        vorticity confinement force for each cell.
     * @param Fvc_z The array to store the z component of the
     *        vorticity confinement force for each cell.
     **/
    public void vorticityConfinement(float[][][] Fvc_x, float[][][] Fvc_y, float[][][] Fvc_z)
    {
        float dw_dx, dw_dy, dw_dz;
        float length;
        float v;
        float epsilon = 3f;

        // Calculate magnitude of curl(u,v,w) for each cell. (|w|)
        for (int x = 1; x <= size; x++)
            for (int y = 1; y <= size; y++)
            	for (int z = 1; z <= size; z++)
            		curl[x][y][z] = curl(x, y, z);

        for (int x = 2; x < size; x++)
        {
            for (int y = 2; y < size; y++)
            {
            	for (int z = 2; z < size; z++)
            	{
            		// Find derivative of the magnitude (n = del |w|)
            		dw_dx = (curl[x + 1][y][z] - curl[x - 1][y][z]) * 0.5f;
            		dw_dy = (curl[x][y + 1][z] - curl[x][y - 1][z]) * 0.5f;
            		dw_dz = (curl[x][y][z + 1] - curl[x][y][z - 1]) * 0.5f;

            		// Calculate vector length. (|n|)
            		// Add small factor to prevent divide by zeros.
            		length = (float) Math.sqrt(dw_dx * dw_dx + dw_dy * dw_dy + dw_dz * dw_dz)
            				+ 0.000001f;

            		// N = ( n/|n| )
            		dw_dx /= length;
            		dw_dy /= length;
            		dw_dz /= length;

            		v = curl(x, y, z);

            		// N x w
            		Fvc_x[x][y][z] = (dw_dy * k - dw_dz *j) * epsilon;   // a2b3 - a3b2
            		Fvc_y[x][y][z] = -(dw_dx * k - dw_dz * i) * epsilon; // a3b1 - a1b3
            		Fvc_z[x][y][z] = (dw_dx * j - dw_dy * i) * epsilon;  // a1b2 - a2b1
            	}
            }
        }
    }
    
    /**
     * The basic velocity solving routine as described by Stam.
     **/
    public void velocitySolver()
    {
        // add velocity that was input by mouse
        addSource(u, uOld);
        addSource(v, vOld);
        addSource(w, wOld);

        // add in vorticity confinement force
        vorticityConfinement(uOld, vOld, wOld);
        addSource(u, uOld);
        addSource(v, vOld);
        addSource(w, wOld);

        // add in buoyancy force
        buoyancy(vOld);
        addSource(v, vOld);

        // swapping arrays for economical mem use
        // and calculating diffusion in velocity.
        swapU();
        diffuse(0, u, uOld, visc);

        swapV();
        diffuse(0, v, vOld, visc);
        
        swapW();
        diffuse(0, w, wOld, visc);

        // we create an incompressible field
        // for more effective advection.
        project(u, v, w, temp, vOld);

        swapU(); swapV(); swapW();

        // self advect velocities
        advect(1, u, uOld, uOld, vOld, wOld);
        advect(2, v, vOld, uOld, vOld, wOld);
        advect(3, w, wOld, uOld, vOld, wOld);

        // make an incompressible field
        project(u, v, w, temp, vOld);

        // clear all input velocities for next frame
        for (int x = 0; x < bSize; x++)
        { 
        	for (int y = 0; y < bSize; y++)
        	{
        		for (int z = 0; z < bSize; z++)
        		{
        			uOld[x][y][z] = 0; 
        			vOld[x][y][z] = 0;
        			wOld[x][y][z] = 0;
        		}
        	}
        }
    }

    /**
     * The basic density solving routine.
     **/
    public void densitySolver()
    {       
        // add density inputted by mouse
        addSource(d, dOld);
        swapD();

        diffuse(0, d, dOld, diff);
        swapD();

        advect(0, d, dOld, u, v, w);

        // clear input density array for next frame
        for (int x = 0; x < bSize; x++) 
        	for (int y = 0; y < bSize; y++)
        		for (int z = 0; z < bSize; z++)
        			dOld[x][y][z] = 0;
    }
    
    private void addSource(float[][][] x, float[][][] x0)
    {
        for (int i = 0; i < bSize; i++)
        	for (int j = 0; j < bSize; j++)
        		for(int k = 0; k < bSize; k++)
        			x[i][j][k] += dt * x0[i][j][k];
    }
    
    /**
     * Calculate the input array after advection. We start with an
     * input array from the previous timestep and an and output array.
     * For all grid cells we need to calculate for the next timestep,
     * we trace the cell's center position backwards through the
     * velocity field. Then we interpolate from the grid of the previous
     * timestep and assign this value to the current grid cell.
     *
     * @param b Flag specifying how to handle boundries.
     * @param d Array to store the advected field.
     * @param d0 The array to advect.
     * @param du The x component of the velocity field.
     * @param dv The y component of the velocity field.
     **/

    private void advect(int b, float[][][] d, float[][][] d0, float[][][] du, float[][][] dv, float[][][] dw)
    {
        int i0, j0, k0, i1, j1, k1;
        float x, y, z, r0, s0, t0, r1, s1, t1, dt0;

        dt0 = dt * size;

        for (int i = 1; i <= size; i++)
        {
            for (int j = 1; j <= size; j++)
            {
            	for (int k = 1; k <= size; k++)
            	{            		
            		// go backwards through velocity field
            		x = i - dt0 * du[i][j][k];
            		y = j - dt0 * dv[i][j][k];
            		z = k - dt0 * dw[i][j][k];

            		// interpolate results
            		if (x > size + 0.5) x = size + 0.5f;
            		if (x < 0.5)     	x = 0.5f;
            		
            		i0 = (int) x;
            		i1 = i0 + 1;

            		if (y > size + 0.5) y = size + 0.5f;
            		if (y < 0.5)     	y = 0.5f;

            		j0 = (int) y;
            		j1 = j0 + 1;
            		
            		if (z > size + 0.5) z = size + 0.5f;
            		if (z < 0.5)     	z = 0.5f;

            		k0 = (int) z;
            		k1 = k0 + 1;

            		r1 = x - i0;
            		r0 = 1 - r1;
            		s1 = y - j0;
            		s0 = 1 - s1;
            		t1 = z - k0;
            		t0 = 1 - t1;
            		        		
            		d[i][j][k] = r0 * ( s0 * (t0 * d0[i0][j0][k0] + t1 * d0[i0][j0][k1])
            				   +  s1 * (t0 * d0[i0][j1][k0] + t1 * d0[i0][j1][k1]))
            				   + r1 * ( s0 * (t0 * d0[i1][j0][k0] + t1 * d0[i1][j0][k1])
            				   +  s1 * (t0 * d0[i1][j1][k0] + t1 * d0[i1][j1][k1]));
            	}
            }
        }
        setBoundry(b, d);
    }
    
    /**
     * Recalculate the input array with diffusion effects.
     * Here we consider a stable method of diffusion by
     * finding the densities, which when diffused backward
     * in time yield the same densities we started with.
     * This is achieved through use of a linear solver to
     * solve the sparse matrix built from this linear system.
     *
     * @param b Flag to specify how boundries should be handled.
     * @param c The array to store the results of the diffusion
     * computation.
     * @param c0 The input array on which we should compute
     * diffusion.
     * @param diff The factor of diffusion.
     **/
    private void diffuse(int b, float[][][] c, float[][][] c0, float diff)
    {
        float a = dt * diff * size * size * size;
        linearSolver(b, c, c0, a, 1 + 9 * a);
    }

    /**
     * Use project() to make the velocity a mass conserving,
     * incompressible field. Achieved through a Hodge
     * decomposition. First we calculate the divergence field
     * of our velocity using the mean finite differnce approach,
     * and apply the linear solver to compute the Poisson
     * equation and obtain a "height" field. Now we subtract
     * the gradient of this field to obtain our mass conserving
     * velocity field.
     *
     * @param x The array in which the x component of our final
     * velocity field is stored.
     * @param y The array in which the y component of our final
     * velocity field is stored.
     * @param z The array in which the z component of our final
     * velocity field is stored.
     * @param p A temporary array we can use in the computation.
     * @param div Another temporary array we use to hold the
     * velocity divergence field.
     *
     **/

    void project(float[][][] x, float[][][] y, float[][][] z, float[][][] p, float[][][] div)
    {
        for (int i = 1; i <= size; i++)
        {
            for (int j = 1; j <= size; j++)
            {
            	for (int k = 1; k <= size; k++)
            	{
            		div[i][j][k] = (x[i + 1][j][k] - x[i - 1][j][k]
            		             + y[i][j + 1][k] - y[i][j - 1][k]
                                 + z[i][j][k + 1] - z[i][j][k - 1])
                                 * -0.5f / size;
            		p[i][j][k] = 0;
            	}
            }
        }

        setBoundry(0, div);
        setBoundry(0, p);

        linearSolver(0, p, div, 1, 6);
//        for (int n = 0; n < 20; n++)
//        {
//            for (int i = 1; i <= size; i++)
//            {
//                for (int j = 1; j <= size; j++)
//                {
//                	for (int k = 1; k <= size; k++)
//                	{
//						//Method 1:
//                		//using average
//                		p[i][j][k] = ((p[i - 1][j][k] + p[i + 1][j][k]
//                		             + p[i][j - 1][k] + p[i][j + 1][k]
//                		             + p[i][j][k - 1] + p[i][j][k + 1]) / 6.0f
//                		             + div[i][j][k]) / 2.0f;
//                		//Method 2:
//                		//solve for each face
//                		float xy = ((p[i - 1][j][k] + p[i + 1][j][k]
//                		           + p[i][j - 1][k] + p[i][j + 1][k])
//                                   + div[i][j][k]) / 6.0f;
//                		float xz = ((p[i - 1][j][k] + p[i + 1][j][k]
//		                           + p[i][j][k - 1] + p[i][j][k - 1])
//		      		               + div[i][j][k]) / 6.0f;
//		                float yz = ((p[i][j - 1][k] + p[i][j + 1][k]
//		                           + p[i][j][k - 1] + p[i][j][k + 1])
//		      		               + div[i][j][k]) / 6.0f;
//						//Method 2 No.1
//		                //using average
//		                p[i][j][k] = (xy + xz + yz) / 3.0f;
//						//Method 2 No.2
//		                //combine xy, xz, yz using sqrt(xy ^ 2 + xz ^ 2 + yz ^ 2);
//		                p[i][j][k] = (float) Math.sqrt(xy * xy + xz * xz + yz * yz)
//        							 + 0.000001f;
//                	}
//                }
//            }
//            setBoundry(0, p);
//        }
        
        for (int i = 1; i <= size; i++)
        {
            for (int j = 1; j <= size; j++)
            {
            	for (int k = 1; k <= size; k++)
            	{
            		x[i][j][k] -= 0.5f * size * (p[i + 1][j][k] - p[i - 1][j][k]);
            		y[i][j][k] -= 0.5f * size * (p[i][j + 1][k] - p[i][j - 1][k]);
            		z[i][j][k] -= 0.5f * size * (p[i][j][k + 1] - p[i][j][k - 1]);            		
            	}
            }
        }

        setBoundry(1, x);
        setBoundry(2, y);
        setBoundry(3, z);
    }
    
    /**
     * Iterative linear system solver using the Gauss-sidel
     * relaxation technique. Room for much improvement here...
     *
     **/
    void linearSolver(int b, float[][][] x, float[][][] x0, float a, float c)
    {
        for (int n = 0; n < 20; n++)
        {
            for (int i = 1; i <= size; i++)
            {
                for (int j = 1; j <= size; j++)
                {
                	for (int k = 1; k <= size; k++)
                	{
                		x[i][j][k] = (a * (x[i - 1][j][k] + x[i + 1][j][k]
                		                 + x[i][j - 1][k] + x[i][j + 1][k]
                		                 + x[i][j][k - 1] + x[i][j][k + 1])
                		                 + x0[i][j][k]) / c;
                	}
                }
            }
            setBoundry(b, x);
        }
    }
     
    // specifies simple boundry conditions.
    private void setBoundry(int b, float[][][] x)
    {
    	//check the border
        for (int i = 1; i <= size; i++)
        {
        	for (int k = 1; k <= size; k++)
        	{
        		x[  0  ][  i  ][  k  ] = b == 1 ? -x[1][i][k] : x[1][i][k];
        		x[size + 1][  i  ][  k  ] = b == 1 ? -x[size][i][k] : x[size][i][k];
        		x[  i  ][  0  ][  k  ] = b == 2 ? -x[i][1][k] : x[i][1][k];
        		x[  i  ][size + 1][  k  ] = b == 2 ? -x[i][size][k] : x[i][size][k];
       			x[  i  ][  k  ][  0  ] = b == 3 ? -x[i][k][1] : x[i][k][1];
       			x[  i  ][  k  ][size + 1] = b == 3 ? -x[i][k][size] : x[i][k][size];
        	}
        }
        
        //check the border frame
        for(int i = 1; i <= size; i++)
        {
        	x[i][0][0] = (x[i][1][0] + x[i][0][1]) / 2.0f;
        	x[i][size + 1][0] = (x[i][size][0] + x[i][size + 1][1]) / 2.0f;
        	x[i][0][size + 1] = (x[i][1][size + 1] + x[i][0][size]) / 2.0f;
        	x[i][size + 1][size + 1] = (x[i][size][size + 1] + x[i][size + 1][size]) / 2.0f;
        	x[0][i][0] = (x[1][i][0] + x[0][i][1]) / 2.0f;
        	x[size + 1][i][0] = (x[size][i][0] + x[size + 1][i][1]) / 2.0f;
        	x[0][i][size + 1] = (x[1][i][size + 1] + x[0][i][size]) / 2.0f;
        	x[size + 1][i][size + 1] = (x[size][i][size + 1] + x[size + 1][i][size]) / 2.0f;
        }
        
        //check each corner
        x[0][0][0] = (x[1][0][0] + x[0][1][0] + x[0][0][1]) / 3.0f;
        x[0][0][size + 1] = (x[1][0][size + 1] + x[0][1][size + 1] + x[0][0][size]) / 3.0f;
        x[0][size + 1][0] = (x[1][size + 1][0] + x[0][size][0] + x[0][size + 1][1]) / 3.0f;
        x[0][size + 1][size + 1] = (x[1][size + 1][size + 1] = x[0][size][size + 1] + x[0][size + 1][size]) / 3.0f;
        x[size + 1][0][0] = (x[size][0][0] + x[size + 1][1][0] + x[size + 1][0][1]) / 3.0f;
        x[size + 1][0][size + 1] = (x[size][0][size + 1] + x[size + 1][1][size + 1] + x[size + 1][0][size]) / 3.0f;
        x[size + 1][size + 1][0] = (x[size][size + 1][0] + x[size + 1][size][0] + x[size + 1][size + 1][1]) / 3.0f;
        x[size + 1][size + 1][size + 1] = (x[size][size + 1][size + 1] + x[size + 1][size][size + 1] + x[size + 1][size + 1][size]) / 3.0f;
    }
    
    // util array swapping methods
    public void swapU(){ tmp = u; u = uOld; uOld = tmp; }
    public void swapV(){ tmp = v; v = vOld; vOld = tmp; }
    public void swapW(){ tmp = w; w = wOld; wOld = tmp; }    
    public void swapD(){ tmp = d; d = dOld; dOld = tmp; }
}
