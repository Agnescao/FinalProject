interface  Data
    {
       
		public int Add();
		public boolean All_Even();
    	   
    }
public class Q3bAns
{
  public static void main(String[] args)
  {
     Data []d = new Data[2];
     d[0] = new Pair(5,6);
     d[1] = new Treble(2, 4, 6);
     for (int i = 0; i < 2; i++)
     {   System.out.println();
         System.out.println("Sum of Values "+(i+1)+" :" +  d[i].Add());
         System.out.println("All Even "+(i+1)+ " :" +  d[i].All_Even());
     }
  }
}
