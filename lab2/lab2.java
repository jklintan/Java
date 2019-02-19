package lab2;
import java.io.*;

public class lab2 {
	
	static BufferedReader myBufferedReader = new BufferedReader(new InputStreamReader(System.in));

	static String questionToUser = "You have the following options :\n"
	     + "End : type 'end'\nLoad from file : type 'load' followed by filename\n"
	     + "Save to file : type 'save' followed by filename\nAdd another word : type the word\n"
	     + "List reduced content : type '1'\nList full content : type '2'\n"
	     + "Remove multiple occurences : type '3'\nSort : type '4'\nList occurences : type '5'\nYour choice : ";

	public static void main(String[] args) {
		
		//Setting up the input stream and format strings
		FileInputStream inputStream = null;
		String breakpoint = " ";
		String in;
		
		//Display user options 
		do {
			 System.out.println(questionToUser);
			 in = consoleInput();
			 String[] myStringArr = in.split(breakpoint);
			 switch(myStringArr[0]){
				 case "0":
					 System.out.println("Something went wrong"); 
					 break;
			     case "1":
			         break;
			     case "2":
			         break;
			     case "3":
			         break;
			     case "4":
			         break;
			     case "5":
			         break;
			     case "load":
			         if (myStringArr.length > 0) {
			        	 try {
				            String Directory = System.getProperty("user.dir");
				            File myFile = new File(Directory + "/src/lab2/" + myStringArr[1] + ".txt"); 
				            BufferedReader myBufferedReader = new BufferedReader(new FileReader(myFile));
				            String allWords = " ";
				            String line = myBufferedReader.readLine();
			            
				            while (line != null) {
				            	allWords += (line + " ");
				            	//System.out.println(line);
				            	line = myBufferedReader.readLine();
				            }
				            
				            myBufferedReader.close();
				            
			        	 } catch (IOException ierr) {
			        		 System.out.println("Error!");
			        	 	}
				     } else {
				    	 System.out.println("You must specify a filename!");
				     }
			           break;
			      case "save":
			    	  break;
			      case "":
			    	  System.out.println("Something went wrong");
			          break;
			      default:
			          break;
		     }
	
		  
		    } while ( !in.equals("end")); {
		     
		    }
	}


	public static String consoleInput() {
	     try {
	      String myString = myBufferedReader.readLine().trim();
	     return myString;
	     } catch (IOException ierr) {
	      return "";
	     }
	}

}
