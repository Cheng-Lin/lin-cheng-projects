package lab8;

public class Derived3 extends Base3 {
   static int getValue() {
      return 2;
   }
   static String getName() {
      return "Der";
   }
   String test1() {
      return super.test();
   }
}

