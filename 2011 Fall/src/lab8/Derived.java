package lab8;
public class Derived extends Base {
	@Override
	public void test() {
		System.out.println(method());
		super.test();
	}
	@Override public String method() {
		return "Derived";
	}
}

