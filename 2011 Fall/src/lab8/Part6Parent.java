package lab8;

public class Part6Parent {
	public void test() {
		System.out.println(method1());
	}
	private String method1() {
		System.out.println("Parent method 1");
		return method2();
	}
	public String method2() {
		System.out.println("Parent method 2");
		return method1();
	}
}
