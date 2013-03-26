package lab8;

import lab8b.Child9;

public class Tester9 {
    public static void main(String[] args) {
        Parent9 test1 = new Child9(3);
        System.out.println(test1.caller(2));
    }
}
