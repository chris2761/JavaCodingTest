import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int L, C, visited[];
	static String[] str;

	static String strM = "aeiou";
	static Deque<String> q;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		str = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			str[i] = st.nextToken();
		}

		Arrays.sort(str); // 문자 정렬

		visited = new int[C];

		for (int i = C - L; i < C; i++) {
			visited[i] = 1;
		}

		do {
			String cur = "";
			int mCnt = 0;
			for (int i = 0; i < C; i++) {
				if (visited[i] == 1) {
					if (strM.contains(str[i])) {
						mCnt++;
					}
					cur += str[i];
				}
			}
			if (mCnt >= 1 && L - mCnt >= 2)
				q.offer(cur);

		} while (np(visited));

		int size = q.size();
		for (int i = 0; i < size; i++) {
			sb.append(q.pollLast()).append("\n");
		}
		
		System.out.println(sb);

	}

	private static boolean np(int[] arr) {

		int i = arr.length - 1;
		int j = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i == 0)
			return false;

		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		swap(arr, i - 1, j);

		Arrays.sort(arr, i, arr.length);

		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
