import java.util.Scanner;
public class TipCalculatorRunner {
    public static void main(String[] args) {


        //Collects input data for receipt
        Scanner s = new Scanner(System.in);
        System.out.println("I am going to calculate your total bill and how much each of your party members owe.\nPlease answer the questions below: \n");
        System.out.println("How much is your bill? ");
        String billTemp = s.nextLine();
        double bill = Double.parseDouble(billTemp);
        System.out.println(" ");

        System.out.println("What whole number percent would you like to tip for our service ? ");
        String tipPercentageTemp = s.nextLine();
        int tipPercentage = Integer.parseInt(tipPercentageTemp);
        System.out.println(" ");

        System.out.println("Wow that was so generous of you! \nHow many people are in your party? ");
        String numberOfPartyMembersTemp = s.nextLine();
        int numberOfPartyMembers = Integer.parseInt(numberOfPartyMembersTemp);
        System.out.println(" ");

        //Final receipt calculations and rounding to correct decimal places
        TipCalculator calculatorAmount = new TipCalculator(bill,tipPercentage, numberOfPartyMembers );

        //Receipt/output print
        System.out.println("Based on the data provided, your new receipt is: " );
        System.out.println("_________________________________________________\n");
        System.out.println("Total Tip: " + String.format("$%.2f", calculatorAmount.calculateTipAmount()) + '\n');
        System.out.println("Total Bill Including Tip: " + String.format("$%.2f", calculatorAmount.calculateTotalBillTip()) + '\n');
        System.out.println("Amount of Tip per Person: " + String.format("$%.2f", calculatorAmount.calculateTipPerPerson()) + '\n');
        System.out.println("Total amount including tip per person: " + String.format("$%.2f", calculatorAmount.calculateTotalPerPerson()));

    }
}
