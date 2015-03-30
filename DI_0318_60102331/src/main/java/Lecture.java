import java.util.Vector;


public class Lecture {
	private String name;
	private Vector<Student> vector;
	private Student student;
	
	public Lecture(){
		
	}
	public Lecture(String name){
		this.name = name;
		vector = new Vector<Student>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		vector.add(student);
	}
	public void showLecture(){
		System.out.println("강좌명 : "+name);
		System.out.println("수강생 : "+ vector.elementAt(0).getName());
	}
}
