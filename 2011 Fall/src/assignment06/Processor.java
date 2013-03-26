package assignment06;
public class Processor 
{
	private int acc;
	private int ip;
	
	/**
	 * add 1 to the Instruction Pointer
	 */
	public void incIP() {
		ip++;
	}
	
	/**
	 * Getter method for Accumulator
	 * @return Accumulator
	 */
	public int getAcc() {
		return acc;
	}
	
	/**
	 * Setter method for Accumulator
	 * @param acc new value for Accumulator
	 */
	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	/**
	 * Getter method for Instruction Pointer
	 * @return Instruction Pointer
	 */
	public int getIp() {
		return ip;
	}
	
	/**
	 * Setter method for Instruction Pointer
	 * @param ip new value for Instruction Pointer
	 */
	public void setIp(int ip) {
		this.ip = ip;
	}
}
