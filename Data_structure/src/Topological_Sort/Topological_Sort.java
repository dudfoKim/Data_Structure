package Topological_Sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Topological_Sort {
		int size;
		Node[] a;			//�� ������ �ϳ��� ����Ʈ�� ������ �Ѵ�
		String[] vertices;  //�������� ����
		int[] indegree;
		
		public Topological_Sort() throws IOException{
			FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/���� ����/eclipse/�ڷᱸ��_����/src/HW04/hw04");
			InputStreamReader reader = new InputStreamReader(stream);
			StreamTokenizer token = new StreamTokenizer(reader);
			
			int index = 0;
			String[] inputs = {null,null};
			
			while((token.nextToken() != StreamTokenizer.TT_EOF)){			
				switch(token.ttype){
				case StreamTokenizer.TT_NUMBER:
					if(token.lineno() == 1){  
						//������ ù ��° ��, ������ ��
						 this.size = (int)token.nval;
						 a = new Node[size];
						 vertices = new String[size];
						 indegree = new int[size];
						 
						 for(int i=0; i<size; i++){
							 a[i] = new Node(i);
						 }
						 
					}break;
					
				case StreamTokenizer.TT_WORD:
					if(token.lineno() < size+2 && token.lineno() > 1){
						//���� �Է¹���
						vertices[index++] = token.sval;
						
					}else{
						//graph ����
						if(inputs[0]==null){
							inputs[0] = token.sval;
						}else{
							inputs[1] = token.sval;
							add(inputs[0], inputs[1]);
							indegree[index(inputs[1])]++;
							inputs[0] = null;
							inputs[1] = null;
						}
						
					}break;
				}			
			}
			stream.close();
		}
		
		public void add(String v, String w){
			a[index(v)].add_vertex(index(w));
		}
		
		public String toString(){
			if(size == 0) return "{}";
			StringBuffer buf = new StringBuffer("{"+vertices[0]);
			for(int i = 1; i <size; i++)
				buf.append(","+vertices[i]);
			return buf+"}";
		}
		
		private int index(String v){
			for(int i = 0; i < size; i++)
				if(vertices[i].equals(v)) return i;
			return vertices.length;
		}
		
		public void topsort(){
			Stack s = new Stack();
			int vert = size;
			
			do{
				//indegree�� 0�� ���� stack�� ����
				for(int i=0; i < size; i++){
					if(indegree[i] == 0){
						s.push(i);
					}
				}
				
				//pop
				while(s.size() != 0){
					int p_index = (int)s.pop();
					vert--;
					if(vert != 0) System.out.print(vertices[p_index] + "->");
					else System.out.print(vertices[p_index]);
					
					//1����
					Node point = a[p_index];
					for(Node p = point; p != null; p = p.next){
						indegree[p.index]--;
					}
				}
				
			}while(vert != 0);
		}
		
		public void printGraph(){
			for(int i=0; i < size; i++){
				Node point = a[i];
				System.out.print(vertices[point.index] + ": ");
				for(Node p = point.next; p != null; p = p.next){
					System.out.print(vertices[p.index]+"  ");
				}System.out.println();
			}
		}
		
		private static class Node{
			int index;
			Node next;
			
			Node(int index){
				this.index = index;
				this.next = null;
			}
			
			Node(int index, Node next){
				this.index = index;
				this.next = next;
			}
			
			public void add_vertex(int index){
				this.next = new Node(index, next);
			}
		}
}