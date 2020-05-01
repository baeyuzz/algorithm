package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이 {
	static int two, three, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int test = 0; test < t; test++) {
			char[] s2 = br.readLine().toCharArray();
			char[] s3 = br.readLine().toCharArray();

			for (int i = 0; i < s2.length; i++) {
				char original = s2[i];
				s2[i] = '0';
				String s = toString(s2);
				int i2 = Integer.parseInt(s, 2);
				res = compare23(i2, s3);
				if (res != -1) {
					break;
				}

				s2[i] = '1';
				s = toString(s2);
				i2 = Integer.parseInt(s, 2);
				res = compare23(i2, s3);
				if (res != -1) {
					break;
				}

				s2[i] = original;

			}
			System.out.println("#" + (test + 1) + " " + res);
		}

	}

	private static String toString(char[] s2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s2.length; i++) {
			sb.append(s2[i]);
		}
		return sb.toString().trim();
	}

	private static int compare23(int i2, char[] s3) {
		for (int j = 0; j < s3.length; j++) {
			char original = s3[j];
			s3[j] = '0';
			String s = toString(s3);
			int i3 = Integer.parseInt(s, 3);
			if (i2 == i3)
				return i2;

			s3[j] = '1';
			s = toString(s3);
			i3 = Integer.parseInt(s, 3);
			if (i2 == i3)
				return i2;

			s3[j] = '2';
			s = toString(s3);
			i3 = Integer.parseInt(s, 3);
			if (i2 == i3)
				return i2;

			s3[j] = original;
		}
		return -1;

	}
}