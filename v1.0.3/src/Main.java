import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        showWelcomeScreen();


    }

    private void showWelcomeScreen() {
        System.out.println("===========================");
        System.out.println("Welcome to the pet shop");
        System.out.println("===========================");
        System.out.println("Let's proceed with the registration first");
        System.out.println("Entering details");
        System.out.println("----------------");
    }
}