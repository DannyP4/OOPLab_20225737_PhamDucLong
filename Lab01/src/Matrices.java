import java.util.Scanner;

public class Matrices {
    public static void main(String[] args){
        System.out.print("Nhap so hang va cot cua ma tran mot: ");
        int r1, c1;
        Scanner scanner = new Scanner(System.in);
        r1 = scanner.nextInt();
        c1 = scanner.nextInt();

        System.out.println("\nNhap ma tran mot: ");
        int[][] a1 = new int[r1][c1];
        for (int i = 0; i < r1; ++i) {
            for (int j = 0; j < c1; ++j)
                a1[i][j] = scanner.nextInt();
        }

        System.out.print("\nNhap so hang va cot cua ma tran hai: ");
        int r2, c2;
        r2 = scanner.nextInt();
        c2 = scanner.nextInt();
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nNhap ma tran hai: ");
            for (int i = 0; i < r1; ++i) {
                for (int j = 0; j < c1; ++j) {
                    int v = scanner.nextInt();
                    a1[i][j] += v;
                }
            }

            System.out.println("\nTong cua hai ma tran la ma tran: ");
            for (int i = 0; i < r1; ++i) {
                for (int j = 0; j < c1; ++j)
                    System.out.print(a1[i][j] + " ");

                System.out.println();
            }
        }
        else
            System.out.println("Hai ma tran khong co cung kich thuoc!");
    }

}