import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_5432_쇠막대기자르기_배유진 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		String line = new String();

		for (int test = 0; test < t; test++) {
			Stack<Character> st = new Stack<Character>();

			int total = 0;
			line = sc.next();

			char c1, c2;

			int size = line.length();

			for (int i = 0; i < size; i++) {
				if (i < size - 1) {
					c1 = line.charAt(i);
					c2 = line.charAt(i + 1);
				} else {
					c1 = line.charAt(i - 1);
					c2 = ')';
				}

				if (c1 == '(' && c2 == ')') { // 바로 끝남
					total += st.size();
						} else if (c1 == '(' && c2 == '(') {
					st.push(c1);
					total ++;
				} else if (c1 == ')' && c2 == ')') {
					if (!st.isEmpty()) {
						st.pop();
					}
				}
			}

			System.out.println("#"+(test+1)+" " + total);
		}

	}
}
