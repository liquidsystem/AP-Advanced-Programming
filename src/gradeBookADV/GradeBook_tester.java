package gradeBookADV;

public class GradeBook_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student test = new Student("Cameron", 18, 12);
//		test.createUI();
		System.out.println(test.getName());
		test.setCourse(0, "Gym");
		test.setCourse(1, "Art");
		test.setCourses(true);
		test.setGradingScale(0, .14, .86);
		System.out.println(test.getCourses());
		System.out.println(test.getGradingScale(0));
	}

}
