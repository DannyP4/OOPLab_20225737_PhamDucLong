package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The media is almost full");
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }

        return totalCost;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("**************************************************");
    }

    public boolean search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id)
                return true;
        }

        return false;
    }

    public boolean search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title))
                return true;
        }

        return false;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title))
                return media;
        }

        return null;
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id)
                return media;
        }

        return null;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println((iterator.next()).toString());
        }
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) System.out.println((iterator.next()).toString());

    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed");
        } else System.out.println("The media is not in the cart");

    }

    public void empty() {
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void placeOrder() {
        DecimalFormat df = new DecimalFormat("#.00");

        if (itemsOrdered.size() == 0) {
            JOptionPane.showMessageDialog(null, "Cart is empty");
            return;
        }

        JOptionPane.showMessageDialog(null, "Order placed successfully, total cost: " + df.format(totalCost()) + " $");
        empty();
    }
}
