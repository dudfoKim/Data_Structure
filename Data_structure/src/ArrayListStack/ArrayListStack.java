package ArrayListStack;
import java.util.ArrayList;

public class ArrayListStack extends ArrayList implements Stack{

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			return get(size()-1);
		}
		return null;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			return remove(size()-1);
		}
		return null;
	}

	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub
		add(object);
	}
	
	public int sizeStack(){
		return size();
	}
	
	public void print(){
		System.out.println("������ִ� ���� : ");
		for(int i = 0; i < size(); i++){
			System.out.print(get(i) + " ");
		}
		System.out.println(" ");
	}

}
