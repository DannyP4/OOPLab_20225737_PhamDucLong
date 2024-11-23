package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[40];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc disc) {
        boolean existed = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equals(disc.getTitle())) {
                existed = true;
                break;
            }
        }

        if (!existed) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("The disc has been added in Store.");
        } else {
            System.out.println("The disc is already in the store.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int check = 41;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getTitle().equals(disc.getTitle()))
                check = i;
        }

        if (check != 41) {
            for (int i = check; i < qtyInStore; i++)
                itemsInStore[i] = itemsInStore[i + 1];

            System.out.println("The disc " + disc.getTitle() + " has been removed.");
            qtyInStore--;
        } else
            System.out.println("The disc is not in the store.");
    }

    public void printStore() {
        for (int i = 0; i < qtyInStore; i++)
            System.out.println(itemsInStore[i].getTitle());
    }
}
