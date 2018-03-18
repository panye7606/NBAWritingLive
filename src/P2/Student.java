package P2;

public class Student {
	protected String studentId;
	protected String studentName;
	protected String studentSex;
	protected String studentAge;
	
	public  Student() {
		
	}
	public Student(String studentId, String studentName, String studentSex, String studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentAge = studentAge;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String i) {
		this.studentSex = i;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentSex=" + studentSex
				+ ", studentAge=" + studentAge + "]";
	}
	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	
	

}
