package hust.soict.hedspi.aims.screen;

import com.sun.javafx.stage.EmbeddedWindow;
import hust.soict.hedspi.aims.Aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.text.DecimalFormat;


public class CartScreenController {
    private Cart cart;
    private Store store;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Label total;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        if (cart.getItemsOrdered().size() == 0) total.setText("0$");
        else {
            DecimalFormat df = new DecimalFormat("#.00");
            total.setText(df.format(cart.totalCost()) + "$");
        }

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

                tfFilter.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilteredMedia(newValue);
                    }
                });
    }

    private void showFilteredMedia(String filter) {
        ObservableList<Media> filteredList = FXCollections.observableArrayList();

        if (radioBtnFilterId.isSelected()) {
            for (Media media : cart.getItemsOrdered()) {
                String mediaToString = media.getId() + "";
                if (mediaToString.contains(filter)) filteredList.add(media);
            }
        } else {
            for (Media media : cart.getItemsOrdered()) {
                String filterToLowerCase = filter.toLowerCase();
                if (media.getTitle().toLowerCase().contains(filterToLowerCase)) filteredList.add(media);
            }
        }

        tblMedia.setItems(filteredList);
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        total.setText(cart.totalCost() + "$");
    }

    @FXML
    void btnPlaceOrder(ActionEvent event) {
        cart.placeOrder();
        total.setText("0$");
    }

    @FXML
    void btnPlayMedia(ActionEvent event) {
        Playable media = (Playable) tblMedia.getSelectionModel().getSelectedItem();
        try {
            media.play();
        } catch (PlayerException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void viewStore(ActionEvent event) {
        Aims.closeCartScreen();
        Aims.openStoreScreen();
    }

    @FXML
    void viewCart(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "You are already in the cart screen!");
        cart.printCart();
    }

    @FXML
    void AddBook(ActionEvent event) {
        Object[] options = {"Go to store screen", "Stay here"};
        int choice = JOptionPane.showOptionDialog(null,
                "Please go to the store screen to add a book!",
                "Add Book",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            Aims.closeCartScreen();
            Aims.openStoreScreen();
        }
    }

    @FXML
    void AddCD(ActionEvent event) {
        Object[] options = {"Go to store screen", "Stay here"};
        int choice = JOptionPane.showOptionDialog(null,
                "Please go to the store screen to add a CD!",
                "Add Book",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            Aims.closeCartScreen();
            Aims.openStoreScreen();
        }
    }

    @FXML
    void AddDVD(ActionEvent event) {
        Object[] options = {"Go to store screen", "Stay here"};
        int choice = JOptionPane.showOptionDialog(null,
                "Please go to the store screen to add a DVD!",
                "Add Book",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == JOptionPane.YES_OPTION) {
            Aims.closeCartScreen();
            Aims.openStoreScreen();
        }
    }
}