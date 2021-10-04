package ddit.or.kr.collection;

public class Phone {
	private String name;
	private String address;
	private String phoneNum;
	
	public Phone() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return phoneNum +"\t"+ address;
	}
	
	
	
	
}
