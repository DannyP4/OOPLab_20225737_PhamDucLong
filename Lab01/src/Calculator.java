import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first number: ",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ", "Input the second number: ",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        double sum, dif, prod, quot;
        sum = num1 + num2;
        dif = num1 - num2;
        prod = num1 * num2;
        if (num2 != 0) {
            quot = num1 / num2;
            strNotification = "Sum of number 1 and number 2 is " + sum
                    + "\nDifference of number 1 and number 2 is " + dif
                    + "\nProduct of number 1 and number 2 is " + prod
                    + "\nQuotient of number 1 and number 2 is " + quot;
        }
        else {
            strNotification = "Cannot divide by zero!";
        }

        JOptionPane.showMessageDialog(null, strNotification,
                "Show Two Number", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
