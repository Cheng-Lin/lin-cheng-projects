package pippin;

public class Processor {
	private int acc;
	private int ip;
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	public int getIp() {
		return ip;
	}
	public void setIp(int ip) {
		this.ip = ip;
	}
	public void incIP() {
		ip++;
	}
}
