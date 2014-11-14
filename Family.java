import java.util.ArrayList;


public class Family {
    private double amountToPay = 0;
    private boolean hasChild = false;
    private ArrayList<Person> arrayOfPeople = new ArrayList<Person>();
    private double amountPaid = -1;

    public Family() {

    }

    public void addPerson(Person person) {
        if(person.isChild() == true) {
            hasChild = true;
        }
        if(person.getAmountDue() != 0) {
            amountToPay = person.getAmountDue();
        }
        if (amountPaid == -1) {
            amountPaid = person.getAmountPaid();
        }

        arrayOfPeople.add(person);
    }

    public ArrayList<Person> getArrayOfPeopleWithEmails() {
        ArrayList<Person> arrayOfPeopleWithEmails = new ArrayList<Person>();
        for(int i = 0; i < arrayOfPeople.size(); i++) {
            if(arrayOfPeople.get(i).getEmail().length() != 0) {
                arrayOfPeopleWithEmails.add(arrayOfPeople.get(i));
            }
        }
        return arrayOfPeopleWithEmails;
    }

    public Person getPerson() {
        return arrayOfPeople.get(0);
    }

    public boolean getHasChild() {
        return hasChild;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
