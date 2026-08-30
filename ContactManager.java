import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: Add contacts
        contacts.put("David",
                new Contact("David", "703-555-5555"));

        contacts.put("Sally",
                new Contact("Sally", "571-555-5555"));

        contacts.put("Rebecca",
                new Contact("Rebecca", "914-555-5555"));

        contacts.put("John",
                new Contact("John", "408-555-5555"));

        contacts.put("Leslie",
                new Contact("Leslie", "301-555-5555"));


        // Step 5: Look up a contact that EXISTS
        Contact found = contacts.get("John");

        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }


        // Test a contact that DOES NOT EXIST
        Contact missing = contacts.get("Jennifer");

        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }


        // Loop through all contacts in HashMap
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(
                    entry.getKey() + " ==> " + entry.getValue()
            );
        }


        // Step 6: Print sorted list

        // Create ArrayList from HashMap values
        ArrayList<Contact> sorted =
                new ArrayList<>(contacts.values());

        // Sort alphabetically by contact name
        sorted.sort(
                (a, b) -> a.getName().compareTo(b.getName())
        );

        // Print header
        System.out.println();
        System.out.println("=== All Contacts ===");

        // Print each contact
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}