import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 计算多项式的
public class test02 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");
        String[] line2 = reader.readLine().split(" ");
        Map<Integer, Double> data1 = new HashMap<>();
        List<Integer> indexs = new ArrayList<>();
        for (int i = 1;i< line1.length; i =i +2){
            indexs.add(Integer.parseInt(line1[i]));
            data1.put(Integer.parseInt(line1[i]), Double.parseDouble(line1[i+1]));
        }
        Map<Integer, Double> data2 = new HashMap<>();
        for (int i = 1; i < line2.length; i = i+2){
            if(!indexs.contains(Integer.parseInt(line2[i]))){
                indexs.add(Integer.parseInt(line2[i]));
            }
            data2.put(Integer.parseInt((line2[i])),Double.parseDouble(line2[i+1]));
        }
        Collections.sort(indexs);
        int cout = 0;
        String result = "";
        for(int i = indexs.size() - 1;i>=0; i--){
            int index = indexs.get(i);
            double value1 = data1.get(index) == null ? 0.0f : data1.get(index);
            double value2 = data2.get(index) == null ? 0.0f : data2.get(index);
            if (value1+ value2 != 0){
                cout = cout +1;
                result = result + " "+ index;
                result = result + " " + String.format("%.1f",value1 + value2);
            }

        }
        System.out.print(cout);
        if(!result.isEmpty()){
            System.out.print(result);
        }
    }

}
