package java_basic_class;

public class Student {
	String name = null;
	int year = 0;
	private double grade = 0;  //�����ʵ�
	
	public Student(String name, int year, double grade){
		this.name = name;
		this.year = year;
		this.grade = grade;
	}
	
	public void graduate_year (){
		System.out.println("�����⵵ : " + (year + 4));
	}
	
	public void print(){
		System.out.println("�̸�: "+ name);
		System.out.println("���� �⵵: "+ year);
		System.out.println("����: "+ grade);
	}
}

