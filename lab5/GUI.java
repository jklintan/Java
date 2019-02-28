package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener{
	
	JButton load_B, save_B, search_B, next_B, add_B, delete_B;
	JTextField searchField, nameField, numberField; 
	PhoneBook myPhoneBook = new PhoneBook();
	int counter = 0;
	ArrayList<person> foundPersons = new ArrayList<>();
	
	public GUI() {
		
		Font myFont = new Font("SansSerif", Font.PLAIN, 20);
		setTitle("Interactive phone book");
		
		 load_B = new JButton("Load phone book"); load_B.setFont(myFont); load_B.addActionListener(this);
		 save_B = new JButton("Save phone book"); save_B.setFont(myFont); save_B.addActionListener(this);
		 search_B = new JButton("Search"); search_B.setFont(myFont); search_B.addActionListener(this);
		 next_B = new JButton("Next name"); next_B.setFont(myFont); next_B.addActionListener(this);
		 add_B = new JButton("Add person"); add_B.setFont(myFont); add_B.addActionListener(this);
		 delete_B = new JButton("Delete person"); delete_B.setFont(myFont); delete_B.addActionListener(this);
		
		 searchField = new JTextField(); searchField.setEditable(true); searchField.setFont(myFont);searchField.addActionListener(this);
		 nameField = new JTextField(); nameField.setEditable(false); nameField.setFont(myFont);
		 numberField = new JTextField(); numberField.setEditable(false);numberField.setFont(myFont);
		 
		 
		load_B.setEnabled(true); save_B.setEnabled(true); search_B.setEnabled(true); next_B.setEnabled(false); add_B.setEnabled(true); delete_B.setEnabled(true);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,3));
		c.add(load_B); c.add(save_B); c.add(searchField); c.add(search_B); c.add(next_B); c.add(nameField); c.add(add_B); c.add(delete_B); c.add(numberField);
		pack();
		
		setVisible(true); setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == load_B) {
			String myText = (searchField.getText());
			searchField.setText("");			
			nameField.setText(myPhoneBook.load(myText));
		}
		if(e.getSource() == searchField) {
			String myText = (searchField.getText());
			searchField.setText("");			
			nameField.setText(myPhoneBook.load(myText));
		}
		if(e.getSource() == search_B) {
            System.out.println("Clicked");
            String myText = (searchField.getText());
            System.out.println(myText);
			searchField.setText("");	
			foundPersons = myPhoneBook.search(myText);
			
			if(foundPersons.size() == 0) {
				nameField.setText("Provide a name");
			}else if(foundPersons.size() == 1) {
				nameField.setText(foundPersons.get(0).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(0).getPhoneNumber()));
			}
			else {
				next_B.setEnabled(true);
				
				
				nameField.setText(foundPersons.get(counter).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));				
				
			
				}
				counter = 0;
			}
		
		if(e.getSource() == next_B) {
				counter++; 	
				nameField.setText(foundPersons.get(counter).getFullName());
				numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));
					
				if(foundPersons.size()-1 == counter) {
						nameField.setText(foundPersons.get(counter).getFullName());
						numberField.setText(Integer.toString(foundPersons.get(counter).getPhoneNumber()));
						counter = 0;
						next_B.setEnabled(false);		
					}
			}				
		if(e.getSource() == delete_B) {
			if(foundPersons != null) {
				searchField.setText(myPhoneBook.deletePerson(nameField.getText(), Integer.valueOf(numberField.getText())));
				
			}else {
				nameField.setText("Please write a name");
			}
			
		}
		if (e.getSource() == add_B) {
            String myText = (searchField.getText());
            String[] arr = myText.split(" ");
            if (arr.length == 3) {
            	System.out.println(arr[0] + " " + arr[1]);
                System.out.println(Integer.parseInt(arr[2]));
                System.out.println(myPhoneBook.addPerson(arr[0] + " " + arr[1], Integer.parseInt(arr[2])));
                searchField.setText("");
            } else {
                nameField.setText("Incorrect format");
            }
        }
		if(e.getSource() == save_B) {
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
