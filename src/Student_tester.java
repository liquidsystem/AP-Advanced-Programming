/*
Programmer: Lori Hunt
Program: Student_tester
Purpose: This program will test my Student class.
*/

public class Student_tester
{

	public static void change_weights(double summ, double form)
	{
		Student.FORM = form;
		Student.SUMM = summ;
	}

	
   public static void main(String[] args)
   {
	   
	   Student jackson = new Student("Jackson Lee");
	   Student jared = new Student();
	   Student nicholas = new Student("Nicholas Monday",17,4);
	   
	   
	   //Setting their name(in case you didn't use the Student(String name) method)
	   jared.set_name("Jared Schwartz");
	   
	   //Setting ages
	   jackson.set_age(17);
	   jared.set_age(17);
	   
	   
	   //Changing teachers (this changes for ALL students, teacher is static)
	   Student.teacher = "Ms. Parks";
	   
	   
	   //Print students
	   System.out.println(jackson.print_student());
	   System.out.println(jared.print_student());
	   System.out.println(nicholas.print_student());
	   
	   //Enter grades for students
	   jackson.enter_grades(5, 'f');
	   jared.enter_grades(3, 's');
	   
	   //Set email
	   jackson.set_email("test");
	   System.out.println(jackson.get_email());
	   
	   
	   //Check the formative and summative weights
	   System.out.println(Student.FORM);
	   System.out.println(Student.SUMM);
	   
	   change_weights(0.5,0.5);
	   
   }

}

/*

Before doing these, complete the Student class.  You will be testing all
of the methods/constructors. Once you have completed that class, you will
be able to do the following in this program:
1. Define three students.  Make sure to use one of each of the constructors
2. Change some of the information about each of the students, make sure they
   all end up with all of the information necessary to make a complete student
3. Test all of your methods
4. Ms. Hunt retired :(.  The new teacher has decided that she would like to
   change the weighting for formative and summative. You will have to write a mutator method
   in the class that will allow this program to change the weights (this is similar to the 
   change_teacher method in the Student class that will change a static value for all students.
   From THIS program, change the weight of summative to .9 and formative to .1.
   You will also change the teacher name in this program.
5.  Does the new weight and teacher name get reflected in all students?  Why?
6.  What does 'static' mean in the context of java programming?
	Static means that in all cases, it'll always be the same, if you don't make a method static, then you'll have to do something like
	Formative formative = new Formative(); instead of just calling the method Formative();

*/