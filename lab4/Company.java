package lab4;
import java.util.*;


public class Company extends Object {

    private ArrayList<Employee> theEmployees;

    /**
     *  Constructor
     */
    public Company() {
    	theEmployees = new ArrayList<Employee>();
    }

    /**
     *  Add a director to the company
     * the director @param d
     */
    public void addEmployee(Director d) {
        theEmployees.add(d);
    }

    /**
     *  Adds a worker and connects it to a director
     * the worker @param w
     * the director @param d
     * @return adds the worker to employees and the worker to the directors subordinates 
     */
    public void addEmployee(Worker w, Director d) {
        theEmployees.add(w);
        d.addEmployee(w); //Set the worker as subordinate to director d
    }
    
    /**
     * @return Writes out the employees of the company
     */

    // Writes out the employees of the company
    public String toString() {
        String list = "List of employees \n-----------------\n";
        
        // Sort the list of employees according to a criteria
        if (Employee.sortCriterion == 0) {

            Collections.sort(theEmployees);

            list += "First name 	 Surname	  Number \n";
            for (int i = 0; i < theEmployees.size(); i++) {
                list += "\n" + theEmployees.get(i);
            }
        } else if (Employee.sortCriterion == 1) {
            Collections.sort(theEmployees);
            list += "First name	  Surname 	 Number		 Salary \n";
            for (int i = 0; i < theEmployees.size(); i++) {
                list += theEmployees.get(i);
                list += String.format("%20s", theEmployees.get(i).getSalary()) + "\n";
            }
        } else if (Employee.sortCriterion == 2) {
            Collections.sort(theEmployees);
            list += "First name  	Surname 	 Number		 Taxes \n";
            for (int i = 0; i < theEmployees.size(); i++) {
                list += "\n" + theEmployees.get(i) + "		" + theEmployees.get(i).computeTaxes();
            }
        }

        return list;
    }

}
