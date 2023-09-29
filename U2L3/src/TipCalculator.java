public class TipCalculator {
    private double bill;
    private int tipPercentage;
    private int numberOfPartyMembers;

    public TipCalculator(double bill, int tipPercentage, int numberOfPartyMembers){
        this.bill = bill;
        this.tipPercentage = tipPercentage;
        this.numberOfPartyMembers = numberOfPartyMembers;
    }

    public double calculateTipAmount(){
        return bill * ((double)tipPercentage /100);
    }

    public double calculateTotalBillTip(){
        return bill + calculateTipAmount();
    }
    public double calculateTotalPerPerson(){
        return calculateTotalBillTip() / numberOfPartyMembers;
    }

    public double calculateTipPerPerson(){
        return calculateTipAmount() / numberOfPartyMembers;
    }
}
