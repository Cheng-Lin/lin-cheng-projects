package lab8;

public class Part6Child extends Part6Parent {
	public String method1() {
		return "Child" + method2();
	}
	public String method2() {
		return "Child";
	}
}
