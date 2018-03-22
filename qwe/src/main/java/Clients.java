public class Clients {
    private double amountOfMoney;
    private String firstname;

    public String getFirstname() {
        return firstname;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void addMoney(double amountOfMoney) {
        this.amountOfMoney += amountOfMoney;
    }

    public void decrease(double value) {
        this.amountOfMoney -= value;
    }

    public Clients(String firstname, double amountOfMoney) {
        this.firstname = firstname;
        this.amountOfMoney = amountOfMoney;
    }

}
