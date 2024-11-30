package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args){
        //TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle DVD title: "+ jungleDVD.getTitle());
        System.out.println("cinderella DVD title: "+cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.err.println("jungle DVD title: "+jungleDVD.getTitle());
    }

//    public static void swap(Object o1, Object o2){
//        Object temp = o1;
//        o1=o2;
//        o2=temp;
//    }

    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
        String tmp1 = o1.getTitle();
        String tmp2 = o2.getTitle();
        o1.setTitle(tmp2);
        o2.setTitle(tmp1);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle(); // Lấy tiêu đề cũ của dvd
        dvd.setTitle(title); // Thay đổi tiêu đề của đối tượng dvd bằng setter
        dvd = new DigitalVideoDisc(oldTitle); // Thay đổi tham chiếu của đối tượng dvd (không ảnh hưởng đến đối tượng ban đầu)
    }
}