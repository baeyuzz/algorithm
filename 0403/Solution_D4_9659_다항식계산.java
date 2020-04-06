package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9659_다항식계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int d = 998244353;

		StringBuilder sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");

			int n = Integer.parseInt(br.readLine());

			int tab[][] = new int[n - 1][3];

			StringTokenizer st;

			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tab[i][0] = Integer.parseInt(st.nextToken());
				tab[i][1] = Integer.parseInt(st.nextToken());
				tab[i][2] = Integer.parseInt(st.nextToken());
			}

			int m = Integer.parseInt(br.readLine());
			int x[] = new int[m];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < m; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			// input

			
			long f[] = new long[n + 1];

			f[0] = 1;

			for (int i = 0; i < m; i++) {
				f[1] = x[i]  % d;

				for (int j = 0; j < n - 1; j++) {
					if (tab[j][0] == 1) {
						f[j + 2] = (f[tab[j][1]] + f[tab[j][2]]) % d;
					} else if (tab[j][0] == 2) {
						f[j + 2] = (tab[j][1] * f[tab[j][2]]) % d;
					} else if (tab[j][0] == 3) {
						f[j + 2] = (f[tab[j][1]] * f[tab[j][2]]) % d;
					}
				}
				sb.append(f[n] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
