package assign1;

public class Gym extends Events{
	private final int type = 4;
	
	public Gym() {}
	
	public Gym(int year, int month, int day, int hour, int minute, String description, String location, String extra) {
		super(year, month, day, hour, minute, description, location, extra);
	}
	
	@Override
	public int getType() { return type; }
}
