package assign1;

public class Social extends Events{
	private final int type = 5;
	
	public Social() {}
	
	public Social(int year, int month, int day, int hour, int minute, String description, String location, String extra) {
		super(year, month, day, hour, minute, description, location, extra);
	}
	
	@Override
	public int getType() { return type; }
}
