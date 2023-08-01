package prac;

import java.io.*;
import java.util.*;

public class NM0801 {

	static StringBuilder sb = new StringBuilder();

	static void func(int n, int m, String now, int[] visited) {
		if (now.length() == m+(m-1)) {
			sb.append(now+"\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				func(n, m, now + " " + i, visited);
				visited[i] = 0;
			}
		}
	}

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 1~n까지
		int m = Integer.parseInt(st.nextToken()); // m개

		int[] visited = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			visited[i] = 1;
			func(n, m, ""+ i, visited);
			visited[i] = 0;
		}

		System.out.println(sb);

	}
}
