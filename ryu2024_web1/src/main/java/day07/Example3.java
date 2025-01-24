package day07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Example3 {

	public static void main(String[] args) {
		//[1] HashSet 인스턴스 생성
		Set<String> set = new HashSet<>();
		//[2] set 인터페이스 주요 메소드들
			//(1) .add(자료) : set 내 지정한 자료를 추가한다.
		set.add("정준재");System.out.println(set); //[정준재]
		set.add("오원석");System.out.println(set); //[오원석, 정준재]
		set.add("조병현");System.out.println(set); //[오원석, 정준재, 조병현]
			//(2) .size() : set내 전체 요소 개수 반환
		System.out.println(set.size()); //3
			//(3) .remove(자료) : set 내 지정한 자료가 존재하면 삭제
		set.remove("오원석"); System.out.println(set);//[정준재, 조병현]
			//(4) .contains(자료) : set내 지정한 자료가 존재하는지 
		System.out.println(set.contains("정준재"));	//true
			//(5) 순회, JDBC(DAO) : ResultSet
		Iterator<String> rs = set.iterator();//iterate : 반복하다
		while(rs.hasNext()) {
			System.out.println(rs.next());
		}
			//1. 일반 for문 , 사용불가능, 왜? 인덱스가 존재하지 않으므로 순회 불가능
			//2. 향상된 for문 , 향상된 for문 문법 자체가 Iterator 기반으로 만들었기 때문
		for(String str : set) {System.out.println(str);}
			//3. forEach()함수, forEach함수도 Iterator 기반으로 만들었기 때문에
		set.forEach((str)->{System.out.println(str);});
		
			//(6) set 컬렉션은 
		set.add("정준재"); System.out.println(set);
		set.add("정준재"); System.out.println(set);
		
		//[3] TreeSet 인스턴스 생성
		Set<String> set2 = new TreeSet<String>();
		set2.add("정준재");
		set2.add("오원석");
		set2.add("조병현");
		System.out.println(set2);
		System.out.println(set2.descendingSet());
	}
	
	
	

}
