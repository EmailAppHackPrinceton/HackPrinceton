//Vince's comment
public class Person {
	//testing
    private final double amountDue;
    private final String firstName;
    private final String lastName;
    private final String email;
    private boolean isChild;
    private final double amountPaid;

    public Person(String firstName, String lastName, String email, boolean isChild, double amountDue, double amountToPay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amountDue = amountDue;
        this.isChild = isChild;
        this.amountPaid = amountToPay;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean isChild) {
        this.isChild = isChild;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
 }
//Justice's Comment
