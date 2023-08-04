public class Trycatch {
    public static void main(String[] args) {
        try
        {
            int data=500/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println(e);
        }
        System.out.println("An exception is found");
    }
    
}
