import java.util.Arrays;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		//if문 사용하여 다섯개 정수 입력 받아 가장 큰 수를 출력하는 프로그램 작성
		//입력받는 숫자 0~100 사이값만 되도록. 5개 입력받아 큰 수 구하기
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		int max = 0;
		String tmp;

		System.out.println(">>");
		
		
		for(int i=0; i<5; i++) {
			tmp = sc.nextLine();
			num = Integer.parseInt(tmp);
			
			if(0>num || num>100) {
				System.out.println("0이상 100이하만 입력");
				i--;
			}
			
			else if(max<num)
				max=num;
		}
		System.out.println(max);
		
		
	}

}
