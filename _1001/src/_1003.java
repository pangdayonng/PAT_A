import java.util.Scanner;

public class _1003 {

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

        for (int i = 0; i < N; i++) {

            weights[i] = sc.nextInt(); //每个城市的救援队的数量
        }

        for (int i = 0; i < M; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            map[x][y] = map[y][x] = z;
        }
        sc.close();

        dfs(C1, 0, weights[C1]);
        System.out.printf("%d %d", anspath, answeights);
    }

    public static void dfs(int start, int sumPath, int sumWeight) {

        if (start == C2) {
            //到达了终点C2（需要救援的城市的编号）
            if (sumPath < minPath) {
                //如果这条路的长度小于当前最短路的长度
                //更新最短路的长度
                minPath = sumPath;
                //将C1-C2之间的不同的路的数量更新为1
                anspath = 1;
                //更新总权重，即救援队总数量
                answeights = sumWeight;
            } else if (sumPath == minPath) {
                //如果这条路和最短路的长度一样
                //将C1-C2之间的不同的路的数量增加1
                anspath++;
                //如果这条路救援队总数量比之前最短路的总数量大，则更新救援队总数量
                if (sumWeight > answeights) {

                    answeights = sumWeight;
                }
            }
            return;
        }
        //如果当前路的和的长度大于最小路长度（没到达终点，及时退出）
        if (sumPath > minPath) return;
        for (int i = 0; i < N; i++) {
            //以C1点为起点找到到其他各点的路
            if (!visit[start][i] && map[start][i] != 0) {

                //如果城市start和i之间的路没有被访问（无法保证start不等一i），并且路的长度不为0（保证start不等一i）
                visit[start][i] = visit[i][start] = true; //更新访问状态
                dfs(i, sumPath + map[start][i], sumWeight + weights[i]); //递归，将起点更新为i点
                visit[start][i] = visit[i][start] = false; //更新访问状态，很重要，注意一下
            }
        }
    }
}