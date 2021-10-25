import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contacts> contacts;
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


}
