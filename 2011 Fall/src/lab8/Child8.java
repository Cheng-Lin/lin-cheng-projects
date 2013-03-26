package lab8;
public class Child8 extends Parent8 {
    int j = 11;
   
    public Child8(int i) {
        super(i);
    }

    //@Override--cannot override, method not visible
    public String method1(int k) {
        return j+" "+(k+1);
    }
   
    public String method2(int k) {
        return "THIS IS Child8 "+j+" "+(10*k);
    }   
}