import java.util.Scanner;

public class Solution_BabyGin_배유진 {

	static int n[], res[];
	static boolean selected[], baby;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		res = new int[6];
		n = new int[6];
		selected = new boolean[6];

		for (int i = 0; i < 6; i++)
			n[i] = sc.nextInt();

		per(0);
		if (baby == true)
			System.out.println("baby gin");
	}

	private static void per(int index) {
		if (index == 6) { // perm comp.
			
			for(int i = 0;i<6;i++) {
				System.out.print(res[i]);
			}
			System.out.println();
			check(); // babygin인지 check
			return;
		}
		for (int i = 0; i < n.length; i++) { // 1~n까지.?...뽑는거
			if (selected[i])
				continue; // 뽑힌 건 다시 안 뽑음

			res[index] = n[i];
			selected[i] = true;

			per(index + 1);
			selected[i] = false;

		}
	}

	private static void check() {
		int gc = 0, cc = 0;

		if ((res[0] == res[1] && res[1] == res[2]))
			gc++;

		if (res[4] == res[3] && res[5] == res[4])
			gc++;

		if (res[0] + 1 == res[1] && res[1] + 1 == res[2])
			cc++;

		if ((res[3] + 1) == res[4] && (res[4] + 1) == res[5])
			cc++;

		if (gc + cc == 2) {
			baby = true;
		}
	}
}
