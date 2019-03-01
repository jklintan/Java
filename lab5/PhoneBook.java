package lab5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<person> listOfNumbers;

	//Constructor
	PhoneBook(){
		listOfNumbers = new ArrayList<person>();
	}
	
	//Load and read in from a file
	public String load(String filename) {
		
		try {
			String Directory = System.getProperty("user.dir");
			File myFile = new File(Directory + "/src/lab5/" + filename); 
			BufferedReader myFileReader = new BufferedReader(new FileReader(myFile));
			String returnString;
			
			while(!((returnString = myFileReader.readLine())==null)) {
				String[] array = returnString.split(" +");
				listOfNumbers.add(new person(array[0],array[1],Integer.valueOf(array[2])));
			}
			myFileReader.close();
			return "Phone book loaded";
		}
		catch (IOException ierr) {return "Try again";}
	}
	
	
	//Search for a person
	public ArrayList<person> search(String arg) {
		ArrayList<person> foundPersons = new ArrayList<person>();
		
		for (int i=0; i < listOfNumbers.size(); i++) {
			if (arg.trim().equals(listOfNumbers.get(i).getSurname().trim() )) {
				foundPersons.add(listOfNumbers.get(i));
				}
			else if(Integer.toString(listOfNumbers.get(i).getPhoneNumber()).equals(arg)){
				foundPersons.add(listOfNumbers.get(i));
			}
		}
		return foundPersons;
	}
	
	
	//Add a new person
	public boolean addPerson(String fullName, int number) {
		boolean added = true;
		String[] temp = fullName.split(" ");
		
		for (int i=0; i < listOfNumbers.size(); i++) {
			if (number == listOfNumbers.get(i).getPhoneNumber()) {
				added = false;
			}
			if(temp.length != 2) {
				added = false;
			}
		}
		
		if (added) listOfNumbers.add(new person(temp[0],temp[1], number));
		return added;
	}
	
	//Delete a person
	public String deletePerson(String fullName, int phoneNumb) {
		String result;
		result = "The person/number does not exist.";
		for (int i=0; i < listOfNumbers.size(); i++) {
			if (listOfNumbers.get(i).getFullName().equals(fullName) && phoneNumb == listOfNumbers.get(i).getPhoneNumber() ) {
				listOfNumbers.remove(i);
				i--;
				result = "Person deleted";
			}
		}
		return result;
	}
	
	//Save the list
	public String save(String theFile) {
		String result ="";
		File f = new File(theFile);
		if(f.exists()) {
			System.out.println("File exists");
		}
		if(theFile.equals("")) {
			System.out.println("Provide file name");
		}
		try {
			FileWriter fw = new FileWriter(f, false);	
			for(int i = 0; i < listOfNumbers.size(); i++) {
				fw.write(String.format("%20s%5s", listOfNumbers.get(i).getFullName() + " ", String.valueOf(listOfNumbers.get(i).getPhoneNumber() + "\n")));
			}

			fw.close();
			result = "Saved " + listOfNumbers.size() + " people to the file.";

		} catch(IOException ierr) {
			result =  "Could not save the file";
			System.out.println("catch: " + result);	
		}
		
		return result;
	}


	//Output
	public String toString() {
		String result = "";
		for (int i=0; i < listOfNumbers.size();i++) {
			result = result + listOfNumbers.get(i) + "\n";
		}		
		return result;
	}
	
}
