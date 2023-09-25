import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, m, board[][], result = -1;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		List<int[]> zero = new ArrayList<>();
		List<int[]> virus = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					int[] add = { i, j };
					zero.add(add);
				} else if (board[i][j] == 2) {
					int[] add = { i, j };
					virus.add(add);
				}
			}
		}

		int[] selected = new int[zero.size()];

		for (int i = selected.length - 3; i < selected.length; i++) {
			selected[i] = 1;
		}

		do {

			List<int[]> newOne = new ArrayList<>();
			// 벽세우기
			for (int i = 0; i < selected.length; i++) {
				if (selected[i] == 1) {
					int[] one = { zero.get(i)[0], zero.get(i)[1] };
					newOne.add(one);
					board[one[0]][one[1]] = 1;
				}
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			int[][] visited = new int[n][m];

			for (int i = 0; i < virus.size(); i++) {
				dfs(virus.get(i)[0], virus.get(i)[1], visited);
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(board[i][j]==0) cnt++;
					else if(board[i][j]==3) {
						board[i][j]=0;
					}
				}
			}
			result = Math.max(cnt, result);
			

			for (int i = 0; i < newOne.size(); i++) {
				board[newOne.get(i)[0]][newOne.get(i)[1]] = 0;
			}

		} while (np(selected));
		
		System.out.println(result);

	}

	private static void dfs(int y, int x, int[][] visited) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[ny][nx] == 0) {
				if (visited[ny][nx] == 0) {
					visited[ny][nx] = 1;
					board[ny][nx] = 3;
					dfs(ny, nx, visited);
					visited[ny][nx] = 0;
				}
			}

		}

		return;
	}

	static private boolean np(int[] arr) {

		int i = arr.length - 1;
		int j = arr.length - 1;

		while (i > 0 && arr[i] <= arr[i - 1]) {
			i--;
		}

		if (i == 0)
			return false;

		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		int a = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = a;

		Arrays.sort(arr, i, arr.length);

		return true;
	}
}
