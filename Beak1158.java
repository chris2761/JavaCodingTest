package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak1158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, K;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb.append("<");

		N = Integer.parseInt(st.nextToken()); // 7
		K = Integer.parseInt(st.nextToken()); // 3
		int[] arr = new int[N];
		int[] visited = new int[N];
		int cnt = 0;

		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		int ind = 0;
		while (cnt < N) {
			int num = 0;
			while (num < K-1) {
				if(ind==N) ind = 0;
				if(visited[ind++]==0) {
					++num;
				}
				
				if(ind==N) ind = 0;
				if(num==K-1&&visited[ind]==1) {
					while(true) {
						if(ind==N) ind = 0;
						if(visited[ind]==0) break;
						else ind++;
					}
				};
			}
			sb.append(arr[ind]).append(", ");
			visited[ind] = 1;
			++ind;
			++cnt;
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}
