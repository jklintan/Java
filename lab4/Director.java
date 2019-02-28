package lab4;
import java.util.*;

public class Director extends Employee {

    private ArrayList<Worker> subordinates;

    /**
     *  Constructor
     * the first name @param inFirstName
     * the second name @param inSecondName
     * the employee number @param inEmployeeNumber
     * the salary @param inSalary
     */
    Director(String inFirstName, String inSecondName, int inEmployeeNumber, double inSalary) {
        super(inFirstName, inSecondName, inEmployeeNumber, inSalary);
        subordinates = new ArrayList<Worker>();
    }

    /**
     *  Add a worker to the current director
     * the worker @param w
     */
    public void addEmployee(Worker w) {
        subordinates.add(w);
    }

    /**
     *  Compute the bonus of the director, 10% of total subordinates salary
     * @return the bonus for the director
     */
    public double computeBonus() {
        double bonus = 0.0;
        for (int i = 0; i < subordinates.size(); i++) {
            bonus += subordinates.get(i).getSalary();
        }
        return (0.1 * bonus);
    }

    /**
     *  Compute the taxes that the director has to pay
     *  @return the taxes for the current director
     */
    public double computeTaxes() {
        double res = getSalary() + computeBonus();
        res = res * 0.25;
        return res;
    }

    /** Compare employees, -1 if lower than this, 0 if equal, 1 if greater
     * 
     */
    public int compareTo(Employee employer) {
        if (getSalary() > employer.getSalary()) {
            return -1;
        } else if (getSalary() == employer.getSalary()) {
            return 0;
        } else {
            return 1;
        }
    }

}