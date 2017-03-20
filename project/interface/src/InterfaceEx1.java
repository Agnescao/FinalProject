public class InterfaceEx1
{
  public static void main(String[] args)
  {
     Shape []s = new Shape[2];
     s[0] = new Square(5);
     s[1] = new Rectangle(2, 4);
     for (int i = 0; i < 2; i++)
     {
         System.out.println("Area of shape" +s[i].calculateArea());
     }
  }
}
