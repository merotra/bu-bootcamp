import java.util.HashMap;

public class Contact {

    // FIELDS
    private String name;
    private String phone;

    // CONSTRUCTOR
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // TOSTRING
    @Override
    public String toString() {
        return name + " | " + phone;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        // Create 4 contacts
        Contact contact1 = new Contact("John", "408-555-5555");
        Contact contact2 = new Contact("Sally", "571-555-5555");
        Contact contact3 = new Contact("Rebecca", "914-555-5555");
        Contact contact4 = new Contact("David", "703-555-5555");

        // Print contacts
        System.out.println(contact1);
        System.out.println(contact2);
        System.out.println(contact3);
        System.out.println(contact4);
    }
}