/*  keyin
Programmer:  Lori Hunt
Program: BasicArray
Purpose:  This program illustrates how basic 1-D arrays
work and some of the manipulations you can do with them.
One thing to note is the use of the word 'static' in front
of those methods...

*/

import javax.swing.*;

public class BasicArray
{

	

	// Notice I am not calling this method toString, but
	// instead I am calling it aString and sending it an array
	// as a parameter.  I can't override the toString method if 
	// I write methods this way.
	public static String aString(int[] a)
	{
		String result = "";
		for(int i = 0; i<a.length; i++)
		{
			result += a[i] + " ";
		}
		System.out.println(result);
	return result;
	}
	
		// This method sorts an array (a) and returns it all
	// sorted in order (see questions below...)
	// See the document for other sorting techniques
public static int[] sort(int[] a)
	{
		
		 int i,j;
		 int temp;  // crucial!
 		for(i = 0; i<a.length-1; i++)
 		{
  			 for(j = i+1; j<a.length; j++)
				{
					if(a[j] < a[i])
					{
		 				temp = a[j];
		 				a[j] = a[i];
		 				a[i] = temp;
					}
				}
		}
		return a;
	}//end sort method

	public void greaterThan(Object j)
	{
		if((j.getClass().getName()).equals("String"));
	
	}
	public static void main(String[] args)
	{
		String[] Name = { "Seymore Code", "Ima Coder", "Cee Plusplus" , "Ima Newkid", "Doyour Best"};
		
		int[] grades = {98, 88, 87, 90, 92};		
		String searchName = " ";//initializing
		int correspondingGrade = -1; //initializeing
		int total=0, ave=0;
		int[] sorted = new int[grades.length];
		
		searchName = JOptionPane.showInputDialog(null, "Name: ");		
		
		while(!searchName.equals("q"))
		{
		// reinitializing everything
		total = 0; ave = 0;
		
		// To search a parallel array:
		for(int i = 0; i < Name.length; i++)
		{
			if(searchName.equals(Name[i]))
			{
				correspondingGrade = grades[i];
				break;
			}
			
		}
		
		if(correspondingGrade == -1)
		{
		JOptionPane.showMessageDialog(null,"Sorry I didn't find that one!  Check spelling.");
		
		}else
		{
		JOptionPane.showMessageDialog(null,searchName + "'s grade is " + correspondingGrade);
		
		
		// If you want to sum up all of the integers in an array:
		for(int j = 0; j<grades.length;j++)
		{
			total += grades[j];
		}
		ave = total/grades.length;
		
		JOptionPane.showMessageDialog(null, "The average is: " + ave);
		
		sorted = sort(grades);
		
		JOptionPane.showMessageDialog(null, "Sorted grades: " + aString(sorted));
		}// end else
		
		searchName = JOptionPane.showInputDialog(null, "Name (q to quit): ");
		}// end while
	}

}


/*
1.  Take this program and write the following 4 methods:
	a.  copy(int[] original) 
	    This method will accept as a parameter an integer
		 array and return a copy of that array.
	b.  sum(int[] a)  
	    This method will sum up the elements of the array
		 sent to it and return the value of the sum.
	c.  search(int[] a, int value)
		 This method will search the array a for the integer
		 value given and return the index location of the given
		 value.
	d.  getLarge(int[] a)
	    This method will return the larges value found in the(unsorted)
		 array given.
		 
2.  Change this program so that you can fill in the names by asking
     the user to enter the names.  Create an array that can hold up to
	  5 names. have the user enter the names to fill in the array.
	  What is a potential problem with setting up an array this way? 		 

3.  Does the sort method sort in ascending or descending order?

4.  What is the meaning of the key word static?  why am I using it here?
    What would happen if I didn't use it?

** Make sure to look at the Searching and Sorting document in this module

*/