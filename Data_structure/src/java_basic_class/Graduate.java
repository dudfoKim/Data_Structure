package java_basic_class;

public class Graduate extends Student{
	String degree = null;
	
	public Graduate(String name, int year, double grade, String degree){
		super(name, year, grade);
		this.degree = degree;
	}
	
	@Override
	public void graduate_year() {
		if(degree == "����"){
			System.out.println("�����⵵(����) : "+ (year + 2)); //����
		}
		else if(degree == "�ڻ�"){
			System.out.println("�����⵵(�ڻ�) : "+ (year + 5)); //�ڻ�
		}
		else{
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
	}
}

