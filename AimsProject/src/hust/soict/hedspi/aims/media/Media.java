package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {

    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Media: " +
                "id=" + id +
                " - title='" + title + '\'' +
                " - category='" + category + '\'' +
                " - cost=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(title, media.title);
    }

    @Override
    public int compareTo(Media other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) return titleComparison;


        return Float.compare(other.cost, this.cost);
    }

//    public static void main(String[] args) {
//        ArrayList<Media> mediaList = new ArrayList<>();
//        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", 10.5f));
//        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", 15.0f));
//        mediaList.add(new DigitalVideoDisc("Aladdin", "Animation", 12.0f));
//
//        System.out.println("Before sorting:");
//        for (Media media : mediaList) {
//            System.out.println(media.title + " " + media.cost);
//        }
//
//        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
//        System.out.println("\nAfter sorting by title and cost:");
//        for (Media media : mediaList) {
//            System.out.println(media.title + " " + media.cost);
//        }
//
//        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
//        System.out.println("\nAfter sorting by cost and title:");
//        for (Media media : mediaList) {
//            System.out.println(media.title + " " + media.cost);
//        }
//    }
}
