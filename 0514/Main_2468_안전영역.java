import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int map[][], max = 1, n;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		StringTokenizer st;
		int highest = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if (tmp > highest) {
					highest = tmp;
				}
			}
		}

		if (highest > 100) {
			highest = 100;
		}
		for (int h = highest - 1; h >= 1; h--) {
			int cnt = 0;
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (map[x][y] > h) {
//						System.out.println("x y : " + x + " " + y);
						map[x][y] = h;
						cnt++;
						dfs(x, y, h);
					}
				}
			}

//			System.out.println("h : " + h + "cnt : " + cnt);
			if (cnt > max) {
				max = cnt;
			}
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y, int h) {
		for (int d = 0; d < 4; d++) {
			int tx = x + dx[d];
			int ty = y + dy[d];
			if (tx < n && ty < n && tx >= 0 && ty >= 0 && map[tx][ty] > h) {
//				System.out.println("tx ty : " + tx + " " + ty);
				map[tx][ty] = h;
				dfs(tx, ty, h);
			}
		}
	}
}
