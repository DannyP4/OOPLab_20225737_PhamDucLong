package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfDirector;
    private JTextField tfLength;
    private JTextField tfCost;

    public AddDigitalVideoDiscToStoreScreen() {
        super("DVD");
        JPanel center = createCenter();
        tfTitle = addInputField("Title: *", center);
        tfCategory = addInputField("Category:", center);
        tfDirector = addInputField("Director:", center);
        tfLength = addInputField("Length:", center);
        tfCost = addInputField("Cost: *", center);
        center.add(Box.createRigidArea(new Dimension(10, 40)));
        add(center, BorderLayout.CENTER);
        add(createSouth(new ButtonListener()), BorderLayout.SOUTH);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "OK": {
                    if (tfTitle.getText().equals("") || tfCost.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Some required fields (*) are empty!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        float cost = Float.parseFloat(tfCost.getText());
                        int length = Integer.parseInt(tfLength.getText());
                        if (cost <= 0 || length <= 0) {
                            JOptionPane.showMessageDialog(null, "Cost and length must be positive!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(),
                                tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
                        Aims.getStore().addMedia(dvd);
                        setVisible(false);
                        JOptionPane.showMessageDialog(null, "New DVD added to store!");
                        Aims.closeStoreScreen();
                        Aims.openStoreScreen();
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Length and cost must be numeric!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                break;
                case "Cancel":
                    setVisible(false);
                    break;
            }
        }
    }
}
