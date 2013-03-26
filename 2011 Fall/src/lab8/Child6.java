package lab8;
public class Child6 extends Parent6 {
    int j = 11;
   
    public Child6(int i) {
        super(i);
    }

    //@Override--cannot override, method not visible
    public String method1(int k) {
        // super.method1(k) is not accessible
        return j+" "+(k+1);
    }
}
