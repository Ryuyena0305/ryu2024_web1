package web.model.dto;

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
public class BoardDto {
    private int bno;              
    private String btitle;                 
    private String bcontent;
    private int bview;
    private String bdate;
    private int mno; 
    private int cno;
    //+HTML에 출력할 때 작성자의 회원번호가 아닌 작성자 ID
    private String mid;
    private String cname;
   
}