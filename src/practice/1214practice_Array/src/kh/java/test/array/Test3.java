package kh.java.test.array;

import java.util.Scanner;

//[문제3]
//- 클래스 : kh.java.test.array.Test3.java
//- 메소드명 : public void test()
//    문자열을 하나 입력 받아 문자배열에 넣고 검색할 문자를 하나 입력 받아
//    검색 문자가 문자열에 몇 개인지 개수를 출력하는 프로그램을 작성하세요.
//    
//    예) 입력값 : helloworld
//    검색값 :ㅣ
//    출력 : 입력하신 문자열 helloworld에서 찾으시는 문자 l은 3개 입니다.


public class Test3 {

	public static void main(String[] args) {

		Test3 te = new Test3();
		te.test3();
	}public void test3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("영단어 입력하시오");
		String st = sc.nextLine();
		System.out.println("검색하고 싶은 알파벳은?");
		char ch = sc.next().charAt(0);
		
		
		char[] result = new char[st.length()];//영단어 숫자만큼 빈공간 만들음
	
		
		for(int i= 0;i<st.length() ;i++ ) {
			result[i]=st.charAt(i);//빈공간1자리에 영단어 1번쨰를 집어넣음
		}

		int count=0;
		
		for(int i=0; i<st.length();i++) {
			if(ch == result[i]) {
				count++;
			}
			
		}System.out.printf("입력하신 문자열 %s에서 찾으시는 문자 %s은 %s개 입니다.",st,ch,count);
		
		
	}

}
