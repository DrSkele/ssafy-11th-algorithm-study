import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(in.readLine());
		
		int T;
		T=Integer.parseInt(tokens.nextToken());
        
        int[] dx = { +1, 0, -1, 0 };
        int[] dy = { 0, +1, 0, -1 };
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            tokens = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(tokens.nextToken());
            int[][] matrix = new int[N][N];
            int[][] visited = new int[N][N];
            for(int y = 0; y < N; y++){
             	tokens = new StringTokenizer(in.readLine());
                for(int x = 0; x < N; x++){
                    matrix[y][x] = Integer.parseInt(tokens.nextToken());
                    visited[y][x] = Integer.MAX_VALUE;
                }
            }
			
            Queue<int[]> q = new LinkedList<>();
            
            int[] start = new int[2];
            int[] end = new int[2];
            
            tokens = new StringTokenizer(in.readLine());
            start[1] = Integer.parseInt(tokens.nextToken());
            start[0] = Integer.parseInt(tokens.nextToken());
			
            tokens = new StringTokenizer(in.readLine());
            end[1] = Integer.parseInt(tokens.nextToken());
            end[0] = Integer.parseInt(tokens.nextToken());

            
            q.add(start);
            visited[start[1]][start[0]] = 0;
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
            	int x = cur[0];
                int y = cur[1];
                int curTime = visited[y][x];
                
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(matrix[ny][nx] == 1) continue;
                    
                    int nextTime = curTime + 1;
                    int swirlTime = curTime + (3-(curTime%3));
                    
                    if(matrix[ny][nx] == 2){
                        if(visited[ny][nx] <= swirlTime) continue;
                        visited[ny][nx] = swirlTime;
                        q.add(new int[]{nx, ny});
                    } else {
                        if(visited[ny][nx] <= nextTime) continue;
                        visited[ny][nx] = nextTime;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            
            int result = visited[end[1]][end[0]];
            System.out.println(String.format("#%d %d", test_case, result == Integer.MAX_VALUE ? -1 : result));
		}
	}
}
