import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		int cnt =0;
		
		{
				
			File file = new File("data/data1.txt");  //파일 자체의 위치 저장
			FileInputStream src = new FileInputStream(file);  //파일 인풋. 읽어오기
			
			Scanner sc = new Scanner(src); //읽어주는 건 여기
			
			while(sc.hasNext()) {   //hasNext 읽어올게 있는지. hasNextLine-->통으로
				String tmp = sc.next();
				System.out.printf("%s " , tmp );
				cnt++;
			}
			System.out.println("cnt : "+cnt);
			
			sc.close();  //클로즈 반드시 필요
			src.close();  //==
		}
		
		
		int[] nums = new int[cnt];
		{	
			
			File file = new File("data/data1.txt");
			FileInputStream src = new FileInputStream(file);
			Scanner sc = new Scanner(src);
			
				
			for(int i =0; i<nums.length; i++) {
				String tmp = sc.next();
				nums[i]=Integer.parseInt(tmp);
			}
			
			System.out.println("nums : " +Arrays.toString(nums));
			
			sc.close();
			src.close();
		}	
		
		//배열에서 특정 숫자 찾기
		{

			int index = -1;
			for(int i =0; i<cnt; i++) {
				if(nums[i]==88) {
					index = i;
					break;
				}
			}
			System.out.println("위치는 : " +index);
		
		}
		
		//index 위치 변경 --> 0 <--> 5 위치 교환
		{
			int tmp =0;
			tmp = nums[0];
			nums[0] = nums[5];
			nums[5] = tmp;
			
			System.out.println("nums : "+Arrays.toString(nums));
			
		}
		
		//반복적으로 i <> i+1를 교환
		{
			for(int i=0;i<cnt-1;i++) {
					int tmp =0;
					tmp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = tmp;
					
				Thread.sleep(1000);
				
				for(int j=0; j<10; j++)
					System.out.println();
				
				for(int j=0; j<cnt;j++)
					if(j==i+1 || j== i+0)
						System.out.printf("[%d] ",nums[j]);
					else
						System.out.printf("%d ", nums[j]);
			}
			//System.out.println("nums : "+Arrays.toString(nums));
		}
		
	}//main.end

}
