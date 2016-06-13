package DS_Performance_AVL_BST_HT_LL;

public class LinkedList {
	private int size;
	private Node start;

	public boolean add(Object object){  //�Է¹��� ���Ҹ� ���ᱸ�� �������� ����		
		if(start == null){   //���ᱸ�� �� ���� null�� ���
			start = new Node(object);
			++size;
			return true;
		}

		for(Node p = start; p != null; p = p.next){  //�� ���� null�� �ƴϰ� �ڿ� ���Ұ� �ִ� ���
			if((p.data).equals(object)){  //�� �ڷ� �ɾ���鼭 ���� ���Ұ� �ִ� ���
				p.count++;
				return false;
			}
			
			if(p.next == null){  //linked list�� �� ���ڸ��� ã���� ��� ����
				p.next = new Node(object);
				++size;
				return true;
			}
		}return false;
	}


	public boolean remove(Object object) {   //���ᱸ������ �Է¹��� ���� ����	
		if((start.data).equals(object)){  //�Է¹��� ���Ұ� �� �տ� ��ġ�� ���
			start = start.next;
			--size;
			return true;
		}
		
		for(Node p = start; p.next != null; p = p.next){   //�Է¹��� ���Ұ� �� ���Ŀ� ���� ���
			if((p.next.data).equals(object)){
					p.next = p.next.next; 
					--size;
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		for(Node p = start; p != null; p = p.next){
			System.out.println(p.data + " : "+ p.count);
		}
	}
	
	public int size(){
		return size;
	}
	
	private static class Node{  //Node Ŭ����
		Object data;
		Node next;
		int count = 1;
		
		Node(Object data){
			this.data = data;
		}
	}
}