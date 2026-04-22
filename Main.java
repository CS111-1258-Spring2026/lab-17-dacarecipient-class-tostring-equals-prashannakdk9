class Main {
  public static void main(String[] args) {
    DACArecipient p1 = new DACArecipient();
    p1.setAll("Mendez", "Javier", "56-3-445", "El Salvador", 2451564, 3956753, 3956840, 'M');
    
    DACArecipient p2 = new DACArecipient();
    p2.setAll("Mendez", "Javier", "56-3-445", "El Salvador", 2451564, 3956753, 3956840, 'M');

    // Part 1: Test toString
    System.out.println("--- toString() Test ---");
    System.out.println(p1);

    // Part 2: Test equals
    System.out.println("\n--- equals() Test ---");
    System.out.println("Are they equal? " + p1.equals(p2));

    // Part 4: Test printCard
    System.out.println("\n--- printCard() Test ---");
    System.out.println(p1.printCard());
  }
}
