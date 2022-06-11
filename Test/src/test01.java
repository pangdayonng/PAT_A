import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//计算两数之和的标准形式
public class test01{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        reader.close();
        String s = String.valueOf(a + b);
        StringBuilder out =new StringBuilder();
        int len = s.length();
        for (int i=0;i< len ; i++){
            char c = s.charAt(i);
            out.append(c);
            if(c == '-') {
                continue;
            }
            if((i+1)%3 == len % 3 && i != len-1)
                out.append(',');
        }
        System.out.println(out);

    }

}