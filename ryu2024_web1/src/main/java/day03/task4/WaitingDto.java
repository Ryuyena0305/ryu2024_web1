package day03.task4;

public class WaitingDto {
	private int num;
	private String phoneNum;
	private int pNum;
	public WaitingDto() {}
	public WaitingDto(int num, String phoneNum, int pNum) {
		super();
		this.num = num;
		this.phoneNum = phoneNum;
		this.pNum = pNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
		return "WaitingDto [num=" + num + ", phoneNum=" + phoneNum + ", pNum=" + pNum + "]";
	}
}
