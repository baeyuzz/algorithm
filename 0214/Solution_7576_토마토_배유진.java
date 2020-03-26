package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7576_토마토_배유진 {
	static int n, m, map[][], cnt, day = 1;
	static boolean visited[][];
	static boolean endcheck = false;
	static Queue<Point> q = new LinkedList<Point>();
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < m; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				if (map[x][y] == -1) {
					visited[x][y] = true;
				}
			}
		}

		// input
/////////////////////////////////////////////////////
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
/////////////////////////////////////////////////////

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if (map[x][y] == 1) {
					q.add(new Point(x, y));
					visited[x][y] = true;
				}
			}
		}

		bfs();
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//

		L: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					day = 1;
					break L;
				}
			}

		}
		System.out.println(day - 2);

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();

			day++;

			for (int i = 0; i < size; i++) {
				Point front = q.poll();
				int fx = front.x;
				int fy = front.y;

				for (int d = 0; d < 4; d++) {
					fx += dx[d];
					fy += dy[d];

					if (fx < n && fx >= 0 && fy < m && fy >= 0 && !visited[fx][fy]) {
						visited[fx][fy] = true;
						map[fx][fy] = day;
						q.add(new Point(fx, fy));
					}

					fx -= dx[d];
					fy -= dy[d];

				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
