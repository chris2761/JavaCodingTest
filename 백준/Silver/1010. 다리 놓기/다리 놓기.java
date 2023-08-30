import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, dp[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			dp = new int[N + 1][M + 1];

			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j <= Math.min(M, i); j++) {
					if (j == 0 || j == i) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
					}
				}
			}

			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);
	}
}
