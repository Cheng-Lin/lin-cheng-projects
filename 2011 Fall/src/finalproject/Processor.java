package finalproject;

public class Processor {
	private int acc;
	private int ip;
	
	/**
	 * Getter method for the accumulator value
	 * @return the value in acc
	 */
	public int getAcc() {
		return acc;
	}
	
	/**
	 * Setter method for the accumulator value
	 * @param acc the new value for acc
	 */
	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	
	/**
	 * Getter method for the instruction pointer
	 * @return the value in ip
	 */
	public int getIp() {
		return ip;
	}

	/**
	 * Setter method for the instruction pointer
	 * @param acc the new value for ip
	 */
	public void setIp(int ip) {
		this.ip = ip;
	}

	/**
	 * Method to increment the instruction pointer
	 * value by 1
	 */
	public void incIP() {
		ip++;
	}
}
