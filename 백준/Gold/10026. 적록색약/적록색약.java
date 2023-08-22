import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, visited[][], cnt, cnt2;
	static char map[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.println(i + " " + j);
				if (visited[i][j] == 0) {
					cnt++;
					dfs(i, j);
				}
			}
		}

		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
					cnt2++;
					dfs2(i, j);
				}
			}
		}

		sb.append(cnt).append(" ").append(cnt2);
		System.out.println(sb);

	}

	private static void dfs(int y, int x) {
		visited[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx] == 0) {
				if (map[y][x] == map[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}

	private static void dfs2(int y, int x) {
		visited[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx] == 0) {
				if (map[y][x] == map[ny][nx] || (map[y][x] == 'R' && map[ny][nx] == 'G')
					||(map[y][x] == 'G' && map[ny][nx] == 'R')	) {
					dfs2(ny, nx);
				}
			}
		}
	}
}