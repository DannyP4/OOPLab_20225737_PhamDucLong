import javax.swing.*;

public class SysFirstEq {
    public static void main(String[] args) {
        String str_a11, str_a12, str_b1, str_a21, str_a22, str_b2;

        JOptionPane.showMessageDialog(null, "Giai He phuong trinh 2 an co dang: \n a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2");
        str_a11 = JOptionPane.showInputDialog(null,
                "Nhap so a11: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(str_a11);

        str_a12 = JOptionPane.showInputDialog(null,
                "Nhap so a12: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a12 = Double.parseDouble(str_a12);

        str_b1 = JOptionPane.showInputDialog(null,
                "Nhap so b1: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double b1 = Double.parseDouble(str_b1);

        str_a21 = JOptionPane.showInputDialog(null,
                "Nhap so a21: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a21 = Double.parseDouble(str_a21);

        str_a22 = JOptionPane.showInputDialog(null,
                "Nhap so a22: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a22 = Double.parseDouble(str_a22);

        str_b2 = JOptionPane.showInputDialog(null,
                "Nhap so b2: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double b2 = Double.parseDouble(str_b2);

        Solve(a11, a12, a21, a22, b1, b2);
    }

    public static void Solve(double a, double b, double c, double d, double e, double f) {
        // ax + by = e & cx + dy = f
        double det = a * d - b * c;
        double det_x = b * f - d * e;
        double det_y = a * f - c * e;

        if (det == 0) {
            if (det_x == 0 && det_y == 0)
                JOptionPane.showMessageDialog(null, "He phuong trinh vo so nghiem");
            else
                JOptionPane.showMessageDialog(null, "He phuong trinh vo nghiem");
        }
        else {
            double x = ((d) * (e) - (b) * (f)) / det;
            double y = ((a) * (f) - (c) * (e)) / det;
            JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem x = " + x + " y = " + y);
        }
    }
}
