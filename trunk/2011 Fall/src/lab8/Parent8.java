package lab8;
public class Parent8 {
    private int i;
    public Parent8(int i) {
        this.i = i;
    }
    public String caller(int k) {
        return method1(i+k+1);
    }
   
    private String method1(int k) {
        return method2(k);
    }
   
    public String method2(int k) {
        return "THIS IS Parent8 "+i+" "+k;
    }
}