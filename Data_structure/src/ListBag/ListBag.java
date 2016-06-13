package ListBag;

public class ListBag {
	private int size;
	private Node start;
	private int diffsize;


	public boolean add(Object object){  //�Է¹��� ���Ҹ� ���ᱸ�� �������� ����
		int sameObj = 0;
		
		if(start == null){   //���ᱸ�� �� ���� null�� ���
			start = new Node(object);
			++size;  ++diffsize;
			return true;
		}

		for(Node p = start; p != null; p = p.next){  //�� ���� null�� �ƴϰ� �ڿ� ���Ұ� �ִ� ���
			if((p.data).equals(object)){  //�� �ڷ� �ɾ���鼭 ���� ���Ұ� �ִ� ���
				sameObj++;
			}
			
			if(p.next == null){  //linked list�� �� ���ڸ��� ã���� ��� ����
				p.next = new Node(object);
				++size;
				if(sameObj == 0){
					++diffsize;
				}
				return true;
			}
		}return false;
	}


	public boolean remove(Object object) {   //���ᱸ������ �Է¹��� ���� ����
		int sameObj = 0;
		
		for(Node p = start; p != null; p = p.next){  //���ᱸ�� �ȿ� �Է¹��� ���Ұ� �ִ��� Ȯ��
			if((p.data).equals(object)){
				++sameObj;
			}
		}
		if(sameObj == 1){  //���ο� ���� ���Ұ� �Ѱ��� �ִ� ��� diffsize�� -1
			--diffsize;
		}
		
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
	
	public void print(){  //������ ����, ���� �ٸ� ���� ����, ���Ҹ� ����ϴ� �޼ҵ�
		System.out.println("������ ����: " + size + "\t���� �ٸ� ���ҵ��� ����: " + diffsize);
		for(Node p = start; p != null; p = p.next){
			System.out.print(p.data + " ");
		}
		System.out.println(" ");
	}
	
	
	private static class Node{  //Node Ŭ����
		Object data;
		Node next;
		
		Node(Object data){
			this.data = data;
		}
	}
}
