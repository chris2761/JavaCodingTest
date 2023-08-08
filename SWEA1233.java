package prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA1233 {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String str = "/-*+";
 
    public static void main(String[] args) throws IOException {
 
 
        for (int t = 0; t < 10; t++) {
            int result = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            // 짝수면 탈락
            if (N % 2 == 0) {
                sb.append("#").append(t + 1).append(" ").append(0).append("\n");
                for (int i = 1; i <= N; i++) {
                    br.readLine();
                }
                continue;
            }
             
            // 홀수면
            int ch = 0;
            for (int i = 1; i <= N; i++) {
                String curr[] = br.readLine().split(" ");
                if(curr.length == 2 && str.contains(curr[1])) { //말단 노드
                    ch=1;
                    result = 0;
                }
            }
 
            if (ch == 0) result = 1;
             
            sb.append("#").append(t + 1).append(" ").append(result).append("\n");
 
        }
 
        System.out.println(sb);
    }
}