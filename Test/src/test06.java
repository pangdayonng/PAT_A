import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        String[][] str = new String[num][];
        for (int i = 0; i < num; i++) {
            str[i] = reader.readLine().split(" ");
        }
        reader.close();
        int start = 0;
        int end = 0;
        for (int i = 1; i < num; i++) {
            if (str[i][1].compareTo(str[start][1]) < 0) {
                start = i;
            }
            if( str[i][2].compareTo(str[end][2]) > 0){
                end = i;
            }
        }
        System.out.println( str[start][0]+ " " + str[end][0]);
        }
        }

