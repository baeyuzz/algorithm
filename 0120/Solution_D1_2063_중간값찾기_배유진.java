
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기_배유진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mid = n / 2;

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		insertionSort(arr, n);

		System.out.println(arr[mid]);

	}

	private static void insertionSort(int[] input, int length) {
		int tmp;
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j - 1] > input[j]) {
					tmp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = tmp;
				}
			}
		}
	}
}
