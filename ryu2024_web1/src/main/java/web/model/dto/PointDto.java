package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PointDto {
	private int pno;
	private String pcontent;
	private int pcount;
	private String pdate;
	private int mno;

}
