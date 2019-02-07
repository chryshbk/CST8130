package assign1;

public abstract class Events {
	private OurDate ourDate = new OurDate();
	private OurTime ourTime = new OurTime();
	private String description, location, extra;
	
	public Events() {}
	
	public Events(int year, int month, int day, int hour, int minute, String description, String location, String extra) {
		setYear(year);
		setMonth(month);
		setDay(day);
		setHour(hour);
		setMinute(minute);
		setDescription(description);
		setLocation(location);
		setExtra(extra);
	}
	
	public abstract int getType();
	
	public void setYear(int year) {ourDate.setYear(year);}
	public int getYear() {return ourDate.getYear();}
	
	public void setMonth(int month) {ourDate.setMonth(month);}
	public int getMonth() {return ourDate.getMonth();}
	
	public void setDay(int day) {ourDate.setDay(day);}
	public int getDay() {return ourDate.getDay();}
	
	public void setHour(int hour) {ourTime.setHour(hour);}
	public int getHour() {return ourTime.getHour();}
	
	public void setMinute(int minute) {ourTime.setMinute(minute);}
	public int getMinute() {return ourTime.getMinute();}
	
	public String getDescription() { return description;};
	public void setDescription(String description) { this.description = description; }
	
	public String getLocation() { return location; };
	public void setLocation(String location) { this.location = location; }
	
	public String getExtra() { return extra;}
	public void setExtra(String extra) { this.extra = extra;}
	
	@Override
	public String toString() { 
		return "\t"+ ourDate.getYear() + "/"+ ourDate.getMonth()+ "/" + ourDate.getDay()+ " "+ ourTime.getHour() + ":"+ ourTime.getMinute() + " "+ getDescription(); }
	
}
