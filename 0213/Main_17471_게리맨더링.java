import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {

	static int map[][], population[];

	static ArrayList<Integer> pick = new ArrayList<Integer>();

	static ArrayList<Integer> notpick = new ArrayList<Integer>();

	static boolean visited[], connected[];

	static int p, min = 999999;

	static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		p = Integer.parseInt(in.readLine());

		population = new int[p + 1];

		map = new int[p + 1][p + 1];

		visited = new boolean[p + 1];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		for (int i = 1; i <= p; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum += population[i];
		}

		for (int i = 1; i <= p; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= num; j++) {
				map[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		// 인접행렬 만듦

		for (int r = 1; r <= p / 2; r++) {
			comb(p, r, 1);
		}

		if (min == 999999)
			min = -1;
		System.out.println(min);
	}

	private static void comb(int n, int r, int idx) {

		if (r == 0) {
			pick = new ArrayList<Integer>();
			notpick = new ArrayList<Integer>();

			for (int i = 1; i <= p; i++) {
				if (visited[i]) {
					pick.add(i);
				} else {
					notpick.add(i);
				}
			}
//////////////////////////////
//System.out.println("==========unchecked===========");
//for (int i = 0; i < pick.size(); i++) {
//System.out.print(pick.get(i));
//}
//System.out.println();
//for (int i = 0; i < notpick.size(); i++) {
//System.out.print(notpick.get(i));
//}
//System.out.println();
//System.out.println("==========================");

//////////////////////////////////
		
			if (!check()) {
				return;
			}

//////////////////////////////
//			System.out.println("==========check===========");
//			for (int i = 0; i < pick.size(); i++) {
//				System.out.print(pick.get(i));
//			}
//			System.out.println();
//			for (int i = 0; i < notpick.size(); i++) {
//				System.out.print(notpick.get(i));
//			}
//			System.out.println();
//			System.out.println("==========================");

//////////////////////////////////

			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < pick.size(); i++) {
				sum1 += population[pick.get(i)];
			}

			sum2 = sum - sum1;

			int diff = 0;

			if (sum2 > sum1) {
				diff = sum2 - sum1;
			} else {
				diff = sum1 - sum2;
			}

			if (min >= diff) {
				min = diff;
			}
			return;
		}

		if (idx == p) {
			return;
		}

		visited[idx] = true;
		comb(p - 1, r - 1, idx + 1);
		visited[idx] = false;
		comb(p - 1, r, idx + 1);
	}

	private static boolean check() {

		int cnt = 0;

		connected = new boolean[p + 1];
		connected[pick.get(0)] = true;
		dfs(pick.get(0), pick); // 1부터 돌면서

////////////////////////////////////////
//		System.out.print("pick - ");
//		for (int i = 1; i <= p; i++) {
//			System.out.print(connected[i] + "\t");
//		}
//		System.out.println();
//////////////////////////////////////

		for (int i = 1; i <= p; i++) {
			for (int j = 0; j < pick.size(); j++) {
				if (connected[i] && i == pick.get(j)) {
					cnt++;
				}
			}
		}

		if (cnt != pick.size()) {
			return false;
		}

////////////////////////////////////////////////////////////////////////////////
		
		cnt = 0;

		connected = new boolean[p + 1];
		connected[notpick.get(0)] = true;
		dfs(notpick.get(0), notpick); // 1부터 돌면서

//////////////////////////////////////
//		System.out.print("not - ");
//		for (int i = 1; i <= p; i++) {
//			System.out.print(connected[i] + "\t");
//		}
//		System.out.println();
//		System.out.println();
///////////////////////////////////////

		for (int i = 1; i <= p; i++) {
			for (int j = 0; j < notpick.size(); j++) {
				if (connected[i] && i == notpick.get(j)) {
					cnt++;
				}
			}
		}

		if (cnt == notpick.size()) {
			return true;
		}

		return false;
	}

	private static void dfs(int i, ArrayList<Integer> arr) {
		for (int j = 1; j <= p; j++) {
			for (int k = 0; k < arr.size(); k++) {
				if (map[i][j] == 1 && arr.get(k) == j && !connected[j]) {
					connected[j] = true;
					dfs(arr.get(k), arr);

				}
			}

		}
	}
}