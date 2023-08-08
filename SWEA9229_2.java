package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] snacks;
	static int maxWeight;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int t = 0; t < tc; t++) {
			maxWeight = -1;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				int curr = snacks[i];
				for (int j = i + 1; j < N; j++) {
					int next = curr + snacks[j];
					if (next <= M && next> maxWeight ) {
						maxWeight = next;
					}
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(maxWeight).append("\n");

		}

		System.out.println(sb);

	}

}
