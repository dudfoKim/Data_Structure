package java_basic_saveWord;

import java.util.Scanner;

public class Test {
	public static void main(String [] args){
		int select1 = 0;
		int select2 = 0;
		Scanner sc = new Scanner(System.in);
		SaveWord sw1 = new SaveWord();
		
		while(select1 == 0){
			System.out.print("�ܾ �Է��Ͻÿ� : ");
			sw1.SaveWords(sc.next());
			System.out.print("�ܾ ��� �Է��Ͻðڽ��ϱ�?(0:��, 1:�ƴϿ�) : ");
			select1 = sc.nextInt();
		}
		
		sw1.sort();
		sw1.printWord();
		System.out.println(" ");
		
		while(select2 == 0){
			System.out.print("���� �ܾ �Է��Ͻÿ� : ");
			sw1.removeWord(sc.next());
			System.out.print("�ܾ ��� �Է��Ͻðڽ��ϱ�?(0:��, 1:�ƴϿ�) : ");
			select2 = sc.nextInt();
		}
		sw1.printWord();  //������ ���ڵ� ���
	}
}

