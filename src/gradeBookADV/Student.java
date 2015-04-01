package gradeBookADV;
import javax.swing.*;
public class Student {
	
	
	String newline = "\n";
	int age, gradeLevel;
	String name;
	String[] courses;
	double[][] gradingScale;
	Student()
	{
		name = " ";
		age = 16;
		gradeLevel = 10;
		courses = new String[7];
		gradingScale = new double[7][2];
	}
	Student(String n, int a, int gradeLvl)
	{
		name = n;
		age = a;
		gradeLevel = gradeLvl;
		courses = new String[7];
		gradingScale = new double[7][2];
	}

	public void setCourses(boolean includeGradingScale)
	{
		if(includeGradingScale == true)
		{
			String input;
			double temp = 0.0;
			for(int i=0; i < this.courses.length; i++)
			{
				input = JOptionPane.showInputDialog("Please enter the name for course " + (i+1));
				this.courses[i] = input;
				input = JOptionPane.showInputDialog("Please enter the formative for the course " + (i+1));
				
				try
				{
					temp = Double.parseDouble(input);
					if(temp > 1)
					{
						temp/=temp;
					}
					System.out.println(temp);
				}
				catch(NumberFormatException error)
				{
					JOptionPane.showMessageDialog(null, "You did not enter a number in proper format (It must be in decimal form)");
				}
				this.gradingScale[i][0] = temp;
				this.gradingScale[i][1] = 1-temp;
			}
		}
		else
		{
			String input;
			for(int i=0; i < this.courses.length; i++)
			{
				input = JOptionPane.showInputDialog("Please enter the name for course " + (i+1));
				this.courses[i] = input;
			}
		}
	}
	
	
	public void setCourse(int index, String name)
	{
		this.courses[index] = name;
	}
	
	public void setCourse(int index, String name, double formative, double summative)
	{
		this.courses[index] = name;
		this.gradingScale[index][0] = formative;
		this.gradingScale[index][1] = summative;
	}
	
	public void setGradingScale(int index, double formative, double summative)
	{
		this.gradingScale[index][0] = formative;
		this.gradingScale[index][1] = summative;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getGradingScale(int index)
	{
		String grading_scale = "";
		grading_scale = "Formative: " + this.gradingScale[index][0] + newline
				+ "Summative: " + this.gradingScale[index][1] + newline;
		return grading_scale;
	}
	
	public String getCourses()
	{
		String all_grades = "";
		for(int i=0; i<this.courses.length; i++)
		{
			all_grades+=this.courses[i] + ": " + this.getGradingScale(i);
		}
		return all_grades;
	}
}
