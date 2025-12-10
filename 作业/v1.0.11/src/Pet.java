public class Pet {
    private String petBreeds = "";
    private int petCode = 0;
    private double unitCost = 0;
    private String color = "";

    public Pet(String petBreeds, int petCode, double unitCost, String color) {
        this.petBreeds = petBreeds;
        this.petCode = petCode;
        this.unitCost = unitCost;
        this.color = color;

    }
    public String getPetBreeds() {return petBreeds;}

    public void setPetBreeds(String petBreeds) {
        if (petBreeds != null) {
            if (petBreeds.length() > 30)
                this.petBreeds = petBreeds.substring(0, 30);

            else
                this.petBreeds = petBreeds;
        } }

    public int getPetCode() {return petCode;}

    public double getUnitCost() {return unitCost;}

    public void setUnitCost(double unitCost) {

        if ((unitCost > 0)&&(unitCost <= 99999))
            this.unitCost = unitCost;
    }

    public String getColor() {return color;}

    public void setColor(String color) {
        if (color != null) {
            if (color.length() > 30)
                this.color = color.substring(0, 30);

            else
                this.color = color;
        }
    }

    public void setPetCode(int petCode) {
        this.petCode = petCode;
    }

    public String toString()
    {

        return"\u001B[33m===== Details of pet =====\n" +
                "Breed: " + petBreeds + "\n" +
                "Code: " + petCode + "\n" +
                "Price: " + unitCost + "\n" +
                "Color: " + color + "\n" +
                "==========================\u001B[0m";
    }
}
