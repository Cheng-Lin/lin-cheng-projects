package lab8;
public class BaseDriver2 {

   public static void main(String[] args) {
      Base2 ex = new Base2();
      System.out.println(ex.test());
      ex = new Derived2();
      System.out.println(ex.test());
      ex = new SubDerived2();
      System.out.println(ex.test());
   }
}
