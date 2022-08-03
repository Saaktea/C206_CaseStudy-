import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<subjectGroup> subjectGroupList = new ArrayList<subjectGroup>();
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<TuitionInfo> tutionInfoList = new ArrayList<TuitionInfo>();
		ArrayList<Timetable> ttList = new ArrayList<Timetable>();
		
		ttList.add(new Timetable(001, 80.0, "01/02/2020", "01/10/2020", "Face to Face"));
		
		int option =0;
		
		while (option != 5) {

			adminMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllCamcorder(camcorderList);
				ResourceCentre.viewAllChromebook(chromebookList);

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("Maintain Tuition Details");			
				
				int Type = Helper.readInt("Enter option to select > ");

				if (Type == 1) {
					// Maintain tuition timetable details
					C206_CaseStudy.setHeader("Maintain Tuition Timetable Information");
					System.out.println("1. View Tuition Timetable");
					System.out.println("2. Add Tuition Timetable");
					System.out.println("3. Delete Tuition Timetable");
					
					int optionNum = Helper.readInt("Enter option to select > ");
					
					if (optionNum == 1) {
						
					} else if (optionNum == 2) {
						
					} else if (optionNum == 3) {
						
					} else {
						System.out.println("Invalid Option Number");
					}

				} else if (Type == 2) {
					// Maintain tuition details
					C206_CaseStudy.setHeader("Maintain Tuition Information");
					System.out.println("1. View Tuition");
					System.out.println("2. Add Tuition");
					System.out.println("3. Delete Tuition");
					
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
				// Loan item
				C206_CaseStudy.setHeader("LOAN");			
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				ResourceCentre.setHeader("RETURN");				
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					ResourceCentre.returnCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(chromebookList);
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
		System.out.println("1. Register student account");				//NEED TO DO 
		System.out.println("2. Maintain tuition information");
		System.out.println("3. Maintain Subject group information");
		System.out.println("4. Maintain student");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	private static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
}
