package P1;

public class PlayTime {
	protected int minute;
	protected int second;
	protected int millisecond;
	
	public PlayTime() {
		// TODO Auto-generated constructor stub
		minute = 12;
		second = 0;
		millisecond = 0;
	}

	public PlayTime(int t) {
		// TODO Auto-generated constructor stub
		minute = t;
		second = 0;
		millisecond = 0;
	}


	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getMillisecond() {
		return millisecond;
	}

	public void setMillisecond(int millisecond) {
		this.millisecond = millisecond;
	}

	public String str() {
		return this.minute +":" + this.second;
	}
}
