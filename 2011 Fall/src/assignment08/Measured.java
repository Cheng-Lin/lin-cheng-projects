package assignment08;

public class Measured implements Measurable 
{
	private double measure;
	
	/**
	 * Constructor method for Measured
	 * @param measure value that can used to compare
	 */
	public Measured(double measure)
	{
		this.measure = measure;
	}
	
	/**
	 * set measure to specified value
	 * @param measure
	 */
	public void setMeasure(double measure) {
		this.measure = measure;
	}

	@Override
	public double getMeasure() {
		return measure;
	}
	
    @Override
    public int hashCode() {
        Double d = new Double(measure);
        return d.hashCode();
    }
    
    @Override
    public boolean equals(Object obj)
    {
    	return measure == ((Measured)obj).getMeasure();
    }
}
