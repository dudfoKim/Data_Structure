package ArrayStack;

public class ArrayStack implements Stack{
	private Object [] a;
	private int size;
	
	public ArrayStack(int capacity){
		a = new Object [capacity];
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(size == 0)throw new IllegalStateException("Stack is empty"); 
		return a[size-1];
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(size == 0)throw new IllegalStateException("Stack is empty");
		Object object = a[--size];  //push���� �ְ� size�� +1�ؼ� -1�� ���صڿ� �����ؾ���
		a[size] = null;
		return object;
	}

	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub
		if(size == a.length) resize();
		a[size++] = object;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private void resize(){
		Object [] aa = a;
		a = new Object[aa.length * 2];
		System.arraycopy(aa, 0, a, 0, size);
	}
}
