
import java.util.Scanner;
public class pallindrome {
    public static void main(String []args)
    {   Scanner myObj=new Scanner(System.in);
        System.out.println("Enter the number:");
        int rev =0;
        int n = myObj.nextInt();
        int a=n;
        while(n!=0)
        {
            rev=rev*10+n%10;
            n=n/10;
        }
        System.out.println("reversed number is:"+rev);
        int b = rev;

        if(a == b)
        System.out.println(" the number is palindrome");

        else
        System.out.println(" the number is not a palindrome");
    }
}
