package day07;

import java.util.HashMap;
import java.util.Map;

public class Example4 {

	public static void main(String[] args) {
		//[1] HashMap 인스턴스 생성
		Map<String,Integer> map=new HashMap<String,Integer>();
		
		//[2] Map 인터페이스  주요 메소드
			//(1) .put ("key",value) : map 컬렉션내 key와 value를 한쌍으로 저장
		map.put("정준재", 3); System.out.println(map);//{정준재=3}
		map.put("오원석", 47); System.out.println(map);//{오원석=90, 정준재=3}
		map.put("조병현", 19); System.out.println(map);//{오원석=47, 정준재=3, 조병현=19}
		map.put("최정", 14); System.out.println(map);//{최정=14, 오원석=47, 정준재=3, 조병현=19}
		map.put("박성한", 2);System.out.println(map);//{최정=14, 오원석=47, 정준재=3, 박성한=2, 조병현=19}
		
			//(2) .get("key")		:map 컬렉션내 key의 value값 변환
		System.out.println(map.get("정준재"));
		int value1= map.get("오원석");
		System.out.println(value1);//100
		
			//(3) .size() : map 객체내 전체 entry 개수 반환
		System.out.println(map.size());//4
		
			//(4) .remove("key") : map 객체내 지정한 key의 엔트리를 삭제
		map.remove ("박성한"); System.out.println(map);//{최정=14, 오원석=47, 정준재=3, 조병현=19}
			//(5) .map.containsKey("key") , map.containsValue(value) : map 객체내 지정한 key또는 value존재 여부
			//(6) . entrySet() : map객체 내 모든entry를 반환 함수
		System.out.println(map.entrySet());
		
			//(7) .keySet() : map객체 내 모든key를 반환 함수
		System.out.println(map.keySet());//[최정, 오원석, 정준재, 조병현]
		
			//(8) .values() : map객체 내 모든value를 반환 함수
		System.out.println(map.values());//[14, 47, 3, 19]
			//(9) 순회
				//1. 일반 for문주로 사용하지 않음
				//2. 향상된 for문
		for(String key : map.keySet()) {System.out.println(map.get(key));}
		
				//3. forEach()
		map.keySet().forEach((key)->{
			System.out.println(map.get(key));
		});
		
	}

}
