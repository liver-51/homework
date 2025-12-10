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
        System.out.println("\u001B[36m===========================");
        System.out.println("\uD83D\uDC3EWelcome to the pet shop\uD83D\uDC3E");
        System.out.println("===========================");
        System.out.println("Let's proceed with the registration first");
        System.out.println("Entering details");
        System.out.println("----------------\u001B[0m");
    }

    private void addMember() {


        System.out.print("\u001B[33mEnter your name:    ");
        String name = input.nextLine();

        int ID = 0;
        while (true) {
            System.out.print("\u001B[33mEnter your ID(8-digit number):  \u001B[0m");

            ID = input.nextInt();
            input.nextLine();

            if (ID >= 10000000 && ID <= 99999999) {
                break;
            } else {
                System.out.println("\u001B[31mError:ID must be an eight-digit number\u001B[0m");
                System.out.println("\u001B[31mEnter your ID number again:  \u001B[0m");
            }
        }

        int phoneNumber = 0;
        while (true) {
            System.out.print("\u001B[33mEnter your phone number(6-digit number):  \u001B[0m");
            phoneNumber = input.nextInt();
            input.nextLine();

            if (phoneNumber >= 100000 && phoneNumber <= 999999) {
                break;
            }else{
                System.out.println("\u001B[31mError:Phone number must be a six-digit number\u001B[0m");
                System.out.println("\u001B[31mEnter your phone number again:  \u001B[0m");
            }
        }



        System.out.print("\u001B[33mDo you have any experience in keeping pets(y/n):     ");
        char isExperiencedChar = input.next().charAt(0);

        boolean isExperienced = false;
        if ((isExperiencedChar == 'Y') || (isExperiencedChar == 'y')) {
            isExperienced = true;
        }

        System.out.print("Do you  have pet (y/n):     \u001B[0m");
        char isPetOwnerChar = input.next().charAt(0);


        boolean isPetOwner = false;
        if ((isPetOwnerChar == 'Y') || (isPetOwnerChar == 'y')) {
            isPetOwner = true;
        }

        assignment = new Assignment(name, ID, phoneNumber, isExperienced, isPetOwner);
    }

    private int mainMenu() {
        System.out.print("\u001B[34m"+"""
                PetShop Menu
                ---------
                   1) List the register
                   2) Add pets
                   3) List the pets
                   4) Display cheapest pet
                   5) List pets that are more expensive than a given price
                   6) List pets that are less expensive than a given price
                   7) Delete a pet
                   8) Save data to file
                   9) Load data from file
                   0) Exit
                ==>>"""+"\u001B[0m");
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
                case 4 -> printCheapestPet();
                case 5 -> printPetsAboveAPrice();
                case 6 -> printPetsBelowAPrice();
                case 7 -> deletePet();
                case 8 -> saveData();
                case 9 -> loadData();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("\u001B[32m\nYou have completed this segment");
            System.out.println("\nPress enter key to continue...");
            System.out.println("==========================\u001B[0m" );
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }

        System.out.println("\u001B[31mExiting...bye\u001B[0m");
        System.exit(0);
    }

    private void saveData() {
        if (store != null&& store.getTotalPets() > 0) {
            store.saveToFile();
            System.out.println("\u001B[32mData saved successfully!\u001B[0m");
        } else {
            System.out.println("\u001B[31mPlease add a pet before saving!\u001B0m");
        }
    }

    private void loadData() {
        if (store == null) {
            store = new Store(100);
        }

        try {
            store.loadFromFile();
        } catch (Exception e) {
            System.out.println("\u001B[31mLoading failed: " + e.getMessage() + "\u001B[0m");
        }
    }

    private void printMember() {
        System.out.println("\u001B[36m\n\nPrinting details");
        System.out.println("----------------\u001B[0m");
        System.out.println(assignment);
    }

    private void processOrder() {

        if (store == null) {
            System.out.print("\u001B[33mHow many Pets would you like to have in your Store? : ");
            int numberPets = input.nextInt();
            store = new Store(numberPets);
        }

        System.out.println("\u001B[32mYou can now add pets,you can choose：");
        System.out.println("1. add a pet");
        System.out.println("2. return to Main Menu\u001B[0m");

        while (true) {
            System.out.print("\u001B[33mPlease choose (1/2): \u001B[0m");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (store.getTotalPets() < store.getCapacity()) {
                    addPet();
                } else {
                    System.out.println("\u001B[31mThe shop is full!You cannot add more\u001B[0m");
                    return;
                }
            } else if (choice == 2) {
                return;
            } else {
                System.out.println("\u001B[31mError！Please enter again\u001B[0m");
            }
        }
    }

    private void addPet() {
        input.nextLine();

        System.out.print("\u001B[33mEnter your pet breed:    ");
        String petBreed = input.nextLine();


        System.out.print("Enter the Pet Code:  ");
        int petCode = input.nextInt();

        input.nextLine();

        System.out.print("Enter the Price:  ");
        double unitCost = input.nextDouble();

        input.nextLine();

        System.out.print("Enter your pet color:    \u001B[0m");
        String color = input.nextLine();

        input.nextLine();

        boolean isAdded = store.add(new Pet(petBreed, petCode, unitCost, color));
        if (isAdded) {
            System.out.println("\u001B[32mPet Added Successfully\u001B[0m");
        } else {
            System.out.println("\u001B[31mNo Pet Added\u001B[0m");
        }

    }

    private void printPets() {
        System.out.println("\u001B[36mList of Pets are:\u001B[0m");
        System.out.println(store.listPets());
    }

    private void printCheapestPet() {
        Pet cheapestPet = store.cheapestPet();
        if (cheapestPet != null) {
            System.out.println("\u001B[33mDetails of the cheapest pet: ");
            System.out.println("==========================\u001B[0m");
            System.out.println("\u001B[34mCode: \u001B[0m" + cheapestPet.getPetCode());
            System.out.println("\u001B[34mBreed: \u001B[0m" + cheapestPet.getPetBreeds());
            System.out.println("\u001B[34mPrice: \u001B[0m" + cheapestPet.getUnitCost());
            System.out.println("\u001B[34mColor: \u001B[0m" + cheapestPet.getColor());
            System.out.println("\u001B[33m==========================\u001B[0m");
        } else {
            System.out.println("\u001B[31mThere are no pets in the store.\u001B[0m");
        }
    }

    private void printPetsAboveAPrice() {
        System.out.print("\u001B[33mView the pets costing more than this price: \u001B[0m ");
        double price = input.nextDouble();
        System.out.println(store.listPetsAboveAPrice(price));
    }

    private void printPetsBelowAPrice() {
        System.out.print("\u001B[33mView the pets costing lower than this price:  \u001B[0m");
        double price = input.nextDouble();
        System.out.println(store.listPetsBelowAPrice(price));
    }

    private void deletePet() {
        if (store == null) {
            System.out.println("\u001B[31mPlease add a pet first!\u001B[0m");
            return;
        }

        System.out.println("\u001B[33mCurrently all pets：");
        System.out.println(store.listPets());

        System.out.print("\u001B[34mPlease enter the pet code to be deleted: \u001B[0m");
        int petCode = input.nextInt();
        input.nextLine();


        boolean isDeleted = store.deletePetByCode(petCode);
        if (isDeleted) {
            System.out.println("\u001B[32mPet with code " + petCode + " deleted successfully!\u001B[0m");
            System.out.println("Remaining pet quantity: " + store.getTotalPets());
        } else {
            System.out.println("\u001B[31mDeletion failed! No pet found with code: " + petCode);
            System.out.println("Please check the pet code and try again.\u001B[0m");
        }
    }
}
