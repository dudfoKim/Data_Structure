package java_basic_ArraySet;

import java.util.Scanner;

public class TestSet {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		ArraySet s1 = new ArraySet();
		
		s1.askAdd();
		System.out.print("�V�� ������: "+ s1.size() + "\t����: ");
		s1.print();
		
		s1.askRemove();
		System.out.print("�V�� ������: "+ s1.size() + "\t����: ");
		s1.print();
	}
}