public class Triangle {
    private double side1;
    private double side2;
    private double side3;
  
    public Triangle() {
      side1 = 0;
      side2 = 0;
      side3 = 0;
    }
  
    public Triangle(double side1, double side2, double side3) {
      side1 = side1;
      side2 = side2;
      side3 = side3;
    }
  
    public boolean validate() {
      return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }
  
    public double findPerimeter() {
      return side1 + side2 + side3;
    }
  
    public double findArea() {
      double s = (side1 + side2 + side3) / 2;
      return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
  }
  Triangle t = new Triangle(3, 4, 5);
if (t.validate()) {
  double perimeter = t.findPerimeter();
  double area = t.findArea();
  System.out.println("Perimeter: " + perimeter);
  System.out.println("Area: " + area);
} else {
  System.out.println("Invalid triangle sides!");
}

