package Week1_AnotherTypeOfEmployee;

public class Commision extends Hourly{
    private double total_sales;
    private double commision_rate;

    //Constructor
    Commision (String eName, String eAddress, String ePhone,
               String socSecNumber, double rate, double commis_rate) {
        super(eName,eAddress,ePhone,socSecNumber,rate);
        this.commision_rate = commis_rate;
    }

    //add total sales to the instance variable
    public void addSales(double totalSales) {
        this.total_sales = totalSales;
    }

    //override pay method to calculate payment
    @Override
    public double pay() {
        double payment = super.pay() + (this.commision_rate * this.commision_rate);
        this.total_sales = 0;
        return  payment;
    }

    //override toString method to print the total sales
    @Override
    public String toString() {
        return super.toString() + "\nTotal sales: " + this.total_sales;
    }
}
