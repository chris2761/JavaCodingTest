package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak3040 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] nums = new int[9];
	static int[] visited = new int[9];

	public static void main(String[] args) throws IOException {

		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// visited 배열 생성
		for (int i = 8; i >= 2; i--) {
			visited[i] = 1;
		}
		

		do {
			//visited와 비교해서 nums 조합 구하고, 총합 구하기
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (visited[i] == 1)
					sum += nums[i];
			}
			//100이라면 정답
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (visited[i] == 1)
						sb.append(nums[i]).append("\n");
				}
			}

		} while (np(visited));
		
		System.out.println(sb);
	}

	private static boolean np(int[] arr) {

		int i = arr.length - 1; // top
		int j = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}

		if (i == 0)
			return false;

		while (arr[j] <= arr[i-1]) {
			j--;
		}

		swap(arr, i - 1, j);

		Arrays.sort(arr, i, arr.length);// 정렬

		return true;
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
