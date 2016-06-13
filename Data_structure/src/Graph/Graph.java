package Graph;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	int size;
	Node[] a;			//�� ������ �ϳ��� ����Ʈ�� ������ �Ѵ�
	String[] vertices;  //�������� ����
	
	boolean[] visited;
	String[] prev;
	int[] dist;
	
	public Graph() throws IOException{
		FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/���� ����/eclipse/�ڷᱸ��_����/src/HW02/hw02");
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
					 
					 for(int i=0;i < size; i++){
						a[i] = new Node(i, null); 
					 }
					 
				}else{
					//����ġ�϶�
					add(inputs[0], inputs[1], (int)token.nval);
					inputs[0] = inputs[1] = null;
					
				}break;
				
			case StreamTokenizer.TT_WORD:
				if(token.lineno() < size+2 && token.lineno() > 1){
					//���� �Է¹���
					vertices[index++] = token.sval;
					
				}else{
					//����ġ graph ����
					if(inputs[0]==null){
						inputs[0] = token.sval;
					}else{
						inputs[1] = token.sval;
					}
					
				}break;
			}			
		}
		stream.close();
	}
	
	public void add(String v, String w, int weight){
		a[index(v)].add_vertex(index(w), weight);
		a[index(w)].add_vertex(index(v), weight);
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
	
	private void dijkstra(String V){
		visited = new boolean[size];
		prev = new String[size];
		dist = new int[size];
		for(int i = 0; i < size; i++)	this.dist[i] = Integer.MAX_VALUE;  //dist�� ���Ѵ�� ����
		
		prev[index(V)] = null;
		dist[index(V)] = 0;
		
		for(Node point = a[index(V)]; point != null; point = findShortestDist()){
			
			for(int i = 0; i < size;i++){
				System.out.print(visited[i]+"  ");
			}System.out.println();
			
			visited[point.index] = true;
			for(Node p = point.next; p != null; p = p.next){
				int P_index = p.index;
				if(!visited[P_index] && dist[point.index] + p.weight < dist[P_index]){
					dist[P_index] = dist[point.index] + p.weight;
					prev[P_index] = vertices[point.index];
				}
			}
		}
	}
	
	private Node findShortestDist(){
		int M_dist = Integer.MAX_VALUE;
		Node min = null;
		
		for(int i = 0; i < size; i++){
			Node point = a[i];
			if(M_dist > dist[i] && !visited[i]){
				M_dist = dist[i];
				min = point;
			}
		}
		
		if(M_dist == Integer.MAX_VALUE || M_dist == 0){
			return null;
		}else{
			return min;
		}
	}
	
	public void printpath(){
		Stack<String> s = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<size; i++){
			System.out.print(vertices[i]+" ");
		}System.out.println("�� " + size + "���� ����(Vertex)�� �ֽ��ϴ�. ������� �Է��Ͻÿ�:");
		String input = sc.nextLine();
		
		dijkstra(input);
		
		for(int i = 0; i < size; i++){
			System.out.print(vertices[i] + ": �Ÿ�" +  dist[i] + " / ");
			if(index(input) == i){    //��������� ��
				System.out.println("�����");
			}else if(prev[i].equals(input)){  //�ѹ��� ������ ��
				System.out.println(input + "->" + vertices[i]);
			}else{  
				int p = i;
				do{
					s.push(vertices[p]);
					p = index(prev[p]);
				}while(!(s.peek()).equals(input));
				
				do{
					if((s.peek()).equals(vertices[i])){
						System.out.println(s.pop());
					}else{
						System.out.print(s.pop() + "->");
					}
				}while(!s.isEmpty());
			}
		}
	}
	
	public void printGraph(){
		for(int i=0; i < size; i++){
			Node point = a[i];
			System.out.print(vertices[point.index] + ": ");
			for(Node p = point.next; p != null; p = p.next){
				System.out.print(vertices[p.index] + "," + p.weight +"  ");
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
		
		printDFS(L);
	}
	
	private void printDFS(String[] L){
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
		int weight;
		
		Node(int index, Node next){
			this.index = index;
			this.next = next;
		}
		
		Node(int index, Node next, int weight){
			this.index = index;
			this.next = next;
			this.weight = weight;
		}
		
		public void add_vertex(int index, int weight){
			this.next = new Node(index, next, weight);
		}
	}
}
