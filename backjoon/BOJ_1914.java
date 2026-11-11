import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static StringBuilder sb = new StringBuilder();
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		
		if(N <= 20) {
			hanoi(N, 1, 3);
			System.out.println(answer);
			System.out.println(sb.toString());
		}
		else {
			double answer = Math.pow(2, N) -1;
//			System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
		}
		
	}
	
	
	static void hanoi(int n, int x, int y) {
		if (n <= 1) {
			sb.append(x + " " + y + "\n");
			answer++;
			return;
		}
		hanoi(n-1, x, 6-x-y);
		
		sb.append(x + " " + y + "\n");
		answer++;
		
		hanoi(n-1, 6-x-y, y);
	}
}
