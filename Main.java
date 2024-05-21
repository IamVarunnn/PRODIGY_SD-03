import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    manager.addContact(new Contact(name, phoneNumber, email));
                    break;
                case 2:
                    displayContacts(manager.getContacts());
                    break;
                case 3:
                    displayContacts(manager.getContacts());
                    System.out.print("Enter the number of the contact to edit: ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (isValidIndex(manager.getContacts(), editIndex)) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        manager.editContact(editIndex, new Contact(newName, newPhoneNumber, newEmail));
                    } else {
                        System.out.println("Invalid contact index.");
                    }
                    break;
                case 4:
                    displayContacts(manager.getContacts());
                    System.out.print("Enter the number of the contact to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (isValidIndex(manager.getContacts(), deleteIndex)) {
                        manager.deleteContact(deleteIndex);
                    } else {
                        System.out.println("Invalid contact index.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static boolean isValidIndex(List<Contact> contacts, int index) {
        return index >= 0 && index < contacts.size();
    }
}
