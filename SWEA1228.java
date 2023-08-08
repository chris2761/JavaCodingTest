package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		for (int tc = 0; tc < 10; tc++) {
			List<Integer> list = new LinkedList<>();
			
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++) {
				list.add(i, Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			int num2 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int t = 0; t < num2; t++) {
				String s = st.nextToken(); // I
				int insertTo = Integer.parseInt(st.nextToken());
				int insertCnt = Integer.parseInt(st.nextToken());
				for (int i = 0; i < insertCnt; i++) {
					list.add(insertTo++, Integer.parseInt(st.nextToken()));
				}
			}

			sb.append("#").append(tc + 1).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
