import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);
    private Assignment assignment;
    private Store store;


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        showWelcomeScreen();
        addMember();
        runMenu();
    }

    private void showWelcomeScreen() {
        System.out.println("===========================");
        System.out.println("Welcome to the pet shop");
        System.out.println("===========================");
        System.out.println("Let's proceed with the registration first");
        System.out.println("Entering details");
        System.out.println("----------------");
    }

    private void addMember() {


        System.out.print("Enter your name:    ");
        String name = input.nextLine();


        int ID = 0;
        while (true) {
            System.out.print("Enter your ID(8-digit number):  ");

            ID = input.nextInt();
            input.nextLine();

            if (ID >= 10000000 && ID <= 99999999) {
                break;
            } else {
                System.out.println("Error:ID must be an eight-digit number");
                System.out.println("Enter your ID number again:  ");
            }
        }


        int phoneNumber = 0;
        while (true) {
            System.out.print("Enter your phone number(6-digit number):  ");
            phoneNumber = input.nextInt();
            input.nextLine();

            if (phoneNumber >= 100000 && phoneNumber <= 999999) {
                break;
            } else {
                System.out.println("Error:Phone number must be a six-digit number");
                System.out.println("Enter your phone number again:  ");
            }
        }

        System.out.print("Do you have any experience in keeping pets(y/n):     ");
        char isExperiencedChar = input.next().charAt(0);

        boolean isExperienced = false;
        if ((isExperiencedChar == 'Y') || (isExperiencedChar == 'y')) {
            isExperienced = true;
        }

        System.out.print("Do you  have pet (y/n):     ");
        char isPetOwnerChar = input.next().charAt(0);


        boolean isPetOwner = false;
        if ((isPetOwnerChar == 'Y') || (isPetOwnerChar == 'y')) {
            isPetOwner = true;
        }

        assignment = new Assignment(name, ID, phoneNumber, isExperienced, isPetOwner);
    }

    private int mainMenu() {
        System.out.print("""
                PetShop Menu
                ---------
                   1) List the register
                   2) Add pets
                   3) List the pets
                   0) Exit
                ==>>""");
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        int option = mainMenu();

        while (option != 0) {

            switch (option) {
                case 1 -> printMember();
                case 2 -> processOrder();
                case 3 -> printPets();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("\nYou have completed this segment");
            System.out.println("\nPress enter key to continue...");
            System.out.println("==========================" );
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }

        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void printMember() {
        //printing out the data to the user
        System.out.println("\n\nPrinting details");
        System.out.println("----------------");
        System.out.println(assignment);
    }

    private void processOrder() {

        if (store == null) {
            System.out.print("How many Pets would you like to have in your Store? : ");
            int numberPets = input.nextInt();
            store = new Store(numberPets);
        }

        System.out.println("You can now add pets,you can choose：");
        System.out.println("1. add a pet");
        System.out.println("2. return to Main Menu");

        while (true) {
            System.out.print("Please choose (1/2): ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (store.getTotalPets() < store.getCapacity()) {
                    addPet();
                } else {
                    System.out.println("The shop is full!You cannot add more");
                    return;
                }
            } else if (choice == 2) {
                return;
            } else {
                System.out.println("Error！Please enter again");
            }
        }
    }

    private void addPet() {
        input.nextLine();

        System.out.print("Enter your pet breed:    ");
        String petBreed = input.nextLine();


        System.out.print("Enter the Pet Code:  ");
        int petCode = input.nextInt();

        input.nextLine();

        System.out.print("Enter the Price:  ");
        double unitCost = input.nextDouble();

        input.nextLine();

        System.out.print("Enter your pet color:    ");
        String color = input.nextLine();

        input.nextLine();

        boolean isAdded = store.add(new Pet(petBreed, petCode, unitCost, color));
        if (isAdded) {
            System.out.println("Pet Added Successfully");
        } else {
            System.out.println("No Pet Added");
        }

    }

    private void printPets() {
        System.out.println("List of Pets are:");
        System.out.println(store.listPets());
    }





}
