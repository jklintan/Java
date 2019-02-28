package lab4;

public class Worker extends Employee {

    /**
     *  Constructor
     * the first name @param inFirstName
     * the last name @param inSecondName
     * the employee number @param inEmployeeNumber
     * the salary @param inSalary
     */
    public Worker(String inFirstName, String inSecondName, int inEmployeeNumber, double inSalary) {
        super(inFirstName, inSecondName, inEmployeeNumber, inSalary);
    }

    /**
     *  Compares two employees
     *  @return the comparision int
     */
    public int compareTo(Employee e) {
    	
    	if (sortCriterion == 0) {
                 return getName().compareTo(e.getName());
             } else if (sortCriterion == 1 || sortCriterion == 2) {
                 if (getSalary() > e.getSalary()) {
                     return -1;
                 } else if (getSalary() == e.getSalary()) {
                     return 0;
                 } else {
                     return 1;
                 }
             }else {
		        if (getSalary() > e.getSalary()) {
		            return -1;
		        } else if (getSalary() == e.getSalary()) {
		            return 0;
		        } else {
		            return 1;
		        }
             }
    }

    /**
     *  Compute the taxes for a worker, 25% of salary
     */
    public double computeTaxes() {
        return (0.25 * getSalary());
    }

}
