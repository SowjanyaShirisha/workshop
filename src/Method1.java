public class Method1 {
     static int  logic(int x,int y)
    {
        int z;
        z=x+y;

        return z;
    }
    public static void main(String[] args) {
        
    
int a=5,b=9;
int c;
//Method1 sum = new Method1(); 
//c = sum.logic(8,9);
 c = logic(a, b);
    System.out.println(+c);

}
}