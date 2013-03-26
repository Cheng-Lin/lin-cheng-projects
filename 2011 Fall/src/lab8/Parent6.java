package lab8;
public class Parent6 {
    private int i;
    public Parent6(int i) {
        this.i = i;
    }
    public String caller(int k) {
        return method1(i+k+1);
    }
   
    private String method1(int k) {
        return i + " " + k;
    }
}
