import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int dp[] = new int[N + 1];
		Arrays.fill(dp, N + 1);
		
		dp[1] = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i * 2 <= N)
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			if (i * 3 <= N)
				dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			if (i + 1 <= N)
				dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
		}

		System.out.println(dp[N]);
	}
}
