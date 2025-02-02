package test;

public class SalesDto {
	private int mno;
	private int sno ;
	private int price;
	private int quenti;
	private int tprice;
	private String pnum;
	private String sdate;
	
	public SalesDto() {}

	public SalesDto(int mno, int sno, int price, int quenti, int tprice, String pnum, String sdate) {
		super();
		this.mno = mno;
		this.sno = sno;
		this.price = price;
		this.quenti = quenti;
		this.tprice = tprice;
		this.pnum = pnum;
		this.sdate = sdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuenti() {
		return quenti;
	}

	public void setQuenti(int quenti) {
		this.quenti = quenti;
	}

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "SalesDto [mno=" + mno + ", sno=" + sno + ", price=" + price + ", quenti=" + quenti + ", tprice="
				+ tprice + ", pnum=" + pnum + ", sdate=" + sdate + "]";
	}



}
