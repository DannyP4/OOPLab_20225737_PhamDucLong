import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = scanner.nextInt();

        System.out.print("Mang sap xep tang dan: ");
        incSort(arr);
        System.out.print("\nMang sap xep giam dan: ");
        desSort(arr);
    }

    public static void incSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void desSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}
