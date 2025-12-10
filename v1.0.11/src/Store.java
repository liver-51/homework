import java.io.*;


public class Store {

    private Pet[] pets;
    private int total = 0;

    public int getCapacity() {
        return pets.length;
    }

    public int getTotalPets() {
        return total;
    }

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

    public String listPets() {
        if (isEmpty()) {
            return "\u001B[31mNo pets in the store,please add a pet first!\u001B[0m";
        } else {
            String listOfProducts = "";
            for (int i = 0; i < total; i++) {
                listOfProducts += i + ": " + pets[i] + "\n";
            }
            return listOfProducts;
        }
    }

    public Pet cheapestPet() {
        if (!isEmpty()) {
            Pet cheapestPet = pets[0];
            for (int i = 1; i < total; i++) {
                if (pets[i].getUnitCost() < cheapestPet.getUnitCost())
                    cheapestPet = pets[i];
            }
            return cheapestPet;
        } else {
            return null;
        }
    }










}