package Huffman_code;

public class LinkedList {
	private int size;
	private trecord start;
	

	public int size(){
		return size;
	}

	public boolean add(trecord object){  //�Է¹��� ���Ҹ� ���ᱸ�� �������� ����		
		if(start == null){   //���ᱸ�� �� ���� null�� ���
			start = new trecord(object);
			++size;
			return true;
		}

		for(trecord p = start; p != null; p = p.next){  //�� ���� null�� �ƴϰ� �ڿ� ���Ұ� �ִ� ���			
			if(p.next == null){  //linked list�� �� ���ڸ��� ã���� ��� ����
				p.next = new trecord(object);
				++size;
				return true;
			}
		}return false;
	}
	
	public String getCode(char word){
		for(trecord p = start; p != null; p = p.next){
			if(p.alphabet == word){
				return p.binaryCode;
			}
		}
		return null;
	}
	
	public String getWord(String code){
		for(trecord p = start; p != null; p = p.next){
			if((p.binaryCode).equals(code)){
				return p.alphabet+"";
			}
		}
		return null;
	}
	
	public void print(){
		for(trecord p = start; p != null; p = p.next){
			System.out.println(p.binaryCode + " : "+ p.alphabet);
		}
	}
}