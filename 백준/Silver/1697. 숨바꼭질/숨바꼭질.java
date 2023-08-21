import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, K, result;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs(N);
		System.out.println(result);
	}

	private static void bfs(int a) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(a);
		visited[a] = 1;
		while (!queue.isEmpty()) {
			int n = queue.poll();

			if (n == K) {
				result = visited[n] - 1;
				return;
			}

			if (n - 1 >= 0 && visited[n - 1] == 0) {
				visited[n - 1] = visited[n] + 1;
				queue.offer(n - 1);
			}

			if (n + 1 < 100001 && visited[n + 1] == 0) {
				visited[n + 1] = visited[n] + 1;
				queue.offer(n + 1);
			}

			if (n * 2 < 100001 && visited[n * 2] == 0) {
				visited[n * 2] = visited[n] + 1;
				queue.offer(n * 2);
			}

		}

		result = -1;
		return;

	}
}
