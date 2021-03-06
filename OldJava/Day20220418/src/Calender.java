import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class Calender {

	public static void main(String[] args) {

		
		//달력 만들기
		Scanner sc = new Scanner(System.in);

		System.out.println("연도 입력 : ");
		int year = sc.nextInt();
		System.out.println("월 입력 : ");
		int month = sc.nextInt();

		//월 마지막 날짜 배열
		
		int[] lastD ={31,28,31,30,31,30,31,31,30,31,30,31};
		
		//2월)윤년 구하기
		
		if(month==2 && (year/4==0 && (year/100!=0 || year/400==0)))
			lastD[1]=29;
		
		//원하는 날짜 전 날들 구하기 ( 작년까지의 총 일 수 + 이번년도에서 원하는 날짜까지의 일 수 )
		int day;
		int week;
		
		//작년까지의 총 날짜 구하기
		int lastY = year-1;                                   //(일 월 화 수 목 금 토)
		day = (lastY*365 + lastY/4 - lastY/100 + lastY/400)+1; //+1 : 일요일부터 시작
		
		//이번년도 원하는 날짜까지의 일 수 
		for(int i=0; i<month-1;i++)
			day+= lastD[i];
		
		week = day%7;// 요일
		
		//출력//
		
		System.out.printf("%n %d년 %d월",year,month);
		System.out.printf("%n===========");
		System.out.printf("%n-----------------------");
		System.out.printf("%n일  월  화  수  목  금  토");
		System.out.printf("%n-----------------------%n");

		
		for(int i=0;i<week;i++)
			System.out.print("   "); //1일 출력 전 공백
			
		for(int i=1; i<lastD[month]-1;i++) {
			System.out.printf("%3d",i);
			week++; //줄 이동 해주기 위해 + 시켜줌
				if(week%7==0)  //일주일 넘어가면 줄 이동
					System.out.println();  
		}
			
		
		
			
	} //class.end

}
