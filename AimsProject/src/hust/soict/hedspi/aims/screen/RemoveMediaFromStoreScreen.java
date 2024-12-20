package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveMediaFromStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle;

    public RemoveMediaFromStoreScreen() {
        super("Remove Media");
        JPanel center = createCenter();
        tfTitle = addInputField("Title: *", center);
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
                    if (tfTitle.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Some required fields (*) are empty!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Media media = Aims.getStore().searchByTitle(tfTitle.getText());
                    if (media == null) {
                        JOptionPane.showMessageDialog(null, "Media not found!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Aims.getStore().removeMedia(media);
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Media removed from store!");
                    Aims.closeStoreScreen();
                    Aims.openStoreScreen();
                    break;
                }
                case "Cancel": {
                    setVisible(false);
                    break;
                }
            }
        }
    }
}
