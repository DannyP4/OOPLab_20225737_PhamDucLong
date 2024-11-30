package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
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

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName)) authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) authors.remove(authorName);
    }

    public static void main(String[] args) {
        List<String> author = new ArrayList<>();
        Book hieu = new Book(1, "hieu ngu", "gay", 60, author);
        hieu.addAuthor("hoangngu");
        hieu.removeAuthor("Hieungu");
        System.out.println(hieu.id + " "  + hieu.cost + " " + hieu.authors);
    }
}
