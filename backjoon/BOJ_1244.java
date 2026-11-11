import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int R = Integer.parseInt(br.readLine());
		for(int r=0; r<R; r++) {
			token = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(token.nextToken());
			int num = Integer.parseInt(token.nextToken())-1;
			switch(gender) {
				case 1:
					for(int i=0; i<N; i++) {
						if((i+1) % (num+1) != 0) continue;
						arr[i] = ((arr[i] == 0) ? 1 : 0);
					}
					break;
				case 2:
					int i = 1;
					arr[num] = ((arr[num] == 0) ? 1 : 0);
					while(num-i >= 0 && num+i < N) {
						if(arr[num-i] == arr[num+i]) {
//							System.out.println(arr[num-i] + " = " + arr[num+i] + " , i = " + i);
							arr[num-i] = ((arr[num-i] == 0) ? 1 : 0);
							arr[num+i] = ((arr[num+i] == 0) ? 1 : 0);
							i++;
						}
						else {
							break;
						}
					} //while
					break;
			} //switch
		} //for r
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i] + " ");
			if((i+1) % 20 == 0) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
