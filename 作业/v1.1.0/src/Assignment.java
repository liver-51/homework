public class Assignment {
    private String name = "Unknown";
    private int ID = 90000000;
    private int PhoneNumber = 900000;
    private boolean isExperienced = false;
    private boolean isPetOwner=false;

    public Assignment(String name,int ID,int PhoneNumber,boolean isExperienced,boolean isPetOwner) {

        setname(name);
        setID(ID);
        setPhoneNumber(PhoneNumber);
        setExperienced (isExperienced);
        setPetOwner(isPetOwner);
    }

    public String getName(){
        return name;
    }

    public void setname(String name){
        if (name.isEmpty()) {
            System.out.println("Name is empty");
        }

        if (name != null) if (name.length() > 30) {
            System.out.println("The name is too long,maximum 30 characters");
            this.name = name.substring(0, 30);
        } else {
            this.name = name;
        }

    }

    public int getID(){return ID;}
    public void setID(int ID) {

        if ((ID > 10000000) && (ID < 99999999)) {
            this.ID = ID;
        }
        else {
            System.out.println("\u001B[31mID must be an eight-digit number\u001B[0m");

        }
    }

    public int getPhoneNumber(){return PhoneNumber;}

    public void setPhoneNumber(int PhoneNumber){

        if((PhoneNumber>100000)&&(PhoneNumber<999999))
        {
            this.PhoneNumber = PhoneNumber;
        }
        else
        {
            System.out.println("\u001B[31mPhone number must be a six-digit number\u001B[0m");
        }
    }


    public boolean isExperienced() {
        return isExperienced;
    }
    public void setExperienced(boolean Experienced){

        isExperienced=Experienced;
    }


    public boolean isPetOwner() {
        return isPetOwner;
    }
    public void setPetOwner(boolean PetOwner){
        isPetOwner=PetOwner;
    }

    public String toString() {
        return name + ": " + "\n\nPhoneNumber:" + PhoneNumber + "\n\nID: " + ID +
                "\n\nisExperienced: " + isExperienced + "\n\nisPetOwner: " + isPetOwner;
    }

}

