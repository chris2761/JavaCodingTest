import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, peoples[], visited[], isA[], isB[], visitedMin[], total;
	static List<List<Integer>> list = new ArrayList<>();
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		peoples = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {// 1번부터 6번까지 인구수
			peoples[i] = Integer.parseInt(st.nextToken());
			total += peoples[i]; //합계
		}

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {// 1번부터 6번까지 연결 정보
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int cnt = 1; cnt <= N; cnt++) { // 개수만큼 조합
			visited = new int[N + 1]; // visited 배열 생성
			
			for (int i = N - cnt + 1; i <= N; i++) {
				visited[i] = 1;
			}

			do {
				isA = new int[cnt];
				isB = new int[N - cnt];
				int aCnt = 0, bCnt = 0;
				for (int i = 1; i < N + 1; i++) {
					if (visited[i] == 1) {
						isA[aCnt++] = i;
					} else
						isB[bCnt++] = i;
				}

				if (aCnt == 0 || bCnt == 0)
					continue;

				int[] visitedAll = new int[N + 1];
				visitedMin = new int[N + 1];
				visitedMin[isA[0]] = 1;
				dfs(isA[0], visitedMin, visitedAll, isA);
				visitedMin[isB[0]] = 1;
				dfs(isB[0], visitedMin, visitedAll, isB);

				int ch = 0;
				for (int i = 1; i < visitedAll.length; i++) {
					if (visitedAll[i] == 0) {
						ch = 1;
						break;
					}
				}
				if (ch == 1)
					continue;
				
				int aPeopleCnt = 0;
				for (int i = 0; i < isA.length; i++) {
					aPeopleCnt += peoples[isA[i]];
				}
				int bPeopleCnt = total - aPeopleCnt;
				int curMin = Math.abs(aPeopleCnt - bPeopleCnt);
				if (curMin < result) {
					//System.out.println(Arrays.toString(isA));
					result = curMin;
					//System.out.println(aPeopleCnt+" "+bPeopleCnt+" "+result);
				}
				// System.out.println(Arrays.toString(visitedAll));

			} while (np(visited));
		}

//		System.out.println(Arrays.toString(peoples));
//		System.out.println(list);
		if(result==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);

	}

	private static void dfs(int ind, int[] visitedArr, int arr[], int cur[]) {
		arr[ind] = 1;
		List<Integer> curList = list.get(ind);

		for (int i = 0; i < curList.size(); i++) {
			int nextInd = curList.get(i);
			
			if (visitedArr[nextInd] == 0) {
				
				int ch = 0;
				for (int j = 0; j < cur.length; j++) {
					if (cur[j] == nextInd) {
						ch = 1;
						break;
					}
				}
				
				if (ch == 1) {
					visitedArr[nextInd] = 1;
					dfs(curList.get(i), visitedArr, arr, cur);
					visitedArr[curList.get(i)] = 0;
				}
				
			}
		}
	}

	private static boolean np(int[] arr) {

		int i = arr.length - 1;
		int j = arr.length - 1;

		while (i > 1 && arr[i - 1] >= arr[i]) {
			i--;
		}

		if (i == 1)
			return false;

		while (arr[j] <= arr[i - 1]) {
			j--;
		}

		swap(arr, j, i - 1);

		Arrays.sort(arr, i, arr.length);

		return true;
	}

	private static void swap(int[] arr, int j, int i) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
