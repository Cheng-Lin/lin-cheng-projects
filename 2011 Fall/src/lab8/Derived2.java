package lab8;
public class Derived2 extends Base2 {
   int getValue() {
      return 2;
   }
   String getName() {
      return "Der";
   }
   String test() {
      return super.test();
   }
}

