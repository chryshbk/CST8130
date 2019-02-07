package assign1;

public class Meeting extends Events{
	private final int type = 1;
	
	public Meeting() {}
	
	public Meeting(int year, int month, int day, int hour, int minute, String description, String location, String extra) {
		super(year, month, day, hour, minute, description, location, extra);
	}

	@Override
	public int getType() { return type; }
	
	@Override
	public String toString() {
		return "\t"+ getYear() + "/"+ getMonth()+ "/" + getDay()+ " "+ getHour() + ":"+ getMinute() + " "+ getDescription() + " at " +getLocation();
	}
}
