package test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MemberDto {
	private int mno;
	private String mname;
	private String mphone;
	private String maddress;
	private String mdate;
	private String mgrade;
	private int mcode;
	

}
