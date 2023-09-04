
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R, C, result;
	static int visited[] = new int[27];
	static String map[][];

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new String[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}

		visited[map[0][0].charAt(0) - 'A'] = 1;
		dfs(0, 0, 1);
		
		System.out.println(result);
	}

	private static void dfs(int y, int x, int cnt) {
		int ch = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
				int curInd = map[ny][nx].charAt(0) - 'A';
				if (visited[curInd] == 0) {
					ch = 1;
					visited[curInd] = 1;
					dfs(ny, nx, cnt+1);
					visited[curInd] = 0;
				}
			}
		}

		if (ch == 0) {
			result = Math.max(cnt, result);
			return;
		}
	}

}
