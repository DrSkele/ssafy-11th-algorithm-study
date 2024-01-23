//swea 1868
import java.util.*;
import java.io.*;
 
class Solution
{
    static int[] dx = {+1, +1, 0, -1, -1, -1, 0, +1};
    static int[] dy = {0, +1, +1, +1, 0, -1, -1, -1};
    static int size;
    static char[][] matrix;
     
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(in.readLine());
         
        int T;
        T=Integer.parseInt(tokens.nextToken());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            tokens = new StringTokenizer(in.readLine());
            size = Integer.parseInt(tokens.nextToken());
            matrix = new char[size][size];
            for(int y = 0; y < size; y++){
                tokens = new StringTokenizer(in.readLine());
                matrix[y] = tokens.nextToken().toCharArray();
            }
            for(int y = 0; y < size; y++){
                for(int x = 0; x < size; x++){
                    if(matrix[y][x] == '.'){
                        boolean nearMine = false;
                        for(int i = 0; i < 8; i++){
                            int nx = x + dx[i];
                            int ny = y + dy[i];
 
                            if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                            if(matrix[ny][nx] == '*'){
                                nearMine = true;
                                break;
                            }
                        }
                        matrix[y][x] = nearMine ? '1' : '0';
                    }
                }
            }
             
            int cnt = 0;
            for(int y = 0; y < size; y++){
                for(int x = 0; x < size; x++){
                    if(matrix[y][x] == '0'){
                        cnt++;
                        bfs(x, y);
                    }
                }
            }
             
            for(int y = 0; y < size; y++){
                for(int x = 0; x < size; x++){
                    if(matrix[y][x] == '1'){
                        cnt++;
                    }
                }
            }
             
            System.out.println(String.format("#%d %d", test_case, cnt));
        }
    }
     
    static void bfs(int x, int y){
         
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        matrix[y][x] = 'v';
 
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
 
            for(int i = 0; i < 8; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
 
                if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue;
                if(matrix[ny][nx] == '0'){
                    q.add(new int[]{nx, ny});
                }
                matrix[ny][nx] = 'v';
            }
        }
    }
}
