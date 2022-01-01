import java.util.LinkedList;

/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class AddressBook extends BinarySearchTree<Contact> {
    public AddressBook() {
        super();
    }

    /**
     * Get contacts with specified zip code
     * 
     * @param zipcode zipcode
     * @return contacts
     */
    public LinkedList<Contact> getContactByZipCode(int zipcode) {
        LinkedList<Contact> ret = new LinkedList<Contact>();
        for (Contact contact : this) {
            if (contact.getAddress().getZipCode() == zipcode) {
                ret.add(contact);
            }
        }
        return ret;
    }

    /**
     * Get contacts with specified city
     * 
     * @param city city
     * @return contacts
     */
    public LinkedList<Contact> getContactByCity(String city) {
        LinkedList<Contact> ret = new LinkedList<Contact>();
        for (Contact contact : this) {
            if (contact.getAddress().getCity().compareTo(city) == 0) {
                ret.add(contact);
            }
        }
        return ret;
    }

    /**
     * Get contacts with specified area code
     * 
     * @param areaCode area code
     * @return contacts
     */
    public LinkedList<Contact> getContactByAreaCode(int areaCode) {
        LinkedList<Contact> ret = new LinkedList<Contact>();
        for (Contact contact : this) {
            if (contact.getPhoneAreaCode() == areaCode) {
                ret.add(contact);
            }
        }
        return ret;
    }
}