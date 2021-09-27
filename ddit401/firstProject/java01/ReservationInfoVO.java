package vo;

public class ReservationInfoVO {
	private String timeCode;
	private String routeNo;
	private int reserveNo;
	private String startTime;
	private int adultTk;
	private int childTk;
	private String id;
	private int seatNo;
	
	public ReservationInfoVO() {
	}
	public String getTimeCode() {
		return timeCode;
	}
	public void setTimeCode(String timeCode) {
		this.timeCode = timeCode;
	}
	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getAdultTk() {
		return adultTk;
	}
	public void setAdultTk(int adultTk) {
		this.adultTk = adultTk;
	}
	public int getChildTk() {
		return childTk;
	}
	public void setChildTk(int childTk) {
		this.childTk = childTk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	@Override
	public String toString() {
		return "ReservationInfoVO [timeCode=" + timeCode + ", routeNo=" + routeNo + ", reserveNo=" + reserveNo
				+ ", startTime=" + startTime + ", adultTk=" + adultTk + ", childTk=" + childTk + ", id=" + id
				+ ", seatNo=" + seatNo + "]";
	}
	
}
