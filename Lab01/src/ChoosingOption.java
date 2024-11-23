import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
//        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
//        JOptionPane.showMessageDialog(null, "you've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));

        String[] options = {"I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null,
                "Do you want to change the first class ticket?",
                null,
                0,
                3,
                null,
                options,
                options[0]);

        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == 0 ? "I do" : "I don't"));
        System.exit(0);
    }
}
