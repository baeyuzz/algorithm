import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기_배유진 {
	static int n, res[];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test = 0; test < 10; test++) {

			int t = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				n = sc.nextInt();
				q.offer(n);

			}
			int cnt = 1;
			while (true) {
				int tmp = q.poll();

				tmp -= cnt;
				cnt++;

				if (cnt == 6) {
					cnt = 1;
				}

				if (tmp <= 0) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
			}

			int s = q.size();
System.out.print("#" + (test+1) + " ");
			for (int i = 0; i < s; i++)
				System.out.print(q.poll() + " ");
			System.out.println();
		}
	}
}
