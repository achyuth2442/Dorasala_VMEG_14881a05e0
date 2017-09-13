import java.util.*;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else
		{
			this.students=students;
		}
		
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index >= students.length)
		{
			throw new IllegalArgumentException("Students not exist");
		}
		else{
			return this.students[index];
		}
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException("Student not exist");
	}
	else if(index < 0 || index >= this.students.length)
	{
		throw new IllegalArgumentException("Student not exists");
	}
	else{
		this.students[index]=student;
	}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException("Student not exists");
		}
		else{
			Student[]  stued= new Student[this.students.length+1];
			stued[0]=student;
			for(int i=0;i<this.students.length;i++)
			{
				stued[i+1]=students[i];
			}
			this.students=stued;
		}
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student==null)
		{throw new IllegalArgumentException("student not exists");
		}
		else{
		Student[] stued= new Student[this.students.length+1];
		int i=1;
		for(i=1;i<=this.students.length;i++)
		{
			stued[i]=students[i];
		}
		stued[i+1]=student;
		this.students=stued;
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		Student[] stued= new Student[this.students.length+1];
		int i;
		if(student==null)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else if(index < 0 || index >= students.length)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else
		{
			for(i=0;i<index;i++)
			{
				stued[i]=students[i];
			}
		stued[index]=student;
		for(i=index+1;i<this.students.length;i++)
		{
			stued[i]=students[i-1];
		}
		this.students=stued;
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index >= this.students.length)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else
		{
			Student[] stued= new Student[this.students.length-1];
			int i,j=0;
			for(i=0;i<this.students.length;i++)
			{
				if(i == index)
				{
					continue;
				}
				else
				{
					stued[j]=students[i];
					j=j+1;
				}
			}
		this.students=stued;
	}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException("Student no exist");
		}
		else
		{
			Student[] stued= new Student[this.students.length-1];
			int i,j=0,f=0;
			for(i=0;i<this.students.length;i++)
			{
				if(students[i] == student)
				{	f=1;
					continue;
				}
				else
				{
				stued[j]=students[i];
				j=j+1;
				}
			}
			if(f == 0)
			{
				throw new IllegalArgumentException("Student not exist");
			}
			else
			{
				this.students=stued;
			}
		}	
		
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		Student[] stued = new Student[students.length-index];
		int i;
		if(index < 0 || index >=this.students.length)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else
		{
				for(i=0;i<this.students.length;i++)
			{
				if(i == index+1)
				{	
					break;
				}
				else
				{
				stued[i]=students[i];
				}
			}
				this.students=stued;
	}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int limit=0;
		if(student==null)
		{
			throw new IllegalArgumentException("Students not exist");
		}
		else
		{
			for(int i=0;i<this.students.length;i++)
			{
				if(students[i] == student)
				{limit=i;
					break;
				}
			}
			Student[] stued=new Student[limit];
			for(int i=0;i<=limit;i++)
			{
				stued[i]=students[i];
			}
			students=stued;
		}	
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= this.students.length)
		{
			throw new IllegalArgumentException("Student not exist");
		}
		else
		{
			int start=0,i;
			Student[] stued= new Student[students.length-index];
			for(i=index;i<this.students.length;i++)
			{
				stued[start]=students[i];
				start=start+1;
			}
			this.students=stued;
		}
	
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException("Students not exist");
		}
		else
		{
			int i=0,limit=0,start=0;
			for(i=0;i<this.students.length;i++)
			{
				if(students[i] == student)
				{	
					break;
				}
				limit=i;
			}
			Student[] stued=new Student[students.length-limit];
			for(i=limit;i<this.students.length;i++)
			{
				stued[start]=students[i];
			}
			this.students=stued;
	}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int start=0;start<this.students.length-1;start++)
		{
			for(int start1=0;start1<this.students.length;start1++)
			{
				if(students[start1].getId() > students[start1+1].getId())
				{
					Student stued = students[start1];
					students[start1]=students[start1+1];
					students[start1+1]=stued;
				}
			}		
		}			
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max_marks=0;
		for(int start=0 ;start<this.students.length;start++)
		{
			if(students[start].getAvgMark() > max_marks)
			{
				max_marks=students[start].getAvgMark();
			}
		}
		ArrayList<Student> max = new ArrayList<Student>();
		for(int j=0;j<this.students.length;j++)
		{
			if(students[j].getAvgMark()==max_marks)
			{
				max.add(students[j]);
			}
		}
		students= max.toArray(new Student[max.size()]);
		return students;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null)
		{
			throw new IllegalArgumentException("Student not exists");
		}
		else
		{int i;
			for(i=0;i<this.students.length;i++)
			{
				if(students[i]==student)
				{
					break;
				}
			}
			return this.students[i+1];
		}
	}
}
