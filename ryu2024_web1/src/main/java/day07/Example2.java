package day07;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
	public static void main(String[] args) {
		//1. ArrayList 인스턴스 생성
				//1. 인스턴스 : new ArrayList<String>(); //클래스
				//2. 변수명 : list,						//아무거나
				//3. 변수의 타입 : List<String> list		//인터페이스타입
			List<String> list = new ArrayList<String>();//ArrayList 타입은 List 인터페이스를 구현했으므로
		
		//2. List 인터페이스 메소드를
				//(1) .add(자료) : 리스트 내 지정한 자료를 마지막 요소 추가
				//(1) .add(인덱스,자료) : 리스트 내 지정한 인덱스에 지정한 자료의 요소 추가
			list.add("정준재"); System.out.println(list);//[정준재]
			list.add("오원석"); System.out.println(list);//[정준재, 오원석]
			list.add("박성한"); System.out.println(list);//[정준재, 오원석, 박성한]
			list.add("최지훈"); System.out.println(list);//[정준재, 오원석, 박성한, 최지훈]
			list.add(2,"최정"); System.out.println(list);//[정준재, 오원석, 최정, 박성한, 최지훈]
		
				//(2) .set(인덱스,자료) : 리스트 내 지정한 인덱스에 지정한 자료의 요소 수정/변경
			list.set(3,"박지환"); System.out.println(list); //3번째 위치에 자료 변경//[정준재, 오원석, 최정, 박지환, 최지훈]
		
				//(3) .get(인덱스) : 리스트내 지정한 인덱스의 요소 값 변환
			System.out.println(list.get(1));//1번째 위치한 요소 값 반환//'오원석'
			String str1 = list.get(0);//1번째 위치한 요소 값 반환//'정준재'
			System.out.println(str1);
		
				//(4) .size() : 리스트내 요소 전체 개수 반환
			System.out.println(list.size()); //5
		
				//(5) .contains(자료) : 리스트내 지정한 자료 존재 여부 반환 , true/false
			System.out.println(list.contains("박성한"));//true
			boolean result1 = list.contains("한유섬");
			System.out.println(result1); //false
		
				//(6) .indexOf(자료) : 리스트내 지정한 자료의 인덱스 반환 , 없으면 -1있으면 인덱스 수 반환
			System.out.println(list.indexOf("박지환"));//3
			int result2 = list.indexOf("김성현");
			System.out.println(result2);
		
				//(7) .remove(인덱스/자료) : 리스트내 지정한 인덱스/자료의 요소 삭제
			list.remove(4);
			System.out.println(list);
		
				//(8) .clear() : 리스트내 모든 요소 삭제
				//(9) .isEmpty() : 리스트내 요소가 비어있으면 true 1이상 존재하면 fasle 반환
			System.out.println(list.isEmpty());
		
				//(10) 리스트내 요소들을 순회 (하나씩 꺼내기)하는 방법
			//1. 일반 for문
			for(int index = 0;index<=list.size()-1;index++) {
				System.out.print(list.get(index));
			}
			//2. 향상된 for문, for(타입 반복변수명 : 리스트명){}
			for(String str : list) {
				System.out.print(str);
			}
			//3. forEach() , JS : () => {} , JAVA : () ->{}
			list.forEach((str)->{System.out.println(str);});
		}
	//3. 클래스 들
		//3가지 주요 클래스들은 사용법(메소드) 동일하다.
	

}
