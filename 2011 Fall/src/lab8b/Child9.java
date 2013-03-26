package lab8b;

import lab8.Parent9;

public class Child9 extends Parent9 {
    int j = 11;
   
    public Child9(int i) {
        super(i);
    }

    //@Override--cannot override, method not visible
    public String method1(int k) {
        return j+" "+(k+1);
    }
   
    public String method2(int k) {
        return "THIS IS Child9 "+j+" "+(10*k);
    }   
}
