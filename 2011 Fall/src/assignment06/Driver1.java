package assignment06;
public class Driver1 {
    public static void main(String[] args) {
        Top test = new Top();
        System.out.println(test.methodA());
        System.out.println(test.methodB());
        System.out.println(test.methodC());
        System.out.println("-------------------");
        test = new Middle();
        System.out.println(test.methodA());
        System.out.println(test.methodB());
        System.out.println(test.methodC());
        System.out.println("-------------------");
        test = new Bottom();
        System.out.println(test.methodA());
        System.out.println(test.methodB());
        System.out.println(test.methodC());
        System.out.println("-------------------");
    }
}