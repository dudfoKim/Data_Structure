package java_basic_length;

import java.util.Scanner;

public class Test {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		System.out.print("3���� ������ �Է��Ͻÿ�: ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		MyLength l1 = new MyLength(a,b,c);
		l1.setCM();
		l1.getCM();
		l1.setInch();
		l1.getInch();
	}
}

