package Graph_DFS2;

public class DFS_test {
	public static void main (String [] args){
		Graph g = new Graph(new String[]{"SE", "UK", "DE", "FR", "CZ", "CH", "AT", "IT"});
		
		System.out.println(g); //�ʱ� �׷��� ���� ��� 
		
		g.add("SE", "UK"); //Edge �߰� 
		g.add("SE", "DE");
		g.add("UK", "FR");
		g.add("DE", "FR");
		g.add("DE", "IT");
		g.add("DE", "CZ");		
		g.add("CH", "FR");
		g.add("CH", "IT");
		g.add("CH", "AT");
		
		g.printNode();
		g.DFS_search();
	}
}
