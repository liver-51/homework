import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);
    private Assignment assignment;


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        showWelcomeScreen();
        addMember();

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











    
}
