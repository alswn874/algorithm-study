import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int[] parent;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt( br.readLine() );
        
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer token = new StringTokenizer(br.readLine() );
            
            int n = Integer.parseInt( token.nextToken() );
            int m = Integer.parseInt( token.nextToken() );
            
            parent = new int[n];
            
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
            
            for(int i=0; i<m; i++){
                token = new StringTokenizer(br.readLine() );
                
                int a = Integer.parseInt( token.nextToken() ) -1;
            	int b = Integer.parseInt( token.nextToken() ) -1;
                
                union(a,b);
            }
            
            HashSet<Integer> set = new HashSet<>();
            
            for(int i=0; i<n; i++){
                set.add(find(i));
            }
            
            System.out.println("#" + test_case + " " + set.size());
            
            
            
		}
	} // main
    
    static int find(int x){
        if(x == parent[x]) return x;
        
        return find(parent[x]);
    }
    
    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        
        parent[parentB] = parentA;
        // System.out.println(a + " " + b + ": " + Arrays.toString(parent));
    }
}