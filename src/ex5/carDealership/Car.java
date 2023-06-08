package ex5.carDealership;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Represents a car in a car dealership.
 */
public class Car {
    private String numOfCar;
    private int year;
    private String name;
    private int km;
    private int price;

    /**
     * Constructs a car object with the specified parameters.
     *
     * @param numOfCar the car number
     * @param year the year of the car
     * @param name the name of the car
     * @param km the mileage of the car
     * @param price the price of the car
     * @throws Exception if any of the parameters is invalid
     */
    public Car(String numOfCar, int year, String name, int km, int price) throws Exception {
        if (numOfCar.length() != 6)
            throw new Exception("the length of numOfCar must be 6");
        else {
            this.numOfCar = numOfCar;
        }
        if (year < 2017)
            throw new Exception("the year must be greater than 2017");
        else {
            this.year = year;
        }

            if (!name.matches("[a-zA-Z]+"))
                throw new Exception("The name must contain only letters");
            else {
                this.name = name;
            }

        if (km < 0)
            throw new Exception("the km must be positive");
        else {
            this.km = km;
        }
        if (price < 0)
            throw new Exception("the price must be positive");
        else {
            this.price = price;
        }
    }

    /**
     * Calculates the car's price after applying depreciation.
     *
     * @param percent the percentage of depreciation
     * @return the updated price after depreciation
     * @throws Exception if the depreciation or discount is invalid
     */
    public double Depreciation(double percent) throws Exception {
        if (price - (percent / 100) * price < 0)
            throw new Exception("the depreciation must be positive");
        else if ((percent / 100) * price > 5000)
            throw new Exception("the discount is too high");
        else
            return price - (percent / 100) * price;
    }

    /**
     * Writes the car's details to a file using the provided BufferedWriter.
     *
     * @param writer the BufferedWriter to write to
     * @throws IOException if an I/O error occurs
     */
    public void sellCar(BufferedWriter writer) throws IOException {
        writer.write(this.toString() + "\n");
        writer.flush();
    }

    /**
     * Returns the car number.
     *
     * @return the car number
     */
    public String getNumOfCar() {
        return numOfCar;
    }

    /**
     * Returns a string representation of the car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "numOfCar: " + numOfCar + " ,year: " + year + " ,name: " + name + " ,km: " + km + " ,price: " + price;
    }
}
