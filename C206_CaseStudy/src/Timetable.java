
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

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getMode() {
		return mode;
	}
	
	
	
}