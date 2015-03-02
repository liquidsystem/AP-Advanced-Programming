import javax.swing.JOptionPane;

/*
Programmer: Lori Hunt
Program: Student class
Purpose: This program allows a programmer to set up a Student
name, formative_average, summative_average, age, email_address, 
grade (year in school 9, 10, 11, 12) define a student


*/
public class Student
{

   String name, email_address;
   double formative_average, summative_average, final_grade;
   int age;
   int grade;
   static String teacher = "Ms. Hunt";
   static double FORM = .2; //formative scores are weighted less than summative 
   static double SUMM = .8;
   
   
   //Lots of ways to construct a Student.  Here are three, can you think of more?
   // Constructors describe what a Student IS.
   Student()
   {
      name = " ";
     email_address = " ";
     formative_average = 0;
     summative_average = 0;
     age = 15;
     grade = 10;
     final_grade = 0;
   }
   
   Student(String n)
   {
      name = n;
     email_address = " ";
     formative_average = 0;
     summative_average = 0;
     age = 15;
     grade = 10;
     teacher = "Ms. Hunt";
     final_grade = 0;
   }

   
   
   Student(String n, int a, int g)
   {
     name = n;
     email_address = " ";
     formative_average = 0;
     summative_average = 0;
     age = a;
     grade = g;
     teacher = "Ms. Hunt";
     final_grade = 0;
   }
   
   
   //The section below is the methods section.  This section describes what a student DOES.
   // Mutator Methods are methods that set a value from the attributes listed in the 
   // constructors.  I will define a few of them here and let you work on the rest.
   void set_name(String n)
   {
      name = n;
   
   }

   void set_age(int a)
   {
      age = a;
   }
   
   void set_grade(int g)
   {
      grade = g;
   }
   
   void set_email(String e)
   {
      email_address = e;
   }
   
   
   void change_teacher(String n)
   {
      teacher = n;
   }
   
   void set_formative(double f)
   {
	   formative_average = f;
   }
   
   void set_summative(double s)
   {
	   summative_average = s;
   }
   
   
/// ... you can do the rest!!

   
   /*
   ACCESSOR METHODS These methods are also called 'Getters'. They allow programmers to access information
   from the class.  I will write a few of them here and let you finish them up... 
   */
   
   String get_name()
   {
      return name;
   }
   
   int get_age()
   {
      return age;
   }
   
   int get_grade()
   {
      return grade;
   }
   
   double get_summative()
   {
	   return summative_average;
   }
   
   double get_formative()
   {
	   return formative_average;
   }
   
   String get_email()
   {
	   return email_address;
   }
   
   String get_teacher()
   {
	   return teacher;
   }
   
// ... you can write the rest
   
// Other methods:  Maybe a Student can have some other actions.
// This section should include the final_grade(), enter_grades(int num_items, char type) 
// as defined below

//@method: enter_grades( char type)
// Takes the type of score(formative or summative)  This method will internally 
// set formative_average or summative average based on the information given
// @param: the type of scores to be entered: formative or summative
// @return: nothing

void enter_grades(int num_items, char type)
{
// ... you write the code here!!
	//Variable initialization and declaration for method use
	double formativeAsDouble = 0;
	double formative_sum = 0;
	double summativeAsDouble = 0;
	double summative_sum = 0;
	//End of initialization
	
	
	//if...then for "formative" scores
	if(type == 'f')
	{
		for(int i = 0; i < num_items; i++) //Make a for:loop that goes for as long as argument num_items
		{
			String formativeAsString = JOptionPane.showInputDialog("Please enter your formative grade for " + get_name() + " : ");
			if (formativeAsString == null)
			{
				break;
			}
			try
			{
				formativeAsDouble = Double.parseDouble(formativeAsString);
			}catch(NumberFormatException err)
			{
				System.out.println("Formative not able to be processed as a double");
			}
			formative_sum += formativeAsDouble;
		}
		
		formative_average = formative_sum*FORM / num_items;
		final_grade();
	}
	//if...then for "summative" scores
	else if(type == 's')
	{
		for(int i = 0; i < num_items; i++) //Make a for:loop that goes for as long as argument num_items
		{
			String summativeAsString = JOptionPane.showInputDialog("Please enter your summative grade for " + get_name() + " : "); //Get number as string
			if (summativeAsString == null)
			{
				break;
			}
			try
			{
				summativeAsDouble = Double.parseDouble(summativeAsString); //Convert to double
			}catch(NumberFormatException err)
			{
				System.out.println("Summative not able to be processed as a double");
			}
			summative_sum += summativeAsDouble; //Add amount entered for each iteration
		}
		summative_average = summative_sum / num_items; //Set summative_average to the average of summative_sum/num_items
		final_grade();
	}
	//

}

// @method: final_grade()
// Calculate the final score for the student based on the weight given to the 
// formative and summative grades.
// @param: none
// @return the value of the final grade for the student
double final_grade()
{
  // ... you write the code here!!
	double summative = get_summative();
	double formative = get_formative();
	summative*=SUMM;
	formative*=FORM;
	final_grade=summative+formative;
  return final_grade;
}



// @method: print_student()
// @param: none
// @return: A string representing the student information
String print_student()
{
   return ("Student: " + name + "\nGrade: "+ grade + "\nTeacher: " +teacher + "\n");

}

}