
public class Treble implements Data {
  private int value3;
  private int value1,value2;
	
	public Treble(int value3, int value1, int value2) {
	super();
	this.value3 = value3;
	this.value1 = value1;
	this.value2 = value2;
}
	public  int Add(){ return value1+value2+value3;}
	@Override
	public boolean All_Even() {
		// TODO Auto-generated method stub
		if((value1%2==0) && (value2%2==0) &&(value3%2==0))
			return true;
			else
			return false;
	}

}
