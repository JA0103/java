import java.util.Scanner;

public class IfMaxQuestion {

	public static void main(String[] args) {
		

		//세 정수 입력 받아서 최대값 출력(배열x)
		//1)
		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int num3 = sc.nextInt();
//
//		int max =0;
//		
//		if(num1>num2 && num1>num3)
//			max = num1;
//		else if(num2>num1 && num2>num3)
//			max = num2;
//		else if(num3>num1 && num3>num2)
//			max = num3;
//		
//		System.out.println(max);
		
	
		
		//2) 강사님 버전
//		Scanner sc = new Scanner(System.in);
//				
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		int num3 = sc.nextInt();
//		
//		int max = num1;
		
//		if(num2 > max){
//			if(num2> num3)
//				max = num2;
//			else 
//				max = num3;
//		}
//		else if(num3 > max)
//			max = num3;
//		
//		System.out.println(max);
		
		
		
		//세정수를 큰 순서대로 출력
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int max, min, med;
		max=min=med=0;
		
		if(num2>num1) {
			if(num2>num3) {
				max = num2;
				if(num1 > num2) {
					med = num1;
					min = num3;
				}
			}
			else {
				max = num3;
				med = num2;
				min = num1;
			}
		}else if (num3>num1) {
			max = num3;
			med = num1;
			min = num2;
		}else {
			if(num2>num3) {
				max = num1;
				med = num2;
				min = num3;
			}else {
				max = num1;
				med = num3;
				min = num2;
			}
		}
		
		System.out.printf("max :%d , med : %d , min : %d %n",max ,med, min);
	}

}
