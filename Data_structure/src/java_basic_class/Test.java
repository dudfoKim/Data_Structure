package java_basic_class;

public class Test {
	public static void main (String [] args){
		UnderGraduate s1 = new UnderGraduate("������",2014, 4.0, true);
		Graduate s2 = new Graduate("������",2012, 3.5, "����");
		
		s1.print();
		s1.graduate_year();
		System.out.println("");
		s2.print();
		s2.graduate_year();
	}
}
