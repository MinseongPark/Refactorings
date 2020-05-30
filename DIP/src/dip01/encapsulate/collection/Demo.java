/*
 * SMELL: Inappropriate Intimacy
 *   -- One class uses the internal fields and methods of another class.
 *   -- A class contains a collection field and a simple getter and setter 
 *      for working with the collection.
 *
 * TREATMENT: Encapsulate Collection
 *   -- Make the getter-returned value read-only and create methods for 
 *      adding/deleting elements of the collection.
 *   
  */
package dip01.encapsulate.collection;

import java.util.HashSet;
import java.util.Set;

class Course
{
	private String name;
	private boolean isAdvanced;
	
	public Course(String name, boolean isAdvanced)
	{
		this.name = name;
		this.isAdvanced = isAdvanced;
	}

	public boolean isAdvanced()
	{
		return isAdvanced;
	}
}

class Person
{
	private Set<Course> courses;

	public Set<Course> getCourses()
	{
		return courses;
	}

	public void setCourses(Set<Course> arg)
	{
		courses = arg;
	}
}

public class Demo
{

	public static void main(String[] args)
	{

		// Client code
		Person kent = new Person();
		Set<Course> s = new HashSet<>();
		s.add(new Course("Smalltalk Programming", false));
		s.add(new Course("Appreciating Single Malts", true));
		kent.setCourses(s);
		assert (kent.getCourses().size() == 2);

		Course refact = new Course("Refactoring", true);
		kent.getCourses().add(refact);
		kent.getCourses().add(new Course("Brutal Sarcasm", false));
		assert (kent.getCourses().size() == 4);

		kent.getCourses().remove(refact);
		assert (kent.getCourses().size() == 3);

		int count = 0;
		for (Course course : kent.getCourses())
		{
			if (course.isAdvanced())
			{
				count++;
			}
		}
		System.out.print("Advanced courses: " + count);
	}
}