
public class Professor {
	
	private String Name;
	private Lecture lecture;
	
	public Professor(){
		
	}
	
	public Professor(String Name){
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setProfessorName(String Name) {
		this.Name = Name;
	}

	public void addLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		this.lecture = lecture;
	}

	public void showLecture() {
		// TODO Auto-generated method stub
		System.out.println(lecture.getName());
	}
	
}
