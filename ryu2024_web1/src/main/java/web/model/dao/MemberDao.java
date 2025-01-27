package web.model.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
public class MemberDao extends Dao{
        // + 싱글톤
        @Getter // 지정된 멤버변수에 getter 적용
        private static MemberDao instance = new MemberDao();
        
} // class end 
