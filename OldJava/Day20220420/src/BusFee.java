import java.util.Arrays;
import java.util.Scanner;

public class BusFee {
	public static void main(String[] args) {
			
		int age = input();
		int fee = 2500;
		double rate = feeRate(age); 
		
		output(fee,age,rate);
		}
	
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		return age;
	}
	
	static double feeRate(int age) {
				
		double rate = 0;
				
				if(0<=age && age<=3)
					rate =0;
				else if(age<=13)
					rate =0.5;
				else if(age<=19)
					rate =0.75;
				else if(age<=64)
					rate =1;
				else if(age>=65)
					rate =0;
				
				return rate ;
		
	}
	
	static void output(int fee,int age, double rate) {
		System.out.println(age+"세"+(int)(fee*rate)+"원");
		
	}
	
	
	}//class.end