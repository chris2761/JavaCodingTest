import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
	int y, x; // 위치
	int s, d, z; // 속력, 방향, 크기

	public Shark(int y, int x, int s, int d, int z) {
		super();
		this.y = y;
		this.x = x;
		this.s = s;
		this.d = d;
		this.z = z;
	}

}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int R, C, M, board[][], result; // 세로, 가로, 상어 수
	static Shark[] sharkArr; // 상어 배열
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R + 2][C + 2];// 시작과 끝 포함

		M = Integer.parseInt(st.nextToken());
		sharkArr = new Shark[M + 1]; // 상어 배열 1번 ~ m+1번까지

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharkArr[i] = new Shark(y, x, s, d, z);
			board[y][x] = i; // 상어 인덱스 넣기
		}


		for (int j = 1; j <= C; j++) { // C번 이동
			// 사람은 이미 이동
			// 가까운 상어 잡기
			for (int i = 1; i <= R; i++) {
				if (board[i][j] > 0) {// 상어 있으면
					Shark cur = sharkArr[board[i][j]]; // 잡을 상어
					result += cur.z; // 크기 더하기
					sharkArr[board[i][j]].z = 0; // 상어 없어진 셈
					board[i][j] = 0;// 상어 없애기
					break;
				}
			}

			if (j == C)
				break;

			// 상어 이동
			int[] nextX = new int[sharkArr.length];
			int[] nextY = new int[sharkArr.length];
			for (int i = 1; i < sharkArr.length; i++) {
				if (sharkArr[i].z == 0) // 없는 셈 쳐진 애들
					continue;
				int y = sharkArr[i].y;
				int x = sharkArr[i].x;
				int d = sharkArr[i].d;
				int s = sharkArr[i].s;
				int[] nextXY = move(board, y, x, d, s); // 놔야되는 좌표 구하기
				nextX[i] = nextXY[0];
				nextY[i] = nextXY[1];
				sharkArr[i].d = nextXY[2];
				board[y][x] = 0; // 움직였으니 원래 자리 0
			}
			// 모든 상어 자리 0
			// 이제 구해준 자리로 상어 넣어줘야함
			for (int i = 1; i < sharkArr.length; i++) {
				if (sharkArr[i].z == 0) // 없는 셈 쳐진 애들
					continue;
				int cur = board[nextY[i]][nextX[i]]; // 지금 있는 상어 없으면 0
				if (cur > 0) {// 이미 있다면
					int bigInd = 0;
					if (sharkArr[cur].z > sharkArr[i].z) {
						bigInd = cur;
						sharkArr[i].z = 0;
					} else {
						bigInd = i;
						sharkArr[cur].z = 0;
					}
					cur = bigInd;
				} else
					cur = i;
				board[nextY[i]][nextX[i]] = cur;
				sharkArr[cur].x = nextX[i];
				sharkArr[cur].y = nextY[i];
			}
		}

		System.out.println(result);
	}

	private static int[] move(int[][] arr, int y, int x, int dir, int speed) {
		int moveX = dx[dir];
		int moveY = dy[dir];

		for (int i = 0; i < speed; i++) {
			int nextX = x + moveX;
			int nextY = y + moveY;

			if (nextX < 1 || nextX > C || nextY < 1 || nextY > R) {
				// 반전
				if (dir == 1)
					dir = 2;
				else if (dir == 2)
					dir = 1;
				else if (dir == 3)
					dir = 4;
				else if (dir == 4)
					dir = 3;
				moveX *= -1;
				moveY *= -1;
				// 반대로 이동
				nextX = x + moveX;
				nextY = y + moveY;
			}

			x = nextX;
			y = nextY;
		}
		// x랑 y는 구했는데..
		int[] answer = { x, y, dir };
		return answer;
	}
}
