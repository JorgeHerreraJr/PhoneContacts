import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;

    public static void main(String[] args) {

    contacts = new ArrayList<>();
        System.out.println("How would you like to proceed?");
        showOptions();
    }

    private static void showOptions() {
        System.out.println("Select One: " +
                "\n\t1. Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageContacts() {
        System.out.println("Select One: " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add new contact" +
                "\n\t3. Search" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Please enter a name:");
            deleteContact();
        } else {
            boolean exists = false;
            for (Contact c: contacts ) {
                if (c.getName().equals(name)) {
                    exists = true;
                    contacts.remove(c);
                }
            }

            if(!exists) {
                System.out.println("Contact does not exist");
            }
        }

        showOptions();
    }

    private static void searchContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Please enter a name: ");
            searchContact();
        } else {
            boolean exists = false;
            for (Contact c: contacts) {
                if (c.getName().equals(name)) {
                    exists = true;
                    c.getDetails();
                }
            }

            if (!exists) {
                System.out.println("Does not exist in contacts");
            }
        }

        showOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding new contact..." +
                "\nEnter New Contact: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact's number:");
        String number = scanner.nextLine();
        System.out.println("Enter contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please Enter Information");
            addNewContact();
        } else {
            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
        }

        showOptions();
    }

    private static void showAllContacts() {
        for (Contact c: contacts) {
            c.getDetails();
        }

        showOptions();
    }


}
