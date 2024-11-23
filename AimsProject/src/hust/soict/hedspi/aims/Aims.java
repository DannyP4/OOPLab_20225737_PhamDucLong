package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
        anOrder.addDigitalVideoDisc(dvdList);

//        anOrder.removeDigitalVideoDisc(dvd2);

//        System.out.println("Total cost is: ");
//        System.out.print(anOrder.totalCost());

        System.out.println("The id of " + dvd1.getTitle() + " is " + dvd1.getId());
        System.out.println("The id of " + dvd2.getTitle() + " is " + dvd2.getId());
        System.out.println("The id of " + dvd3.getTitle() + " is " + dvd3.getId());
    }
}
