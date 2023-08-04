

public class Testthrow {
    public static void validate(int age)
    {
        if(age<18)
        {
            throw new ArithmeticException("You are not eligible to vote.");
        }
        else 
            System.out.println("You are eligible to vote");
    }

    public static void main(String args[])
    {
        validate(12);
        System.out.println("An exception has occured");
    }
}
