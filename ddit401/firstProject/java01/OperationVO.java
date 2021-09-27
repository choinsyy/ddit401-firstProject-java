package vo;

public class OperationVO {
	private String time;
	public OperationVO() {
	}

	public OperationVO(String time) {
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
		return "OperationVO [time=" + time + "]";
	}
	
}
