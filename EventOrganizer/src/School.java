package assign1;

public class School extends Events {
	private final int type = 2;
	
	public School() {}
	
	public School(int year, int month, int day, int hour, int minute, String description, String location, String extra) {
		super(year, month, day, hour, minute, description, location, extra);
	}

	@Override
	public int getType() { return type; }
}
