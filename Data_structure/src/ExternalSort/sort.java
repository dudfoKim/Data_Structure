package ExternalSort;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class sort {
	SLinkedQueue [] q = new SLinkedQueue [8];
	BinarytreeNode [] t = new BinarytreeNode[15];
	int [] result;
	int num=0;
	
	public sort() throws IOException{   //���� �Է� ����
		FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/���� ����/eclipse/�ڷᱸ��_����/src/HW08/input.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		for(int i = 0; i < 8; i++)	q[i] = new SLinkedQueue();  //ť ����
		
		int linenum=1;
		
		while((token.nextToken() != StreamTokenizer.TT_EOF)){
			if(linenum != token.lineno()){
				q[linenum-1].add(Integer.MAX_VALUE);
				linenum++;  //�����ٷ� �Ѿ�� ���
			}
			q[linenum-1].add((int)token.nval);
			num++;
		}
		q[7].add(Integer.MAX_VALUE);
		result = new int [num];
		stream.close();
		
		int j = 7;
		for(int i = 14; i >= 0; i--){   //���� Ʈ�� ����
			if(i >= 7){
				t[i] = new BinarytreeNode(q[j--]);
			}else{
				t[i] = new BinarytreeNode(t[2*i+1], t[2*i+2]);
			}
		}
		
		externalsort();
	}
	
	public void print(){
		for(int i=0; i < num; i++){
			System.out.print(result[i] +" ");
			if(result[i] % 10 == 0) System.out.println( );
		}
	}
	
	public void externalsort(){
		result[0] = t[0].element;

		for(int i=1; i < num; i++){  //���� ����-1 ��ŭ �ݺ� (�������� �ѹ� ������)
			//Queue���� ���ο� ���� remove�Ͽ� ��忡 ����
			//result ������ �� ���� ���� ��带 ������Ʈ!!
			for(int j = 7; j < 15; j++){
				if(result[i-1] == t[j].element){
					t[j].element = (int)t[j].data.remove();
					break;
				}
			}
			
			//���� ��ȸ�� �ϸ鼭 �� update��
			if(t[0].side == 0) postOrder(t[0].leftchild); 
			else postOrder(t[0].rightchild);
			
			//top�� element, side ��������
			updateNode(t[0]);
			
			result[i] = t[0].element;
		}
	}
	
	private void updateNode(BinarytreeNode node){
		if(node.side == -1){
			//���� ��� �ϋ��� ����
		}else if(node.leftchild.element > node.rightchild.element){
			node.side = 1;
			node.element = node.rightchild.element;
		}else{
			node.side = 0;
			node.element = node.leftchild.element;
		}
	}
	
	private void postOrder(BinarytreeNode node) {
		if (node == null)  return;
		postOrder(node.leftchild);
	    postOrder(node.rightchild);
	    updateNode(node);
	}
	
	
	private static class BinarytreeNode{
		int side;  //-1�̸� ��Ȱ��ȭ, 0�� ����, 1�� ������ �ڽ�
		int element;    SLinkedQueue data;
		BinarytreeNode leftchild;
		BinarytreeNode rightchild;
		
		BinarytreeNode(BinarytreeNode leftchild, BinarytreeNode rightchild){
			this.data = null;
			this.leftchild = leftchild;
			this.rightchild = rightchild;
			
			if(leftchild.element > rightchild.element){
				this.side = 1;
				this.element = rightchild.element;
			}else{
				this.side = 0;
				this.element = leftchild.element;
			}
		}
		
		BinarytreeNode(SLinkedQueue data){
			this.side = -1;
			this.data = data;
			this.element = (int) data.remove();
			this.leftchild = null;
			this.rightchild = null;
		}
	}
}
