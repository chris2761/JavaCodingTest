package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak1861 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static int[][] arr, visited;
	static int maxRoom, maxCnt, cnt;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    T = Integer.parseInt(st.nextToken());

	    for (int tc = 0; tc < T; tc++) {
	        st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        arr = new int[N][N];
	        visited = new int[N][N]; // 방문 배열 초기화

	        // 정답 초기화
	        maxRoom = N*N + 1;
	        maxCnt = 1;

	        // 배열 초기화
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                if (visited[i][j] == 1)
	                    continue; // 방문했으면 pass
	                cnt=1; //카운트 초기화
	                dfs(i, j, arr[i][j]);
	            }
	        }

	        sb.append("#").append(tc + 1).append(" ").append(maxRoom).append(" ").append(maxCnt).append("\n");

	    }

	    System.out.println(sb);

	}

	private static void dfs(int x, int y, int start) {
	    visited[x][y] = 1;// 방문체크

	    // 4방향 탐방
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];

	        // 모든 조건 만족 시
	        if (nx >= 0 && nx < N && ny >= 0 && ny < N && (arr[nx][ny] == arr[x][y] + 1 || arr[nx][ny] == arr[x][y] - 1)
	                && visited[nx][ny] == 0) {
	        	//start = Math.min(arr[x][y], start);
	        	if (start > arr[nx][ny])
					start = arr[nx][ny];
	            cnt++;
	            dfs(nx, ny, start);
	        } 
	    }
	    
	    //4방향 확인 후 정답 업데이트
	    if (cnt > maxCnt || (cnt == maxCnt && start < maxRoom)) {
	 	    maxCnt = cnt;
	 	    maxRoom = start;
	 	}
	    
	}

}

