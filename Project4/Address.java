/**
 * Class to represent address object
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Address implements Comparable<Address> {
    String street;
    String city;
    String state;
    int zipCode;

    public Address(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Construct a new address
     * 
     * @param street  the street
     * @param city    the city
     * @param state   the state
     * @param zipCode the zip code
     */
    public Address(String street, String city, String state, String zipCode) {
        this(street, city, state, Integer.parseInt(zipCode));
    }

    /**
     * Compare two addresses
     * 
     * @param o other address
     * @return the value 0 mean equal, less than 0 mean less than, greater than 0
     *         mean greater than.
     */
    @Override
    public int compareTo(Address o) {
        return Integer.compare(this.zipCode, o.zipCode);
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n%d", state, city, street, zipCode);
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public int getZipCode() {
        return this.zipCode;
    }
}
