package ArrayListQueue;
import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		ArrayListQueue q1 = new ArrayListQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("���� �Է�(1), ����(2), ����(0) �Ͻðڽ��ϱ�? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				q1.print();
				System.out.println("���α׷��� ����...");
				break;
			case 1:
				System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
				q1.addQ(sc.next());
				break;
			case 2:
				if(q1.isEmpty()){
					System.out.println("ť�� ����ֽ��ϴ�.");
				}else{
					System.out.println(q1.removeQ()+"�� �����Ǿ����ϴ�.");
				}
				break;
			default:
				System.out.println("�� �տ��� : "+q1.first());
				 System.out.println("�ٽ� �Է��Ͻÿ�.");
				 break;
			}
		}while(select!=0);
	}
}