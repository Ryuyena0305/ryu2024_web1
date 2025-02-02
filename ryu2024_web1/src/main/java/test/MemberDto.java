package test;

public class MemberDto {
	private int mno;
	private String mname;
	private String mphone;
	private String maddress;
	private String mdate;
	private String mgrade;
	private int mcode;
	
	public MemberDto() {}

	public MemberDto(int mno, String mname, String mphone, String maddress, String mdate, String mgrade, int mcode) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mphone = mphone;
		this.maddress = maddress;
		this.mdate = mdate;
		this.mgrade = mgrade;
		this.mcode = mcode;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String madress) {
		this.maddress = madress;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMgrade() {
		return mgrade;
	}

	public void setMgrade(String mgrade) {
		this.mgrade = mgrade;
	}

	public int getMcode() {
		return mcode;
	}

	public void setMcode(int mcode) {
		this.mcode = mcode;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mname=" + mname + ", mphone=" + mphone + ", madress=" + maddress + ", mdate="
				+ mdate + ", mgrade=" + mgrade + ", mcode=" + mcode + "]";
	}
	

}
