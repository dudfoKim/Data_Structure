package java_basic_saveWord;

public class SaveWord {
	String a [] = new String [5];
	
	public SaveWord(){  //�迭 �ʱ�ȭ
		for(int i = 0; i < a.length; i++){
			a[i]=null;
		}
	}
	
	private String[] resize (String [] word_arr){  //�迭�� ũ�⸦ 2��� �÷���
		int n = word_arr.length; 
		String [] temp = new String[2*n];
		System.arraycopy(word_arr, 0, temp, 0, n);
		return temp;
	}
	
	public void SaveWords(String word){   //�迭�ȿ� �ܾ ���ʷ� ����
		for(int i=0; i < a.length; i++){
			if(a[i]==null){
				a[i]=word;
				break;
			}else if(i == a.length-1){  //�迭�� �̹� �� ������ ���
					a = resize(a);
					SaveWords(word);
					break;
				}
		}
	}
	
	public void removeWord(String word){
		for(int i = 0; i < a.length; i++){
			if(a[i] != null){
				if(a[i].compareTo(word) == 0){
					System.arraycopy(a, i+1, a, i, a.length - i - 1);
					a[a.length-1] = null;
				}
			}
		}
	}
	
	 public void sort(){   //�迭 �ȿ� �ִ� �ܾ ���ĺ� ������ ��迭
		 String temp = null;
		 for(int i=0; i < a.length; i++){
			 for(int j = i+1; j < a.length; j++){
				 if(a[j] != null){
					 if(a[i].compareTo(a[j]) > 0){
					 	temp = a[i];
					 	a[i]=a[j];
					 	a[j]=temp;
				 	}
				 }
			 }
		 }
	 }
	
	public void printWord(){  //�迭 ���� �ִ� ���� ���� �� ���
		System.out.print("����� ���� : ");
		for(int i = 0; i < a.length; i++){
			if(a[i] != null){
					System.out.print(a[i] + "  ");
				}else  return;
		}
	}
}
