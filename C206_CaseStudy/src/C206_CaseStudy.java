import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<subjectGroup> subjectGroupList = new ArrayList<subjectGroup>();
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<TuitionInfo> tuitionInfoList = new ArrayList<TuitionInfo>();
		ArrayList<Timetable> ttList = new ArrayList<Timetable>();
		ArrayList<Registration> registrationList = new ArrayList<Registration>();
		

		ttList.add(new Timetable(1001, 80.0, "01/02/2020", "01/10/2020", "Face to Face"));
		ttList.add(new Timetable(1002, 95.0, "01/03/2020", "01/09/2020", "Face to Face"));
		
		registrationList.add(new Registration(4001, 001, "", "abc@gmail.com", "2002/04/14"));
		registrationList.add(new Registration(4002, 001, "", "def@gmail.com", "2002/04/15"));
		
		
		subjectGroupList.add(new subjectGroup("Math", "Math is fun", "Must pass sec1 math"));
		subjectGroupList.add(new subjectGroup("Chemistry", "Chem is fun", "Must pass sec1 chem"));
		
		//Razi
		tuitionInfoList .add(new TuitionInfo(1001, "Mathematics", "Math", "Mathematics is the science and study of quality, structure, space, and change.",
				"1 hour", "Must pass sec1 math", "Mr. Aaron"));
		tuitionInfoList.add(new TuitionInfo(1002, "Chemistry", "Chemistry",
				"The branch of science concerned with the substances of which matter is composed, the investigation of their properties and reactions, and the use of such reactions to form new substances.",
				"45 mins", "Must pass sec1 chem", "Ms. Siti"));
		

		int option = 0;

		while (option != 5) {

			adminMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.setHeader("Maintan Student Details");
				studentMenu();
				Helper.line(80, "-");

				int optionNum = Helper.readInt("Enter option to select > ");

				if (optionNum == 1) {
					student sm = registerstudent(studentList);
					C206_CaseStudy.addstudent(studentList, sm);
				} else if (optionNum == 2) {
					C206_CaseStudy.viewAllstudent(studentList);
				} else if (optionNum == 3) {
					C206_CaseStudy.deletestudent(studentList);
				} else {
					System.out.println("Invalid Option Number");
				}

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("Maintain Tuition Details");

				tuitionMenu();
				int Type = Helper.readInt("Enter option to select > ");

				if (Type == 1) {
					// Maintain tuition timetable details
					C206_CaseStudy.setHeader("Maintain Tuition Timetable Information");
					System.out.println("1. View Tuition Timetable");
					System.out.println("2. Add Tuition Timetable");
					System.out.println("3. Delete Tuition Timetable");
					Helper.line(80, "-");

					int optionNum = Helper.readInt("Enter option to select > ");

					if (optionNum == 1) {
						C206_CaseStudy.viewAllTimetable(ttList);
					} else if (optionNum == 2) {
						Timetable tt = inputTimetable(ttList);
						C206_CaseStudy.addTimetable(ttList, tt);
						System.out.println("Timetable Added!");
					} else if (optionNum == 3) {
						C206_CaseStudy.deleteTimetable(ttList);
					} else {
						System.out.println("Invalid Option Number");
					}

				} else if (Type == 2) {
					// Maintain tuition details
					C206_CaseStudy.setHeader("Maintain Tuition Information");
					System.out.println("1. View Tuition");
					System.out.println("2. Add Tuition");
					System.out.println("3. Delete Tuition");
					Helper.line(80, "-");

					int optionNum = Helper.readInt("Enter option to select > ");

					if (optionNum == 1) {
						C206_CaseStudy.viewAllTuitionInfo(tuitionInfoList);
					} else if (optionNum == 2) {
						TuitionInfo ti = inputTuitionInfo(tuitionInfoList);
						C206_CaseStudy.addTuitionInfo(tuitionInfoList, ti);
						System.out.println("Tuition Information Added!");
					} else if (optionNum == 3) {
						C206_CaseStudy.deleteTuitionInfo(tuitionInfoList);
					} else {
						System.out.println("Invalid Option Number");
					}

				} else {
					System.out.println("Invalid number");
				}

			} else if (option == 3) {
				// Maintan subject group details
				C206_CaseStudy.setHeader("Maintan Subject Group Details");
				subjectGroupMenu();
				Helper.line(80, "-");

				int optionNum = Helper.readInt("Enter option to select > ");

				if (optionNum == 1) {
					subjectGroup sg = registersubjectGroup(subjectGroupList);
					C206_CaseStudy.addsubjectGroup(subjectGroupList, sg);
				} else if (optionNum == 2) {
					C206_CaseStudy.viewAllSubjectGroup(subjectGroupList);
				} else if (optionNum == 3) {
					C206_CaseStudy.deleteSubjectGroup(subjectGroupList);
				} else {
					System.out.println("Invalid Option Number");
				}

			} 
			//=================================NAEEM1S=================================//
			else if (option == 4) {
				registrationMenu();

				int itemType = Helper.readInt("Enter option for registration > ");
				if (itemType == 1) {																			//NAEEM
					Registration register = registerStudent(registrationList);
					C206_CaseStudy.addRegister(registrationList, register);
					System.out.println("Registration added");
				} else if (itemType == 2) {
					C206_CaseStudy.viewAllRegistration(registrationList);
				} 
				else if(itemType == 3){
					C206_CaseStudy.deleteRegistration(registrationList);
				}
				else {
					System.out.println("Invalid input");
				}
				

			} 
			//=================================NAEEM1E=================================//
			
			
			else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void adminMenu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT SYSTEM");
		System.out.println("1. Register student account"); // NEED TO DO
		System.out.println("2. Maintain tuition information");
		System.out.println("3. Maintain Subject group information");
		System.out.println("4. Maintain student");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	// Naeem
	public static void registrationMenu() {
		C206_CaseStudy.setHeader("TUITION MANAGEMENT SYSTEM");
		System.out.println("1. Register student for tuition");
		System.out.println("2. View all registration");
		System.out.println("3. Delete registration");
	}

	//Raghu
	public static void tuitionMenu() {
		System.out.println("1. Tuition Timetable");
		System.out.println("2. Tuition Information");
		Helper.line(80, "-");

	}

	// ================================= RYAN =================================//
		public static void studentMenu() {
			System.out.println("1. Register Student");
			System.out.println("2. View all Student");
			System.out.println("3. Delete Student");
		}
		
		
		// ================================= RYAN =================================//
		
	// ================================= SAKTHI =================================//
	public static void subjectGroupMenu() {
		System.out.println("1. Register Subject Group");
		System.out.println("2. View all Subject Group");
		System.out.println("3. Delete registration");
	}
	// ================================= SAKTHI =================================//

	// ================================= RAGHU =================================//

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String retrieveAllTimetable(ArrayList<Timetable> ttList) {
		String output = "";

		for (int i = 0; i < ttList.size(); i++) {
			output += String.format("%-10s %-20s %-10s %-10s %-20s\n", ttList.get(i).getID(), ttList.get(i).getPrice(),
					ttList.get(i).getStart(), ttList.get(i).getEnd(), ttList.get(i).getMode());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<Timetable> ttList) {
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-10s %-20s %-10s %-10s %-20s\n", "ID", "PRICE", "START TIME", "END TIME",
				"MODE");
		output += retrieveAllTimetable(ttList);
		System.out.println(output);
	}
	// ================================= RAGHU =================================//
	
	// ================================= Razi =================================//
	
	public static String retrieveAllTuitionInfo(ArrayList<TuitionInfo> tuitionInfoList) {
		String output = "";

		for (int i = 0; i < tuitionInfoList.size(); i++) {
			output += String.format("%-10d %-20s %-10s %-10s %-10s %-10s %-20s\n", tuitionInfoList.get(i).getCode(), tuitionInfoList.get(i).getTitle(),
					tuitionInfoList.get(i).getGroupName(), tuitionInfoList.get(i).getDescription(), 
					tuitionInfoList.get(i).getDuration(), tuitionInfoList.get(i).getPreRequisite(), tuitionInfoList.get(i).getTeacher() );
		}
		return output;
	}
	
	
	private static void viewAllTuitionInfo(ArrayList<TuitionInfo>tuitionInfoList)
	{
		C206_CaseStudy.setHeader("TUITION INFORMATION LIST");
		Helper.line(80, "-");
		
		String output = String.format("%-10s %-20s %-10s %-10s %-10s %-10s %-10s\n", "TUITION CODE", "TITLE", 
				"TUITION GROUP NAME", "DESCRIPTION", "DURATION", "PRE-REQUISITE", "TEACHER");
		output += retrieveAllTuitionInfo(tuitionInfoList);
		System.out.println(output);
	}
	
	public static TuitionInfo inputTuitionInfo(ArrayList<TuitionInfo> tuitionInfoList) {
		int newCode = tuitionInfoList.get(tuitionInfoList.size() - 1).getCode();

		String title = Helper.readString("Enter Tuition Title > ");
		String groupName = Helper.readString("Enter Tuition Group Name > ");
		String description = Helper.readString("Enter Tuition Description > ");
		String duration = Helper.readString("Enter Tuition Duration > ");
		String preRequisite = Helper.readString("Enter Tuition Pre-Requisite > ");
		String teacher = Helper.readString("Enter Tuition Teacher > ");

		TuitionInfo ti = new TuitionInfo((newCode + 1), title, groupName, description, 
				duration, preRequisite, teacher);

		return ti;
	}
	
	public static void addTuitionInfo(ArrayList<TuitionInfo> tuitionInfoList, TuitionInfo ti) {
		tuitionInfoList.add(ti);
	}

	public static void deleteTuitionInfo(ArrayList<TuitionInfo> tuitionInfoList) {
		C206_CaseStudy.viewAllTuitionInfo(tuitionInfoList);
		int codeNum = Helper.readInt("Enter code of tuition > ");
		Boolean isDeleted = doDeleteTuitionInfo(tuitionInfoList, codeNum);

		if (isDeleted == false) {
			System.out.println("Invalid entry! Tuition code does not exist");
		} else {
			System.out.println("Tuition code " + codeNum + " is deleted!");
		}

	}
	
	public static boolean doDeleteTuitionInfo(ArrayList<TuitionInfo> tuitionInfoList, int codeNum) {
		boolean isDeleted = false;

		for (int i = 0; i < tuitionInfoList.size(); i++) {
			if (codeNum == (tuitionInfoList.get(i).getCode())) {
				tuitionInfoList.remove(i);

				isDeleted = true;

			}
	}
		return isDeleted;
	}
	
	// ================================= Razi =================================//

	// ================================= SAKTHI =================================//
	public static String retriveAllSubjectGroup(ArrayList<subjectGroup> subjectGroupList) {
		String output = "";

		for (int i = 0; i < subjectGroupList.size(); i++) {
			output += String.format("%-10s %-20s %-10s\n", subjectGroupList.get(i).getName(),
					subjectGroupList.get(i).getDescription(), subjectGroupList.get(i).getPrerequisities());
		}
		return output;
	}

	public static void viewAllSubjectGroup(ArrayList<subjectGroup> subjectGroupList) {
		C206_CaseStudy.setHeader("SUBJECT GROUP LIST");
		String output = String.format("%-10s %-20s %-10s\n", "name", "description", "prerequisities");
		output += retriveAllSubjectGroup(subjectGroupList);
		System.out.println(output);
	}
	// ================================= SAKTHI =================================//

	// ================================= RAGHU =================================//
	public static Timetable inputTimetable(ArrayList<Timetable> ttList) {
		int newID = ttList.get(ttList.size() - 1).getID();

		Double pricing = Helper.readDouble("Enter the pricing for the tuition > ");
		String startDate = Helper.readString("Enter the starting date > ");
		String endDate = Helper.readString("Enter the ending date > ");
		String modeType = Helper.readString("Enter the mode for the tuition > ");

		Timetable tt = new Timetable((newID + 1), pricing, startDate, endDate, modeType);

		return tt;
	}

	public static void addTimetable(ArrayList<Timetable> ttList, Timetable tt) {
		ttList.add(tt);
	}

	public static void deleteTimetable(ArrayList<Timetable> ttList) {
		C206_CaseStudy.viewAllTimetable(ttList);
		int IDNum = Helper.readInt("Enter ID of timetable > ");
		Boolean isDeleted = doDeleteTimetable(ttList, IDNum);

		if (isDeleted == false) {
			System.out.println("Invalid entry! Timetable ID does not exist");
		} else {
			System.out.println("Timetable ID " + IDNum + " is deleted!");
		}

	}

	public static boolean doDeleteTimetable(ArrayList<Timetable> ttList, int IDNum) {
		boolean isDeleted = false;

		for (int i = 0; i < ttList.size(); i++) {
			if (IDNum == (ttList.get(i).getID())) {
				ttList.remove(i);

				isDeleted = true;

			}
		}
		return isDeleted;
	}
	// ================================= RAGHU =================================//

	// ================================= SAKTHI =================================//

	public static void deleteSubjectGroup(ArrayList<subjectGroup> subjectGroupList) {
		C206_CaseStudy.viewAllSubjectGroup(subjectGroupList);
		String search = Helper.readString("Enter Subject Name: ");
		Boolean isDeleted = doDeleteSubjectGroup(subjectGroupList, search);

		if (isDeleted == false) {
			System.out.println("Invalid entry! Subject Group Name does not exist");
		} else {
			System.out.println("Subject Group Name " + search + " is deleted!");
		}

	}

	public static boolean doDeleteSubjectGroup(ArrayList<subjectGroup> subjectGroupList, String search) {
		boolean isDeleted = false;

		for (int i = 0; i < subjectGroupList.size(); i++) {
			if (search.equalsIgnoreCase(subjectGroupList.get(i).getName()))
				subjectGroupList.remove(i);

			isDeleted = true;

		}
		return isDeleted;
	}

	//=================================NAEEM2S=================================//
	
		//REGISTER
		public static Registration registerStudent(ArrayList<Registration> registrationList) {
			
			int id = registrationList.get(registrationList.size()-1).getRegistrationNumber();
			id += 1;
			
			
			int timetableID = Helper.readInt("Enter tuition timetable ID: ");
			String studentEmail = Helper.readString("Enter student email: ");
			LocalDate registerDate = LocalDate.now();  
			String date = registerDate.toString();
			
			Registration register = new Registration(id, timetableID, "", studentEmail, date);
			
			return register;
		}
		
		public static void addRegister(ArrayList<Registration> registrationList, Registration register) {

			registrationList.add(register);	

		}
		//VIEW
		
		public static String viewAllRegister(ArrayList<Registration> registrationList) {
			String output = "";

			for (Registration reg : registrationList) {
				output += String.format("%-10s %-20s %-10s %-20s %-20s\n", reg.getRegistrationNumber(), reg.getRegistrationTTId(), reg.getRegistrationStatus(), reg.getRegistrationEmail(), reg.getRegistrationDate());
			}
			return output;
			
		}
		
		public static void viewAllRegistration(ArrayList<Registration> registrationList) {
			C206_CaseStudy.setHeader("REGISTRATION LIST");
			String output = String.format("%-10s %-20s %-10s %-20s %-20s\n", "REG ID", "TIMETABLE ID", "STATUS", "REGISTRATION DATE", "STUDENT EMAIL");
			output += viewAllRegister(registrationList);
			System.out.println(output);
		}
		
		//DELETE
		public static void deleteRegistration(ArrayList<Registration> registrationList) {
			C206_CaseStudy.viewAllRegistration(registrationList);
			int id = Helper.readInt("Enter ID of Registration to delete > ");
			Boolean isDeleted = doDeleteRegistration(registrationList, id);

			if (isDeleted == false) {
				System.out.println("Registration ID does not exist");
			} else {
				System.out.println("Registration ID " + id + " is deleted");
			}

		}
		
		public static boolean doDeleteRegistration(ArrayList<Registration> registrationList, int id) {
			boolean isDeleted = false;

			for (int i = 0; i < registrationList.size(); i++) {
				if (id == (registrationList.get(i).getRegistrationNumber())) {
					registrationList.remove(i);

					isDeleted = true;
				}
			}
			return isDeleted;
		}
		
		
		
		//=================================NAEEM2E=================================//

	// ================================= SAKTHI =================================//
	public static subjectGroup registersubjectGroup(ArrayList<subjectGroup> subjectGroupList) {
		String groupName = Helper.readString("Enter the subject group name: ");
		String discription = Helper.readString("Enter the discription for the subject group: ");
		String prereq = Helper.readString("Enter the prerequisites for this subject group");

		subjectGroup sg = new subjectGroup(groupName, discription, prereq);
		return sg;
	}

	public static void addsubjectGroup(ArrayList<subjectGroup> subjectGroupList, subjectGroup sg) {
		subjectGroupList.add(sg);
	}
	// ================================= SAKTHI =================================//
	
	// ================================= RYAN ADD =================================//
		public static student registerstudent(ArrayList<student> studentList) {
			String name = Helper.readString("Enter your name: ");
			String gender = Helper.readString("Enter your gender (M/F) : ");
			int mobile = Helper.readInt("Enter your mobile number:");
			String email = Helper.readString("Enter your email: ");
			String DOB = Helper.readString("Enter your Date Of Birth (DD/MM/YYYY) : ");
			String country = Helper.readString("Enter your country of birth: ");
			String interest = Helper.readString("Enter your subject of interest : ");
			String feedback = Helper.readString("Enter your Feedback: ");
			

			student sm = new student(name, gender, mobile, email , DOB , country , interest , feedback);
			return sm;
		}
		public static void addstudent(ArrayList<student> studentList, student sm) {
			studentList.add(sm);
		}
		
		
		
		// ================================= RYAN ADD =================================//
		
		
		// ================================= RYAN VIEW =================================//
		public static String retriveAllstudent(ArrayList<student> studentList) {
			String output = "";

			for (int i = 0; i < studentList.size(); i++) {
				output += String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", studentList.get(i).getStudentName(),studentList.get(i).getStudentGender(),studentList.get(i).getStudentMobile(),studentList.get(i).getStudentEmail(),
						studentList.get(i).getStudentDOB(), studentList.get(i).getStudentCountry(), studentList.get(i).getStudentInterest(), studentList.get(i).getStudentFeedback());
			}
			return output;
		}

		public static void viewAllstudent(ArrayList<student> studentList) {
			C206_CaseStudy.setHeader("STUDENT LIST");
			String output = String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "name", "gender", "mobile", "email","DOB","country","interest","feedback");
			output += retriveAllstudent(studentList);
			System.out.println(output);
		}
		// ================================= RYAN VIEW =================================//
		// ================================= RYAN DELETE =================================//
		
		
		public static void deletestudent(ArrayList<student> studentList) {
			C206_CaseStudy.viewAllstudent(studentList);
			String search = Helper.readString("Enter Student Name: ");
			Boolean isDeleted = doDeletestudent(studentList, search);

			if (isDeleted == false) {
				System.out.println("Invalid entry! Student Name does not exist");
			} else {
				System.out.println("Subject Group Name " + search + " is deleted!");
			}

		}

		public static boolean doDeletestudent(ArrayList<student> studentList, String search) {
			boolean isDeleted = false;

			for (int i = 0; i < studentList.size(); i++) {
				if (search.equalsIgnoreCase(studentList.get(i).getStudentName()))
					studentList.remove(i);

				isDeleted = true;

			}
			return isDeleted;
		}
}
