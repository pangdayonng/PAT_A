import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class test05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int sum = 0;
        for(int i = 0; i < str.length();i++) sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        String out = String.format("%d",sum);

        Map<Integer,String> data = new HashMap<>();
        data.put(0,"zero");
        data.put(1,"one");
        data.put(2,"two");
        data.put(3,"three");
        data.put(4,"four");
        data.put(5,"five");
        data.put(6,"six");
        data.put(7,"seven");
        data.put(8,"eight");
        data.put(9,"nine");
        String result = "";
        result += data.get(Integer.parseInt(String.valueOf(out.charAt(0))));
        for(int i = 1; i < out.length(); i++) result = result + " " + data.get(Integer.parseInt(String.valueOf(out.charAt(i))));
        String result1 = new String();


        System.out.print(result);
    }
}
