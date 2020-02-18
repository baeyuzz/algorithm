import java.util.Scanner;

public class Solution_D3_1244_최대상금_배유진 {

	static int num[], changetmp, change, max, len, test;

	public static void main(String[] args) {
		
		/*
		 * 조합을 이용하기
		 * prunning을 이용해서..prunning[cur][chance] = true;...??????
		 * 한 숫자에 대해 6c2 -> 최대 15번  swapping
		 * 15번의 10승(최대 10번 교환) -> 시간 터짐
		 * swapping이 됐을 때 전에 수조합과 같을 수 있음 -> 다시 dfs하지 않음
		 * 하지만 남아있는 횟수가 다르면 후에 결과가 달라질 수 있기 때문에 dfs를 함
		 * */

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (test = 0; test < t; test++) {
			int maxi = 0;
			boolean check = false;

			changetmp = 0;

			String tmp1 = sc.next();
			String tmp2[] = tmp1.split("");

			num = new int[tmp1.length()];

			for (int i = 0; i < tmp2.length; i++) {
				num[i] = Integer.parseInt(tmp2[i]);

			}

			change = sc.nextInt();

			// 여기까지 입력

			
			
			len = num.length;

			for (int i = 0; i < len; i++) {

				check = maxcheck();

				if (check) {
					break; // 결과 출력 됐으니까 다음 테케로 넘어가기
				}

				
				// 숫자 여러개 중복일 때 제일 작은 거랑 바꾸는 거
				min();
				if (changetmp == change) {
					resprint();
					check = true;
					break;
				}
				
				
				// 제일 큰거 앞으로 당기기
				for (int j = i; j < len; j++) {
					if (num[j] >= max) {
						max = num[j];
						maxi = j;
					}
				}
				if (i != maxi)
					swap(i, maxi);
				else {
					max = 0;
				}

				if (changetmp == change) {
					resprint();
					check = true;
					break;
				}

			}
			System.out.println();
		}
	}

	private static boolean maxcheck() {

		for (int i = 0; i < len - 1; i++) {
			if (num[i] >= num[i + 1] && changetmp != change) {

			} else {
				return false;
			}

		}

		if (change == 1) {
			swap(len - 1, len - 2);
			resprint();
			return true;
		}

		while (true) {
			// 최대 일 때,,,
			if (num[0] == num[1]) {
				swap(0, 1);
			} else {
				swap(len - 1, len - 2);
			}
			if (changetmp == change) {
				resprint();
				return true;

			}
		}

	}

	private static void min() {
		int tmpmax = 0, cnt = 0, mi1 = 0;
		for (int i = 0; i < len; i++) {

			if (num[i] >= tmpmax) {
				tmpmax = num[i];
				mi1 = i;
			}
		}

		for (int i = 0; i < len; i++) {
			if (tmpmax == num[i]) {
				cnt++;
			}
		}
		int m1 = 9, m2 = 9, mi2 = 0;
		if (cnt > 1) {
			for (int i = 0; i < cnt; i++) {
				if (m1 >= num[i]) {
					m1 = num[i];
					mi2 = i;
				}
			}

			for (int i = 0; i < len; i++) {
				if (m2 >= num[i])
					m2 = num[i];
			}
			if (m1 == m2) {
				swap(mi1, mi2);

			}
		}
	}

	private static void swap(int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
		changetmp++;
		max = 0;
	}
	

	private static void resprint() {
		System.out.print("#" + (test + 1) + " ");
		for (int j = 0; j < len; j++) {
			System.out.print(+num[j]);

		}
	}
}
