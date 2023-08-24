import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, maxResult;
	static int[] players, order = new int[10]; // 순서 정할 때 사용하는 배열
	static int[][] games;

	private static void setOrder() {
		for (int i = 1; i < order.length; i++) {
			order[i] = i; // 배열 생성
		}
	}

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		setOrder();
		games = new int[N][10];

		// 쿼터별로 받기
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			players = new int[10];
			// 선수 점수 받기 (1-9번 선수)
			for (int i = 1; i <= 9; i++) {
				games[t][i] = Integer.parseInt(st.nextToken());
			}
		}

		do {
			if (order[4] == 1) {
				//System.out.println(Arrays.toString(order));
				int result = 0;
				int ind = 1;
				// 게임별로 차례로 진행
				for (int t = 0; t < N; t++) {
					int curPlayer[] = games[t];
					int roo[] = new int[3]; // 1,2,3루
					int outCnt = 0; // 아웃 횟수
					while (outCnt < 3) {
						// System.out.println(result + " " + ind + " " + curPlayer[ind]);
						if (curPlayer[order[ind]] == 0) { // 아웃이면
							outCnt++;
						} else if (curPlayer[order[ind]] == 4) { // 홈런이면
							for (int i = 0; i < roo.length; i++) {
								if (roo[i] == 1) { // 루에 선수 있으면 점수 추가, 루 비우기
									result += 1;
									roo[i] = 0;
								}
							}
							result += 1; // 타자도 점수 추가
						} else
							result += movePlayer(roo, curPlayer[order[ind]]);
						ind++;
						if (ind == 10)
							ind = 1;
						//System.out.println(Arrays.toString(roo));
						//System.out.println(result);
					}
				}
				//System.out.println("*" + result);
				maxResult = Math.max(result, maxResult);
			}

		} while (np(order));
		System.out.println(maxResult);

	}

	private static int movePlayer(int[] roo, int cnt) {
		int score = 0;
		for (int i = 0; i < cnt; i++) { // 안타면 1번 옮기고 2루타면 2번 옮기고 3루타면 3번 옮기고
			if (roo[2] == 1) // 3루에 선수가 있었으면
				score += 1;
			// 선수들 옮기기
			roo[2] = roo[1];
			roo[1] = roo[0];
			if (i == 0)
				roo[0] = 1;
			else
				roo[0] = 0; // 1루에는 무조건 선수 진출
		}
		return score;
	}

	private static boolean np(int[] arr) {
		int i = arr.length - 1;
		int j = arr.length - 1;

		while (i > 1 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i == 1)
			return false;

		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		swap(arr, i - 1, j);

		Arrays.sort(arr, i, arr.length);

		return true;
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
