import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, board[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		board = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dp[][][] = new int[N + 1][N + 1][3];

		// 0은 가로 1은 세로 대각선은 2
		dp[1][2][0] = 1;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if ((i == 1 && j == 2) || board[i][j] == 1)
					continue;
				if (board[i - 1][j] != 1)
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
				if (board[i][j - 1] != 1)
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				if (board[i - 1][j - 1] != 1 && board[i - 1][j] == 0 && board[i][j - 1] == 0)
					dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}

		int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		
		System.out.println(result);

	}
}
