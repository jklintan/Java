package lab4;

abstract class Employee implements Comparable<Employee> {
    public String firstName;
    private String secondName;
    private int employeeNumber;
    private double salary;

    static int BYNAME = 0; // default
    static int BYSALARY = 1;
    static int BYTAXES = 2;

    public static int sortCriterion = BYNAME;

    /**
     * Constructor
     * the first name @param inFirstName
     * the second name @param inSecondName
     * the employee number @param inEmployeeNumber
     * the salary @param inSalary
     */
    Employee(String inFirstName, String inSecondName, int inEmployeeNumber, double inSalary) {
        firstName = inFirstName;
        secondName = inSecondName;
        employeeNumber = inEmployeeNumber;
        salary = inSalary;
    }

    /**Get the employee number
     * 
     * @return the employee number of the current employee
     */
    public int getNumber() {
        return employeeNumber;
    }

    /**
     * Get the first name of an employee
     * @return the name of the employee
     */
    public String getName() {
        return secondName;
    }

    /**
     * Get an employees salary
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Change the criterion for sorting
     * @param criteria
     */
    public static void changeCriterion(int criteria) { // STATIC IN DOC?
        sortCriterion = criteria;
    }

    /**
     *  Compute the taxes, abstract method
     * @return the taxes for the given employee
     */
    public abstract double computeTaxes();

    /**
     *  Set the output format
     */
    public String toString() {
    	String res = String.format("%12s %12s %10s", firstName, secondName, employeeNumber);
        return res;
    }
}