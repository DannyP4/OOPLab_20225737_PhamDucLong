package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        boolean existed = false;
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(media.getTitle())) {
                existed = true;
                break;
            }
        }

        if (!existed) {
            itemsInStore.add(media);
            System.out.println("The media has been added in Store.");
        } else {
            System.out.println("The media is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        boolean existed = false;
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(media.getTitle())) {
                itemsInStore.remove(item);
                System.out.println("The media has been removed from Store.");
                existed = true;
                break;
            }
        }

        if (!existed) {
            System.out.println("The media is not in the store.");
        }
    }

    public void printStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }

        return null;
    }

    public List<Media> searchByTitleLowerCase(String title) {
        List<Media> result = new ArrayList<Media>();
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(media);
            }
        }

        if (result.size() == 0) {
            return null;
        }

        return result;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
