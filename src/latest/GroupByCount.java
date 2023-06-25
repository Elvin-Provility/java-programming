package latest;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupByCount {
    public static void main(String[] args) {
        int [] inputArray={2, 3, 4, 5, 4, 3, 2, 1, 7, 11, 13};
        Map<Integer, Integer> outPut = new LinkedHashMap<>();
         int count=1;
        for(int i : inputArray){
            if(outPut.containsKey(i)){
                int res = outPut.get(i);
                outPut.put(i, ++res);
            }else{
                outPut.put(i,count);
            }

        }
        System.out.println(outPut);
    }


}
