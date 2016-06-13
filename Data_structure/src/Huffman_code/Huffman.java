package Huffman_code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Huffman {
	MinHeap queue = new MinHeap(30);
	int[] freq = new int[26];  int word = 0;
	LinkedList l;
	String code = "";
	

	public void incode() {
		readFile(0, "book.txt", null);  //�󵵼� ���
		
		for (int i = 0; i < freq.length; i++){  //�ּ� ���� ����
			if(freq[i] != 0){
				trecord input = new trecord((char)(i + 65), freq[i], null, null);
				queue.insert(input);
				queue.minHeap();
				word++;
			}
		}
		
		HuffmanTree();  //������ Ʈ�� ����
		
		l = new LinkedList();
		HuffmanCode(queue.remove());  //������ �ڵ� ����
		l.print();
		
		readFile(1, "book.txt", "incode.txt");  //���ڵ�
		
	}
	
	public void decode(){
		readFile(2, "incode.txt", null);
	}
	
	private void readFile(int op, String read, String write){
		int lineNumber = 0;
		String inputCode = "";
		FileWriter out = null;  PrintWriter bufOut = null;

		try {
			BufferedReader in = new BufferedReader(new FileReader(read));
			if(op==1){
				out = new FileWriter(write);
				bufOut = new PrintWriter(new BufferedWriter(out));
			}
			 
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++) {
						char input = word.charAt(i);
						
						if(op == 0)  freq[(int)input - 65]++;  //�󵵼� ���
						
						else if(op == 1){
							System.out.print(l.getCode(input));  //���ڵ�
							bufOut.print(l.getCode(input));
						}
						
						else if(op == 2){                    //���ڵ�
							inputCode += (input+"");
							String result = l.getWord(inputCode);
							if(result != null){
								System.out.print(result);
								inputCode = "";
							}
						}
						
					}
				}
				line = in.readLine();
				if(op != 0){
					System.out.println();
					if(op==1) bufOut.println(" ");
				}
			}
			in.close();
			if(op == 1) bufOut.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void HuffmanCode(trecord root){
		if (root == null) return;
			
		root.binaryCode = code;
		if(root.alphabet != '\0'){
			l.add(root);
		}else{
			code += "0";
		}
		HuffmanCode(root.lchild);
		code = root.binaryCode;
		code += "1";
		HuffmanCode(root.rchild);
		code = root.binaryCode;
	}
	
	private void HuffmanTree() {
		for (int i = 1; i < word; i++) {
			trecord tnode = new trecord();
			tnode.lchild = queue.remove();		// �켱����ť queue���� �켱 ������ ���� ���� �����ؼ� ����		
			tnode.rchild = queue.remove();
			tnode.freq = tnode.lchild.freq + tnode.rchild.freq;
			queue.insert(tnode); // �켱����ť queue�� ���� ������ Ʈ�� tnode�� ����
		}
	}
}