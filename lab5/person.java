package lab5;

public class person {
	private String givenName;
	private String surname;
	private int phoneNumber;
	
	//Constructor
	person(String name, String surn, int number){
		givenName = name;
		surname = surn;
		phoneNumber = number;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getFullName() {
		return givenName + " " + surname;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

}
