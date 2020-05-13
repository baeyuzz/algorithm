package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	static int n, m, comp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 사람수
		m = Integer.parseInt(st.nextToken()); // 비교횟수

		Queue<Integer> [] list = new LinkedList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		int x[] = new int [n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			list[first].add(second); // 1번 리스트에 2번 들어갔다는 정보
			x[second]++; // 얘는 앞에 누구 있음
			
		}

		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i <n+1; i++) {
			if(x[i] == 0) { // 내 앞에 아무도 없음
				q.add(i);
			}
		}
		
		q.poll()
		;
		
		while(!q.isEmpty()) {
			System.out.print(q.peek() + " ");
			int front = q.poll();
			
			for (int i = 0; i < list[front].size(); i++) {
				int tmp = list[front].poll();
				x[tmp]--;
				if(x[tmp] == 0) {
					q.add(tmp);
//					System.out.println(tmp);
				}
				
			}
		}
		
		
		
	}
}
