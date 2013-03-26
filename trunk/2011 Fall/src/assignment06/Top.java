package assignment06;

public class Top {
    public char methodA() {
        System.out.println(getClass().getSimpleName() + ", in class Top");
        return 'A';
    }
    public int methodB() {
        System.out.println(getClass().getSimpleName() + ", in class Top");
        return 10;
    }
    public String methodC() {
        return getClass().getSimpleName() + ", in class Top";
    }   
}