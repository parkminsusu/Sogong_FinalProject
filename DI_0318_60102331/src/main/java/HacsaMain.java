import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HacsaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Professor professor = new Professor("choi");
		//Lecture lecture = new Lecture("소프트웨어 공학");
		
		
		ApplicationContext factory = new ClassPathXmlApplicationContext
				(new String[]{"applicationContext.xml"}); //XML파일을 가지고 온다.
		
		Professor professor = (Professor)factory.getBean("professor"); //id를 파라메터로 생성해준다.
		Lecture lecture2 = (Lecture)factory.getBean("lecture2");
		Student student1 = (Student)factory.getBean("student1");
		
		lecture2.addStudent(student1);
		lecture2.showLecture();
		//professor.addLecture(lecture2);
		//professor.showLecture();
		
	}

}
