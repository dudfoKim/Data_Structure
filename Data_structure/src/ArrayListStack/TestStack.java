package ArrayListStack;

import java.util.Scanner;

public class TestStack {
	public static void main(String [] args){
		ArrayListStack s1 = new ArrayListStack();
		
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("���� �Է�(1), ����(2), ����(0) �Ͻðڽ��ϱ�? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				s1.print();
				System.out.println("���α׷��� ����...");
				break;
			case 1:
				System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
				s1.push(sc.next());
				break;
			case 2:
				if(s1.isEmpty()){
					System.out.println("ť�� ����ֽ��ϴ�.");
				}else{
					System.out.println(s1.pop()+"�� �����Ǿ����ϴ�.");
				}
				break;
			default:
				System.out.println("�� �տ��� : " + s1.peek());
				 System.out.println("�ٽ� �Է��Ͻÿ�.");
				 break;
			}
		}while(select!=0);

	}
}
