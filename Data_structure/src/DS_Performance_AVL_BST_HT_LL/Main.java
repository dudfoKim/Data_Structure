package DS_Performance_AVL_BST_HT_LL;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
	
	static HashTable h = new HashTable(30);
	static LinkedList l = new LinkedList();
	static BinarySearchTree b = new BinarySearchTree();
	static AVLTree a;
	
	private static long htime=0, ltime=0, btime=0, atime=0;
	private long startTime = 0;
	private long endTime = 0;
	
	public Main(String file){
		int lineNumber = 0;
		boolean first = true;
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line != null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()){  //�ܾ �Ѱ��� �Է¹���
					
					String word = parser.nextToken().toUpperCase();
					
					startTime = System.nanoTime();
					l.add(word);  //���� ���� ���� ����
					endTime = System.nanoTime();
					ltime += endTime - startTime;
					
					startTime = System.nanoTime();
					b.add(word);  //���� Ʈ�� ����
					endTime = System.nanoTime();
					btime += endTime - startTime;
					
					if(first){
						startTime = System.nanoTime();
						a = new AVLTree(word);
						endTime = System.nanoTime();
						first = false;		
					}else{
						startTime = System.nanoTime();
						a.add(word);
						endTime = System.nanoTime();
					}
					atime += endTime - startTime;
					
					startTime = System.nanoTime();
					//h.put(word, word);  //�ؽ� ����
					endTime = System.nanoTime();
					htime += endTime - startTime;
				}
				line = in.readLine();
			}
			in.close();
		}catch(IOException e){System.out.println(e);}
	}
	
	public static void main(String[] args){	
		h.setMode(2);  //�����ؽ� ���
		
		new Main("C:/Users/jinWook/Desktop/���� ����/eclipse/�ڷᱸ��_����/src/HW07/example.txt");	
		
		System.out.println("1. ���� ���Ḯ��Ʈ ���  ");
		l.print();
		
		System.out.println("\n2. ���� Ž�� Ʈ�� ���  ");
		b.inorderPrint();
		
		System.out.println("\n3. AVLTree ���  ");
		a.toString();
		
		System.out.println("\n4. ���� �ؽ� ���  ");
		//h.Print();
		
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("���� �� (���� �� �ҿ� �ð�)");
		
		System.out.println("1. ���� ����  : " + ltime);
		System.out.println("2. ���� Ž��  : " + btime);
		System.out.println("3. AVL Ʈ�� : " + atime);
		System.out.println("4. ���� �ؽ� : " + htime);
		
	}
}