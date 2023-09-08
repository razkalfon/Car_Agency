package ex5.carDealership;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum menu{
    EMPLOYEE,CAR,SALE,ADDCAR,END;
}
/**
 * Represents a car dealership program.
 */

public class CarDealership {
    public static Scanner in= new Scanner(System.in);
    public static Scanner st= new Scanner(System.in);
    public static void printcar(ArrayList cars){
        System.out.println("display the vehicles in the dealership that have not been sold");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }
    public static void printemployee(ArrayList employees){
        System.out.println("display the list of employees in the store");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
        }
    }
    public static void printmenu(){
        System.out.println("Menu:");
        System.out.println("To display the list of employees in the store, click 1");
        System.out.println("To display the vehicles in the dealership that have not been sold, click 2");
        System.out.println("To sell a car, click 3");
        System.out.println("To add a vehicle to the agency, click 4");
        System.out.println("To finish the program click, 5");
    }
        public static void sort( ArrayList<Employee>employees ) {
            for (int i = employees.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (employees.get(j).compareTo(employees.get(j + 1)) > 0) {
                        Employee e = employees.get(j);
                        employees.set(j, employees.get(j + 1));
                        employees.set(j + 1, e);
                    }
                }
            }
        }
        public static void sellcar(ArrayList <Employee>employees,ArrayList<Car>cars,File filePath,Path carPath,Path employeePath){}
    /**
     * The main entry point of the program.
     *
     * @param args command-line arguments
     * @throws Exception if an error occurs during program execution
     */

    public static void main(String[] args) throws Exception {
        File filePath = new File("Sold.txt");
        Path carPath;
        Path employeePath;
        FileWriter w = new FileWriter(filePath);
        try {
            employeePath = Paths.get("C:\\Users\\97258\\IdeaProjects\\ex5.java\\src\\Employee.txt.txt");
            carPath = Paths.get("C:\\Users\\97258\\IdeaProjects\\ex5.java\\src\\CarDealership.txt.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        List<String> lines = Files.readAllLines(carPath);
        for (String line : lines) {
            String s1[] = line.split(" ");
            int s11 = Integer.parseInt(s1[1]);
            int s13 = Integer.parseInt(s1[3]);
            int s14 = Integer.parseInt(s1[4]);
            Car car = new Car(s1[0], s11, s1[2], s13, s14);
            cars.add(car);
        }
        List<String> lines2 = Files.readAllLines(employeePath);
        for (String line2 : lines2) {
            String s2[] = line2.split(" ");
            int s22 = Integer.parseInt(s2[2]);
            Employee employee = new Employee(s2[0], s2[1], s22);
            employees.add(employee);
        }
        System.out.println(employees);
        while (true) {
           printmenu();
            int num = in.nextInt();
            menu select=menu.values()[num-1];
            switch (select) {
                case EMPLOYEE:
                    sort(employees);
                    printemployee(employees);
                    break;
                case CAR:
                    printcar(cars);
                    break;
                case SALE:
                    System.out.println("sell a car");
                    printemployee(employees);
                    Boolean flag = false;
                    Boolean flag2 = false;
                    while (!flag) {
                        System.out.println("Enter your ID number");
                        try {
                            String id = st.nextLine();
                            for (int i = 0; i < employees.size(); i++) {
                                if (id.equals(employees.get(i).id)) {
                                    flag = true;
                                    for (int j = 0; j < cars.size(); j++) {
                                        System.out.println(cars.get(j));
                                    }
                                    while (!flag2) {
                                        System.out.println("Select the car number");
                                        try {
                                            String numOfCar = st.nextLine();
                                            for (int x = 0; x < cars.size(); x++) {
                                                if (numOfCar.equals(cars.get(x).getNumOfCar())) {
                                                    employees.get(i).sales++;
                                                    String caradd = cars.get(x).toString();
                                                    Files.write(filePath.toPath(), caradd.getBytes());
                                                    cars.remove(x);
                                                    flag2 = true;
                                                }
                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {

                        }
                    }
                    break;
                case ADDCAR:
                    try {

                        System.out.println("add a vehicle to the agency");
                        System.out.println("Enter your number the car");
                        String numCar = st.nextLine();
                        System.out.println("Enter your year the car");
                        int year = in.nextInt();
                        System.out.println("Enter your name the car");
                        String name = in.nextLine();
                        System.out.println("Enter your km the car");
                        int km = in.nextInt();
                        System.out.println("Enter your price the car");
                        int price = in.nextInt();
                        Car car = new Car(numCar, year, name, km, price);
                        cars.add(car);
                        String caradd=cars.get(cars.size()-1).toString();
                        Files.writeString(carPath,caradd+"\n",StandardOpenOption.APPEND);
                    } catch (Exception e) {
                    }
                    break;
                case END:
                    System.out.println("finish the program...");
                    Files.write(carPath, "".getBytes());
                    for (int i = 0; i < cars.size(); i++) {
                        String c=cars.get(i).toString();
                        Files.writeString(carPath,c+"\n",StandardOpenOption.APPEND);
                    }
                    return;
                default:
                    throw new IllegalStateException("Unexpected value: " + num);
            }
        }
    }
}