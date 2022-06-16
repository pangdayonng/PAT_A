import java.util.Scanner;

public class test03 {

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt(); //城市数量 城市编号从0到N-1
    static int M = sc.nextInt(); //道路数量
    static int C1 = sc.nextInt(); //当前所在城市的编号
    static int C2 = sc.nextInt(); //需要救援的城市的编号
    static int[] weights = new int[N];//每个城市的救援队的数量
    static int[][] map = new int[N][N]; //城市之间路的长度
    //城市间路被访问的状态，要是访问了就更新为true
    static boolean[][] visit = new boolean[N][N];
    static int minPath = Integer.MAX_VALUE; //刚开始的最小路径的小设为一个很大的值
    static int anspath = 0;
    static int answeights = 0;

    public static void main(String[] args) {
        for(int i =0;i <N;i++) weights[i] = sc.nextInt();

        int x,y,z;
        for (int i= 0 ; i < M; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            map[x][y]=map[y][x]=z;
        }
        sc.close();

        dfs(C1,0,weights[C1]);
        System.out.printf("%d %d", anspath, answeights);
    }

    public static void dfs(int start, int sumPath, int sumWeight){
        if (start == C2){
            if(sumPath < minPath){
                anspath =1;
                answeights = sumWeight;
                minPath = sumPath;
            }else if (sumPath == minPath){
                anspath++;
                if (sumWeight > answeights){
                    answeights =sumWeight;
                }
            }
            return;
        }
        if (sumPath > minPath) return;
        for (int i = 0; i < N;i++){
            if(!visit[start][i] && map[start][i]!=0){
                visit[start][i] = visit[i][start]=true;
                dfs(i , sumPath + map[start][i],sumWeight + weights[i]);
                visit[start][i] = visit[i][start] = false;
            }
        }
    }

}
