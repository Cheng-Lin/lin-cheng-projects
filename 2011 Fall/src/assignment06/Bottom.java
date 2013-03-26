package assignment06;
public class Bottom extends Middle 
{
    public char methodA() 
    {
        System.out.println(getClass().getSimpleName() + ", in class Bottom");
        return 'B';
    }
}