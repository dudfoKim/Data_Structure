package ListBag;

import java.util.Scanner;

public class TestBag {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		ListBag b1 = new ListBag();
		boolean done = true;
		int select = 0;
		
		while(select == 0){
			System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
			b1.add(sc.next());
			System.out.print("����Է��Ͻðڽ��ϱ�?(��:0 / �ƴϿ�:1)");
			select = sc.nextInt();
		}
		
		b1.print();
		select = 0;
		
		while(select == 0){
			System.out.print("������ ���Ҹ� �Է��ϼ��� : ");
			done = b1.remove(sc.next());
			if(done == true){
				System.out.print("����Է��Ͻðڽ��ϱ�?(��:0 / �ƴϿ�:1)");
				select = sc.nextInt();
			}else if(done == false){
				System.out.println("�Է��� ���Ұ� �������� �ʽ��ϴ�.");
				System.out.print("����Է��Ͻðڽ��ϱ�?(��:0 / �ƴϿ�:1)");
				select = sc.nextInt();
			}
		}
		b1.print();
	}
}
