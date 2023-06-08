package ex5.carDealership;



import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents an employee in a car dealership.
 */
public class Employee implements Comparable<Employee> {
    public String name;
    public String id;
    public int sales;

    /**
     * Constructs an employee object with the specified parameters.
     *
     * @param name the name of the employee
     * @param id the ID of the employee
     * @param sales the number of sales made by the employee
     * @throws Exception if any of the parameters is invalid
     */
    public Employee(String name, String id, int sales) throws Exception {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
                throw new Exception("The name must contain only letters");
            else {
                this.name = name;
            }
        }
        if (id.length() != 9)
            throw new Exception("The number of digits should be 9");
        else {
            this.id = id;
        }
        if (sales < 0)
            throw new Exception("the sales must be positive");
        else {
            this.sales = sales;
        }
    }

    /**
     * Compares this employee to another employee based on their sales.
     *
     * @param e the employee to compare to
     * @return 0 if the sales are equal, -1 if this employee has higher sales, 1 if the other employee has higher sales
     */
    public int compareTo(Employee e) {
        if (sales == e.sales)
            return 0;
        else if (sales > e.sales)
            return -1;
        return 1;
    }

    /**
     * Calculates the wage of the employee based on the number of sales.
     *
     * @return the calculated wage
     */
    public int wage() {
        return 6000 + sales * 100;
    }

    /**
     * Writes the car details to a file using the provided BufferedWriter and increments the sales count.
     *
     * @param writer the BufferedWriter to write to
     * @param c the car to sell
     * @throws IOException if an I/O error occurs
     */
    public void sellEmployee(BufferedWriter writer, Car c) throws IOException {
        c.sellCar(writer);
        sales++;
    }

    /**
     * Returns a string representation of the employee.
     *
     * @return a string representation of the employee
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sales=" + sales +
                ", wage" + wage() +
                '}';
    }
}
