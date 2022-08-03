
public class Timetable {
	
	private int ID;
	private double price;
	private String start;
	private String end;
	private String mode;
	
	public Timetable(int iD, double price, String start, String end, String mode) {
		ID = iD;
		this.price = price;
		this.start = start;
		this.end = end;
		this.mode = mode;
	}

	public int getID() {
		return ID;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice()
	{
		this.price = price;
	}

	public String getStart() {
		return start;
	}
	
	public void setStart()
	{
		this.start = start;
	}

	public String getEnd() {
		return end;
	}
	
	public void setEnd()
	{
		this.end = end;
	}

	public String getMode() {
		return mode;
	}
	
	public void setMode()
	{
		this.mode = mode;
	}
	
	
	
}