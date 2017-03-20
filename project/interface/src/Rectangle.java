
public class Rectangle implements Shape{
	public int width;
	public int length;
	public Rectangle (int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}
	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return width*length;
	}
	

}
