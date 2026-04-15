import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int R = Integer.parseInt(token.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		token = new StringTokenizer(br.readLine(), " ");
		int oper = 0;
		int[][] tmp;
		for(int r=0; r<R; r++) {
			oper = Integer.parseInt(token.nextToken());
		
		int n, m;
			switch(oper) {
				case 1:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[n][m];
					for(int i=0; i<n; i++) {
						System.arraycopy(arr[i], 0, tmp[n-1-i], 0, m);
					} //for i
					
					
					arr = new int[n][m];
					for(int i=0; i<n; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, m);
					} //for i
					break;
					
					
				case 2:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[n][m];
					for(int i=0; i<n; i++) {
						for(int j=0; j<m; j++) {
							tmp[i][j] = arr[i][m-1-j];
						} //for j
					} //for i
					
					arr = new int[n][m];
					for(int i=0; i<n; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, m);
					} //for i
					break;
					
					
				case 3:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[m][n];
					for(int i=0; i<m; i++) {
						for(int j=0; j<n; j++) {
							tmp[i][j] = arr[n-1-j][i];
						} //for j
					} //for i
					
					arr = new int[m][n];
					for(int i=0; i<m; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, n);
					} //for i
					break;
					
					
				case 4:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[m][n];
					for(int i=0; i<m; i++) {
						for(int j=0; j<n; j++) {
							tmp[i][j] = arr[j][m-1-i];
						} //for j
					} //for i
					
					arr = new int[m][n];
					for(int i=0; i<m; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, n);
					} //for i
					break;
					
					
				case 5:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[n][m];
					for(int i=0; i<n/2; i++) { //1
						for(int j=0; j<m/2; j++) {
							tmp[i][j] = arr[i+(n/2)][j];
						} //for j
						
						for(int j=m/2; j<m; j++) { //2
							tmp[i][j] = arr[i][j-m/2];
						} //for j
					} //for i
					
					
					for(int i=n/2; i<n; i++) { //3
						for(int j=m/2; j<m; j++) {
							tmp[i][j] = arr[i-n/2][j];
						} //for j
					} //for i
					
					for(int i=n/2; i<n; i++) { //4
						for(int j=0; j<m/2; j++) {
							tmp[i][j] = arr[i][j+m/2];
						} //for j
					} //for i
					
					
					arr = new int[n][m];
					for(int i=0; i<n; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, m);
					} //for i
					break;
					
					
				case 6:
					n = arr.length;
					m = arr[0].length;
					tmp = new int[n][m];
					for(int i=0; i<n/2; i++) { //1
						for(int j=0; j<m/2; j++) {
							tmp[i][j] = arr[i][j+m/2];
						} //for j
						
						for(int j=m/2; j<m; j++) { //2
							tmp[i][j] = arr[i+n/2][j];
						} //for j
					} //for i
					
					
					for(int i=n/2; i<n; i++) { //3
						for(int j=m/2; j<m; j++) {
							tmp[i][j] = arr[i][j-m/2];
						} //for j
					} //for i
					
					for(int i=n/2; i<n; i++) { //4
						for(int j=0; j<m/2; j++) {
							tmp[i][j] = arr[i-n/2][j];
						} //for j
					} //for i
					
					
					arr = new int[n][m];
					for(int i=0; i<n; i++) {
						System.arraycopy(tmp[i], 0, arr[i], 0, m);
					} //for i
					break;
					
			} //switch
		} //for r
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			} //for j
			System.out.println();
		} //for i
	} //main
	
	

}//class
