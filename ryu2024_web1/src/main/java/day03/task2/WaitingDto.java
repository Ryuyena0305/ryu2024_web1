package day03.task2;

public class WaitingDto {
	private String phoneNum;
	private int pNum;
	private WaitingDto() {}
	public WaitingDto(String phoneNum, int pNum) {
		super();
		this.phoneNum = phoneNum;
		this.pNum = pNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	@Override
	public String toString() {
		return "WaitingDto [phoneNum=" + phoneNum + ", pNum=" + pNum + "]";
	}
	
	
}
