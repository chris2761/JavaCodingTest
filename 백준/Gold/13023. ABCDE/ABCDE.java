import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, visited[], result;

	static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 관계 수

		list = new ArrayList<>();
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				dfs(i, 1);
				if (result == 1) {
					System.out.println(result);
					return;
				}
			}
		}

		System.out.println(result);

	}

	private static void dfs(int ind, int cnt) {
		if (cnt == 5) {
			result = 1;
			return;
		}
		visited[ind] = 1;
		List<Integer> cur = list.get(ind);
		for (int i = 0; i < cur.size(); i++) {
			if (visited[cur.get(i)] == 0) {
				dfs(cur.get(i), cnt + 1);
			}
		}
		visited[ind] = 0;

	}
}