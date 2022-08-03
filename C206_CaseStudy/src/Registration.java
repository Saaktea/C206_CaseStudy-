import java.time.LocalDate;

//Naeem

public class Registration {

	private int registrationNumber;
	private int registrationTTId;
	private String registrationEmail;
	private String registrationStatus;
	private LocalDate registrationDate;
	
	
	public Registration(int registrationNumber, int registrationTTId, String registrationEmail, String registrationStatus, LocalDate registrationDate) {
		this.registrationNumber = registrationNumber;
		this.registrationTTId = registrationTTId;
		this.registrationEmail = registrationEmail;
		this.registrationStatus = "Pending";
		this.registrationDate = registrationDate;
	}


	public int getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public int getRegistrationTTId() {
		return registrationTTId;
	}


	public void setRegistrationTTId(int registrationTTId) {
		this.registrationTTId = registrationTTId;
	}


	public String getRegistrationEmail() {
		return registrationEmail;
	}


	public void setRegistrationEmail(String registrationEmail) {
		this.registrationEmail = registrationEmail;
	}


	public String getRegistrationStatus() {
		return registrationStatus;
	}


	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
	
	

	
	
	
}
