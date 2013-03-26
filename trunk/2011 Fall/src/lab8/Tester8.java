package lab8;
public class Tester8 {
    public static void main(String[] args) {
        Parent8 test1 = new Child8(3);
        System.out.println(test1.caller(2));
    }
}