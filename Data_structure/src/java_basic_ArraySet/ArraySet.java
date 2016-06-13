package java_basic_ArraySet;

import java.util.Scanner;

public class ArraySet implements setADT {
	private Object[] objects = new Object[1000];
	private int size, i;
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean add(Object object) {
		// TODO Auto-generated method stub
		if(!contains(object)){
				objects[size++] = object;
				return true;
			}else return false;
	}

	@Override
	public boolean contains(Object object){
		// TODO Auto-generated method stub
		for(int i = 0; i<size; i++){
			if(objects[i].equals(object)) return true;
		}return false;
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		i = 0;
		return objects[i];
	}

	@Override
	public Object getNext() {
		// TODO Auto-generated method stub
		return objects[++i];
	}

	@Override
	public boolean remove(Object object) {  //������ �ȵ�
		// TODO Auto-generated method stub
		for(int i = 0; i<size; i++){
			if(objects[i].equals(object)){
				System.arraycopy(objects, i+1, objects, i, size-i-1);
				objects[--size] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public Object getObject(int index){
		return objects[index];
	}
	
	public void print(){  //p47 �˰��� ����, ���� �۵�
		Object firstobject = getFirst();
		Object nextobject;
		
		if(firstobject != null){
			System.out.print(firstobject + " ");
			do{
				nextobject = getNext();
				if(nextobject != null){
					System.out.print(nextobject + " ");
				}
			}while(nextobject != null);
			System.out.println("");
		}else{
			System.out.println("");
			return;
			}
	}
	
	public void askAdd(){
		int select = 0;
		boolean done = true;
		
		do{
			System.out.print("������ ���Ҹ� �Է��Ͻÿ�: ");
			done = add(sc.next());
			if(done == true){
				System.out.print("��� �Է��Ͻðڽ��ϱ�?(0: �� / 1: �ƴϿ�) : ");
				select = sc.nextInt();
			}else{
				System.out.println("�ߺ��Ǵ� �����Դϴ�. ��� �Է��Ͻðڽ��ϱ�?(0: �� / 1: �ƴϿ�) : ");
				select = sc.nextInt();
				continue;
			}
		}while(select == 0);
	}
	
	public void askRemove(){
		boolean done = true;
		int select = 0;
		
		do{
			System.out.print("������ ���Ҹ� �Է��Ͻÿ�: ");
			done = remove(sc.next());
			if(done == true){
				System.out.print("��� �Է��Ͻðڽ��ϱ�?(0: �� / 1: �ƴϿ�) : ");
				select = sc.nextInt();
			}else{
				System.out.println("���� �����Դϴ�. ��� �Է��Ͻðڽ��ϱ�?(0: �� / 1: �ƴϿ�) : ");
				select = sc.nextInt();
				continue;
			}
		}while(select == 0);
	}
}
