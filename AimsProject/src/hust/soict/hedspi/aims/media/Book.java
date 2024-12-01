package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public static int nbBook = 1;
    public Book(String title, String category, float cost) {
        super(nbBook++, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added");
        }
        else System.out.println("Author is already in the list");
    }

    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed");
        }
        else System.out.println("Author is not in the list");
    }

    @Override
    public String toString() {
        return "Book: " +
                "id = " + getId() +
                " - title = '" + getTitle() + '\'' +
                " - category = '" + getCategory() + '\'' +
                " - cost = " + getCost() +
                " - (List of) authors = " + authors;
    }

    //    public static void main(String[] args) {
//        List<String> author = new ArrayList<>();
//        Book hieu = new Book(1, "hoang", "ite6", 60);
//        hieu.addAuthor("hoang");
//        hieu.addAuthor("Hieu");
////        hieu.removeAuthor("Hieu");
//        Book hoang = new Book(2, "hoang", "it1", 40);
//
//        if (hieu.equals(hoang)) System.out.println("2 books are the same title"); // test equals
//        else System.out.println("2 books are different title");
//
////        System.out.println(hieu.getId() + " "  + hieu.getCost() + " " + hieu.authors);
//    }
}
