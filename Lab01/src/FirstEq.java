import javax.swing.*;

public class FirstEq {
    public static void main(String[] args) {
        String str_a, str_b;

        JOptionPane.showMessageDialog(null, "Giai he phuong trinh bac nhat ax + b = 0");
        str_a = JOptionPane.showInputDialog(null,
                "Nhap so a: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(str_a);

        str_b = JOptionPane.showInputDialog(null,
                "Nhap so b: ", null,
                JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(str_b);

        if (a == 0) {
            if (b == 0) JOptionPane.showMessageDialog(null, "Phuong trinh co vo so nghiem");
            else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        } else {
            double nghiem = -b/a;
            JOptionPane.showMessageDialog(null, "Nghiem phuong trinh la: " + nghiem);
        }
    }
}
