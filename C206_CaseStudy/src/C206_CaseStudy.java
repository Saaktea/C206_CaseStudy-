import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<subjectGroup> subjectGroupList = new ArrayList<subjectGroup>();
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<TuitionInfo> tutionInfoList = new ArrayList<TuitionInfo>();
		ArrayList<Timetable> ttList = new ArrayList<Timetable>();
		ArrayList<Registration> registrationList = new ArrayList<Registration>();
		DateTimeFormatter registrationDtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		ttList.add(new Timetable(1001, 80.0, "01/02/2020", "01/10/2020", "Face to Face"));
		ttList.add(new Timetable(1002, 95.0, "01/03/2020", "01/09/2020", "Face to Face"));
		registrationList
				.add(new Registration(4001, 001, "abc@gmail.com", LocalDate.parse("14/04/2002", registrationDtf)));
		subjectGroupList.add(new subjectGroup("Math", "Math is fun", "Must pass sec1 math"));
		subjectGroupList.add(new subjectGroup("Chemistry", "Chem is fun", "Must pass sec1 chem"));

		int option = 0;

		while (option != 5) {

			adminMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				// ResourceCentre.viewAllCamcorder(camcorderList);
				// ResourceCentre.viewAllChromebook(chromebookList);

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

					} else if (optionNum == 2) {

					} else if (optionNum == 3) {

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
					C206_CaseStudy.deleteTimetable(subjectGroupList);
				} else {
					System.out.println("Invalid Option Number");
				}

			} else if (option == 4) {
				registrationMenu();
				// Return item
				// ResourceCentre.setHeader("RETURN");
				// ResourceCentre.setHeader("ITEM TYPES");

				int itemType = Helper.readInt("Enter option for registration > ");
				if (itemType == 1) { // NAEEM
					Registration register = registerStudent(registrationList);
					C206_CaseStudy.addRegister(registrationList, register);
					System.out.println("Chromebook added");
				} else if (itemType == 2) {

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
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

	public static void tuitionMenu() {
		System.out.println("1. Tuition Timetable");
		System.out.println("2. Timetable");
		Helper.line(80, "-");

	}

	// ================================= SAKTHI =================================//
	public static void subjectGroupMenu() {
		System.out.println("1. Register Subject Group");
		System.out.println("2. View all Subject Group");
		System.out.println("3. Delete registration");
	}
	// ================================= SAKTHI =================================//

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String retriveAllTimetable(ArrayList<Timetable> ttList) {
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
		output += retriveAllTimetable(ttList);
		System.out.println(output);
	}

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

	// ================================= SAKTHI =================================//

	public static void deleteStudentGroup(ArrayList<subjectGroup> subjectGroupList) {
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

	// =================================NAEEM=================================//
	public static Registration registerStudent(ArrayList<Registration> registrationList) {

		int id = registrationList.get(registrationList.size() - 1).getRegistrationNumber();
		id += 1;

		int timetableID = Helper.readInt("Enter tuition timetable ID: ");
		String studentEmail = Helper.readString("Enter student email: ");
		LocalDate registerDate = LocalDate.now();

		Registration register = new Registration(id, timetableID, studentEmail, registerDate);

		return register;
	}

	public static void addRegister(ArrayList<Registration> registrationList, Registration register) {

		registrationList.add(register);

	}

	public static void viewAllRegister(ArrayList<Registration> registrationList) {

	}
	// =================================NAEEM=================================//

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

}
