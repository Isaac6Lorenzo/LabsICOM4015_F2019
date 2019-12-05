public class UPRMClass {
	
	private Student[] roster;
	private int studentCount;
	
	/**
	 * A method to initialize an UPRMClass data structure
	 */
	public UPRMClass() {
		roster = new Student[3];
		studentCount = 0;
	}
	
	/**
	 * A method to initialize an UPRMClass data structure with the given space reserved.
	 */
	public UPRMClass(int initialSpace) {
		roster = new Student[initialSpace];
		studentCount = 0;
	}
	
	public UPRMClass(Student[] initialClass) {
		roster = initialClass;
		studentCount = initialClass.length;
				
	}
	
	public int size() {
		return studentCount;
	}
	
	public Student getStudent(int index) {
		if(index < 0 || index >= studentCount) return null;
		return roster[index];
	}
	
	public Student[] getInternalArray() {
		return roster;
	}
		
	public UPRMClass add(Student student) {
		if(studentCount >= roster.length) {
			Student[] newRoster = new Student[roster.length*2];
			for(int i = 0; i < roster.length; i++) {
				newRoster[i] = roster[i];
			}
			roster = newRoster;
		}
		roster[studentCount++] = student;
		return this;
	}
	
	/**
	 * Exercise #1
	 * Adds all the given students into the instance roster.
	 * HINT: You may find the add method useful
	 * @param students
	 */
	public void addAll(Student[] students) {
		// Add code here!
		for (int i = 0; i < students.length; i++) {
			Student estudiante = students[i];
//			roster[i] = this.add(estudiante);
		}
		
	}
	
	/**
	 * Exercise #2
	 * Returns true if and only if target and parameter Classes have the same ammount of students
	 * and all the students are the same.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof UPRMClass) {
			UPRMClass otherO = (UPRMClass) o;
			UPRMClass otherClass = (UPRMClass) o;
			// Add Code Here
			
			if((otherClass.size() == otherO.size()) && otherClass.equalsObject(otherO)){
				
				return true;
			}
//			return true; // Dummy return

		}
		return false;
	}
	
	public boolean equalsObject(Object o) {
		if (o instanceof UPRMClass) {
			UPRMClass otherO = (UPRMClass) o;
			UPRMClass otherClass = (UPRMClass) o;
			// Add Code Here
			
			for (int i = 0; i < roster.length; i++){
				if((otherClass.getStudent(i).getName() == otherO.getStudent(i).getName()) && 
						(otherClass.getStudent(i).getID() == otherO.getStudent(i).getID())){
					if((otherClass.getStudent(i).getGPA() == otherO.getStudent(i).getGPA() && 
							(otherClass.getStudent(i).getMajor() == otherO.getStudent(i).getMajor()))) {
						if((otherClass.getStudent(i).getYearsInCollege() == otherO.getStudent(i).getYearsInCollege())) {
							return true;
						}
						
					}
				
			}}

		}
		return false;
	}

	/**
	 * Exercise #3
	 * Returns the average years between all the students that are in the given major.
	 * @return
	 */
	public int averageYearsInCollege(String major) { 
		// Add code here
		int count =0;
		int avg = 0;
		int sum = 0;
		for (int i = 0; i < roster.length; i++) {
			if(roster[i].getMajor() == major) {
				count++;
			}
		}
		Student[] years = new Student[count];
		for (int i = 0; i < roster.length; i++) {
			if(roster[i].getMajor() == major) {
			for (int j = 0; j < years.length; j++) {
				years[j] = roster[i];
			}
			}
		}
		
		for (int i = 0; i < years.length; i++) {
			sum += years[i].getYearsInCollege();
		}
		avg = sum / count;
		
		return avg; // Dummy return
	}
	
	/**
	 * Exercise #4
	 * Returns the first student with the lowest GPA.
	 * @return
	 */
	public Student minGPA() {
		// Add code here
//		Student minGPA = roster[0].getGPA();
//		for (int i = 0; i < roster.length; i++) {
//			{	if(roster[i] == null) return minGPA;
//		}
//	}
		return null; // Dummy return
	}
	
	
	/**
	 * Exercise #5
	 * Returns true if there is a repeated student in the roster, false otherwise.
	 * @return
	 */
	public boolean repeatedStudent() {
		// Add code here
//		roster[0];
		return false; // Dummy return
	}
	

	public static class Student {
		
		private String id;
		private String name;
		private String major;
		private double gpa;
		private int yearsInCollege;
	
		public Student(String id, String name, String major, double gpa, int yearsInCollege) {
			this.id = id;
			this.name = name;
			this.major = major;
			this.gpa = gpa;
			this.yearsInCollege = yearsInCollege; 
		}
	
		// Getters
		public String getID() {
			return id;
		}
	
		public String getName() {
			return name;
		}
	
		public String getMajor() {
			return major;
		}
	
		public double getGPA() {
			return gpa;
		}
	
		public int getYearsInCollege() {
			return yearsInCollege;
		}
	
		/**
		 * Returns true if and only if target and parameter StudentRecord's have equal ID's
		 */
		@Override
		public boolean equals(Object o) {
			if (o instanceof Student) {
				Student sr = (Student) o;
				return this.getID().equals(sr.getID());
			}
			return false;
		}
	}
}