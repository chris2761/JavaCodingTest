package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, N, companyX, companyY, houseX, houseY, result;
	static int[] clientX, clientY, visited;

	public static void main(String[] args) throws IOException {
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			result = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 고객의 수
			clientX = new int[N];
			clientY = new int[N];

			st = new StringTokenizer(br.readLine());
			// 회사좌표
			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());

			// 집 좌표
			houseX = Integer.parseInt(st.nextToken());
			houseY = Integer.parseInt(st.nextToken());

			// 고객 좌표
			for (int i = 0; i < N; i++) {
				clientX[i] = Integer.parseInt(st.nextToken());
				clientY[i] = Integer.parseInt(st.nextToken());
			}

			visited = new int[N];
			dfs(companyX, companyY, 0, 0);
			sb.append("#").append(tc+1).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);

	}

	public static void dfs(int currX, int currY, int dis, int route) {
		if (route == N) {
			int finalDis = dis + Math.abs(currX - houseX) + Math.abs(currY - houseY);
			if (finalDis < result)
				result = finalDis;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				int nextX = clientX[i];
				int nextY = clientY[i];
				dfs(nextX, nextY, dis + Math.abs(currX - nextX) + Math.abs(currY - nextY), route + 1);
				visited[i] = 0;
			}

		}

	}

}
