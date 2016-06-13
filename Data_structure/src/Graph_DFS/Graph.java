package Graph_DFS;
import java.util.Stack;

public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	
	
	public Graph(String[] args){  //args���� ���� ������
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}
	
	public void add(String v, String w){  //������ ���ڸ� �߰�  ����� true�� ��ȯ��Ŵ
		int i = index(v), j= index(w);
		a[i][j] = a[j][i] = true;
	}
	
	public String toString(){    //����� ��� �޼ҵ�
		if(size ==0) return "{}";
		StringBuffer buf = new StringBuffer("{"+vertex(0));
		for(int i=1;i < size;i++)
			buf.append(","+vertex(i));
		return buf + "}";
	}
	
	private int index(String v){
		for(int i=0; i<size; i++)
			if(vertices[i].equals(v)) return i;  //������ �迭 �ε��� ��ȣ ��ȯ 
		return a.length; //�߸� �Էµ� ��
	}
	
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for(int j=0; j < size; j++)
			if(a[i][j]) buf.append(vertices[j] + " ");
		return buf + "";
	}
	
	public void DFS_search(){
		Stack<String> s = new Stack<String>();  //����, ��� ����Ʈ �ʱ�ȭ
		String[] L = new String [size];
		String point = null;
		int L_index = 0;
		boolean[] visit = new boolean[size];
		
		s.push(vertices[0]);  //�ܰ� 2~3
		visit[0] =true;
		L[L_index] = point = (String) s.pop();
		
		do{										//4~6�ܰ�
			for(int i = 0; i<size; i++){
				if(a[index(point)][i] && visit[i] == false){
					s.push(vertices[i]);
					visit[i] = true;
				}
			}
			point = (String) s.pop();
			L[++L_index] = point;
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
}


