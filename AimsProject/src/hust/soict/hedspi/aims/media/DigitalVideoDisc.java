package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 1;

    public DigitalVideoDisc(String title) {
        super(nbDigitalVideoDiscs++, title, null, 0, 0, null);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(nbDigitalVideoDiscs++, title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(nbDigitalVideoDiscs++, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs++, title, category, cost, length, director);
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc: " +
                "id = " + getId() +
                " - title = '" + getTitle() + '\'' +
                " - category = '" + getCategory() + '\'' +
                " - cost = " + getCost() +
                " - length = " + getLength() +
                " - director = '" + getDirector() + '\'';
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public int compareTo(Media other) {
        if (!(other instanceof DigitalVideoDisc)) return super.compareTo(other);

        DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;

        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) return titleComparison;

        if (this.getLength() == otherDVD.getLength()) return Float.compare(otherDVD.getCost(), this.getCost());

        return Integer.compare(otherDVD.getLength(), this.getLength());
    }

//    public static void main(String[] args) {
//        ArrayList<DigitalVideoDisc> DVDList = new ArrayList<>();
//        DVDList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
//        DVDList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 25f));
//        DVDList.add(new DigitalVideoDisc("Aladdin", "Animation", "Roger Allers", 90, 12.0f));
//
//        System.out.println("Before sorting:");
//        for (DigitalVideoDisc dvd : DVDList) {
//            System.out.println(dvd.getTitle() + " " + dvd.getLength() + " " + dvd.getCost());
//        }
//
//        System.out.println("\nAfter sorting:");
//        Collections.sort(DVDList, COMPARE_BY_TITLE_COST);
//        for (DigitalVideoDisc dvd : DVDList) {
//            System.out.println(dvd.getTitle() + " " + dvd.getLength() + " " + dvd.getCost());
//        }
//    }
}
