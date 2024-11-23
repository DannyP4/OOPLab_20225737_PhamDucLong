import java.util.Scanner;

public class DayinMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] Calendar = {{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"},
                {"Jan.", "Feb.","Mar.","Apr.","May","June","July","Aug.","Sep.","Oct.","Nov.","Dec."},
                {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct","Nov","Dec"},
                {"1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12"},
                {"31","28","31","30","31","30","31","31","30","31","30","31"},
                {"31","29","31","30","31","30","31","31","30","31","30","31"}};

        System.out.print("Nhap thang: ");
        String month = scanner.next();
        System.out.print("Nhap nam: ");
        int year = scanner.nextInt();

        boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        boolean check = false;

        String day = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 12; ++j) {
                if (Calendar[i][j].equals(month)) {
                    day = isLeapYear ? Calendar[5][j] : Calendar[4][j];
                    if (year > 0 && year < 9999) check = true;
                    break;
                }
            }
        }
        if (check)
            System.out.println("So ngay trong thang la: " + day + " ngay");
        else
            System.out.println("Sai dinh dang!");
    }
}
