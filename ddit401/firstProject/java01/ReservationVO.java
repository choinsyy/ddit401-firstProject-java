package vo;

public class ReservationVO {

	private String routeNo;
	private String arrivalSpot;
	private String time;
	
	public ReservationVO() {
	}
	
	public ReservationVO(String time) {
		this.time = time;
	}

	public ReservationVO(String routeNo, String arrivalSpot) {
		this.routeNo = routeNo;
		this.arrivalSpot = arrivalSpot;
	}

	public String getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}
	public String getArrivalSpot() {
		return arrivalSpot;
	}
	public void setArrivalSpot(String arrivalSpot) {
		this.arrivalSpot = arrivalSpot;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "노선번호 : " + routeNo + ", 도착지명 : " + arrivalSpot;
	}
	
}
