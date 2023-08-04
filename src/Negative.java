class Negative {
    public static void main(String[] args) {
      int size = -5;
      try {
        int [] array = new int[size];
      } catch (NegativeArraySizeException e) {
        System.out.println("Caught exception: " + e.getMessage());
      }
    }
  }
  
