package vo;

public class TimeVO {
	private String time;

	public TimeVO() {
	}
	
	public TimeVO(String time) {
		super();
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return time;
	}
	
}
