import java.util.Scanner;

public class Triangle {
    public static void main(String[] args){
        System.out.print("Enter n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; ++i){
            for (int k = 0; k < n - i - 1; ++k){
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; ++j){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        scanner.close();
    }
}