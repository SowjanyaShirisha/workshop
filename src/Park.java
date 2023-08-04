public class Park {
    private int length;
    private int breadth;
    private int area;
  
    public Park(int length, int breadth) {
      this.length = length;
      this.breadth = breadth;
      this.area = length * breadth;
    }
  
    public void display() {
      System.out.println("Length: " + this.length);
      System.out.println("Breadth: " + this.breadth);
      System.out.println("Area: " + this.area);
    }
  
  
  public static void main(String[] args) {
    
  
  Park park = new Park(50, 70);
park.display();
  }}
