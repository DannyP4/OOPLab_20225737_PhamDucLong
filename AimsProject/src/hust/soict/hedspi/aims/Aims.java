package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        storeSetup();
        showMenu();
    }


    public static void storeSetup(){
        // DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Guy Ritchie", 89, 18.99f);
        store.addMedia(dvd1); store.addMedia(dvd2); store.addMedia(dvd3);

        // CD + Track
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 9.99f);
        Track track1 = new Track("Billie Jean", 236);
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);

        CompactDisc cd2 = new CompactDisc("Kind of Blue", "Jazz", "Miles Davis", 15.50f);
        Track track4 = new Track("So What", 431);
        Track track5 = new Track("Freddie Freeloader", 539);
        cd2.addTrack(track4); cd2.addTrack(track5);

        CompactDisc cd3 = new CompactDisc("Bohemian Rhapsody", "Rock", "Queen", 11.99f);
        Track track6 = new Track("Bohemian Rhapsody", 355);
        Track track7 =  new Track("Killer Queen", 205);
        Track track8 = new Track("Somebody to Love", 296);
        cd3.addTrack(track6); cd3.addTrack(track7); cd3.addTrack(track8);

        store.addMedia(cd1); store.addMedia(cd2); store.addMedia(cd3);

        // book
        Book book1 = new Book("Hannibal", "Crime Thriller", 8.99f);
        book1.addAuthor("Thomas Harris");
        Book book2 = new Book("Red Dragon", "Crime Thriller", 9.11f);
        book2.addAuthor("Thomas Harris");
        Book book3 = new Book("The Martian", "Science Fiction", 8.97f);
        book3.addAuthor("Andy Weir");
        store.addMedia(book1); store.addMedia(book2); store.addMedia(book3);
    }

    //clear console method
    public static void clc(){
        for(int i = 0; i < 20; i++) System.out.println();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    clc();
                    System.out.println("Thank you! Goodbye and have a nice day.");
                    scanner.close();
                    return;
                case "1":
                    clc();
                    store.printStore();
                    storeMenu();
                    break;
                case "2":
                    updateStore();
                    break;
                case "3":
                    clc();
                    cart.printCart();
                    cartMenu();
                    break;
                default:
                    clc();
                    System.out.println("Invalid option, please choose a number: 0-1-2-3.");
                    break;
            }
        }
    }

    public static void storeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        String option = scanner.nextLine();
        switch (option) {
            case "0":
                clc();
                showMenu();
                break;

            case "1":
                while (true) {
                    System.out.print("Enter the title of the media to view details (Press 0 to return): ");
                    String title = scanner.nextLine();
                    if (title.equals("0")) break;
                    Media foundMedia = store.searchByTitle(title);
                    if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
                    else {
                        System.out.println("Details: " + foundMedia.toString());
                        mediaDetailsMenu(foundMedia);
                    }
                }

                break;

            case "2":
                while (true) {
                    System.out.print("Enter the title of the media to add to cart (Press 0 to return): ");
                    String title = scanner.nextLine();
                    if (title.equals("0")) break;
                    Media foundMedia = store.searchByTitle(title);
                    if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
                    else cart.addMedia(foundMedia);
                }

                break;

            case "3":
                while (true) {
                    System.out.print("Enter the title of the media to play (Press 0 to return): ");
                    String title = scanner.nextLine();
                    if (title.equals("0")) break;
                    Media foundMedia = store.searchByTitle(title);
                    if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
                    else {
                        if (foundMedia instanceof CompactDisc) {
                            CompactDisc mediaCD = (CompactDisc) foundMedia;
                            clc();
                            mediaCD.play();
                        } else if (foundMedia instanceof DigitalVideoDisc) {
                            DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
                            clc();
                            mediaDVD.play();
                        } else System.out.println(foundMedia.getTitle() + " cannot be played! Please try another.");
                    }
                }

                break;

            case "4":
                clc();
                cart.printCart();
                cartMenu();
                break;
        }
    }

    public static void mediaDetailsMenu(Media media) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        String option = scanner.nextLine();
        switch (option) {
            case "0":
                clc();
                storeMenu();
                break;

            case "1":
                cart.addMedia(media);
                break;

            case "2":
                if (media instanceof CompactDisc) {
                    CompactDisc mediaCD = (CompactDisc) media;
                    clc();
                    mediaCD.play();
                } else if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc mediaDVD = (DigitalVideoDisc) media;
                    clc();
                    mediaDVD.play();
                } else System.out.println(media.getTitle() + " cannot be played! Please try another.");

                break;
            default:
                clc();
                System.out.println("Invalid option");
                break;
        }
    }

    public static void cartMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        String option = scanner.nextLine();
        switch (option) {
            case "0":
                clc();
                showMenu();
                break;

            case "1":
                System.out.println("Filter by:\n(1) Title\n(2) Id\n");
                int filterOption = scanner.nextInt();
                scanner.nextLine();
                while (true) {
                    Media foundMedia = null;
                    List<Media> foundMediaList = new ArrayList<>();
                    if (filterOption == 1) {
                        System.out.print("Enter the title of the media to filter (press 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) break;
                        foundMedia = cart.searchByTitle(title);
                    }
                    else if (filterOption == 2) {
                        System.out.print("Enter the ID of the media to filter (press 0 to stop): ");
                        int id = scanner.nextInt();
                        if (id == 0) break;
                        foundMediaList = cart.searchById(id);
                        foundMedia = foundMediaList.get(0);
                    } else {
                        clc();
                        System.out.println("Invalid Input.");
                    }

                    if (foundMedia == null) {
                        clc();
                        System.out.println("There is no matched items in your cart.");
                    } else {
                        clc();
                        if (filterOption == 1) System.out.println("Result: " + foundMedia.toString());
                        else if (filterOption == 2) {
                            System.out.println("Result: \n");
                            for (Media m : foundMediaList) System.out.println(m.toString());
                        }
                    }
                }
                break;

            case "2":
                System.out.println("Sort medias in cart by:\n (1) title \n (2) cost");
                int sortOption = scanner.nextInt();
                scanner.nextLine();
                if (sortOption == 1) cart.sortByTitle();
                else if (sortOption == 2) cart.sortByCost();
                else System.out.println("Invalid option.");
                break;

            case "3":
                while (true) {
                    System.out.print("Enter the title of the media to remove from cart (Press 0 to return): ");
                    String title = scanner.nextLine();
                    if (title.equals("0")) break;
                    Media foundMedia = cart.searchByTitle(title);
                    if (foundMedia == null) System.out.println(title + " is not in the cart. Please try another.");
                    else {
                        cart.removeMedia(foundMedia);
                        System.out.println(title + " has been successfully removed from the cart.");
                    }
                }
                break;

            case "4":
                while (true) {
                    System.out.print("Enter the title of the media to play (Press 0 to return): ");
                    String title = scanner.nextLine();
                    if (title.equals("0")) break;
                    Media foundMedia = cart.searchByTitle(title);
                    if (foundMedia == null) System.out.println(title + " is not in the cart. Please try another.");
                    else {
                        if (foundMedia instanceof CompactDisc) {
                            CompactDisc mediaCD = (CompactDisc) foundMedia;
                            clc();
                            mediaCD.play();
                        } else if (foundMedia instanceof DigitalVideoDisc) {
                            DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
                            clc();
                            mediaDVD.play();
                        } else System.out.println(foundMedia.getTitle() + " cannot be played! Please try another.");
                    }
                }
                break;

            case "5":
                clc();
                System.out.println("The order has successfully created.\nYour cart is now empty.");
                cart.empty();
                break;

            default:
                System.out.println("Invalid option. Please choose a number: 0-1-2-3-4-5.");
                break;
        }
    }

    public static void updateStore() {
    }
}

//        Cart anOrder = new Cart();
//
//        Media dvd1 = new DigitalVideoDisc("The Lion King",
//                "Animation", "Roger Allers", 87, 19.95f);
////        anOrder.addMedia(dvd1);
//
//        Media dvd2 = new DigitalVideoDisc("Star Wars",
//                "Science Fiction", "George Lucas", 87, 24.95f);
////        anOrder.addMedia(dvd2);
//
//        Media dvd3 = new DigitalVideoDisc("Aladdin",
//                "Animation", 18.99f);
////        anOrder.addMedia(dvd3);
//
//        Media dvd4 = new DigitalVideoDisc("The Lion King");
//
//        Media cd1 = new CompactDisc(4, "CD1", "Music", 10.3f, "Director 1", "Long");
////        anOrder.addMedia(cd1);
//
//        Media book1 = new Book(5, "Book1", "Horror", 4.5f);
////        anOrder.addMedia(book1);
//
//        Media book2 = new Book(6, "Book1", "Scientific", 5.5f);
//
////        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
////        anOrder.addDigitalVideoDisc(dvdList);
//
////        System.out.println("Total cost is: ");
////        System.out.print(anOrder.totalCost());
//
////        System.out.println("\nThe id of " + dvd1.getTitle() + " is " + dvd1.getId());
////        System.out.println("The id of " + dvd2.getTitle() + " is " + dvd2.getId());
////        System.out.println("The id of " + dvd3.getTitle() + " is " + dvd3.getId());
////        System.out.println("The id of " + cd1.getTitle() + " is " + cd1.getId());
////        System.out.println("The id of " + book1.getTitle() + " is " + book1.getId());
//
////        if (book1.equals(book2)) System.out.println("Two objects are equal"); // test equals
////        else System.out.println("Two objects are not equal");
//
//        List<Media> mediae = new ArrayList<Media>();
//        ArrayList<Track> tracks = new ArrayList<Track>();
//        tracks.add(new Track("Track 1", 1));
//        tracks.add(new Track("Track 2", 2));
//        Media cd = new CompactDisc(7, "CD2", "Music", 10.3f, "Director 2", "Long", tracks);
//
//        Media dvd = new DigitalVideoDisc("The Lion King",
//                "Animation", "Roger Allers", 87, 19.95f);
//
//        List<String> authors = new ArrayList<>();
//        authors.add("Author 1");
//        authors.add("Author 2");
//        Media book = new Book(8, "Book2", "Horror", 4.5f, authors);
//
//        mediae.add(cd);
//        mediae.add(dvd);
//        mediae.add(book);
//
//        for (Media m : mediae) {
//            System.out.println(m.toString());
//        }
//
