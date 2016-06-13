package LinkedStack;

import java.util.Scanner;

public class getParentheses {
	public static void main (String [] args){
		
		String equation = null;
		LinkedStack stack = new LinkedStack();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է��Ͻÿ� : ");
		equation = sc.nextLine();
		
		Object [] input = equation.split(" ");
		Object [] output = new Object [input.length];
		int outputIndex = 0;
		
		for(int i = 0; i < input.length; i++){
			
			if(input[i].equals("(")){
				stack.push(i + " ");
				
			}else if(input[i].equals(")")){
				if(!stack.isEmpty()){
					output[outputIndex] = stack.pop();
					outputIndex++;
					output[outputIndex] = i;
					outputIndex++;
				}else{
					stack.push(i);
					outputIndex++;
				}
			}
		}
		
		if(outputIndex % 2 == 0 && outputIndex != 0 && stack.isEmpty()){
			for(int i = 0; i < output.length; i++){
				if(i % 2 == 0 && output[i] != null){
					System.out.println(output[i] +", "+ output[i+1]);
				}
			}
			System.out.println("��ȣ���Ⱑ �½��ϴ�.");
		}else{
			System.out.println("��ȣ���Ⱑ ���� �ʽ��ϴ�.");
		}
	}
}
