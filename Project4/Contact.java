/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Contact implements Comparable<Contact> {
    String firstName;
    String lastName;
    Address address;
    long phone;

    /**
     * Construct a new contact
     * 
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     * @param phone     the phone
     */
    public Contact(String firstName, String lastName, Address address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = Long.parseLong(phone.replace("-", ""));
    }

    /**
     * Compare two contacts
     * 
     * @param o other contact
     * @return the value 0 mean equal, less than 0 mean less than, greater than 0
     *         mean greater than.
     */
    @Override
    public int compareTo(Contact o) {
        return (lastName + firstName).compareTo(o.lastName + o.firstName);
    }

    /**
     * Get the string representation.
     */
    public String toString() {
        return String.format("Name: %s\nPhone: %s\nAddress:\n%s\n", this.getName(), this.getPhoneFormatted(),
                this.getAddress());
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public Address getAddress() {
        return this.address;
    }

    public long getPhone() {
        return this.phone;
    }

    /**
     * Get the area code of phone
     * 
     * @return area code
     */
    public long getPhoneAreaCode() {
        return this.phone / 10000000;
    }

    /**
     * Get formatted phone
     * 
     * @return formatted string
     */
    public String getPhoneFormatted() {
        return String.format("%d-%d-%d", this.getPhoneAreaCode(), (this.phone % 10000000) / 10000, this.phone % 10000);
    }
}
