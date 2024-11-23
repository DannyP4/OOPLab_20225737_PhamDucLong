import javax.swing.*;

public class SecondEq {
    public static void main(String[] args) {
        String str_a, str_b, str_c;

        JOptionPane.showMessageDialog(null, "Giai he phuong trinh bac hai ax^2 + bx + c = 0");
        str_a = JOptionPane.showInputDialog(null,
                "Nhap so a: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(str_a);

        str_b = JOptionPane.showInputDialog(null,
                "Nhap so b: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(str_b);

        str_c = JOptionPane.showInputDialog(null,
                "Nhap so c: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(str_c);
        Solve(a, b, c);
    }


    public static void Solve(double a, double b, double c) {
            if (a == 0) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
                } else {
                    JOptionPane.showMessageDialog(null, "Phuong trinh co mot nghiem: "
                            + "x = " + (-c / b));
                }
                return;
            }

            double delta = b*b - 4*a*c;
            double x1;
            double x2;
            if (delta > 0) {
                x1 = (double) ((-b + Math.sqrt(delta)) / (2*a));
                x2 = (double) ((-b - Math.sqrt(delta)) / (2*a));
                JOptionPane.showMessageDialog(null, "Phuong trinh co hai nghiem: "
                        + "x1 = " + x1 + " va x2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem kep: "
                        + "x1 = x2 = " + x1);
            } else {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            }
    }
}
