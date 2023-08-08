package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak16929 {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static int N, M, R, to, from;
	static int[][] arr, arr2;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < R; k++) {
			arr2 = new int[N][M]; // 매번 새로운 빈 배열

			from = M - 1;
			to = 1;
			for (int i = 0; i <= N / 2; i++) {
				for (int j = to; j <= from; j++) {
					arr2[i][j - 1] = arr[i][j];
				}
				to++;
				from--;
			}

			// 아래로 이동
			from = 0;
			to = N - 2;
			for (int j = 0; j <= M / 2; j++) {
				for (int i = from; i <= to; i++) {
					arr2[i + 1][j] = arr[i][j];
				}
				to--;
				from++;
			}

			// 오른쪽으로 이동
			from = 0;
			to = M - 2;
			for (int i = N - 1; i >= N / 2; i--) {
				for (int j = from; j <= to; j++) {
					arr2[i][j + 1] = arr[i][j];
				}
				to--;
				from++;
			}

			// 위로 이동
			from = N - 1;
			to = 1;
			for (int j = M - 1; j >= M / 2; j--) {
				for (int i = to; i <= from; i++) {
					arr2[i - 1][j] = arr[i][j];
				}
				to++;
				from--;
			}

			arr = arr2;

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr2[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}