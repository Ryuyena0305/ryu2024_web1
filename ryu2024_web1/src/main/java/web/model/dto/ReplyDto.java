package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyDto {
	private int rno;
	private String rcontent;
	private int mno;
	private String mname;
	private String rdate;
	private int bno;
}
