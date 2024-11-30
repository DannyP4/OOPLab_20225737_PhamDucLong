package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.Scanner;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Media dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        Media dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
//
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
//                "Animation", 18.99f);
//        cart.addDigitalVideoDisc(dvd3);

        cart.printCart();

//        System.out.println("Enter the title of DVD you want to search: ");
//        Scanner sc = new Scanner(System.in);
//        int idForSearch = sc.nextInt();
//        Scanner sc = new Scanner(System.in);
//        String titleForSearch = sc.nextLine();
//
//        if(cart.search(titleForSearch))
//            System.out.println("Found DVD with title " + titleForSearch + " and the id of this DVD is " + cart.getDiscId(titleForSearch));
//        else
//            System.out.println("Not found DVD with title " + titleForSearch);

    }
}
