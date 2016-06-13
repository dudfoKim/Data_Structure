package CircularQueue;

import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		CircularQueue cq1 = new CircularQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("���� �Է�(1), ����(2), ����(0) �Ͻðڽ��ϱ�? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				cq1.printProgress();
				System.out.println("���α׷��� ����...");
				break;
			case 1:
				System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
				cq1.add(sc.next());
				cq1.printProgress();
				break;
			case 2:
				if(cq1.first() != null){
					System.out.println(cq1.remove()+"�� �����Ǿ����ϴ�.");
					cq1.printProgress();
				}else{
					cq1.remove();
				}
				break;
			}
		}while(select!=0);
	}
}
