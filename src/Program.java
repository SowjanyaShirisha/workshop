import java.util.Scanner;

public class Program {
    public static void main(String[] args)
    {
        Scanner my = new Scanner(System.in);
        System.out.println("Enter the name and age:");
        String name = my.nextLine();
        int age = my.nextInt();
        System.out.println("Name :"+name) ; 
        System.out.println("Age :"+age) ; 
    }
}

