import java.util.Arrays;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		//if�� ����Ͽ� �ټ��� ���� �Է� �޾� ���� ū ���� ����ϴ� ���α׷� �ۼ�
		//�Է¹޴� ���� 0~100 ���̰��� �ǵ���. 5�� �Է¹޾� ū �� ���ϱ�
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		int max = 0;
		String tmp;

		System.out.println(">>");
		
		
		for(int i=0; i<5; i++) {
			tmp = sc.nextLine();
			num = Integer.parseInt(tmp);
			
			if(0>num || num>100) {
				System.out.println("0�̻� 100���ϸ� �Է�");
				i--;
			}
			
			else if(max<num)
				max=num;
		}
		System.out.println(max);
		
		
	}

}