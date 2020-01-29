package com.ssafy.step1.pretest;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1_배유진 {

	static int[][] ladder = new int[100][100];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int k = 0; k < 10; k++) {
			sc.nextInt(); // test case
			int y = 0;

			boolean visited[][] = new boolean[100][100];

			for (int i = 0; i < 100; i++)
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt(); // 사다리 입력 받음
				}

			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					y = i;
				}
			}

			int depth = 99;

			while (true) {
				if ((y - 1) >= 0 && ladder[depth][y - 1] == 1 && visited[depth][y - 1] == false) { // 왼쪽을 이동
					visited[depth][y - 1] = true;
					y--;
				} else if ((y + 1) < 100 && ladder[depth][y + 1] == 1 && visited[depth][y + 1] == false) { // 오른쪽으로 이동
					visited[depth][y + 1] = true;
					y++;
				} else if (visited[depth - 1][y] == false) {
					visited[depth - 1][y] = true;
					depth--;
				}

				if (depth == 0)
					break;
			}

			System.out.println("#" + (k + 1) + " " + y);
			// find(y, 99);
		}

	}
}