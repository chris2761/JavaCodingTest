package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2563 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+10;i++) {
				for(int j=y;j<y+10;j++) {
					arr[i][j]++;
				}
			}
			
		}
	
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j]!=0) answer++;
			}
		}
		
		System.out.println(answer);
	}
}
