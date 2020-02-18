import java.util.Scanner;

public class Solution_7576_토마토_배유진 {

	static int n, m, map[][], cnt;
	static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0) {
					visited[i][j] = true;
				}

			}
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j] + "   ");
//
//			}
//			System.out.println();
//		}

		boolean check = false;
		L: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				check = dfs();
				if (check)
					break L;
			}

		}
		System.out.println(cnt);

	}

	private static boolean dfs() {
		boolean check = false;
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					tmp++;
			}
		}
		if (tmp == n * m) {
			return true;
		}

		int two = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j]) {
					two = 0;
					for (int d = 0; d < 4; d++) {
						int x = i + dx[d];
						int y = j + dy[d];
						if (x < 0 || y < 0 || x >= n || y >= m) {
							two++;
						} else {
							if (map[x][y] == 0 && !visited[x][y]) {
								map[x][y] = 1;
								check = true;
								// visited[x][y] = true;
							}
							if (map[x][y] == -1) {
								two++;
							}

						}
						x -= dx[d];
						y -= dy[d];
					}

					if (two == 4) {
						cnt = -1;
						return true;

					}

				}
			}
		}
		if (check)
			cnt++;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					visited[i][j] = true;
			}
		}

		return false;
	}

}