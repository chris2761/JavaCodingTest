package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoJ1535 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, result = -1;
	static int[] minus, plus;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		minus = new int[N];
		plus = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			minus[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			plus[i] = Integer.parseInt(st.nextToken());
		}
		
		calc(0,0,100);
		
		System.out.println(result);
	}

	public static void calc(int ind, int happy, int power) {
		if ( ind == N || (power <= 0 && ind >= 1)) {
			if(power<=0) return;
			else if (result < happy)
				result = happy;
			return;
		}
		calc(ind+1 ,happy+plus[ind], power-minus[ind]);
		calc(ind+1 ,happy, power);
	}
}
