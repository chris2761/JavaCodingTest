package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoJ1074 {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N, r, c, cnt;
	static int[][] minArr = { { 0, 1 }, { 2, 3 } };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken()); // 2
		r = Integer.parseInt(st.nextToken()); // 3
		c = Integer.parseInt(st.nextToken()); // 1

		calc((int) Math.pow(2, N), 0, 0, 0);

	}

	private static void calc(int max, int y, int x, int num) {
		if (max == 2) {
			for (int i = y; i < y + 2; i++) {
				for (int j = x; j < x + 2; j++) {
					if (i == r && j == c) {
						System.out.println(num + minArr[i % 2][j % 2]);
						return;
					}
				}
			}
		}

		//4분의 1
		//좌표가 속한 4분의 1의 (0,0)위치 찾기
		int cnt = 0;
		int min = max / 2;
		for (int i = y; i < y + max; i += min) {
			for (int j = x; j < x + max; j += min) {
				if (i <= r && j <= c && r < i + min && c < j + min) {
					calc(min, i, j, num + cnt * min * min);
				}
				cnt++;
			}
		}
	}
}