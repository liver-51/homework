import java.io.*;


public class Store {

    private Pet[] pets;
    private int total = 0;


    public Store(int numberItems) {
        pets = new Pet[numberItems];
        total = 0;

    }

    public boolean add(Pet pet) {
        if (total < pets.length) {
            pets[total] = pet;
            total++;
            System.out.print("Added successfully!");
            return true;
        }
        return false;
    }


    private boolean isFull() {
        return total == pets.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }
}