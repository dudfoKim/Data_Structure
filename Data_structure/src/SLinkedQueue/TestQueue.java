package SLinkedQueue;

import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		SLinkedQueue sq1 = new SLinkedQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("���� �Է�(1), ����(2), ����(0) �Ͻðڽ��ϱ�? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				sq1.printProgress();
				System.out.println("���α׷��� ����...");
				break;
			case 1:
				System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
				sq1.add(sc.next());
				sq1.printProgress();
				break;
			case 2:
				if(sq1.isEmpty()){
					System.out.println("ť�� ����ֽ��ϴ�.");
				}else if(sq1.first() != null){
					System.out.println(sq1.remove()+"�� �����Ǿ����ϴ�.");
					sq1.printProgress();
				}else{
					sq1.remove();
				}
				break;
			}
		}while(select!=0);
	}
}
