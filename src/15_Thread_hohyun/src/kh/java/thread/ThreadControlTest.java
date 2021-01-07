package kh.java.thread;

import javax.swing.JOptionPane;

public class ThreadControlTest {
	
	public static void main(String[] args) {
		ThreadControlTest t = new ThreadControlTest();
		t.test1();
//		t.test2();
//		t.test3();
//		t.test4();
		
		System.out.println("[" +Thread.currentThread().getName() + "종료]");
	}
	
	/*
	 * 쓰레드 종료시키기
	 * 1. 해당 쓰레드의 interrupt() 메소드 호출
	 * 2. InterruptedException발생
	 * 3. catch절에 다음액션(종료) 작성
	 * 
	 */
	
	private void test4() {
		
		Thread cnt = new CountDown(100);
		cnt.start();
		
		JOptionPane.showMessageDialog(null, "확인을 누르면, 카운트다운을 종료합니다.");
		cnt.interrupt();
		
	}
	
	/**
	 * 쓰레드간의 종속관계
	 * 일반쓰레드 - Daemon쓰레드
	 * Daemon - linux계열의 컴퓨터에서 백그라운드 프로세스를 가리키는 말
	 */
	private void test3() {
		Thread cnt = new CountDown(50);
		cnt.setDaemon(true);//메인 종료 버튼 누르면 같이 종료됨.
		cnt.start();
		
		//main thread 일시 정지 다이어로그 생성.
				JOptionPane.showMessageDialog(null, "확인을 누르면 메인쓰레드가 종료됩니다.");
		
	}
	

	/**
	 * 3의 배수출력 쓰레드와 
	 * 4의 배수출력쓰레드를 생성하고 실행하세요.
	 * [Thread이름 - 배수]
	 * 실행간격은 200밀리초.
	 * 100초과시 중지할것.
	 * 
	 * [3배수 쓰레드 - 3]
	 * [3배수 쓰레드 - 6]
	 * [3배수 쓰레드 - 9]
	 * [4배수 쓰레드 - 4]
	 * [3배수 쓰레드 - 12]
	 * [4배수 쓰레드 - 8]
	 * ....
	 * ...
	 */
	private void test2() {
		Thread a = new Thread(new testThread(3, 200));
		Thread b = new Thread(new testThread(4, 100));
		
		a.setName("3배수 쓰레드");
		b.setName("4배수 쓰레드");
		
		a.start();
		b.start();
		
	}
	
	private void test1() {
		Thread a = new Thread (new SleepThread('|', 50));
		Thread b = new Thread (new SleepThread('-', 30));
		
		a.setName("a쓰레드");
		b.setName("b쓰레드");
		
		a.start();
		b.start();
	}
}
