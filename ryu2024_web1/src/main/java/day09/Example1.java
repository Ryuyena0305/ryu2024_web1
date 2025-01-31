package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		// [1] 실행중인 자바 자료를 (윈도우)파일 출력(쓰기)
		//FileOutputStream out = new FileOutputStream("파일 경로")
		// - c드라이브에 'java'폴더를 하나 생성하기
		// - FileNotFoundException : 예외처리
		
		try {
			//(1)파일출력스트림 객체 생성한다. 1.파일경로 2. 예외처리
		FileOutputStream out = new FileOutputStream("C:/java/test1.txt");
		// (2) 출력할 문자열
		String str = "HELLO JAVA";
		// (3) 출력할 문자열을 바이트열로 변환 - "".getBytes() : String -> bytes[] 변환함수
		byte[] outStr = str.getBytes();
		// (4) 출력스트림 객체 내 출력함수로 바이트열 내보내기 .write(출력할바이트) , - 예외처리함수 
		out.write(outStr);
		}catch (FileNotFoundException e) {System.out.println(e);}
		catch (IOException e) {System.out.println(e);}
		
		//[2] 키보드로부터 입력받은 자료를 파일에 출력하기
		try {
		FileOutputStream out = new FileOutputStream("C:/java/test2.txt");
		Scanner scan = new Scanner(System.in);
		System.out.println("[2]메모장에 작성할 내용입력 : ");
		String str = scan.nextLine();
		byte[] outStr = str.getBytes();
		out.write(outStr);
		}catch(IOException e) {System.out.println(e);}
		
	}// m e 
}// c e
