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

    public String listPetsAboveAPrice(double price) {
        if (isEmpty()) {
            return "\u001B[31mNo Pets in the store\u001B[0m";
        } else {
            String str = "";
            for (int i = 0; i < total; i++) {
                if (pets[i].getUnitCost() > price)
                    str += i + ": " + pets[i] + "\n";
            }
            if (str.equals("")) {
                return "\u001B[31mNo products are more expensive than:\u001B[0m " + price;
            } else {
                return str;
            }
        }
    }

    public String listPetsBelowAPrice(double price) {
        if (isEmpty()) {
            return "\u001B[31mNo Pets in the store\u001B[0m";
        }
        else {
            String str = "";
            for (int i = 0; i < total; i++) {
                if (pets[i].getUnitCost() < price)
                    str += i + ": " + pets[i] + "\n";
            }
            if (str.equals("")) {
                return "\u001B[31mNo products are less expensive than: \u001B[0m" + price;
            } else {
                return str;
            }
        }
    }

    public boolean deletePet(int index) {

        if (index < 0 || index >= total) {
            return false;
        }

        for (int i = index; i<total -1; i++) {
            pets[i] = pets[i + 1];
        }

        pets[total - 1] = null;
        total--;
        return true;
    }

    public boolean deletePetByCode(int petCode) {
        for (int i = 0; i < total; i++) {
            if (pets[i].getPetCode() == petCode) {

                return deletePet(i);
            }
        }
        return false;
    }






}