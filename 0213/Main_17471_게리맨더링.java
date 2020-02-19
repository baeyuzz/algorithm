import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.StringTokenizer;

 

public class Main_17471_게리맨더링 {

	static int map[][], population[];

	static ArrayList<Integer> pick = new ArrayList<Integer>();

	static ArrayList<Integer> notpick = new ArrayList<Integer>();

	static boolean visited[];

	static int p, min = 1000;

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

 

//			for (int i = 0; i < pick.size(); i++) {

//				System.out.print(pick.get(i));

//			}

//			System.out.println();

//

//			for (int i = 0; i < notpick.size(); i++) {

//				System.out.print(notpick.get(i));

//			}

//			System.out.println();

//			System.out.println();

//			

 

		}

		System.out.println(min);

	}

 

	private static void comb(int n, int r, int idx) {

		if (r == 0) {

			pick = new ArrayList<Integer>();

			notpick = new ArrayList<Integer>();

 

			for (int i = 1; i <= p; i++) {

				if (visited[i]) {

					pick.add(i);

 

				}

				if (!visited[i]) {

					notpick.add(i);

//					if(!check()) {

//						return;

//					}

				}

			}

			if (!check()) {

				return;

			}

 

			for (int i = 0; i < pick.size(); i++) {

				System.out.print(pick.get(i));

			}

			System.out.println();

 

			for (int i = 0; i < notpick.size(); i++) {

				System.out.print(notpick.get(i));

			}

			System.out.println();

			System.out.println();

//			

 

			int sum1 = 0, sum2 = 0;

			for (int i = 0; i <= pick.size(); i++) {

				sum1 += population[pick.get(i)];

				System.out.println("pop : " +population[pick.get(i)]);

				pick.remove(i);

			}

 

			sum2 = sum - sum1;

			

			System.out.println(sum1 + " " + sum2);

 

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

		for (int i = 0; i < pick.size(); i++) {

			int cnt = 0;

 

			for (int j = 0; j < pick.size(); j++) {

				if (map[pick.get(i)][pick.get(j)] == 1) {

					cnt++;

				}

			}

 

			if (cnt == 0)

				return false;

 

		}

		for (int i = 0; i < notpick.size(); i++) {

			int cnt = 0;

 

			for (int j = 0; j < notpick.size(); j++) {

				if (map[notpick.get(i)][notpick.get(j)] == 1) {

					cnt++;

				}

			}

 

			if (cnt == 0)

				return false;

 

		}

 

		return true;

	}

}