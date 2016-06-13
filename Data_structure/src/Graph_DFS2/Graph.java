package Graph_DFS2;
import java.util.Stack;

public class Graph {
	int size;
	Node[] a;			//�� ������ �ϳ��� ����Ʈ�� ������ �Ѵ�
	String[] vertices;  //�������� ����
	
	public Graph(String [] args){
		size = args.length;
		a = new Node[size];
		vertices = args;
		for(int i = 0; i < size; i++){
			a[i] = new Node(i, null);
		}
	}
	
	public void add(String v, String w){
		a[index(v)].add_vertex(index(w));
		a[index(w)].add_vertex(index(v));
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
	
	public void printNode(){
		for(int i=0; i < size; i++){
			Node point = a[i];
			System.out.print(vertices[point.index] + ": ");
			for(Node p = point; p != null; p = p.next){
				System.out.print(vertices[p.index] + " ");
			}System.out.println();
		}
	}
	
	public void DFS_search(){
		Stack<String> s = new Stack<String>();  //����, ��� ����Ʈ �ʱ�ȭ
		String[] L = new String [size];
		boolean[] visit = new boolean[size];
		Node point;
		int L_index = 0;
		
		s.push(vertices[0]);  //�ܰ� 2~3
		visit[0] =true;
		
		do{										//4~6�ܰ�
			point = a[index(s.pop())];
			L[L_index++] = vertices[point.index];
			
			for(Node p = point; p != null; p = p.next){
				if(visit[p.index] == false){
					s.push(vertices[p.index]);
					visit[p.index] = true;
				}
			}
		}while(!s.empty());
		
		printL(L);
	}
	
	private void printL(String[] L){
		System.out.println("���� �켱 Ž���� ����Դϴ�.");  //���
		System.out.print("{");
		for(int i=0; i < size; i++){
			if(i != size-1){
				System.out.print(L[i] + "->");
			}else{
				System.out.println(L[i] + "}");
			}
		}
	}
	
	private static class Node{
		int index;
		Node next;
		
		Node(int index, Node next){
			this.index = index;
			this.next = next;
		}
		
		public void add_vertex(int index){
			this.next = new Node(index, next);
		}
	}
}
