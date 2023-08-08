package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	int data;
	int index;

	public Pair(int a, int b) {
		this.data = a;
		this.index = b;
	}

	public int getData() {
		return this.data;
	}

	public int getIndex() {
		return this.index;
	}
}

public class Beak2493 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<Pair> stack = new Stack<>();

	static Pair first = new Pair(100000001, 0);

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] index = new int[N];

		stack.push(first);
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (stack.peek().getData() < height)
				stack.pop();
			sb.append(stack.peek().getIndex()).append(" ");
			stack.push(new Pair(height, i));
		}
		System.out.println(sb);
	}
}
