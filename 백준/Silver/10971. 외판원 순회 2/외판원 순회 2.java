import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, board[][];
	static long minCost = Long.MAX_VALUE;
	private static int[] visited;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		board = new int[N + 1][N + 1];
		visited = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N+1; i++) {
			visited[i] = 1;
			dfs(i, 0, 1, i);
			visited[i] = 0;
		}

		if (minCost == Long.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(minCost);
	}

	private static void dfs(int ind, int cost, int cnt, int start) {
		if (cnt == N) {
			if( board[ind][start] > 0) {
				if (cost + board[ind][start] < minCost) {
					minCost = cost + board[ind][start];
				}
			}
			return;
		}

		if (cost > minCost)
			return;

		for (int i = 2; i < N + 1; i++) {
			if (visited[i] == 0 && board[ind][i] > 0) {
				visited[i] = 1;
				dfs(i, cost + board[ind][i], cnt + 1, start);
				visited[i] = 0;
			}
		}
	}
}
