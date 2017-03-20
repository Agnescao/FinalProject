
public class Pair implements Data{
   private int value1,value2;
	
	public Pair(int value1, int value2) {
	
	this.value1 = value1;
	this.value2 = value2;
}

	public int Add(){return value1+value2;}

	@Override
	public boolean All_Even() {
		// TODO Auto-generated method stub
		if((value1%2==0) && (value2%2==0))
		return true;
		else
		return false;
	}
	
	

}
