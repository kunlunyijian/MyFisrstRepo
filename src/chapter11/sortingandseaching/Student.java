package chapter11.sortingandseaching;

public class Student implements Comparable<Student> {
	private int age = 0;
	
	public Student(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student stu) {
		return this.age - stu.getAge();
	}

}
