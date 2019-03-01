package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener{
	
	JButton loadButton, saveButton, searchButton, nextButton, addButton, deleteButton;
	JTextField searchField, nameField, numberField; 
	PhoneBook myPhoneBook = new PhoneBook();
	int counter = 0;
	ArrayList<person> foundPersons = new ArrayList<>();
	
	public GUI() {
		
		Font myFont = new Font("SansSerif", Font.PLAIN, 20);
		setTitle("Interactive phone book");
		
		//Load button
		loadButton = new JButton("Load phone book"); 
		loadButton.setFont(myFont); 
		loadButton.addActionListener(this);
		loadButton.setEnabled(true);
		
		//Save button
		saveButton = new JButton("Save phone book"); 
		saveButton.setFont(myFont); 
		saveButton.addActionListener(this);
		saveButton.setEnabled(true);
		
		//Search button
		searchButton = new JButton("Search"); 
		searchButton.setFont(myFont); 
		searchButton.addActionListener(this);
		searchButton.setEnabled(true);
		
		//Next button, only added if we have more than one search result
		nextButton = new JButton("Next name"); 
		nextButton.setFont(myFont); 
		nextButton.addActionListener(this);
		nextButton.setEnabled(false);
		
		//Add button, add a person to PhoneBook
		addButton = new JButton("Add person"); 
		addButton.setFont(myFont); 
		addButton.addActionListener(this);
		addButton.setEnabled(true);
		
		//Delete a person from the PhoneBook
		deleteButton = new JButton("Delete person"); 
		deleteButton.setFont(myFont); 
		deleteButton.addActionListener(this);
		deleteButton.setEnabled(true);
		
		//Setup the search field
		searchField = new JTextField(); 
		searchField.setEditable(true); 
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		
		//Name field, also textfield
		nameField = new JTextField(); 
		nameField.setEditable(false); 
		nameField.setFont(myFont);
		
		//Number field, also textfield
		numberField = new JTextField(); 
		numberField.setEditable(false);
		numberField.setFont(myFont);
		 
		//Set the layout for the GUI
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,3));
		//Add the buttons to the contentpane
		c.add(loadButton); 
		c.add(saveButton); 
		c.add(searchField); 
		c.add(searchButton); 
		c.add(nextButton); 
		c.add(nameField); 
		c.add(addButton); 
		c.add(deleteButton); 
		c.add(numberField);
		pack();
		
		setVisible(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	//Handles if a button is pressed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loadButton) {
			String myText = (searchField.getText());
			searchField.setText("");			
			nameField.setText(myPhoneBook.load(myText));
		}
		if(e.getSource() == searchField) {
			String myText = (searchField.getText());
			searchField.setText("");			
			nameField.setText(myPhoneBook.load(myText));
		}
		if(e.getSource() == searchButton) {
            //System.out.println("Clicked");
            String myText = (searchField.getText());
            //System.out.println(myText);
			searchField.setText("");	
			foundPersons = myPhoneBook.search(myText);
			
			if(foundPersons.size() == 0) {
				nameField.setText("Provide a name");
			}else if(foundPersons.size() == 1) {
				nameField.setText(foundPersons.get(0).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(0).getPhoneNumber()));
			}
			else {
				nextButton.setEnabled(true);
				
				
				nameField.setText(foundPersons.get(counter).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));				
				
			
				}
				counter = 0;
			}
		
		if(e.getSource() == nextButton) {
				counter++; 	
				nameField.setText(foundPersons.get(counter).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));
					
				if(foundPersons.size()-1 == counter) {
						nameField.setText(foundPersons.get(counter).getFullName());
						numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));
						counter = 0;
						nextButton.setEnabled(false);		
					}
			}				
		if(e.getSource() == deleteButton) {
			if(foundPersons != null) {
				searchField.setText(myPhoneBook.deletePerson(nameField.getText(), Integer.valueOf(numberField.getText())));
				
			}else {
				nameField.setText("Please write a name");
			}
			
		}
		if (e.getSource() == addButton) {
            String myText = (searchField.getText());
            String[] arr = myText.split(" ");
            if (arr.length == 3) {
//            	System.out.println(arr[0] + " " + arr[1]);
//                System.out.println(Integer.parseInt(arr[2]));
                myPhoneBook.addPerson(arr[0] + " " + arr[1], Integer.parseInt(arr[2]));
                searchField.setText("");
            } else {
                nameField.setText("Incorrect format");
            }
        }
		if(e.getSource() == saveButton) {
			String myText = (searchField.getText());
		
			if(myText.isEmpty()) {
				nameField.setText("Provide a file name");
			}else {
				nameField.setText(myPhoneBook.save(myText));	
			}
			
			searchField.setText("");
			
			
			}
		
		}
		
	}
