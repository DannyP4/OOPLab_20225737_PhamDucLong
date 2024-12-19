package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.CartScreen;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static StoreScreen storeScreen;
    private static CartScreen cartScreen;

    public static void main(String[] args) {
        storeSetup();
//        clc();
//        showMenu();
        openStoreScreen();
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreen() {
        return storeScreen;
    }

    public static CartScreen getCartScreen() {
        return cartScreen;
    }

    public static void openStoreScreen() {
        storeScreen = new StoreScreen(store, cart);
    }

    public static void closeStoreScreen() {
        storeScreen.setVisible(false);
        storeScreen = null;
    }

    public static void openCartScreen() {
        cartScreen = new CartScreen(cart);
    }

    public static void closeCartScreen() {
        cartScreen.setVisible(false);
        cartScreen = null;
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
}

    // clear console method
//    public static void clc(){
//        for(int i = 0; i < 20; i++) System.out.println();
//    }
//
//    public static void showMenu() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("AIMS: ");
//            System.out.println("--------------------------------");
//            System.out.println("1. View store");
//            System.out.println("2. Update store");
//            System.out.println("3. See current cart");
//            System.out.println("0. Exit");
//            System.out.println("--------------------------------");
//            System.out.println("Please choose a number: 0-1-2-3");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    clc();
//                    System.out.println("Thank you! Goodbye and have a nice day.");
//                    scanner.close();
//                    return;
//
//                case "1":
//                    clc();
//                    store.printStore();
//                    storeMenu();
//                    break;
//
//                case "2":
//                    updateStore();
//                    break;
//
//                case "3":
//                    clc();
//                    cart.printCart();
//                    cartMenu();
//                    break;
//
//                default:
//                    clc();
//                    System.out.println("Invalid option, please choose a number: 0-1-2-3.");
//                    break;
//            }
//        }
//    }
//
//    public static void storeMenu() {
//        Scanner scanner = new Scanner(System.in);
//
//        boolean back = false;
//        while (!back) {
//            System.out.println("Options: ");
//            System.out.println("--------------------------------");
//            System.out.println("1. See a media’s details");
//            System.out.println("2. Add a media to cart");
//            System.out.println("3. Play a media");
//            System.out.println("4. See current cart");
//            System.out.println("0. Back");
//            System.out.println("--------------------------------");
//            System.out.println("Please choose a number: 0-1-2-3-4");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    clc();
//                    back = true;
//                    break;
//
//                case "1":
//                    while (true) {
//                        System.out.print("Enter the title of the media to view details (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = store.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
//                        else {
//                            System.out.println("Details: " + foundMedia.toString());
//                            mediaDetailsMenu(foundMedia);
//                        }
//                    }
//                    break;
//
//                case "2":
//                    while (true) {
//                        System.out.print("Enter the title of the media to add to cart (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = store.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
//                        else cart.addMedia(foundMedia);
//                    }
//                    break;
//
//                case "3":
//                    while (true) {
//                        System.out.print("Enter the title of the media to play (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = store.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
//                        else {
//                            if (foundMedia instanceof CompactDisc) {
//                                CompactDisc mediaCD = (CompactDisc) foundMedia;
//                                clc();
//                                mediaCD.play();
//                            } else if (foundMedia instanceof DigitalVideoDisc) {
//                                DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
//                                clc();
//                                mediaDVD.play();
//                            } else System.out.println(foundMedia.getTitle() + " cannot be played! Please try another.");
//                        }
//                    }
//                    break;
//
//                case "4":
//                    clc();
//                    cart.printCart();
//                    cartMenu();
//                    break;
//
//                default:
//                    clc();
//                    System.out.println("Invalid option. Please choose a number: 0-1-2-3-4.");
//                    break;
//            }
//        }
//    }
//
//    public static void mediaDetailsMenu(Media media) {
//        Scanner scanner = new Scanner(System.in);
//
//        boolean back = false;
//        while (!back) {
//            System.out.println("Options: ");
//            System.out.println("--------------------------------");
//            System.out.println("1. Add to cart");
//            System.out.println("2. Play");
//            System.out.println("0. Back");
//            System.out.println("--------------------------------");
//            System.out.println("Please choose a number: 0-1-2");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    clc();
//                    back = true;
//                    break;
//
//                case "1":
//                    cart.addMedia(media);
//                    break;
//
//                case "2":
//                    if (media instanceof CompactDisc) {
//                        CompactDisc mediaCD = (CompactDisc) media;
//                        clc();
//                        mediaCD.play();
//                    } else if (media instanceof DigitalVideoDisc) {
//                        DigitalVideoDisc mediaDVD = (DigitalVideoDisc) media;
//                        clc();
//                        mediaDVD.play();
//                    } else System.out.println(media.getTitle() + " cannot be played! Please try another.");
//                    break;
//
//                default:
//                    clc();
//                    System.out.println("Invalid option");
//                    break;
//            }
//        }
//    }
//
//    public static void cartMenu() {
//        Scanner scanner = new Scanner(System.in);
//
//        boolean back = false;
//        while (!back) {
//            System.out.println("Options: ");
//            System.out.println("--------------------------------");
//            System.out.println("1. Filter medias in cart");
//            System.out.println("2. Sort medias in cart");
//            System.out.println("3. Remove media from cart");
//            System.out.println("4. Play a media");
//            System.out.println("5. Place order");
//            System.out.println("0. Back");
//            System.out.println("--------------------------------");
//            System.out.println("Please choose a number: 0-1-2-3-4-5");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    clc();
//                    back = true;
//                    break;
//
//                case "1":
//                    System.out.println("Filter by:\n(1) Title\n(2) Id\n");
//                    int filterOption = scanner.nextInt();
//                    scanner.nextLine();
//                    while (true) {
//                        Media foundMedia = null;
//                        if (filterOption == 1) {
//                            System.out.print("Enter the title of the media to filter (press 0 to stop): ");
//                            String title = scanner.nextLine();
//                            if (title.equals("0")) break;
//                            foundMedia = cart.searchByTitle(title);
//                        } else if (filterOption == 2) {
//                            System.out.print("Enter the ID of the media to filter (press 0 to stop): ");
//                            int id = scanner.nextInt();
//                            if (id == 0) break;
//                            foundMedia = cart.searchById(id);
//                        } else {
//                            clc();
//                            System.out.println("Invalid Input.");
//                        }
//
//                        if (foundMedia == null) {
//                            clc();
//                            System.out.println("There is no matched items in your cart.");
//                        } else {
//                            clc();
//                            if (filterOption == 1) System.out.println("Result: " + foundMedia.toString());
//                            else if (filterOption == 2) System.out.println("Result: " + foundMedia.toString());
//                        }
//                    }
//                    break;
//
//                case "2":
//                    System.out.println("Sort medias in cart by:\n (1) title \n (2) cost");
//                    int sortOption = scanner.nextInt();
//                    scanner.nextLine();
//                    if (sortOption == 1) cart.sortByTitle();
//                    else if (sortOption == 2) cart.sortByCost();
//                    else System.out.println("Invalid option.");
//                    break;
//
//                case "3":
//                    while (true) {
//                        System.out.print("Enter the title of the media to remove from cart (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = cart.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the cart. Please try another.");
//                        else {
//                            cart.removeMedia(foundMedia);
//                            System.out.println(title + " has been successfully removed from the cart.");
//                            System.out.println("Current cart: ");
//                            cart.printCart();
//                        }
//                    }
//                    break;
//
//                case "4":
//                    while (true) {
//                        System.out.print("Enter the title of the media to play (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = cart.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the cart. Please try another.");
//                        else {
//                            if (foundMedia instanceof CompactDisc) {
//                                CompactDisc mediaCD = (CompactDisc) foundMedia;
//                                clc();
//                                mediaCD.play();
//                            } else if (foundMedia instanceof DigitalVideoDisc) {
//                                DigitalVideoDisc mediaDVD = (DigitalVideoDisc) foundMedia;
//                                clc();
//                                mediaDVD.play();
//                            } else System.out.println(foundMedia.getTitle() + " cannot be played! Please try another.");
//                        }
//                    }
//                    break;
//
//                case "5":
//                    clc();
//                    System.out.println("The order has successfully created.\nYour cart is now empty.");
//                    cart.empty();
//                    break;
//
//                default:
//                    System.out.println("Invalid option. Please choose a number: 0-1-2-3-4-5.");
//                    break;
//            }
//        }
//    }
//
//    public static void updateStore() {
//        Scanner scanner = new Scanner(System.in);
//
//        boolean back = false;
//        while (!back) {
//            System.out.println("Options: ");
//            System.out.println("--------------------------------");
//            System.out.println("1. Add a media");
//            System.out.println("2. Remove a media");
//            System.out.println("0. Back");
//            System.out.println("--------------------------------");
//            System.out.println("Please choose a number: 0-1-2");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    clc();
//                    back = true;
//                    break;
//
//                case "1":
//                    boolean back1 = false;
//                    while (!back1) {
//                        System.out.println("Enter the category of the media:\n(1) Book\n(2) CD\n(3) DVD\n(0) Back");
//                        String choice = scanner.nextLine();
//                        switch (choice) {
//                            case "0":
//                                clc();
//                                back1 = true;
//                                break;
//
//                            case "1":
//                                System.out.println("Enter the title of the book: ");
//                                String bookTitle = scanner.nextLine();
//                                System.out.println("Enter the category of the book: ");
//                                String bookCategory = scanner.nextLine();
//                                System.out.println("Enter the cost of the book: ");
//                                float bookCost = scanner.nextFloat();
//                                scanner.nextLine();
//
//                                Book book = new Book(bookTitle, bookCategory, bookCost);
//                                System.out.println("Enter the (List of) author(s) of the book (Press 0 to stop): ");
//                                while (true) {
//                                    String bookAuthor = scanner.nextLine();
//                                    if (bookAuthor.equals("0")) break;
//                                    book.addAuthor(bookAuthor);
//                                }
//                                store.addMedia(book);
//                                System.out.println("\nCurrent store: ");
//                                store.printStore();
//                                System.out.println();
//                                break;
//
//                            case "2":
//                                clc();
//                                System.out.println("Enter the title of the CD: ");
//                                String cdTitle = scanner.nextLine();
//                                System.out.println("Enter the category of the CD: ");
//                                String cdCategory = scanner.nextLine();
//                                System.out.println("Enter the artist of the CD: ");
//                                String cdArtist = scanner.nextLine();
//                                System.out.println("Enter the cost of the CD: ");
//                                float cdCost = scanner.nextFloat();
//                                scanner.nextLine();
//
//                                CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);
//                                System.out.println("Do you want to add tracks to your CD?\n (1) Yes (0) No:");
//                                int addTrack = scanner.nextInt();
//                                scanner.nextLine();
//
//                                if (addTrack == 1) {
//                                    System.out.println("Enter the number of tracks: ");
//                                    int numTracks = scanner.nextInt();
//                                    scanner.nextLine();
//                                    for (int i = 0; i < numTracks; i++) {
//                                        System.out.println("Enter the title of track " + (i + 1) + ": ");
//                                        String trackTitle = scanner.nextLine();
//                                        System.out.println("Enter the length of track " + (i + 1) + ": ");
//                                        int trackLength = scanner.nextInt();
//                                        scanner.nextLine();
//                                        cd.addTrack(new Track(trackTitle, trackLength));
//                                    }
//                                    store.addMedia(cd);
//                                } else if (addTrack == 0) store.addMedia(cd);
//                                System.out.println("\nCurrent store: ");
//                                store.printStore();
//                                System.out.println();
//                                break;
//
//                            case "3":
//                                clc();
//                                System.out.println("Enter the title of the DVD: ");
//                                String dvdTitle = scanner.nextLine();
//                                System.out.println("Enter the category of the DVD: ");
//                                String dvdCategory = scanner.nextLine();
//                                System.out.println("Enter the director of the DVD: ");
//                                String dvdDirector = scanner.nextLine();
//                                System.out.println("Enter the length (second) of the DVD: ");
//                                int dvdLength = scanner.nextInt();
//                                System.out.println("Enter the cost of the DVD: ");
//                                float dvdCost = scanner.nextFloat();
//                                scanner.nextLine();
//
//                                DigitalVideoDisc dvd = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
//                                store.addMedia(dvd);
//                                System.out.println("\nCurrent store: ");
//                                store.printStore();
//                                System.out.println();
//                                break;
//
//                            default:
//                                clc();
//                                System.out.println("Invalid option. Please choose a number: 0-1-2.");
//                                break;
//                        }
//                    }
//                    break;
//
//                case "2":
//                    clc();
//                    while (true) {
//                        System.out.print("Enter the title of the media to remove from store (Press 0 to return): ");
//                        String title = scanner.nextLine();
//                        if (title.equals("0")) break;
//                        Media foundMedia = store.searchByTitle(title);
//                        if (foundMedia == null) System.out.println(title + " is not in the store. Please try another.");
//                        else {
//                            store.removeMedia(foundMedia);
//                            System.out.println(title + " has been successfully removed from the store.");
//                            System.out.println("\nCurrent store: ");
//                            store.printStore();
//                            System.out.println();
//                        }
//                    }
//                    break;
//
//                default:
//                    clc();
//                    System.out.println("Invalid option. Please choose a number: 0-1-2.");
//                    break;
//            }
//        }
//    }
//}
