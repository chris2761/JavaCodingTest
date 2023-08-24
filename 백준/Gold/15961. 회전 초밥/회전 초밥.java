import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, d, k, c, cnt = 1, answer; // 접시 수, 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + k - 1];
		int visited[] = new int[d + 1];
		visited[c]++;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ind = 0;
		for (int i = N; i < N + k - 1; i++) {
			arr[i] = arr[ind++];
		}

		for (int i = 0; i < k; i++) {
			visited[arr[i]]++;
			if (visited[arr[i]] == 1)
				cnt++;
		}

		for (int i = k; i < arr.length; i++) {
			visited[arr[i - k]]--;
			visited[arr[i]]++;

			if (visited[arr[i - k]] == 0)
				cnt--;
			if ((arr[i - k] != arr[i]) && visited[arr[i]] == 1)
				cnt++;
			answer = Math.max(cnt, answer);
		}

		System.out.println(answer);

	}

}
