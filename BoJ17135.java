package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BoJ17135 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, D, castle, cnt;
	static int map[][], visited[];

	public static void main(String[] args) throws IOException {
		int reuslt = -1;

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		castle = N;
		visited = new int[M]; //조합
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = M - 3; i <= M - 1; i++) {
			if (i < 0)
				continue;
			visited[i] = 1;
		}

		do {
			int[][] minMap = new int[N][M]; // 임시 지도 생성

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					minMap[i][j] = map[i][j];
				}
			}

			while (castle > 0) {
				calc(castle, minMap);
				castle--;
			}

			castle = N; // 초기화
			reuslt = Math.max(cnt, reuslt);
			cnt = 0;

		} while (np(visited)); //조합

		System.out.println(reuslt);

	}

	private static void calc(int castleInd, int[][] arr) {
		List<Integer> listX = new ArrayList<>();
		List<Integer> listY = new ArrayList<>();

		for (int j = 0; j < M; j++) {
			if (visited[j] == 1) { // 궁수가 있는 자리라면
				shoot(castleInd, j, arr, listX, listY);
			}
		}

		for (int i = 0; i < listX.size(); i++) {
			if (arr[listY.get(i)][listX.get(i)] != 0) {
				arr[listY.get(i)][listX.get(i)] = 0;
				cnt++;
			}

		}

	}

	private static void shoot(int castleInd, int j, int[][] arr, List<Integer> listX, List<Integer> listY) {
		int minDis = Integer.MAX_VALUE;
		int minX = -1;
		int minY = -1;
		for (int z = M - 1; z >= 0; z--) { //***왼쪽 적이 가장 우선 되어야하기 때문에 x좌표부터 확인
			for (int i = castleInd - D; i <= castleInd - 1; i++) {
				if (i < 0) 
					continue;
				int curDis = Math.abs(i - castleInd) + Math.abs(j - z);
				if (arr[i][z] == 1 && curDis <= D && curDis <= minDis) { // 적수가 있다면
					//가장 가까운 적 찾기
					minDis = curDis;
					minX = z;
					minY = i;
				}
			}
		}
		if (minY == -1 || minX == -1) //찾는 적이 없다면
			return;
		listX.add(minX);
		listY.add(minY);
	}

	private static boolean np(int[] arr) {
		int i = arr.length - 1;
		int j = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}

		if (i == 0)
			return false;

		while (arr[i - 1] >= arr[j]) {
			--j;
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