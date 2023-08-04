public class Divison {
    public static void main(String args[]) {
        int i=100;
        int j=args.length;
        try{
            System.out.println(i/j);
            try{
                System.out.println(args[1]);
            }
            catch(ArrayIndexOutOfBoundsException aoe)
            {
                System.out.println(aoe.getMessage());
            }
        }
        catch(ArithmeticException ae)
        {
            System.out.println(ae.getMessage());
        }
        
    }
}
